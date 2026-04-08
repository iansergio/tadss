package exercises.ex05;

import exercises.ex05.entity.Bank;
import exercises.ex05.entity.Transaction;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(100, 1000);
        System.out.println("Estado inicial do banco");
        System.out.println("Saldo do banco:" + bank.getTotal() + " Transações: " + bank.getTransactions());
        
        for (int i = 0; i < 5; i++) {
            Thread.ofPlatform().start(new Transaction(bank));
        }

        long ini = System.currentTimeMillis();

        while (true) {
            Thread.sleep(5000);
            System.out.println("Saldo do banco: " + bank.getTotal() + " Transações: " + bank.getTransactions());
            
            if (System.currentTimeMillis() - ini >= 180000L) {
                break;
            }
        }
    } 
}
