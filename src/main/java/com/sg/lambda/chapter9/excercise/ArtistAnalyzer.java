package com.sg.lambda.chapter9.excercise;

import java.util.function.Consumer;

public interface ArtistAnalyzer {
    void isLargerGroup(String artistName, String otherName, Consumer<Boolean> handler);
}
