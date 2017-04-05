package com.sg.lambda.chapter9.excercise;

import com.sg.lambda.chapter5.Artist;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class CompletableFutureArtistAnalyzer implements ArtistAnalyzer {
    private Function<String, Artist> artistLookupService;

    public CompletableFutureArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> future1 = CompletableFuture
                .supplyAsync(() -> getNumberOfMembers(artistName));
//                .thenAccept();

        CompletableFuture
                .supplyAsync(() -> getNumberOfMembers(otherArtistName))
                .thenCombine(future1, (n1, n2) -> n1 > n2)
                .thenAccept(res -> handler.accept(res));
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }
}
