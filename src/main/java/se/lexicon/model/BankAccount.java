package se.lexicon.model;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawal (double amount) {
        this.balance -= amount;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }
}
