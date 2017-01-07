package com.corpa;

/**
 * Created by corpa on 1/6/17.
 */

public class Book {

    private String title;
    private String author;
    private int results;

    public Book(String title, String author, int results) {
        this.title = title;
        this.author = author;
        this.results = results;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getURL() {
        return "https://www.google.com/search?hl=en&as_q=" + author.replace(" ", "+") + "&as_epq=" + title.replace(" ", "+") + "&as_oq=&as_eq=&as_nlo=&as_nhi=&lr=&cr=&as_qdr=all&as_sitesearch=&as_occt=title&safe=images&as_filetype=pdf&as_rights=";
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
