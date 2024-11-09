package info.kgeorgiy.ja.bagautdinov.iterative;

import info.kgeorgiy.java.advanced.iterative.NewListIP;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IterativeParallelism implements NewListIP {
    private static <E> List<E> sparse(final List<E> items, final int step) {
        return new AbstractList<>() {
            @Override
            public E get(final int index) {
                return items.get(index * step);
            }

            @Override
            public int size() {
                return (items.size() + step - 1) / step;
            }
        };
    }

    /**
     * Join values to string.
     *
     * @param threads number of concurrent threads.
     * @param values  values to join.
     * @param step    step size.
     * @return list of joined results of {@link Object#toString()} call on each value.
     * @throws InterruptedException if executing thread was interrupted.
     */
    @Override
    public String join(int threads, List<?> values, int step) throws InterruptedException {
        Function<List<?>, String> f = list -> list.stream().map(Object::toString).collect(Collectors.joining());
        return perform(threads, values, f, step)
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    /**
     * Filters values by predicate.
     *
     * @param threads   number of concurrent threads.
     * @param values    values to filter.
     * @param predicate filter predicate.
     * @param step      step size.
     * @return list of values satisfying given predicate. Order of values is preserved.
     * @throws InterruptedException if executing thread was interrupted.
     */
    @Override
    public <T> List<T> filter(int threads, List<? extends T> values, Predicate<? super T> predicate, int step) throws InterruptedException {
        Function<List<? extends T>, List<T>> f = list -> list.stream().filter(predicate).collect(Collectors.toList());
        return merge(perform(threads, values, f, step));
    }

    /**
     * Maps values.
     *
     * @param threads number of concurrent threads.
     * @param values  values to map.
     * @param f       mapper function.
     * @param step    step size.
     * @return list of values mapped by given function.
     * @throws InterruptedException if executing thread was interrupted.
     */
    @Override
    public <T, U> List<U> map(int threads, List<? extends T> values, Function<? super T, ? extends U> f, int step) throws InterruptedException {
        Function<List<? extends T>, List<U>> mapper = list -> list.stream().map(f).collect(Collectors.toList());
        return merge(perform(threads, values, mapper, step));
    }

    /**
     * Returns maximum value.
     *
     * @param threads    number of concurrent threads.
     * @param values     values to get maximum of.
     * @param comparator value comparator.
     * @param step       step size.
     * @return maximum of given values
     * @throws InterruptedException   if executing thread was interrupted.
     * @throws NoSuchElementException if no values are given.
     */
    @Override
    public <T> T maximum(int threads, List<? extends T> values, Comparator<? super T> comparator, int step)
            throws InterruptedException {
        Function<List<? extends T>, T> f = list -> Collections.max(list, comparator);
        List<T> results = perform(threads, values, f, step);
        return results
                .stream()
                .reduce(results.get(0), (a, b) -> comparator.compare(a, b) >= 0 ? a : b);
    }

    /**
     * Returns minimum value.
     *
     * @param threads    number of concurrent threads.
     * @param values     values to get minimum of.
     * @param comparator value comparator.
     * @param step       step size.
     * @return minimum of given values
     * @throws InterruptedException   if executing thread was interrupted.
     * @throws NoSuchElementException if no values are given.
     */
    public <T> T minimum(int threads, List<? extends T> values, Comparator<? super T> comparator, int step)
            throws InterruptedException {
        Function<List<? extends T>, T> f = list -> Collections.min(list, comparator);
        List<T> results = perform(threads, values, f, step);
        return results
                .stream()
                .reduce(results.get(0), (a, b) -> comparator.compare(a, b) > 0 ? b : a);
    }

    /**
     * Returns whether all values satisfy predicate.
     *
     * @param threads   number of concurrent threads.
     * @param values    values to test.
     * @param predicate test predicate.
     * @param step      step size.
     * @return whether all values satisfy predicate or {@code true}, if no values are given.
     * @throws InterruptedException if executing thread was interrupted.
     */
    @Override
    public <T> boolean all(int threads, List<? extends T> values, Predicate<? super T> predicate, int step) throws InterruptedException {
        Function<List<? extends T>, Boolean> f = list -> list.stream().allMatch(predicate);
        // :NOTE: !any(predicate.negate())
        return perform(threads, values, f, step)
                .stream()
                .allMatch(a -> a);
    }

    /**
     * Returns whether any of values satisfies predicate.
     *
     * @param threads   number of concurrent threads.
     * @param values    values to test.
     * @param predicate test predicate.
     * @param step      step size.
     * @return whether any value satisfies predicate or {@code false}, if no values are given.
     * @throws InterruptedException if executing thread was interrupted.
     */
    @Override
    public <T> boolean any(int threads, List<? extends T> values, Predicate<? super T> predicate, int step) throws InterruptedException {
        Function<List<? extends T>, Boolean> f = list -> list.stream().anyMatch(predicate);
        return perform(threads, values, f, step)
                .stream()
                .anyMatch(Boolean::booleanValue);
    }

    /**
     * Returns number of values satisfying predicate.
     *
     * @param threads   number of concurrent threads.
     * @param values    values to test.
     * @param predicate test predicate.
     * @param step      step size.
     * @return number of values satisfying predicate.
     * @throws InterruptedException if executing thread was interrupted.
     */
    @Override
    public <T> int count(int threads, List<? extends T> values, Predicate<? super T> predicate, int step) throws InterruptedException {
        Function<List<? extends T>, Integer> f = list -> (int) list.stream().filter(predicate).count();
        return perform(threads, values, f, step)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private <T, R> List<R> perform(int threads, List<? extends T> values, Function<List<? extends T>, R> operation, int step) throws InterruptedException {
        threads = Math.min(threads, values.size());
        List<List<? extends T>> parts = makeParts(values, threads, step);
        threads = Math.min(threads, parts.size());
        // :NOTE: Better to use List<>, then streams can be used
        Thread[] threadList = new Thread[threads];
        List<R> results = new ArrayList<>(Collections.nCopies(threads, null));
        for (int i = 0; i < threads; i++) {
            final int finalI = i;
            threadList[i] = new Thread(() -> {
                results.set(finalI, operation.apply(parts.get(finalI)));
            });
            threadList[i].start();
        }
        // :NOTE: thread leak
        for (Thread x : threadList) {
            x.join();
        }
        return results;
    }

    private <T> List<List<? extends T>> makeParts(List<? extends T> list, int threads, int step) {
        List<List<? extends T>> parts = new ArrayList<>();
        List<? extends T> sparseList = sparse(list, step);
        int size = sparseList.size();
        int count = (int) Math.ceil((double) size / threads);
        for (int i = 0; i < size; i += count) {
            // :NOTE: last part should spread evenly
            parts.add(sparseList.subList(i, Math.min(i + count, size)));
        }
        return parts;
    }

    private <U> List<U> merge(List<List<U>> results) {
        return results
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
