package me.vladislav;

import java.util.*;

public class Game {

    public static void main(String[] args) {
        Console console = new Console();
        WordsStorage storage = new WordsStorage();
        char currentLetter;
        int indexOfTheWordInTheStorage = 0;

        while(true) {
            System.out.println("To starting new game, enter N");
            System.out.println("To end the game, enter E");
            System.out.println("To add word to the storage, enter W");
            currentLetter = console.inputtingTheLetter();
            if(currentLetter == 'E') {
                System.out.println("Thanks for the game)");
                return;
            } else if(currentLetter == 'W'){
                System.out.println("Enter the word");
                if(storage.isEmpty()){
                    System.out.println("Storage is empty, please, enter the word to storage");
                }
                storage.addWordToTheStorage(console.inputtingTheWord());
            } else if(currentLetter == 'N'){
                runNewGame(console, storage, indexOfTheWordInTheStorage);
                if(indexOfTheWordInTheStorage < storage.size()){
                    indexOfTheWordInTheStorage++;
                }
            } else {
                System.out.println("Please, enter correct letter");
            }
        }
    }

    private static void runNewGame(Console console, WordsStorage storage, int index){
        if(storage.isEmpty()){
            System.out.println("Storage is empty, please, enter the word to storage");
            storage.addWordToTheStorage(console.inputtingTheWord());
            runNewGame(console, storage, index);
            return;
        }

        String currentWord = storage.getWordFromStorage(index);
        int sizeOfCurrentWord = currentWord.length();
        char currentLetter;
        StringBuilder result = new StringBuilder();
        boolean guessed;
        Set<Character> enteredLetters = new TreeSet<>();
        int amountMistakes = 0;

        for(int i = 0; i < sizeOfCurrentWord; i++) {
             result.append("_");
             System.out.print('_');
        }
        System.out.println();

        //cycle of guessing
        while(true){
            guessed = false;

            // printing of entered letters
            System.out.print("You entered the letters: ");
            for (Character enteredLetter : enteredLetters) {
                System.out.print(enteredLetter + " ");
            }
            System.out.println();

            // entering the letter
            System.out.println("Enter the letter");
            currentLetter = console.inputtingTheLetter();
            enteredLetters.add(currentLetter);

            // checking the occurrence of a letter
            for(int i = 0; i < sizeOfCurrentWord; i++){
                if(currentWord.charAt(i) == currentLetter) {
                    result.setCharAt(i, currentLetter);
                    guessed = true;
                }
            }

            System.out.println(result);

            // if included
            if(!guessed){
                System.out.println("There is no such letter");
                amountMistakes++;
                System.out.println("We have a " + (5 - amountMistakes) + " attempts");
                if(amountMistakes == 1) {
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if(amountMistakes == 2) {
                    System.out.println(" --- ");
                    System.out.println("|/  |");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if(amountMistakes == 3) {
                    System.out.println(" --- ");
                    System.out.println("|/  |");
                    System.out.println("|   *");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if(amountMistakes == 4) {
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
                    return;
                }
            }

            // if not included
            if(result.indexOf("_") == -1) {
                System.out.println("You win! :)");
                return;
            }

        }

    }
}
