package org.example.part02.ch11.code;

import java.util.function.Supplier;

public class SynchronizedThunk<T> implements Supplier<T> {

    private static class Holder<T> implements Supplier<T> {
        private final T value;

        Holder(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return this.value;
        }
    }

    private Supplier<T> holder;

    private int count;

    public SynchronizedThunk(Supplier<T> expression) {
        this.holder = () -> evaluate(expression);
    }

    private synchronized T evaluate(Supplier<T> expression) {
        if (!Holder.class.isInstance(this.holder)) {
            count++;
            var evaluated = expression.get();
            this.holder = new Holder<>(evaluated);
        }

        return this.holder.get();
    }

    @Override
    public T get() {
        return this.holder.get();
    }

    public int getCount() {
        return count;
    }
}
