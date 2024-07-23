package org.example.part02.ch13.code;

import java.util.concurrent.*;

public class FutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> expensiveTask = () -> {
            System.out.println("Task start");

            TimeUnit.SECONDS.sleep(2);

            System.out.println("Task done");
            
            return 42;
        };

        System.out.println("before submitting the task");

        Future<Integer> future = executor.submit(expensiveTask);

        System.out.println("after submitting the task");

        Integer theAnswer = future.get();

        System.out.println("after the blocking call future.get()");
        System.out.println(theAnswer);

        executor.shutdown();
    }
}
