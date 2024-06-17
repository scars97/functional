package org.example.part02.ch08.code;

import java.util.ArrayList;
import java.util.List;

public class ParallelEx {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(i);
        }

        // 단일 스레드 처리 시간 측정
        long startTime = System.nanoTime();
        /*int[] singleThreadMultiple1 = numbers.stream()
                .mapToInt(n -> n * n)
                .toArray();*/
        Object[] singleThreadMultiple2 = numbers.stream()
                .map(n -> n * n)
                .toArray();
        long singleThreadTime = System.nanoTime() - startTime;

        System.out.println("단일 스레드 처리 시간: " + singleThreadTime / 1_000_000.0 + " ms");

        // 병렬 스트림 처리 시간 측정
        startTime = System.nanoTime();
        /*int[] multiThreadMultiple1 = numbers.parallelStream()
                .mapToInt(n -> n * n)
                .toArray();*/
        Object[] multiThreadMultiple2 = numbers.parallelStream()
                .map(n -> n * n)
                .toArray();
        long parallelStreamTime = System.nanoTime() - startTime;

        System.out.println("병렬 스트림 처리 시간: " + parallelStreamTime / 1_000_000.0 + " ms");

        if (singleThreadTime < parallelStreamTime) {
            System.out.println("단일 승");
        } else {
            System.out.println("멀티 승");
        }
        
    }
}
