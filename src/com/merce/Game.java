package com.merce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {
  private Word word;
  private int attempt;
  private char letter;
  private int finalAttempts;

  private ArrayList<Word> dictionary = new ArrayList<>();

  private Set<Character> lettersToGuess = new HashSet<>();
  private Set<Character> lettersGuessed = new HashSet<>();
  //private ArrayList<String> alphabet = new ArrayList<>();

  public Game() {

    this.attempt = 0;
    this.finalAttempts = 5;

    dictionary.add(new Word("sun", "source of energy"));
    dictionary.add(new Word("rain", "crying sky"));

    int randomIndex = (int)Math.floor(Math.random()*dictionary.size());
    this.word = dictionary.get(randomIndex);

    for (int i = 0; i < word.getAnswer().length(); i++) {
      lettersToGuess.add(word.getAnswer().charAt(i));
    }

  }

  public void setLetter(String letter) {
    if (letter.length() == 1){
      if (Character.isLetter(letter.charAt(0))){
        this.letter = Character.toLowerCase(letter.charAt(0));
        isLetterInWord();
      }
      else{
        throw new IllegalArgumentException("Make sure you enter a letter");
      }
    }else{
      throw new IllegalArgumentException("Make sure you enter one letter");
    }
  }

  private int getAttempt() {
    return this.attempt;
  }

  private void setAttempt(int attempt) {
    this.attempt = attempt;
  }

  public void cheatNote(){

    for (int i=0; i < word.getAnswer().length(); i++){
      if(lettersGuessed.contains(word.getAnswer().charAt(i))){
        System.out.print( word.getAnswer().charAt(i) + " ");
      }
      else {
        System.out.print("_ ");
      }

    }

  }

  private String hint(){
    return this.word.getHint();
  }

  public void giveHint(){
    if(getAttempt()==3){
      System.out.println(hint());
    }
  }


  public boolean gameOver(){
    if(getAttempt() > finalAttempts){
      System.out.println("You lose");
      return true;
    } else if( lettersToGuess.size() == 0){
      System.out.println("You have guessed the word! " + this.word.getAnswer());
      return true;
    } else
      return false;
  }


  private void isLetterInWord(){
    if(word.getAnswer().contains(String.valueOf(this.letter))){
      lettersToGuess.remove(this.letter);
      lettersGuessed.add(this.letter);
    }
    else{
      setAttempt(getAttempt()+1);
    }
  }

}
