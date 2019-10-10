package com.twu.biblioteca;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

    private String message = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
    private String[] menuOptions = new String[]{"Quit Biblioteca","List of books","Check-out a book", "Return a book", "List of movies", "Check-out a movie"};

    private Book[] books = {new Book("Alpha","Amanda","1066"),
            new Book("Beta","Bjorn","1067"),
            new Book("Charlie","Chris","1068")};
    private Book[] checkedOutBooks = {};

    private Movie[] movies = {new Movie("Al", "1900", "Adams", "5"),
            new Movie("Be", "1910", "Beatrice", "0"),
            new Movie("Ch", "1920", "Connor", "10")};
    private Movie[] checkedOutMovies = {};


    public void showWelcomeMessage(){
        System.out.println(message);
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your library number:");
        int libraryNumber = scanner.nextInt();
        System.out.println("Please enter your password:");
        scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        User user = new User(libraryNumber, password);
        System.out.println("Login successful!");
    }

    public void showMenu() throws InputMismatchException {
        System.out.println("\nPlease select an option by typing in the corresponding number.\nWhen you have finished, press the \"Enter\" key.\n");
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
                case 3:
                    returnBook();
                    break;
                case 4:
                    showMovies();
                    break;
                case 5:
                    checkOutMovie();
                    break;
                default:
                    throw new InputMismatchException();
            }
        }catch(InputMismatchException e){
            System.out.println("\nPlease select a valid option!\n");
        }


    }

    public void showBooks(){
        for(int i =0; i<books.length; i++){
            System.out.print(i+1 + ". ");
            System.out.printf("%-50s%-50s%-50s\n",books[i].getTitle(),books[i].getAuthor(),books[i].getYearPublished());
        }
    }
    public void showMovies(){
        for(int i = 0; i<movies.length; i++){
            System.out.print(i+1 + ". ");
            System.out.printf("%-50s%-50s%-50s%-50s\n",movies[i].getName(),movies[i].getYear(),movies[i].getDirector(), movies[i].getRating());
        }
    }

    public void checkOutBook(){
        System.out.println("From the list below, choose which book you would like to check-out by pressing the corresponding number followed by the \"Enter\" key.\n" +
                "If you would like to quit, press 0");
        showBooks();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            Book selectedBook = books[choice - 1];
            books = removeFromArray(choice - 1, books);
            checkedOutBooks=addToArray(selectedBook,checkedOutBooks);


            System.out.println("\n");
            System.out.println("Thank you, enjoy your book!");
            System.out.println("\n\n");
        }catch(InputMismatchException e){
            System.out.println("\n");
            System.out.println("Sorry, that book is not available!");
            System.out.println("\n\n");
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("\n");
            System.out.println("Sorry, that book is not available!");
            System.out.println("\n\n");
        }
    }

    public void checkOutMovie(){
        System.out.println("From the list below, choose which movie you would like to check-out by pressing the corresponding number followed by the \"Enter\" key.\n" +
                "If you would like to quit, press 0");
        showMovies();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            Movie selectedMovie = movies[choice - 1];
            movies = removeMovieFromArray(choice - 1, movies);
            checkedOutMovies=addMovieToArray(selectedMovie,checkedOutMovies);


            System.out.println("\n");
            System.out.println("Thank you, enjoy your movie!");
            System.out.println("\n\n");
        }catch(InputMismatchException e){
            System.out.println("\n");
            System.out.println("Sorry, that movie is not available!");
            System.out.println("\n\n");
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("\n");
            System.out.println("Sorry, that movie is not available!");
            System.out.println("\n\n");
        }
    }


    public void returnBook(){
        if(checkedOutBooks.length==0){
            System.out.println("You have no checked out books to return.");
            return;
        }

        System.out.println("\n\nPlease type in the name of the book you would like to return:");
        Scanner scanner = new Scanner(System.in);
        String returnedBook = scanner.nextLine();

        for(int i = 0; i<checkedOutBooks.length;i++){
            if(returnedBook.equals(checkedOutBooks[i].getTitle())){

                books = addToArray(checkedOutBooks[i], books);

                checkedOutBooks = removeFromArray(i, checkedOutBooks);

                System.out.println("Thank you for returning the book.");
                break;
            }
            System.out.println("This is not a valid book to return.");
        }
    }

    private static Book[] removeFromArray(int index, Book[] array){

        Book[] newArray = new Book[array.length-1];
        for(int i=0, k=0; i<array.length;i++){
            if(i==index){
                continue;
            }
            newArray[k]=array[i];
            k++;
        }
        return newArray;
    }
    private static Movie[] removeMovieFromArray(int index, Movie[] array){

        Movie[] newArray = new Movie[array.length-1];
        for(int i=0, k=0; i<array.length;i++){
            if(i==index){
                continue;
            }
            newArray[k]=array[i];
            k++;
        }
        return newArray;
    }


    public static Book[] addToArray(Book addition, Book[] array){
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = addition;
        return array;
    }
    public static Movie[] addMovieToArray(Movie addition, Movie[] array){
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = addition;
        return array;
    }

    public void showCheckedOut(){
        for(int i = 0; i<checkedOutBooks.length; i++){
            System.out.print(i+1 + ". ");
            System.out.printf("%-50s%-50s%-50s\n",checkedOutBooks[i]);
        }
    }
}


