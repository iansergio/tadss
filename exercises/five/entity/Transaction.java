package five.entity;

import java.util.Random;

public class Transaction implements Runnable {

    private Bank bank;
    private Random random;

    public Transaction(Bank bank) {
        this.bank = bank;
        this.random = new Random();
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            bank.transaction(random.nextInt(100), random.nextInt(100), random.nextDouble(2500));
        }
    }
    
}
