package com.twu.biblioteca;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class BibliotecaTest {

    @Test
    public void shouldReturnCorrectWelcomeMessage() {
        //given
        String correctWelcomeMessage = "Welcome to BiblioTeca. Your one-stop-shop for great book titles in Bangalore!";
        //when
        Greeting greeting = new Greeting();
        String actualWelcomeMessage = greeting.getMessage();
        //then
        assertThat(actualWelcomeMessage, is(correctWelcomeMessage));
    }
}
