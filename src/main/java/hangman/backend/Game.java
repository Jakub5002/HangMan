package hangman.backend;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private boolean running = true;
    private static Game game;

    private Words words = Words.init();

    private Game() {}

    public static Game init(){
        if(game == null) {
            game = new Game();
        }
        return game;
    }
    public Words getWords(){
        return words;
    }

    public void loop(){
        int tries = 0;
        Random r = new Random();
        int index = r.nextInt(0, words.size()-1);
        String answer = words.getWord(index);
        StringBuilder geuss = new StringBuilder();
        for(int i=0; i<answer.length(); ++i){
            geuss.append("_");
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wylosowano: ");


        while(running){
            if(answer.equals(geuss.toString())) {
                System.out.println("You Geussed it !");
                System.out.println(answer);
                running = false;
                break;
            }
            if(tries == StyleHangman.size()){
                System.out.println(StyleHangman.getNextStep(tries));
                System.out.println("You didn't geuss it! ;( \n The answer was");
                System.out.println(answer);
                running = false;
                break;
            }
            System.out.println("Remaining gesses: ");
            System.out.println(StyleHangman.size()-tries);
            System.out.println(StyleHangman.getNextStep(tries));
            System.out.println(geuss);

            String s = scanner.nextLine().toUpperCase();
            if(!s.isEmpty()) {
                if (answer.contains(s) ){
                    for (int i = 0; i < answer.length(); i++) {
                        if (answer.charAt(i) == s.charAt(0)) {
                            geuss.setCharAt(i, s.charAt(0));
                        }
                    }
                }else{
                    tries++;
                }
            }

        }
//      words.showWords();
    }
    public static void main(String[] args){
        Game game1 = Game.init();
        game1.getWords().loadFromFile("WordsExamples.txt");
        game1.loop();
    }

}
