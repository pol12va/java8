package com.sg.lambda.chapter6.excercises;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class ParallelSum {
    private List<Integer> numbers = new ArrayList<>();

    public static void main(String[] ignore) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + ParallelSum.class.getSimpleName() + ".*")
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void init() {
        IntStream.range(0, 1_000_000)
                .forEach(numbers::add);
    }

    @Benchmark
    public long sum() {
        return numbers
//                .stream()
                .parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, n) -> acc + n);
    }

//    @Benchmark
    public long sumOfSquares() {
        return numbers
                .parallelStream()
                .mapToInt(x -> x * x)
                .reduce(0, (acc, n) -> acc + n);

    }

}
