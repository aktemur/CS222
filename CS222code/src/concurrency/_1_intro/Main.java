package concurrency._1_intro;

import java.util.ArrayList;

public class Main {
    static ArrayList<Printer> printers = new ArrayList<>();
    static int NUM_PRINTERS = 10;

    public static void main(String[] args) throws InterruptedException {
        // Create Printer objects and put into the list.
        // At this time, the object are created only, they don't start running
        for (int i = 0; i < NUM_PRINTERS; i++) {
            Printer printer = new Printer(i);
            printers.add(printer);
        }

        for (Printer printer : printers) {
            printer.start();
        }

        for (Printer printer : printers) {
            printer.join();
        }
    }
}
