package com.twu.biblioteca;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private User[] existingUsers = {new User(1000001, "aaaa", "adam@email.com", 07111111111),
            new User(1000002, "bbbb", "bernie@email.com", 07222222222)};
    private User user;
    private boolean librarian;
    private boolean loggedIn=false;
    private String message = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
    private String[] menuOptions = new String[]{"Quit Biblioteca","List of books","Check-out a book", "Return a book", "List of movies", "Check-out a movie", "See credentials"};

    private Book[] books = {new Book("Alpha","Amanda","1066"),
                                        new Book("Beta","Bjorn","1067"),
                                        new Book("Charlie","Chris","1068")};

    private Movie[] movies = {new Movie("Al", "1900", "Adams", "5"),
                                        new Movie("Be", "1910", "Beatrice", "0"),
                                        new Movie("Ch", "1920", "Connor", "10")};

    private void setLibrarian(boolean librarian){
        this.librarian = librarian;
    }
    public boolean getLibrarian(){
        return librarian;
    }

    public User[] getExistingUsers() {
        return existingUsers;
    }

    public void showWelcomeMessage(){
        System.out.println(message);
    }

    public void login(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your library number:");
        int libraryNumber = scanner.nextInt();
        for(int i=0;i<existingUsers.length;i++){
            if(libraryNumber==existingUsers[i].getLibraryNumber()){
                System.out.println("Please enter your password:");
                scanner = new Scanner(System.in);
                String password = scanner.nextLine();

                if(password.equals(existingUsers[i].password)){
                    user = existingUsers[i];
                    System.out.println("Login successful!");
                    loggedIn=true;
                    break;
                }else{
                    System.out.println("Incorrect password");
                    login();
                }
                break;
            }
        }
        if(loggedIn==false){
            System.out.println("User does not exist, please try again");
            login();
        }
    }


    public void askIfLibrarian(){
        System.out.println("Are you a librarian?");
        System.out.println("1. Yes\n2. No\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice==1){
            setLibrarian(true);
            showAllCheckedOut();
        }
        else{
            setLibrarian(false);
        }
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
                case 6:
                    seeCredentials();
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
            books = removeFromBookArray(choice - 1, books);
            user.setCheckedOutBooks(addToArray(selectedBook,user.getCheckedOutBooks()));


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
            movies = removeFromMovieArray(choice - 1, movies);
            user.setCheckedOutMovies(addMovieToArray(selectedMovie, user.getCheckedOutMovies()));


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

    public void seeCredentials(){
        System.out.printf("User: %d\nE-mail address: %s\nPhone number: %d", user.getLibraryNumber(),user.getEmail(),user.getTelephone());
    }

    public void returnBook(){
        if(user.getCheckedOutBooks().length==0){
            System.out.println("You have no checked out books to return.");
            return;
        }

        System.out.println("\n\nPlease type in the name of the book you would like to return:");
        Scanner scanner = new Scanner(System.in);
        String returnedBook = scanner.nextLine();

        for(int i = 0; i<user.getCheckedOutBooks().length;i++){
            if(returnedBook.equals(user.getCheckedOutBooks()[i].getTitle())){

                books = addToArray(user.getCheckedOutBooks()[i], books);

                user.setCheckedOutBooks(removeFromBookArray(i, user.getCheckedOutBooks()));

                System.out.println("Thank you for returning the book.");
                break;
            }
            System.out.println("This is not a valid book to return.");
        }
    }

    private static Book[] removeFromBookArray(int index, Book[] array){

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
    private static Movie[] removeFromMovieArray(int index, Movie[] array){

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

    public void showCheckedOut(int index){
        if(getExistingUsers()[index].getCheckedOutBooks().length==0){
            System.out.println("this user has no books to return");
            return;
        }
        for(int i = 0; i<user.getCheckedOutBooks().length; i++){
            System.out.print(i+1 + ". ");
            System.out.printf("%-50s%-50s%-50s\n",user.getCheckedOutBooks()[i].getTitle(),user.getCheckedOutBooks()[i].getAuthor(),user.getCheckedOutBooks()[i].getYearPublished());
        }

    }


    public void showAllCheckedOut(){
        for(int i = 0; i<existingUsers.length;i++){
            System.out.printf("User %d has to return the following books:\n", existingUsers[i].getLibraryNumber());
            showCheckedOut(i);
            System.out.println("\n\n");
        }
    }

}
