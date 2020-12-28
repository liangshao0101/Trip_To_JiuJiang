package com.example.trip_to_jiujiang.model;
//吕明骏
public class GoodFood {
    private String name;
    private String imageId;
    public GoodFood(String name,String Id){
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
