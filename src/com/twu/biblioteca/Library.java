package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private String message = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
    private String[] books = new String[]{"Alpha", "Beta", "Charlie"};
    private String[] authors = new String[]{"Amanda", "Bjorn", "Chris"};
    private String[] yearPublished = new String[]{"1066", "1067", "1068"};
    private String[] menuOptions = new String[]{"Quit Biblioteca","List of books","Check-out a book"};

    public void showWelcomeMessage(){
        System.out.print(message);
    }

    public void showMenu() throws InputMismatchException {
        System.out.println("Please select an option by typing in the corresponding number.\nWhen you have finished, press the \"Enter\" key.");
        for(int i=0; i<menuOptions.length; i++){
            System.out.println((i) + ". "+menuOptions[i]);
        }

        Scanner scanner = new Scanner(System.in);
        try{
        int choice = scanner.nextInt();

            switch(choice){
                case 0:
                    System.exit(0);
                case 1:
                    this.showBooks();
                    break;
                case 2:
                    checkOutBook();
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
            System.out.print(i+1 + ". ");
            System.out.printf("%-50s%-50s%-50s\n",books[i],authors[i],yearPublished[i]);
        }
//        System.out.println("\n\n\n\n");
    }

    public void checkOutBook(){
        System.out.println("From the list below, choose which book you would like to check-out by pressing the corresponding number followed by the \"Enter\" key.\n" +
                "If you would like to quit, press 0");
        showBooks();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String selectedBook = books[choice-1];
        books = removeFromArray(choice-1,books);
        authors = removeFromArray(choice-1,authors);
        yearPublished = removeFromArray(choice-1,yearPublished);
        System.out.println("\n\n\n\n");
    }

    private String[] removeFromArray(int index, String[] array){

        String[] newArray = new String[array.length-1];
        for(int i=0, k=0; i<array.length;i++){
            if(i==index){
                continue;
            }
            newArray[k]=array[i];
            k++;
        }
        return newArray;
    }
}
