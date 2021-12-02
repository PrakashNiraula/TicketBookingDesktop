package com.example.ticketer.module;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Comment
{
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("author")
    @Expose
    private String author;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
