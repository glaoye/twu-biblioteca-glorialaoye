package com.twu.biblioteca;

public class Library {
    private String[] books = new String[]{"The Adventure of Rayman", "Crash Bandicoot"};
    private String[] authors = new String[]{"Amanda Adams", "Bjorn Boris"};
    private int[] yearPublished = new int[]{1066, 2019};



    public void showBooks(){
        for(int i =0; i<books.length; i++){
            System.out.printf("%-50s%-50s%-50s\n",books[i],authors[i],yearPublished[i]);
        }

    }
}
