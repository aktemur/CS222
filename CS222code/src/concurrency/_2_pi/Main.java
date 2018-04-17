package concurrency._2_pi;

import java.util.ArrayList;
import java.util.Random;

/**
 * Problem:
 * Calculate an approximate value of Pi using the Monte Carlo simulation approach
 *
 * Can we use concurrency to decrease the total running time?
 *
 */

public class Main {
    private static int MAX = 100000000;
    private static int NUM_THREADS = 8;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<PiCalculator> calculators = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            calculators.add(new PiCalculator(i, MAX/NUM_THREADS));
        }

        long start = System.currentTimeMillis();

        for (PiCalculator calculator : calculators) {
            calculator.start();
        }
        for (PiCalculator calculator : calculators) {
            calculator.join();
        }

        int hits = 0;
        for (PiCalculator calculator : calculators) {
            hits += calculator.getNumHits();
        }

        double pi = 4.0 * hits / MAX;

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Duration:     " + duration + " ms");
        System.out.println("Found PI:    " + pi);
        System.out.println("System's PI: " + Math.PI);
        System.out.println("Error:       " + (Math.abs(Math.PI - pi) / Math.PI));
    }
}
