package com.sg.lambda.chapter9.excercise;

import com.sg.lambda.chapter5.Artist;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class CallableArtistAnalyzer implements ArtistAnalyzer {

    private Function<String, Artist> artistLookupService;
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    public CallableArtistAnalyzer(
            Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherName,
                              Consumer<Boolean> handler) {
        boolean isLarger = getNumberOfMembers(artistName) > getNumberOfMembers(otherName);
        handler.accept(isLarger);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                                    .getMembers()
                                    .count();
    }
}
