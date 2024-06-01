package org.example.part02.ch05.code;

import java.util.Objects;
import java.util.Optional;

public class OptionalRecord {

    public static void main(String[] args) {
        User user = new User("userId", "성현", null);
        System.out.println(user.email);

    }

    public record User(String id, String name, Optional<String> email) {

        public User {
            Objects.requireNonNull(email, "Optional<String> group must not be null");
        }

        /*public User(String id, String name, String email) {
            this(id, name, Optional.ofNullable(email));
        }*/
    }
}
