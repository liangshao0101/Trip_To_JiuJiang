package com.example.trip_to_jiujiang.model;

public class HotelName {
    private String name;
    private String imageId;

    public HotelName(String name,String Id){
        this.name=name;
        this.imageId=Id;
    }
    public String getName(){
        return name;
    }
    public String getImageId(){
        return imageId;
    }
}
