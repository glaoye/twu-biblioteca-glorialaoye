package com.twu.biblioteca;

public class Library {
    private String[] books = new String[]{"The Adventure of Rayman", "Crash Bandicoot"};
    private String[] authors = new String[books.length];
    private String[] yearPublished = new String[books.length];

    public void showBooks(){
        for(int i =0; i<books.length; i++){
            System.out.printf(books[i]);
        }

    }
}
