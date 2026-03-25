package five.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int transactions;

    public Bank(int accountsNumber, double initialAmount) {
        this.accounts = new ArrayList<>();

        for (int i = 0; i < accountsNumber; i++) {
            accounts.add(new Account(initialAmount));
        }
    }

    // Faz a transação
    public synchronized void transaction(int debit, int credit, double value) {
        accounts.get(debit).withdraw(value);
        accounts.get(credit).deposit(value);
    }

    public synchronized double getTotal() {
        double total = 0;

        for (Account ac : accounts) {
            total += ac.getAmount();
        }
        return total;
    }

    public int getTransactions() {
        return this.transactions;
    }
}
