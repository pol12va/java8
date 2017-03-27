package com.sg.lambda.chapter5.excercises;

import com.sg.lambda.chapter5.Artist;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GroupingByTest {

    @Test
    public void testGroupingBy() {
        Artist lennon = new Artist("John Lennon", "The Beatles");
        Artist mccartney = new Artist("Paul McCartney", "The Beatles");
        Artist harrison = new Artist("George Harrison", "The Beatles");
        Artist starr = new Artist("Ringo Starr", "The Beatles");
        Artist cobain = new Artist("Kurt Cobain", "Nirvana");
        Artist grohl = new Artist("Dave Grohl", "Nirvana");
        Artist novoselic = new Artist("Krist Novoselic", "Nirvana");

        List<Artist> artists = Arrays.asList(novoselic, cobain, starr, lennon, harrison, grohl, mccartney);

        Map<String, List<Artist>> mapped = artists.stream()
                .collect(new GroupingBy<>(Artist::getBand));

        assertEquals("Number of members should be 4", 4, mapped.get("The Beatles").size());
        assertEquals("Number of members should be 3", 3, mapped.get("Nirvana").size());
    }

}