package org.example.part02.ch11.code;

import java.util.function.Supplier;

public class Thunk<T> implements Supplier<T> {

    private final Supplier<T> expression;

    private T result;

    private int count;

    public Thunk(Supplier<T> expression) {
        this.expression = expression;
    }

    @Override
    public T get() {
        if (this.result == null) {
            count++;
            this.result = this.expression.get();
        }
        return this.result;
    }

    public static <T> Thunk<T> of(Supplier<T> expression) {
        if (expression instanceof Thunk<T>) {
            return (Thunk<T>) expression;
        }

        return new Thunk<T>(expression);
    }

    public int getCount() {
        return count;
    }
}
