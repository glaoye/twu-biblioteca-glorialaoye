package com.twu.biblioteca;

public class Movie {

   // Movies have a name, year, director and movie rating (from 1-10 or unrated).
    private String name;
    private String year;
    private String director;
    private String rating;

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }
}