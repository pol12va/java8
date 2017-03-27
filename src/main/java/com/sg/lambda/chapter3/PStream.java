package com.sg.lambda.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PStream {

    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        stream.reduce(null, (res, cur) -> {
            result.add(mapper.apply(cur));
            return cur;
        });

        return result;
    }

    public static <T> List<T> filter(Stream<T> stream, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        stream.reduce(null, (acc, cur) -> {
            if (predicate.test(cur)) {
                result.add(cur);
            }
            return cur;
        });

        return result;
    }

}
