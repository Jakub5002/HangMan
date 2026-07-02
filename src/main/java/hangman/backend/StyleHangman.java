package hangman.backend;

import java.util.ArrayList;
import java.util.List;

public class StyleHangman {
    private static String[] hangman = {
            """

            
            
            
            """,
            """
            
            
            
            ____
            """,
            """
              |
              |
              |
            __|__
            """,
            """
              |------
              |
              |
            __|__
            """,
            """
              |------
              |     O
              |
            __|__
            """,
            """
              |------
              |     O
              |     |
            __|__
            """,
            """
              |------
              |  \\ O
              |    | 
            __|__
            """,
            """
              |------
              |  \\ O /
              |    | 
            __|__ 
            """,
            """
              |------
              |  \\ O /
              |    | 
            __|__ /
            """,
            """
              |------
              |  \\ O /
              |    | 
            __|__ / \
            """

    };
    public static String getNextStep(int index){
        try {
            return hangman[index];
        }catch(ArrayIndexOutOfBoundsException e){
            return hangman[0];
        }
    }
    public static int size(){
        return hangman.length;
    }
}
