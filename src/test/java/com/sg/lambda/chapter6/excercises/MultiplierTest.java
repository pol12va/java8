package com.sg.lambda.chapter6.excercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiplierTest {

    @Test
    public void testMultiply() {
        Multiplier m = new Multiplier();
        List<Integer> numbers = Arrays.asList(10, 10, 10, 10);

        assertEquals("Multiply result doesn't match", 50_000, m.multiply(numbers));
    }

}