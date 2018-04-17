package concurrency._5_billboard;

class Reader extends Thread {
    private Billboard bb;

    public Reader(Billboard bb) {
        this.bb = bb;
    }

    public void run() {
        try {
            while(true) {
                String message = bb.read();
                System.out.println("Message: " + message);
                sleep(50);
            }
        } catch(InterruptedException e) {}
    }
}
