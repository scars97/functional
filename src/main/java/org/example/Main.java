package org.example;

import java.time.LocalTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = buildGreeting("성현");
        System.out.println(s);
    }

    public static String buildGreeting(String name) {
        var now = LocalTime.now();

        if (now.getHour() < 12) {
            return "Good morning " + name;
        } else {
            return "Hello " + name;
        }
    }
}