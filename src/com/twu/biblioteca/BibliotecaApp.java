package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        while(true) {
            Library library = new Library();
            library.showWelcomeMessage();
            System.out.print("\n");
            library.showMenu();
        }
    }
}
