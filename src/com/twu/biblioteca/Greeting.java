package com.twu.biblioteca;

public class Greeting {
    private String message;
//constructor, setters, getters
    public Greeting(String message){
        setMessage(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
//method to print greeting
    public void printMessage(){
        System.out.println(message);
    }
}
