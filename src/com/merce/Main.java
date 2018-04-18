package com.merce;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      Game merce = new Game();
      do {
        System.out.println("Guess the word:");
        merce.cheatNote();
        System.out.println();

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String myletter = reader.next();
        // Scans the next token of the input as an int.

        try{
          merce.setLetter(myletter);
        } catch (IllegalArgumentException checkLetter){
          System.out.println(checkLetter.getMessage());
        }

        merce.giveHint();

      } while (!merce.gameOver());

      //throw new IllegalArgumentException("You can only input one character at time");


    }
}
