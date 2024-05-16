package org.example.ch03.code;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamEx {

    public static void main(String[] args) {

        List<Member> members = createMember();

        members.stream()
                .filter(member -> member.nameLength())
                .map(member -> member.getName())
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name));

        // 출력
        // STEVE
        // KENNY
        // MARIA
    }

    static List<Member> createMember() {
        return Arrays.asList(
                new Member("john"),
                new Member("steve"),
                new Member("dave"),
                new Member("kenny"),
                new Member("maria")
        );
    }

    static class Member {
        String name;

        public Member(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        boolean nameLength() {
            return this.name.length() >= 5;
        }
    }
}
