package com.twu.biblioteca;

public class Library {
    private String[] books = new String[]{"The Adventure of Rayman", "Crash Bandicoot"};
    private String[] authors = new String[]{"Amanda Adams", "Bjorn Boris"};
    private int[] yearPublished = new int[]{1066, 2019};

    private String[] menuOptions = new String[]{"List of books"};
    public void showMenu(){
        System.out.println("Please select an option by typing in the corresponding number.\nWhen you have finished, press the \"Enter\" key.");



    }

    public void showBooks(){
        for(int i =0; i<books.length; i++){
            System.out.printf("%-50s%-50s%-50s\n",books[i],authors[i],yearPublished[i]);
        }

    }
}
