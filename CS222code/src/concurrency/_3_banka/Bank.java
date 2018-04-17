package concurrency._3_banka;

import java.util.*;

public class Bank {
    static int NUM_CUSTOMERS = 5;
    
    public static void main(String[] args) throws InterruptedException {
        List<Customer> customers = new ArrayList<Customer>();
        Account sharedAccount = new Account();
        
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer musteri = new Customer(sharedAccount);
            customers.add(musteri);
        }

        for (Customer customer : customers) {
            customer.start();
        }

        for (Customer customer : customers) {
            customer.join();
        }

        System.out.println("Final balance: " + sharedAccount.balance());
    }
}

