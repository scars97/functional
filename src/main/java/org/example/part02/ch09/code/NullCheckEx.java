package org.example.part02.ch09.code;

import java.util.Objects;

public class NullCheckEx {

    public static void main(String[] args) {
        User user = new User(1, null, null);

        System.out.println(user);
    }

    record User(long id, String firstName, String lastName) {

        // null 값 방지를 위한 기본 값 설정
        public User(long id) {
            this(id, "n/a", "n/a");
        }

        public User {
            Objects.requireNonNull(firstName);
            Objects.requireNonNull(lastName);
        }
    }
}
