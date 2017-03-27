package com.sg.lambda.chapter5;

import java.util.List;

public class StringJoiner {

    public String joinNames(List<Artist> artists) {

        return artists.stream()
                .map(Artist::getName)
                .collect(new StringCollector(", ", "[", "]"));

//        StringBuilder reduced = artists.stream()
//                .map(Artist::getName)
//                .reduce(new StringBuilder(),
//                        (builder, name) -> {
//                            if (builder.length() > 1) {
//                                builder.append(", ");
//                            }
//                            builder.append(name);
//                            return builder;
//                        },
//                        (left, right) -> left.append(right));


//        reduced.insert(0, "[");
//        reduced.append("]");
//
//        return reduced.toString();
    }
}
