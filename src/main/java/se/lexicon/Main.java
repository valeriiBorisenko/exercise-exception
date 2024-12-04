package se.lexicon;

import se.lexicon.exceptions.InsufficientFundsException;
import se.lexicon.exceptions.OutOfRangeException;
import se.lexicon.model.BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //BasicExceptionHandling();
        //MultipleExceptionTypes();
        CustomException();
    }

    public static void BasicExceptionHandling () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int number1 = scanner.nextInt();
        System.out.println("Enter number 2:");
        int number2 = scanner.nextInt();

        try {
            System.out.println("Result: " + (number1 / number2));
            scanner.close();
        } catch (ArithmeticException exception) {
            System.out.println("You cannot " + exception.getMessage());
        }
    }

    public static void MultipleExceptionTypes () {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter a number from 1 to 100");
         int number = scanner.nextInt();

         try {
             if (number < 1 || number > 100) {
                 throw new OutOfRangeException(number, "Wrong number. Number should be between 0 to 100");
             }

             System.out.println("Result: " + number);
             scanner.close();
         } catch (InputMismatchException exception) {
             System.out.println(exception.getMessage());
         }
    }

    public static void CustomException() {
        BankAccount account = new BankAccount(0);
        boolean status = true;

        while (status) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------");
            System.out.println("Choice method: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check your balance");
            System.out.println("0. Close");
            int method = scanner.nextInt();
            switch (method) {
                case 1:
                    System.out.println("Enter your deposit: ");
                    double deposit = scanner.nextInt();
                    try {
                        if (deposit == 0) {
                            throw new InsufficientFundsException(deposit, account.getBalance(), "You cannot deposit 0");
                        } else {
                            account.deposit(deposit);
                            System.out.println("Accepted. Your balance: " + account.getBalance());
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter your withdrawal: ");
                    double withdrawal = scanner.nextInt();
                    try {
                        if (withdrawal == 0) {
                            throw new InsufficientFundsException(withdrawal, account.getBalance(), "You cannot deposit 0");
                        } else if (account.getBalance() < withdrawal) {
                            throw new InsufficientFundsException(withdrawal, account.getBalance(), "Balance is insufficient..");
                        } else {
                            account.withdrawal(withdrawal);
                            System.out.println("Accepted. Your balance: " + account.getBalance());
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Your balance: " + account.getBalance());
                    break;
                case 0:
                    System.out.println("Have a nice day!");
                    status = false; break;
                default: throw new RuntimeException("Wrong method. Try again");
            }
        }


    }
}