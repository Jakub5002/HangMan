package hangman.backend;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    public void addWords(String... newWords){
        for(String word: newWords)
            words.add(word.toUpperCase().trim());
    }

    public void addWord(String word){
        words.add(word.toUpperCase().trim());
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

    public List<String> findWordsByLetter(String letter){
        return words.stream().filter((w) -> w.startsWith(letter.toUpperCase())).toList();
    }
    public int size() {
        return words.size();
    }

    public boolean isEmpty(){
        return words.isEmpty();
    }

    public List<String> getAllWords(){
        return words;
    }

    public void loadFromFile(String fileName){
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = bf.readLine()) != null){
                words.add(line.toUpperCase());
            }
        }catch (IOException e){
            System.out.println("File not found!");
        }
    }
}
