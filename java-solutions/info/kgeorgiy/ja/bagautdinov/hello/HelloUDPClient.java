package info.kgeorgiy.ja.bagautdinov.hello;

import info.kgeorgiy.java.advanced.hello.HelloClient;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static info.kgeorgiy.ja.bagautdinov.hello.HelloUDPServer.getMessage;

public class HelloUDPClient implements HelloClient {
    final int TIMEOUT = 100;

    private static String i18n(String request) {
        StringBuilder result = new StringBuilder();
        request.chars().forEach(c -> {
            if (Character.isDigit(c)) {
                result.append(Character.getNumericValue(c));
            } else {
                result.append((char) c);
            }
        });
        return result.toString();
    }

    /**
     * Runs Hello client.
     * This method should return when all requests are completed.
     *
     * @param host     server host
     * @param port     server port
     * @param prefix   request prefix
     * @param threads  number of request threads
     * @param requests number of requests per thread.
     */
    @Override
    public void run(String host, int port, String prefix, int threads, int requests) {
        try {
            InetSocketAddress address = new InetSocketAddress(InetAddress.getByName(host), port);
            try (ExecutorService service = Executors.newFixedThreadPool(threads)) {
                IntStream.range(1, threads + 1).forEach(i ->
                        service.submit(() -> process(address, prefix + i, requests)));
            }
        } catch (UnknownHostException e) {
            System.err.printf("Unknown host: %s%n", host);
        }
    }

    private void process(InetSocketAddress address, String prefix, int requests) {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(TIMEOUT);
            int buffSize = socket.getSendBufferSize();
            byte[] sendData = new byte[buffSize];
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address);
            IntStream.range(1, requests + 1)
                    .forEach(i -> {
                        String message = prefix + "_" + i;
                        packet.setData(message.getBytes(StandardCharsets.UTF_8));
                        while (!Thread.currentThread().isInterrupted()) {
                            try {
                                socket.send(packet);
                                socket.receive(sendPacket);
                                String received = i18n(getMessage(sendPacket));
                                if (received.contains(message)) {
                                    break;
                                }
                            } catch (IOException e) {
                                System.err.printf("IO exception: %s%n", e.getLocalizedMessage());
                            }
                        }
                    });
        } catch (SocketException e) {
            System.err.printf("Socket exception: %s%n", e.getLocalizedMessage());
        }
    }

}
