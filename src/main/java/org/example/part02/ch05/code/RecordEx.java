package org.example.part02.ch05.code;

import java.time.LocalDateTime;
import java.util.Objects;

public class RecordEx {

    public record User( String name, boolean active, LocalDateTime lastLogin) {

        public User {
            Objects.requireNonNull(name);
            Objects.requireNonNull(lastLogin);
        }
    }
}
