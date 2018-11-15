package com.example.jangir.notes;

/**
 * Created by JANGIR on 8/9/2018.
 */

public class Modelclass {

    public String url;
    String title;
    String content;
    public void modelClass(String url,String title, String content){
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
