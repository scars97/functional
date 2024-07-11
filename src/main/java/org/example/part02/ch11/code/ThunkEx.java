package org.example.part02.ch11.code;

public class ThunkEx {

    public static void main(String[] args) {

        Thunk<String> expensiveOperation = Thunk.of(ThunkEx::performExpensiveOperation);

        System.out.println("Before calling the thunk");

        String result = expensiveOperation.get();
        System.out.println("Result: " + result);

        System.out.println("Cached Result: " + expensiveOperation.get());
    }

    private static String performExpensiveOperation() {
        System.out.println("비용이 많이 드는 작업이야!");
        return "비용이 많이 들었지만 해냈어..";
    }
}
