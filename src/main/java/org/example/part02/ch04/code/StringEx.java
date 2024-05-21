package org.example.part02.ch04.code;

public class StringEx {

    public static void main(String[] args) {

        // 객체 생성
        String str1 = new String("asdf");
        String str2 = new String("asdf");

        System.out.println("====인스턴스 생성====");
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true

        // 리터럴
        String literalStr1 = "asdf";
        String literalStr2 = "asdf";

        System.out.println("====리터럴====");
        System.out.println(literalStr1 == literalStr2); // true
        System.out.println(literalStr1.equals(literalStr2)); //true
    }
}
