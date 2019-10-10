package com.twu.biblioteca;

public class User {
    private int libraryNumber;
    private String password;

    public User(int libraryNumber, String password){
        this.libraryNumber=libraryNumber;
        this.password=password;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }
}
