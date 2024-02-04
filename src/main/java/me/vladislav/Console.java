package me.vladislav;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    BufferedReader bufferedReader;
    private Scanner in = new Scanner(System.in);
    private char currentLetter;
    private String currentString;
    private String filePath = "src/main/resources/test.txt";

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
        if(currentString.length() != 1){
            System.out.println("Enter one letter, please");
            inputtingTheLetter();
        } else {
            currentLetter = currentString.charAt(0);
        }
        return currentLetter;
    }

}
