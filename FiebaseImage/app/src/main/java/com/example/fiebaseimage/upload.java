package com.example.fiebaseimage;

public class upload {
    private String imagename;
    private String imageurl;

    public upload(){

    }

    public upload(String imagename, String imageurl) {
        this.imagename = imagename;
        this.imageurl = imageurl;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
