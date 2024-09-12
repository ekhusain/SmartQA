package de.telekom.simple.ta.exceptions;

public class FileNotFoundException extends Exception {

    public FileNotFoundException(String var1) {
        super("File not found: " + var1);
    }

    public FileNotFoundException(String var1, Throwable var2) {
        super("File not found: " + var1, var2);
    }
}