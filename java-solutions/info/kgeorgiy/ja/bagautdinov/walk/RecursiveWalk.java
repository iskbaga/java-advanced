package info.kgeorgiy.ja.bagautdinov.walk;

public class RecursiveWalk {
    public static void main(String[] args) {
        Walker walker = new Walker(Integer.MAX_VALUE);
        walker.walk(args);
    }
}