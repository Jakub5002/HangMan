package hangman.backend;

import java.util.ArrayList;
import java.util.List;

public class Words { //Singleton
    private final List<String> words = new ArrayList<>();

    private static Words instance;

    public static Words init(){
        if(instance == null){
            instance = new Words();
        }
        return instance;
    }

    private Words() {}
    public void addWord(String... newWords){
        for(String word: newWords)
            words.add(word);
    }

    public void showWords() {
        words.stream().forEach(System.out::println);
    }

    public void clear() {
        words.clear();
    }

    public String getWord(int index){
        return words.get(index);
    }

}
