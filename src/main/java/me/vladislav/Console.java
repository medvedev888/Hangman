package me.vladislav;

import java.util.Scanner;

public class Console {
    private Scanner in = new Scanner(System.in);
    private char currentLetter;
    private String currentString;

    //------check this function

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

    public String inputtingTheWord(){
        currentString = in.nextLine();
        return currentString.trim();
    }

}
