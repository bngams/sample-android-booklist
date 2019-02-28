package fr.istef.cw1719.android.booklist.models;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String imgUrl;
    private String author;
    private Integer year;
    private String summary;

    public Book(String title, String imgUrl, String author, Integer year, String summary) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.author = author;
        this.year = year;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
