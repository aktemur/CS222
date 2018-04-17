package concurrency._5_billboard;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Billboard bb = new Billboard();

        // Sequential test
        bb.write("WASH THE CAT");
        System.out.println("Message: " + bb.read());
        bb.write("SELL THE CAR");
        System.out.println("Message: " + bb.read());
        System.out.println();

        // Parallel test
        Writer writer1 = new Writer(bb);
        Writer writer2 = new Writer(bb);
        Reader reader1 = new Reader(bb);
        Reader reader2 = new Reader(bb);
        Reader reader3 = new Reader(bb);
        writer1.start();
        writer2.start();
        reader1.start();
        reader2.start();
        reader3.start();

        writer1.join();
        writer2.join();
        reader1.join();
        reader2.join();
        reader3.join();
    }
}
        
