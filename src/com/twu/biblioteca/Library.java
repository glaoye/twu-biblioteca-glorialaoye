package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private String message = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
    private String[] books = new String[]{"The Adventure of Rayman", "Crash Bandicoot"};
    private String[] authors = new String[]{"Amanda Adams", "Bjorn Boris"};
    private int[] yearPublished = new int[]{1066, 2019};
    private String[] menuOptions = new String[]{"List of books"};

    public void showWelcomeMessage(){
        System.out.print(message);
    }

    public void showMenu() throws InputMismatchException {
        System.out.println("Please select an option by typing in the corresponding number.\nWhen you have finished, press the \"Enter\" key.");
        for(int i=0; i<menuOptions.length; i++){
            System.out.println(i + ". "+menuOptions[i]);
        }

        Scanner scanner = new Scanner(System.in);
        try{
        int choice = scanner.nextInt();

            switch(choice){
                case 0:
                    this.showBooks();
                    break;
                default:
                    throw new InputMismatchException();
                    
            }
        }catch(InputMismatchException e){
            System.out.println("Please select a valid option!");
        }


    }

    public void showBooks(){
        for(int i =0; i<books.length; i++){
            System.out.printf("%-50s%-50s%-50s\n",books[i],authors[i],yearPublished[i]);
        }

    }
}
