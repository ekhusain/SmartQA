package de.telekom.simple.ta.common;

public class BooleanPackedResponse<T> {
    private final T a;
    private final boolean b;

    public BooleanPackedResponse(T var1, boolean var2) {
        this.a = var1;
        this.b = var2;
    }

    public T getResponse() {
        return this.a;
    }

    public boolean getBoolean() {
        return this.b;
    }

    public String toString() {
        return "BooleanPackedResponse{response=" + this.a + ", aBoolean=" + this.b + '}';
    }
}