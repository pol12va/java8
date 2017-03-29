package com.sg.lambda.chapter6.excercises;

import java.util.List;

public class Multiplier {

    public long multiply(List<Integer> numbers) {
        return numbers.parallelStream()
                .reduce(1,
                        (acc, n) -> acc * n) * 5;
    }

}
