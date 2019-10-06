package com.twu.biblioteca;

public class Library {
    private String[] books = new String[]{"The Adventure of Rayman", "Crash Bandicoot"};

    public void showBooks(){
        for(int i =0; i<books.length; i++){
            System.out.println(books[i]);
        }

    }
}
