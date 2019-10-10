package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished){
        this.title=title;
        this.author=author;
        this.yearPublished=yearPublished;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getYearPublished() {
        return yearPublished;
    }
}
