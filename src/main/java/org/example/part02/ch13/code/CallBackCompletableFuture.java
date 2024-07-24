package org.example.part02.ch13.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallBackCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //thenApply();
        //thenAccept();
        thenRun();
    }

    public static void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Thread: " + Thread.currentThread().getName();
        }).thenApply(String::toUpperCase);

        System.out.println(future.get());
    }

    public static void thenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Thread: " + Thread.currentThread().getName();
        }).thenAccept(s -> {
            System.out.println(s.toUpperCase());
        });

        future.get();
    }

    public static void thenRun() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Thread: " + Thread.currentThread().getName();
        }).thenRun(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        future.get();
    }
}
