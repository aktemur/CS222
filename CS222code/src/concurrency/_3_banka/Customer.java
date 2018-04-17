package concurrency._3_banka;

class Customer extends Thread {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public void run() {
        for(int i = 0; i < 1000; i++) {
            account.deposit(1);
        }
    }
}
