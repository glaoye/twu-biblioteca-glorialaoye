package com.twu.biblioteca;

public class Greeting {
    private String message = "";
//constructor, setters, getters
    public Greeting(){
    }

    public String getMessage(){
        return message;
    }
//method to print greeting
    public void printMessage(){
        System.out.println(message);
    }
}
