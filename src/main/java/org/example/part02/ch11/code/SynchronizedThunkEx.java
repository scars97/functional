package org.example.part02.ch11.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedThunkEx {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThunk<String> expensiveOperation = new SynchronizedThunk<>(SynchronizedThunkEx::performExpensiveOperation);
        //Thunk<String> expensiveOperation = Thunk.of(SynchronizedThunkEx::performExpensiveOperation);

        // 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 여러 스레드에서 Thunk의 get 메서드 호출
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                String result = expensiveOperation.get();
                System.out.println("Result: " + result);
            });
        }

        // 스레드 풀 종료
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Thunk를 다시 호출해도 이미 계산된 결과 반환
        System.out.println("Cached Result: " + expensiveOperation.get());
        System.out.println("동기화 문제 발생: " + (expensiveOperation.getCount() - 1));

    }

    private static String performExpensiveOperation() {
        System.out.println("비용이 많이 드는 작업이야!");

        try {
            Thread.sleep(1000); // 1초 지연
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "비용이 많이 들었지만 해냈어..";
    }
}
