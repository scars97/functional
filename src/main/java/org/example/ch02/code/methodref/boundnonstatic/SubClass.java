package org.example.ch02.code.methodref.boundnonstatic;

import java.util.function.Function;

public class SubClass extends SuperClass{

    @Override
    public String isHard(String input) {
        return input + " 어렵다";
    }

    public void superAndThis(String input) {
        Function<String, String> thisHard = this::isHard;
        String thisResult = thisHard.apply(input);
        System.out.println(thisResult);

        Function<String, String> superHard = super::isHard;
        String superResult = superHard.apply(input);
        System.out.println(superResult);
    }
}
