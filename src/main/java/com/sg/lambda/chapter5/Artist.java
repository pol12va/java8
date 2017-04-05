package com.sg.lambda.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Artist {
    private String name;
    private String band;
    private List<Artist> members;

    public Artist(String name) {
        this(name, "");
    }

    public Artist(String name, String band) {
        this(name, band, Collections.emptyList());
    }

    public Artist(String name, String band, List<Artist> members) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(band);
        Objects.requireNonNull(members);
        this.name = name;
        this.band = band;
        this.members = new ArrayList<>(members);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public void setMembers(List<Artist> members) {
        this.members = members;
    }
}
