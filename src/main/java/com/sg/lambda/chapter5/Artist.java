package com.sg.lambda.chapter5;

public class Artist {
    private String name;
    private String band;

    public Artist(String name) {
        this(name, "");
    }

    public Artist(String name, String band) {
        this.name = name;
        this.band = band;
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
}
