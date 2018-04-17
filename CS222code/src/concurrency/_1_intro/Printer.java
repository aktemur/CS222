package concurrency._1_intro;

public class Printer extends Thread {
    private int id;

    public Printer(int id) {
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("Hello from " + id);
        }
    }
}
