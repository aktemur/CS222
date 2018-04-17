package concurrency._4_philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick {
    int id;
    Lock lock = new ReentrantLock();

    public Chopstick(int id) {
        this.id = id;
    }

    public void take(Philosopher taker) {
        lock.lock();
        System.out.println(taker + " owns " + this);
    }

    public void put(Philosopher taker) {
        System.out.println(taker + " puts " + this);
        lock.unlock();
    }

    public String toString() {
        return "Chopstick " + id;
    }
}
