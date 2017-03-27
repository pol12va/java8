package com.sg.lambda.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringCollector implements Collector<String, StringCombiner, String> {

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private String separator;
    private String prefix;
    private String suffix;

    public StringCollector(String separator, String prefix, String suffix) {
        this.separator = separator;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(separator, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}
