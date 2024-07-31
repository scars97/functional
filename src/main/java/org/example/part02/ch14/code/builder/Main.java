package org.example.part02.ch14.code.builder;

public class Main {

    public static void main(String[] args) {
        User.Builder builder = User.builder()
                .name("성현")
                .email("email@email");

        User user = builder.addPermission("create")
                .addPermission("edit")
                .build();

        System.out.println(user);


        UserWith user2 = UserWith.builder()
                .with(with -> {
                    with.email = "email2@email2";
                    with.name = "성현2";
                })
                .withPermissions(permissions -> {
                    permissions.add("create");
                    permissions.add("edit");
                })
                .build();

        System.out.println(user2);
    }
}
