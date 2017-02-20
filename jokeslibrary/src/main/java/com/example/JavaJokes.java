package com.example;

import java.util.Random;

public class JavaJokes {

    public static String getJoke() {

        String[] jokes = new String[]{
                "What did the taco say to the spaghetti? \n\n Que Pasta?",
                "I once took the root of Root Beer, \n\n now I only have beer....",
                "Did you hear about the mathematician who was afraid of negative numbers? \n\n" +
                        "He would stop at nothing to avoid them....",
                "A string walked into a bar...\n\n" +
                        "The bartender says, \"We dont serve your kind\"\n\n" +
                        "The string leaves, twists himself up, parts his hair, and walks back inside\n\n" +
                        "\"Hey, aren\'t you the guy that was just in here? Says the bartender...\"\n\n" +
                        "the rope says, \"I\'m a FRAYED not\""};

        int size = jokes.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return jokes[index];
    }
}
