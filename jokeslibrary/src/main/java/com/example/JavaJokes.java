package com.example;

import java.util.Random;

public class JavaJokes {

    public static String getJoke() {

        String[] jokes = new String[]{
                "Joke 1",
                "Joke 2",
                "Joke 3",
                "Joke 4"};

        int size = jokes.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return jokes[index];
    }
}
