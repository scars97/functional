package org.example.part02.ch05.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableRecordEx {

    public static void main(String[] args) {
        List<String> mutableList = Arrays.asList("A", "B");

        IncreaseImmutability immutability = new IncreaseImmutability(mutableList);

        //mutableList.add("C"); // UnsupportedOperationException

        List<String> values = immutability.values;
        //values.add("C"); // UnsupportedOperationException

        System.out.println(values);
    }

    public record IncreaseImmutability(List<String> values) {

        public IncreaseImmutability {
            values = Collections.unmodifiableList(values);
        }
    }
}
