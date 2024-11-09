package info.kgeorgiy.ja.bagautdinov.hello;

import info.kgeorgiy.java.advanced.hello.NewHelloServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloUDPServer implements NewHelloServer {

    private ExecutorService portsExecutor;
    private ExecutorService submitExecutor;
    private Map<Integer, DatagramSocket> portSockets;

    protected static String getMessage(final DatagramPacket packet) {
        return new String(
                packet.getData(),
                packet.getOffset(),
                packet.getLength(),
                StandardCharsets.UTF_8
        );
    }

    /**
     * Starts a new Hello server.
     * This method should return immediately.
     *
     * @param threads number of working threads.
     * @param ports   port no to response format mapping.
     */
    @Override
    public void start(int threads, Map<Integer, String> ports) {
        if (ports.isEmpty()) {
            return;
        }
        portSockets = new HashMap<>();
        portsExecutor = Executors.newFixedThreadPool(ports.size());
        submitExecutor = Executors.newFixedThreadPool(threads);
        ports.keySet()
                .forEach(key -> {
                    try {
                        portSockets.put(key, new DatagramSocket(key));
                    } catch (SocketException e) {
                        // :NOTE: error?
                        System.err.printf("Socket exception: %s%n", e.getLocalizedMessage());
                    }
                    String format = ports.get(key);
                    portsExecutor.submit(() -> {
                        start(key, format);
                    });
                });

    }

    private void start(int port, String format) {
        try {
            DatagramSocket datagramSocket = portSockets.get(port);
            int buffSize = datagramSocket.getReceiveBufferSize();
            while (!Thread.interrupted()) {
                DatagramPacket packet = new DatagramPacket(new byte[buffSize], buffSize);
                datagramSocket.receive(packet);
                submitExecutor.submit(() -> sendMessage(packet, port, format));
            }
        } catch (SocketException e) {
            System.err.printf("Socket exception on port: %s, %s%n", port, e.getLocalizedMessage());
        } catch (IOException e) {
            System.err.printf("IO exception on port: %s, %s%n", port, e.getLocalizedMessage());
        } catch (SecurityException e) {
            System.err.printf("Security exception manager on port: %s, %s%n", port, e.getLocalizedMessage());
        }
    }

    /**
     * Stops server and deallocates all resources.
     */
    @Override
    public void close() {
        if (portSockets != null && !portSockets.isEmpty()) {
            for (DatagramSocket socket : portSockets.values()) {
                socket.close();
            }
        }
        if (submitExecutor != null && !submitExecutor.isShutdown()) {
            submitExecutor.close();
        }
        if (portsExecutor != null && !portsExecutor.isShutdown()) {
            portsExecutor.close();
        }
    }

    private void sendMessage(DatagramPacket packet, int port, String format) {
        byte[] sendData = format.replaceAll("\\$", getMessage(packet)).getBytes(StandardCharsets.UTF_8);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                packet.getAddress(), packet.getPort());
        try {
            portSockets.get(port).send(sendPacket);
        } catch (IOException e) {
            System.err.printf("IO exception on port: %s, %s%n", port, e.getLocalizedMessage());
        }
    }
}
