package com.cs551androidproject.gpstracker.Database;


public class LocationObject {
    int id;
    private double lat;
    private double lng;
    private String title;

    public double getLat() { return lat; }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
