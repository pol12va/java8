package com.sg.lambda.chapter9.excercise;

import com.sg.lambda.chapter5.Artist;

import java.util.function.Function;

public class BlockingArtistAnalyzer {
    private Function<String, Artist> artistLookupService;

    public BlockingArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public boolean isLargerGroup(String artistName, String otherArtistName) {
        return getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                                    .getMembers()
                                    .count();
    }
}
