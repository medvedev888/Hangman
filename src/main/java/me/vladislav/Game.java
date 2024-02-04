package me.vladislav;

public class Game {

    public static void main(String[] args) {
        Console console = new Console();
        WordsStorage storage = new WordsStorage();
        char currentLetter;
        console.readingDictionary(storage);

        while(true) {
            System.out.println("To starting new game, enter N");
            System.out.println("To end the game, enter E");
            currentLetter = console.inputtingTheLetter();
            if(currentLetter == 'e') {
                System.out.println("Thanks for the game)");
                return;
            } else if(currentLetter == 'n'){
                GameSession gameSession = new GameSession(console, storage);
                gameSession.runNewGameSession(console);
            } else {
                System.out.println("Please, enter the correct letter");
            }
        }
    }
}
