package Service;


import Entities.Player;
import Repository.GameEssentials;
import Repository.PlayerRepo;
import Validator.Validate;

import java.util.HashMap;


public class GameImpl {


    public void addLadder(int start, int end) {
        if (!Validate.validateLadder(start, end))
            throw new IllegalArgumentException("Please check your inputs");
        GameEssentials.ladder.put(start, end);
        System.out.println(GameEssentials.ladder);
    }


    public void addSnakes(int start, int end) {
        if (!Validate.validateSnakes(start, end))
            throw new IllegalArgumentException("Please check your inputs");

        GameEssentials.snake.put(start, end);
        System.out.println(GameEssentials.snake);

    }

    public void addPeople(String name, int id) {
        Player p = new Player(id, name);
        PlayerRepo.player.add(p);
        System.out.println(PlayerRepo.player);
    }


    public void startTheGame() {
        HashMap<Integer,Integer> currentPosition= new HashMap<>();
        while (true){
            var p = PlayerRepo.player.remove();

            if(!currentPosition.containsKey(p.getPlayerId()))
            currentPosition.put(p.getPlayerId(),diceRoll());
            else{
                var currPos= currentPosition.get(p.getPlayerId());
                int score = diceRoll();
                currentPosition.put(p.getPlayerId(),currPos+score);
                if (currentPosition.get(p.getPlayerId())==100){
                    System.out.println(p.getPlayerName() + " is the winner");
                    break;
                }

                if (currentPosition.get(p.getPlayerId())>100){
                    currentPosition.put(p.getPlayerId(),currPos);
                }
                System.out.println(p.getPlayerName() + "is at position " + currentPosition.get(p.getPlayerId()));

                if(GameEssentials.snake.containsKey(currentPosition.get(p.getPlayerId()))) {
                    currentPosition.put(p.getPlayerId(), GameEssentials.snake.get(currentPosition.get(p.getPlayerId())));
                    System.out.println(p.getPlayerName()+ " got bit by snake and your current position is " + currentPosition.get(p.getPlayerId()));
                }

                if(GameEssentials.ladder.containsKey(currentPosition.get(p.getPlayerId()))){
                    currentPosition.put(p.getPlayerId(),GameEssentials.ladder.get(currentPosition.get(p.getPlayerId())));
                    System.out.println(p.getPlayerName()+ " climbed the ladere and your current position is " + currentPosition.get(p.getPlayerId()));
                }

            }
PlayerRepo.player.add(p);

        }

    }


    private static int diceRoll() {
        int k = Math.abs((int) (((Math.random() * 10) % 6) + 1));
        while (true) {

            if (k % 18 == 0) {
                k = Math.abs((int) (((Math.random() * 10) % 6) + 1));
                continue;
            }

            if (k % 6 == 0)
                k += Math.abs((int) (((Math.random() * 10) % 6) + 1));
            else
                break;

        }
        return k;

    }

}
