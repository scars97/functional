package org.example.part02.ch13.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExecuteCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runAsync();
    }

    private static void runAsync() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        future.get();
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    private static void supplyAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Thread: " + Thread.currentThread().getName();
        });

        System.out.println(future.get());
        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}
