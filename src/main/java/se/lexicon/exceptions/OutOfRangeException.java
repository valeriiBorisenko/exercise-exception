package se.lexicon.exceptions;

public class OutOfRangeException extends RuntimeException{

    private int number;

    public OutOfRangeException(int number, String message) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
