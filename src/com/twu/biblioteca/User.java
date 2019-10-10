package com.twu.biblioteca;

import java.util.Arrays;

public class User {
    private int libraryNumber;
    private String password;
    private Book[] checkedOutBooks ={};
    private Movie[] checkedOutMovies = {};

    public User(int libraryNumber, String password){
        this.libraryNumber=libraryNumber;
        this.password=password;
    }

    public Book[] getCheckedOutBooks(){
        return checkedOutBooks;
    }

    public Movie[] getCheckedOutMovies() {
        return checkedOutMovies;
    }

    public void setCheckedOutBooks(Book[] checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void setCheckedOutMovies(Movie[] checkedOutMovies) {
        this.checkedOutMovies = checkedOutMovies;
    }
}
