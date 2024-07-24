package org.example.part02.ch13.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComposeCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //thenCompose();
        thenCombine();
    }

    public static void thenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        // Future 간에 연관 관계가 있는 경우
        CompletableFuture<String> future = hello.thenCompose(ComposeCompletableFuture::message);
        System.out.println(future.get());
    }

    static CompletableFuture<String> message(String message) {
        return CompletableFuture.supplyAsync(() -> {
            return message + " " + "World";
        });
    }

    static void thenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            return "World";
        });

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future.get());
    }

}
