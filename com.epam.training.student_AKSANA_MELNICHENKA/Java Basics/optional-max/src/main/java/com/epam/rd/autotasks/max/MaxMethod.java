package com.epam.rd.autotasks.max;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt result;

        if (values != null && values.length != 0){
            result = Arrays.stream(values).max();
        } else {
            result = OptionalInt.empty();
        }

        return result;
    }
}
