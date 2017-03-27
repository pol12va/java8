package com.sg.lambda.chapter3;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PStreamTest {

    @Test
    public void testMap() throws Exception {
        List<String> result = PStream.map(Stream.of("aaa", "bbb", "ccc"), s -> s.toUpperCase());

        assertEquals("Text should be uppercased", "AAA", result.get(0));
        assertEquals("Text should be uppercased", "BBB", result.get(1));
    }

    @Test
    public void testFilter() {
        List<String> result = PStream.filter(Stream.of("aaa", "bbbb", "ccc"), s -> s.length() > 3);

        assertEquals("Only single string match requirement", 1, result.size());
    }

}