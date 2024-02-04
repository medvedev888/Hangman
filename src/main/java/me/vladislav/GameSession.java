package me.vladislav;

import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Manifest;

public class GameSession {
    private Console console;
    private WordsStorage storage;
    private Set<Character> enteredLetters = new TreeSet<>();
    private StringBuilder result = new StringBuilder();
    private int amountMistakes = 0;
    private int indexOfWord;
    private String currentWord;

    public GameSession(Console console, WordsStorage wordsStorage){
        this.console = console;
        this.storage = wordsStorage;
        this.indexOfWord = (int) (Math.random() * (storage.size() - 1));
        this.currentWord = storage.getWordFromStorage(indexOfWord);
    }

    public void runNewGameSession(Console console) {
        char currentLetter;
        boolean guessed;

        for (int i = 0; i < currentWord.length(); i++) {
            result.append("_");
            System.out.print('_');
        }
        System.out.println();

        //cycle of guessing
        while (true) {
            guessed = false;

            printTheEnteredLetters();

            // entering the letter
            System.out.println("Enter the letter");
            currentLetter = console.inputtingTheLetter();
            enteredLetters.add(currentLetter);

            guessed = checkThePresenceOfALetter(currentLetter);

            System.out.println(result);

            if(printHangman(guessed, result)){
                return;
            }

            if(result.indexOf("_") == -1) {
                System.out.println("You win! :)");
                return;
            }

        }
    }

    // printing of entered letters
    private void printTheEnteredLetters(){
        System.out.print("You entered the letters: ");
        for (Character enteredLetter : enteredLetters) {
            System.out.print(enteredLetter + " ");
        }
        System.out.println();
    }

    // checking the presence of a letter
    private boolean checkThePresenceOfALetter(char currentLetter){
        boolean guessed = false;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == currentLetter) {
                result.setCharAt(i, currentLetter);
                guessed = true;
            }
        }
        return guessed;
    }

    // true, if the attempts are over
    private boolean printHangman(boolean guessed, StringBuilder result){
        if (!guessed) {
            System.out.println("There is no such letter");
            amountMistakes++;
            System.out.println("We have a " + (5 - amountMistakes) + " attempts");
            if (amountMistakes == 1) {
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (amountMistakes == 2) {
                System.out.println(" --- ");
                System.out.println("|/  |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (amountMistakes == 3) {
                System.out.println(" --- ");
                System.out.println("|/  |");
                System.out.println("|   *");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (amountMistakes == 4) {
                System.out.println(" --- ");
                System.out.println("|/  |");
                System.out.println("|   *");
                System.out.println("|  /0\\");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");

            } else {
                System.out.println(" --- ");
                System.out.println("|/  |");
                System.out.println("|   *");
                System.out.println("|  /0\\");
                System.out.println("|  / \\");
                System.out.println("|");
                System.out.println("|");
                System.out.println("You lose :(");
                return true;
            }
        }
        return false;
    }

}
