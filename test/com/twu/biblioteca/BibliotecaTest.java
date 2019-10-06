package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class BibliotecaTest {

    @Test
    public void shouldReturnCorrectWelcomeMessage(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //given
        String expectedWelcomeMessage  = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
        //when
        Greeting greeting = new Greeting();
        greeting.printMessage();
        //then
        assertThat(expectedWelcomeMessage, is(outContent.toString()));
    }
}
