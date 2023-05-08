import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    private ArrayList<Integer> numbers;
    public Game(){
        numbers = winningLotNumber();
    }
    public ArrayList<Integer> winningLotNumber(){
        ArrayList<Integer> W= new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            W.add(i + 1);
        }
        Random random = new Random();
        Collections.shuffle(W, random);
        ArrayList<Integer> N = new ArrayList<>(W.subList(0, 5));
        return N;
    }
    public Integer Match(Player P){
        int matching = 0;
        for (Integer winNum: numbers){
            for (Integer playNum: P.getNumbers()){
                if (winNum == playNum){
                    matching++;
                }
            }
        }
        return matching;
    }
    public Float Winnings(Integer matching){
        float winnings = -1f;
        if (matching == 2){
            winnings++;
        }
        else if (matching == 3){
            winnings = winnings + 10.86f;
        }
        else if (matching == 4){
            winnings = winnings + 197.53f;
        }
        else if (matching == 5){
            winnings = winnings + 212534.83f;
        }
        return winnings;
    }
}
