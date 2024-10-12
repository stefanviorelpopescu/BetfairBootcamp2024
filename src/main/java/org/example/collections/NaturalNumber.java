package org.example.collections;

public class NaturalNumber<T extends Number> {

    private final T n;

    public NaturalNumber(T n) {
        this.n = n;
    }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }
}
