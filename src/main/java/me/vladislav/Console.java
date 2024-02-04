package me.vladislav;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    BufferedReader bufferedReader;
    private Scanner in = new Scanner(System.in);
    private String currentString;
    private char currentLetter;
    private String filePath = "src/main/resources/dictionary.txt";

    // this function reading the dictionary and writing words in the storage
    public void readingDictionary(WordsStorage storage) {
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String readLine;
            do {
                readLine = bufferedReader.readLine();
                storage.addWordToTheStorage(readLine);
            } while(readLine != null);
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("The dictionary is empty");
        }
    }

    // function for reading one letter
    public char inputtingTheLetter(){
        currentString = in.nextLine();
        currentString = currentString.trim();
        if(!validateTheLetter(currentString)){
            System.out.println("Please, enter the correct letter");
            inputtingTheLetter();
        }
        return currentLetter;
    }

    //true is right letter
    private boolean validateTheLetter(String currentString){
        if(currentString.length() != 1){
            System.out.println("Enter one letter, please");
            return false;
        } else if((int) (currentString.charAt(0)) >= 65 && (int) (currentString.charAt(0)) <= 90){
            currentLetter = (char) (currentString.charAt(0) + 32);
            return true;
        } else if((int) (currentString.charAt(0)) >= 97 && (int) (currentString.charAt(0)) <= 122){
            currentLetter = currentString.charAt(0);
            return true;
        } else {
            return false;
        }
    }

}
