package com.sg.lambda.chapter5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StringJoinerTest {

    @Test
    public void testJoinNames() throws Exception {
        StringJoiner joiner = new StringJoiner();
        Artist a1 = new Artist("John Lennon");
        Artist a2 = new Artist("Paul McCartney");
        Artist a3 = new Artist("Ringo Starr");
        Artist a4 = new Artist("George Harrison");

        assertEquals("Result doesn't match",
                "[John Lennon, Paul McCartney, Ringo Starr, George Harrison]",
                joiner.joinNames(Arrays.asList(a1, a2, a3, a4)));
    }

}