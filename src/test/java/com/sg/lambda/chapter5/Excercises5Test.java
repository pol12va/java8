package com.sg.lambda.chapter5;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Excercises5Test {

    @Test
    public void testFindLongestName() {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "Pete Best", "Ringo Starr", "George Harrison", "Stuart Sutcliffe");

        assertEquals("Isn't longest name", "Stuart Sutcliffe", Excercises5.findLongestName(names));
    }

    @Test
    public void testFindLongestNameWithMax() {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "Pete Best", "Ringo Starr", "George Harrison", "Stuart Sutcliffe");

        assertEquals("Isn't longest name", "Stuart Sutcliffe", Excercises5.findLongestNameWithMax(names));
    }

    @Test
    public void testGroupNamesByCount() {
        Stream<String> names = Stream.of("John", "Paul",
                "George", "John", "Paul", "John");

        assertEquals("John's count is incorrect", 3L,
                Excercises5.groupNamesByCount(names).get("John").longValue());
    }

    @Test
    public void testFibonacci() {
        assertEquals("Fibonacci number doesn't match", 55, Excercises5.fibonacci(10));
    }
}