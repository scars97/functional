package org.example.part02.ch13.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class CreateCompletableFutureEx {

    public static void main(String[] args) {
        ForkJoinPool executorService = ForkJoinPool.commonPool();

        Future<?> futureRunnable = executorService.submit(() -> System.out.println("not returning a value"));

        Future<String> submit = executorService.submit(() -> "Hello, Async World!");

        CompletableFuture<Void> completableFutureRunnable =
                CompletableFuture.runAsync(() -> System.out.println("not returning a value"));

        CompletableFuture<String> completableFutureSupplier =
                CompletableFuture.supplyAsync(() -> "Hello, Async World!");

    }
}
