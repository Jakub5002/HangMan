import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman.backend.Words;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordsTest{

    private final Words actual = Words.init();

    @BeforeEach
    public void clearAll(){
        actual.clear();
    }

    @Test
    public void testIsSingleton() {
        Words dict2 = Words.init();
        assertSame(actual, dict2);
    }
    @Test
    public void testAddOneWord(){
        actual.addWord("NEW_WORD");
        assertEquals("NEW_WORD", actual.getWord(0));
    }
    @Test
    public void testAddOneWordWithWhiteCharacter(){
        actual.addWord(" NEW_WORD ");
        assertEquals("NEW_WORD", actual.getWord(0));
    }
    @Test
    public void testGetByIndex(){
        actual.addWord("SOMTHING");
        assertEquals("SOMTHING", actual.getWord(0));
    }

    @Test
    public void testAddNewWords(){
        actual.addWords("FORGET", "DISHONESTY", "ACTUAL");
        assertAll(
                () -> actual.getWord(0).equals("FORGET"),
                () -> actual.getWord(1).equals("DISHONESTY"),
                () -> actual.getWord(2).equals("ACTUAL")
        );
    }

    @Test
    public void testAddNewWordsNotUpperCase(){
        actual.addWords("forGet", "geometRY", "aCTREES");
        assertAll(
                () -> actual.getWord(0).equals("FORGET"),
                () -> actual.getWord(1).equals("GEOMETRY"),
                () -> actual.getWord(2).equals("ACTRESS")
        );
    }
    @Test
    public void testFindByValidLetter(){
        actual.addWords("ALL", "CATS", "SLEEP", "ALONE", "BUT", "AMORE");
        List<String> allStartsWithA = actual.findWordsByLetter("A");
        assertEquals(List.of("ALL", "ALONE", "AMORE"), allStartsWithA);
    }
    @Test
    public void testFindByInvalidLetter(){
        actual.addWords("ALL", "CATS", "SLEEP", "ALONE", "BUT", "AMORE");
        List<String> allStartsWithA = actual.findWordsByLetter(";");
        assertEquals(List.of() ,allStartsWithA);
    }

    @Test
    public void testFindByNotFound(){
        actual.addWords("ALL", "CATS", "SLEEP", "ALONE", "BUT", "AMORE");
        List<String> allStartsWithA = actual.findWordsByLetter("L");
        assertEquals(List.of() ,allStartsWithA);
    }

    @Test
    public void testSizeEmpty(){
        assertEquals(0, actual.size());
    }

    @Test
    public void testSizeNotEmpty(){
        actual.addWords("add", "small");
        assertEquals(2, actual.size());
    }
    @Test
    public void testIsEmpty(){
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIsNotEmpty(){
        actual.addWord("just");
        assertFalse(actual.isEmpty());
    }
    @Test
    public void testGetAllWords(){
        actual.addWords("new", "Old", "fresh");
        List<String> allWords = actual.getAllWords();
        assertAll(
                () -> allWords.get(0).equals(actual.getWord(0)),
                () -> allWords.get(1).equals(actual.getWord(1)),
                () -> allWords.get(2).equals(actual.getWord(2))
        );
    }
}