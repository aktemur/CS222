package concurrency._2_pi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PiCalculator extends Thread {
    private int numHits;
    private int numShots;

    public PiCalculator(int id, int numShots) {
        this.numShots = numShots;
    }

    public void run() {
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < numShots; i++) {
            double x = random.nextDouble(); // between 0 and 1
            double y = random.nextDouble(); // between 0 and 1
            double distance = Math.sqrt(x*x + y*y);
            if (distance <= 1) {
                numHits++;
            }
        }
    }

    public int getNumHits() {
        return numHits;
    }
}
