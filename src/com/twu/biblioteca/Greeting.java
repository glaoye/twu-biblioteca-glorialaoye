package com.twu.biblioteca;

public class Greeting {
    private String message = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
//constructor, setters, getters
    public Greeting(){
    }

    public String getMessage(){
        return message;
    }
//method to print greeting
    public void printMessage(){
        System.out.print(message);
    }
}
