package com.twu.biblioteca;

import java.util.Arrays;

public class User {
    private int libraryNumber;
    public String password;
    private String email;
    private int telephone;
    private Book[] checkedOutBooks ={};
    private Movie[] checkedOutMovies = {};

    public User(int libraryNumber, String password, String email, int telephone){
        this.libraryNumber=libraryNumber;
        this.password=password;
        this.email=email;
        this.telephone = telephone;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
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
