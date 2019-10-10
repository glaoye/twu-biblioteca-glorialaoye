package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        library.showWelcomeMessage();
        library.askIfLibrarian();
        if(library.getLibrarian() == true){
            System.out.println("Welcome, librarian");
        }
        else{
            library.login();
            System.out.print("\n\n");
            while(true) {
                library.showMenu();
            }
        }

    }
}
//call user 'get' methods in main method, simple
//OR have separate Librarian class, main method creates Librarian, which has method to get. I feel this is more secure