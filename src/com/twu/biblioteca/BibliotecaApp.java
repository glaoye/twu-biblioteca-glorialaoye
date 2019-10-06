package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        library.showWelcomeMessage();
        System.out.print("\n");
        while(true) {
            library.showMenu();
        }
    }
}
