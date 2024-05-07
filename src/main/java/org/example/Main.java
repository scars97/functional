package org.example;


public class Main {
    public static void main(String[] args) {

        HelloWorld helloWorld = new HelloWorld() {
            @Override
            public String sayHello(String name) {
                return "hello, " + name + "!";
            }
        };

        System.out.println(helloWorld.sayHello("성현"));

        HelloWorld helloWorldLambda = name -> "hello, " + name + "!";

        System.out.println(helloWorldLambda.sayHello("성현2"));

    }

    interface HelloWorld {
        String sayHello(String name);
    }
}