package five.entity;

public class Account {
    private double amount;

    public Account(double amount) {
        this.amount = amount;
    }

    public void deposit(double value) {
        amount += value;
    }

    public void withdraw(double value) {
        amount -= value;
    }

    public double getAmount() {
        return amount;
    }
}
