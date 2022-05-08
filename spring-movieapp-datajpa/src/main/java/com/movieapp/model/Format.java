package com.movieapp.model;

public enum Format {
    TWOD("2-D"),THREED("3-D"),IMAX("i-max"),SCREENX("screen-x");

    public final String type;

    Format(String type) {
        this.type = type;
    }
}
