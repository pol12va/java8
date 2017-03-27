package com.sg.lambda.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Excercises {

    public static void main(String[] args) {
        System.out.println(countRegular("I think here IS 9 REGULAR CHARS"));
        System.out.println(findMaxRegCount(
                Arrays.asList(
                        "NO REGULAR", "Two REGULAR", "all regular", "big all regular", "regular")
                ).get()
        );
    }

    public static int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(n -> n).sum();
    }

    public static long countRegular(String str) {
        return str.chars()
//                .peek(System.out::println)
                .filter(c -> c >= 97 && c <= 122)
                .count();
    }

    public static Optional<String> findMaxRegCount(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(str -> str.chars()
                        .filter(c -> c >= 97 && c <= 122)
                        .count())
                );
    }


}
