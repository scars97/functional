package org.example.part02.ch11.code;

import java.util.HashMap;
import java.util.Map;

public class LazinessMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.computeIfAbsent("key1", k -> {
            System.out.println(k);
            return 42;
        });

        System.out.println(map.get("key1"));

        map.computeIfAbsent("key1", k -> {
            System.out.println("키가 존재하는 경우 계산하지 않는다.");
            return 100;
        });

        System.out.println(map.get("key1"));
    }
}
