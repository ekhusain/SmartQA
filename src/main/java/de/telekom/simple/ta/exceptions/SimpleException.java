package de.telekom.simple.ta.exceptions;

public class SimpleException extends RuntimeException {
    private static final long serialVersionUID = 2018090500000932L;

    public SimpleException(String var1) {
        super(var1);
    }

    public SimpleException(String var1, Throwable var2) {
        super(var1, var2);
    }

}