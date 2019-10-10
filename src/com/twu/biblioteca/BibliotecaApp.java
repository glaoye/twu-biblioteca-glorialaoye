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
