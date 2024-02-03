package me.vladislav;

import java.util.ArrayList;
import java.util.List;

public class WordsStorage {
    private List<String> arrayOfWords = new ArrayList<>();

    public int size(){
        return arrayOfWords.size();
    }

    public boolean isEmpty(){
        if(arrayOfWords.isEmpty()){
            return true;
        }
        return false;
    }

    public void addWordToTheStorage(String word) {
        arrayOfWords.add(word);
    }

    public void deleteWordFromStorage(int index){
        arrayOfWords.remove(index);
    }

    public String getWordFromStorage(int index) {
        return arrayOfWords.get(index);
    }
}
