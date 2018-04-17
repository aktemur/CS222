package concurrency._3_banka;

import java.util.concurrent.locks.*;

class Account {
    int balance = 0;
    Lock lock = new ReentrantLock();

    public void deposit(int d) {
        try {
            lock.lock();
            balance = balance + d;
        } finally {
            lock.unlock();
        }
    }

    public int balance() {
        return balance;
    }
}
