package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (MyException e) {
            System.out.println("예외 처리: " + e.getMessage());
        } finally {
            System.out.println("finally 블록 실행");
        }
        System.out.println("프로그램 종료");
    }

    public static void methodA() throws MyException {
        System.out.println("methodA 시작");
        methodB();
        System.out.println("methodA 종료");
    }

    public static void methodB() throws MyException {
        System.out.println("methodB 시작");
        throw new MyException("문제가 발생했습니다!"); // 예외 발생
    }

    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

}