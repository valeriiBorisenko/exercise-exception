package se.lexicon.exceptions;

public class InsufficientFundsException extends RuntimeException {
    private double balance;
    private double amount;

    public InsufficientFundsException(double amount, double balance, String message) {
        super(message);
        this.amount = amount;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }
}
