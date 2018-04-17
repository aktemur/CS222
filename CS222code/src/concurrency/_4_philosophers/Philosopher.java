package concurrency._4_philosophers;

class Philosopher extends Thread {
    int id;
    Chopstick leftStick;
    Chopstick rightStick;

    public Philosopher(int n, Chopstick left, Chopstick right) {
        id = n;
        leftStick = left;
        rightStick = right;
    }

    public void run() {
        while(true) {
            think();

            if (id % 2 == 0) {
                leftStick.take(this);
                rightStick.take(this);
            } else {
                rightStick.take(this);
                leftStick.take(this);
            }

            eat();

            leftStick.put(this);
            rightStick.put(this);
        }
    }

    private void think() {
        System.out.println(this + " is philosophizing.");
        try {
            sleep(500);
        } catch (InterruptedException e) {
        }
    }

    private void eat() {
        System.out.println(this + " eats, yum yum.");
        try {
            sleep(200);
        } catch (InterruptedException e) {
        }
    }

    public String toString() {
        return "Philosopher " + id;
    }
}
