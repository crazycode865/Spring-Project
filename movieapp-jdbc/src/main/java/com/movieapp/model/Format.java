package com.movieapp.model;

public enum Format {
    THREED("3-D"),TWOD("2-D"),IMAX("Imax-3D"),IMAXSCREENX("3D-Screen X");

    public String type;

    Format(String type) {
        this.type = type;
    }
}
