package com.example;

import java.util.Random;

/**
 * Created by Shehab Salah on 6/18/17.
 * This class contain all jokes that will return randomly
 */

class JokeSource {
    String[] jokes = new String[]{
            "A lawyer was just waking up from anesthesia after surgery, and his wife was sitting by" +
            " his side. His eyes fluttered open and he said, \"You're beautiful!\" and then he fell" +
            " asleep again. His wife had never heard him say that so she stayed by his side.\n\n" +
            "A couple of minutes later, his eyes fluttered open and he said, \"You're cute!\" Well, " +
            "the wife was disappointed because instead of \"beautiful,\" it was \"cute.\" She asked," +
            " \"What happened to 'beautiful'?\" His reply was \"The drugs are wearing off!\"",

            "One day a man goes to a pet shop to buy a parrot. The assistant takes the man to the " +
            "parrot section and asks the man to choose one. The man asks, ''How much is the yellow one?''\n\n" +
            "The assistant says, \"$2000.\" The man is shocked and asks the assistant why it's so expensive." +
            " The assistant explains, \"This parrot is a very special one. He knows typewriting and " +
            "can type really fast.\"\n\n \"What about the green one?\" the man asks.\n\n" +
            "The assistant says, \"He costs $5000 because he knows typewriting and can answer incoming " +
            "telephone calls and takes notes.\"\n\n\"What about the red one?\" the man asks.\n\n" +
            "The assistant says, \"That one's $10,000.\"\n\nThe man says, \"What does HE do?\"\n\n" +
            "The assistant says, \"I don't know, but the other two call him boss.\"",

            "A couple wants a divorce, but first they must decide who will be the main guardian of " +
            "their child. The jury asks both the man and woman for a reason why they should be the " +
            "one to keep the child. So the jury asks the woman first. She says, \"Well I carried " +
            "this child around in my stomach for nine months and I had to go through a painful birth " +
            "process, this is my child and apart of me.\"\n\nThe jury is impressed and then turns to ask " +
            "the man the same question. The man replies, \"OK, I take a coin and put it in the drink " +
            "machine and a drink comes out, now tell me who does the drink belong to me or the machine\"",

            "Q: Why couldn't the blonde add 10 and seven on a calculator?\n" +
            "\n" + "A: She couldn't find the 10 key.",

            "Q: What's it called when a blonde blows in another blonde's ear?\n" +
            "\nA: Data transfer.",

            "SCENE: My teenage daughter and me in the car.\n" +
            "\n" +
            "Lauren: Dad, do you know what the most commonly used letter in a girl’s name is?\n" +
            "\n" +
            "Me: Hmm, is it a consonant or a vowel? (Silence.) Please tell me you know what consonants and vowels are.\n" +
            "\n" +
            "Lauren: You’re no fun, Dad. Forget it.\n" +
            "\n" +
            "Me: What is a vowel?\n" +
            "\n" +
            "Lauren: OK, OK. A vowel is … ahh … eh … well, oh … uh …\n\n" +
            "\n" +
            "Me: Close enough.",

            "How To Translate Work Emails!!\n\n\nI have a question.     =     I have 18 questions.\n\n" +
            "\n" +
            "I’ll look into it.     =     I’ve already forgotten about it.\n" +
            "\n" +
            "I tried my best.     =     I did the bare minimum.\n" +
            "\n" +
            "Happy to discuss further.     =     Don’t ask me about this again.\n" +
            "\n" +
            "No worries.     =     You really messed up this time.\n" +
            "\n" +
            "Take care.     =     This is the last you’ll ever hear from me.\n" +
            "\n" +
            "Cheers!     =     I have no respect for you or myself!",

            "I put so much more effort into naming my first Wi-Fi than my first child.",

            "A client called my help desk saying she couldn’t send an e-mail. When I was done " +
            "troubleshooting the problem, she interrupted me to ask, “Wait a minute, do I type @ in" +
            " lower- or uppercase?”",

            "While taking stock of our products, I read aloud the final numbers to my boss. As he " +
            "entered each one into a calculator, I deleted it off my mobile device. Only after I’d " +
            "finished did we realize that he had entered the numbers on his desk phone’s keypad."
    };

    String JokeGenerator(){
        Random rn = new Random();
        int randomNum = rn.nextInt(10);
        return jokes[randomNum];
    }

}
