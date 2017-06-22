package com.example;

public class Jokes {

    public String getJoke(){
        return (new JokeSource()).JokeGenerator();
    }
}
