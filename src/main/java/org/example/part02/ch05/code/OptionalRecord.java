package org.example.part02.ch05.code;

import java.util.Objects;
import java.util.Optional;

public class OptionalRecord {

    public static void main(String[] args) {
        User user = new User("userId", "성현", (String) null);
        System.out.println(user);

    }

    public record User(String id, String name, Optional<String> password) {

        public User(String id, String name, String password) {
            this(id, name, Optional.ofNullable(password));

        }
    }
}
