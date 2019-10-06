package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Greeting greeting = new Greeting();
        greeting.printMessage();
        System.out.print("\n");
        Library library = new Library();
        library.showMenu();
    }
}
