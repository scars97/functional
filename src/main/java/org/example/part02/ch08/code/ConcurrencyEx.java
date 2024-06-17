package org.example.part02.ch08.code;

public class ConcurrencyEx {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println("작업 1 시작");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("작업 1 종료");
        };

        Runnable task2 = () -> {
            System.out.println("작업 2 시작");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("작업 2 종료");
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
