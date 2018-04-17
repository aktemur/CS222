package concurrency._5_billboard;

class Writer extends Thread {
    Billboard bb;

    public Writer(Billboard bb) {
        this.bb = bb;
    }

    public void run() {
        try {
            while(true) {
                bb.write("WASH THE CAT");
                sleep(50);
                bb.write("SELL THE CAR");
                sleep(50);
            }
        } catch(InterruptedException e) {}
    }
}
