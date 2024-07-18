package org.example.part02.ch12.code;

import java.util.function.Consumer;

public record Node<T>(T value, Node<T> left, Node<T> right) {

    public static <T> Node<T> of(T value, Node<T> left, Node<T> right) {
        return new Node<>(value, left, right);
    }

    public static <T> Node<T> of(T value) {
        return new Node<>(value, null, null);
    }

    public static <T> Node<T> left(T value, Node<T> left) {
        return new Node<>(value, left, null);
    }

    public static <T> Node<T> right(T value,  Node<T> right) {
        return new Node<>(value, null, right);
    }

    private static <T> void traverse(Node<T> node, Consumer<T> fn) {
        if (node == null) {
            return;
        }

        traverse(node.left(), fn);

        fn.accept(node.value);

        traverse(node.right(), fn);
    }

    public void traverse(Consumer<T> fn) {
        Node.traverse(this, fn);
    }
}
