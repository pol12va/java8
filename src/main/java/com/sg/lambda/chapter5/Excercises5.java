package com.sg.lambda.chapter5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Excercises5 {

    public static String findLongestName(Stream<String> names) {
        String result = names.reduce(
                "",
                (max, name) -> name.length() > max.length() ? name : max);

        return result;
    }

    public static String findLongestNameWithMax(Stream<String> names) {
        return names.max(Comparator.comparing(String::length)).orElse("");
    }

    public static Map<String, Long> groupNamesByCount(Stream<String> names) {
        return names.collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));
    }

    public static long fibonacci(int num) {
        if (num <= 0) {
            return 0;
        }

        Map<Integer, Long> cachedValues = new HashMap<>();
        Long result = 0L;

        for (int i = 1; i <= num; i++) {
            final int ind = i;
            result += cachedValues.computeIfAbsent(
                    ind,
                    (n) -> n == 1 || n == 2 ? 1 : cachedValues.get(ind - 1) + cachedValues.get(ind - 2));
            System.out.println(cachedValues.get(i));
//            System.out.println(result);
        }

        return result;
    }
}
