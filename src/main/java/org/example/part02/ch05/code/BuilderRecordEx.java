package org.example.part02.ch05.code;


public class BuilderRecordEx {

    public static void main(String[] args) {
        User user = new User.UserBuilder().id(1L).username("성현").build();

        System.out.println(user.id());
        System.out.println(user.username());
    }

    public record User(Long id, String username) {

        public static final class UserBuilder {
            private Long id;
            private String username;

            public UserBuilder id(Long id) {
                this.id = id;
                return this;
            }

            public UserBuilder username(String username) {
                this.username = username;
                return this;
            }
            
            public User build() {
                return new User(id, username);
            }
        }
    }

}
