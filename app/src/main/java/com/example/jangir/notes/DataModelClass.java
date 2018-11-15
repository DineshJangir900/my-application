package com.example.jangir.notes;

/**
 * Created by JANGIR on 8/13/2018.
 */

public class DataModelClass {
    private String title;
    private String content;
    private int Image;
    public DataModelClass(){

    }

    public DataModelClass(String title, String content, int Image) {
        this.title = title;
        this.content = content;
        this.Image = Image;
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImage() {
        return Image;
    }
}

