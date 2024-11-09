package info.kgeorgiy.ja.bagautdinov.crawler;

import info.kgeorgiy.java.advanced.crawler.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class WebCrawler implements NewCrawler {
    public final Downloader downloader;
    private final int perHost;
    private final Map<String, Semaphore> semaphores;
    private final ExecutorService downloadService;
    private final ExecutorService extractService;


    public WebCrawler(Downloader downloader, int downloaders, int extractors, int perHost) {
        this.downloader = downloader;
        this.perHost = perHost;
        downloadService = Executors.newFixedThreadPool(downloaders);
        extractService = Executors.newFixedThreadPool(extractors);
        semaphores = new ConcurrentHashMap<>();
    }

    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.err.println("Args format: url [depth [downloads [extractors [perHost]]]]");
            return;
        }
        String URL = args[0];
        int depth = toInteger(args, 1);
        int downloads = toInteger(args, 2);
        int extractors = toInteger(args, 3);
        int perHost = toInteger(args, 4);
        Downloader sampleDownloader;
        try {
            sampleDownloader = new CachingDownloader(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        WebCrawler crawler = new WebCrawler(sampleDownloader, downloads, extractors, perHost);
        crawler.download(URL, depth);
        crawler.close();
    }

    private static int toInteger(String[] args, int n) {
        if (n >= args.length || args[n] == null)
            return 1;
        return Integer.parseInt(args[n]);
    }

    /**
     * Downloads website up to specified depth.
     *
     * @param url      start URL.
     * @param depth    download depth.
     * @param excludes URLs containing one of given substrings are ignored.
     * @return download result.
     */

    public Result download(String url, int depth, Set<String> excludes) {
        DownloadHelper helper = new DownloadHelper(excludes);
        helper.download(url, depth);
        return helper.getResult();
    }

    /**
     * Downloads website up to specified depth.
     *
     * @param url   start <a href="http://tools.ietf.org/html/rfc3986">URL</a>.
     * @param depth download depth.
     * @return download result.
     */
    @Override
    public Result download(String url, int depth) {
        return download(url, depth, Set.of());
    }

    /**
     * Closes this crawler, freeing any allocated resources.
     */
    @Override
    public void close() {
        downloadService.shutdown();
        extractService.shutdown();
    }

    private class DownloadHelper {
        final Set<String> visited;
        final Set<String> excludes;
        final Map<String, IOException> exceptions;
        final Phaser phaser;
        Set<String> current;
        Set<String> next;

        DownloadHelper(Set<String> excludes) {
            this.excludes = excludes;
            exceptions = new ConcurrentHashMap<>();
            visited = ConcurrentHashMap.newKeySet();
            current = ConcurrentHashMap.newKeySet();
            next = ConcurrentHashMap.newKeySet();
            phaser = new Phaser(1);
        }

        boolean containsExcluded(String url) {
            for (String exclude : excludes) {
                if (url.contains(exclude)) {
                    return false;
                }
            }
            return true;
        }

        void download(final String url, final int depth) {
            current.add(url);
            for (int d = depth; d > 0; d--) {
                current.parallelStream()
                        .filter(this::containsExcluded)
                        .filter(visited::add)
                        .forEach(this::processLink);
                phaser.arriveAndAwaitAdvance();
                swapLinks();
            }
        }

        void swapLinks() {
            Set<String> temp = next;
            next = current;
            current = temp;
            next.clear();
        }


        void processLink(final String url) {
            phaser.register();
            final String host = getHost(url);
            semaphores.putIfAbsent(host, new Semaphore(perHost));
            final Semaphore sem = semaphores.get(host);
            downloadService.submit(() -> {
                try {
                    sem.acquire();
                    extractLinks(url);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    sem.release();
                    phaser.arriveAndDeregister();
                }
            });
        }

        String getHost(String url) {
            try {
                return URLUtils.getHost(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        void extractLinks(String url) {
            try {
                Document document = downloader.download(url);
                phaser.register();
                extractService.submit(() -> {
                    try {
                        List<String> extracted = document.extractLinks();
                        next.addAll(extracted);
                    } catch (IOException e) {
                        exceptions.put(url, e);
                    } finally {
                        phaser.arriveAndDeregister();
                    }
                });
            } catch (IOException e) {
                exceptions.put(url, e);
            }
        }

        Result getResult() {
            List<String> res = new ArrayList<>(visited);
            res.removeAll(exceptions.keySet());
            return new Result(res, exceptions);
        }
    }
}