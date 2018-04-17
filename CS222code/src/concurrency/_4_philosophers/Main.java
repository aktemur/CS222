package concurrency._4_philosophers;

public class Main {
    static int NUM_PHILOSOPHERS = 5;
    
    public static void main(String[] args) throws InterruptedException {
        Chopstick[] sticks = new Chopstick[NUM_PHILOSOPHERS];

        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = new Chopstick(i);
        }
        
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, sticks[i], sticks[(i + 1) % NUM_PHILOSOPHERS]);
        }

        for (Philosopher phil : philosophers) {
            phil.start();
        }

        for (Philosopher phil : philosophers) {
            phil.join();
        }
    }   
}
