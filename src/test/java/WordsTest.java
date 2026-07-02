import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman.backend.Words;

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
    public void testGetByIndex(){
        actual.addWord("SOMTHING");
        assertEquals("SOMTHING", actual.getWord(0));
    }

    @Test
    public void testAddNewWords(){
        actual.addWord("FORGET", "DISHONESTY", "ACTUAL");
        assertAll(
                () -> actual.getWord(0).equals("FORGET"),
                () -> actual.getWord(1).equals("DISHONESTY"),
                () -> actual.getWord(2).equals("ACTUAL")
        );
    }
}