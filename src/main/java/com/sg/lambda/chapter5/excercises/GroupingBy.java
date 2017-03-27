package com.sg.lambda.chapter5.excercises;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {
    private Function<T, K> keyMapper;
    private Set<Characteristics> characteristics = Collections.emptySet();

    public GroupingBy(Function<T, K> keyMapper) {
        this.keyMapper = keyMapper;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, t) -> {
            K key = keyMapper.apply(t);
            List<T> val = map.get(key);
            if (val == null) {
                List<T> newVal = new ArrayList<>();
                newVal.add(t);
                map.put(key, newVal);
            } else {
                val.add(t);
            }
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (m1, m2) -> {
            for (Map.Entry<K, List<T>> entry : m2.entrySet()) {
                List<T> values = m1.get(entry.getKey());
                if (values == null) {
                    m1.put(entry.getKey(), entry.getValue());
                } else {
                    values.addAll(entry.getValue());
                }
            }

            return m1;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}

