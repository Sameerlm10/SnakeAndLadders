package Validator;

import Repository.GameEssentials;

public class Validate {

    public static boolean validateLadder(int start,int end){

        return start > 0
                && start < 100
                && end < 100
                && end >0
                && start < end && !GameEssentials.ladder.containsKey(start);


    }

    public static boolean validateSnakes(int start, int end) {
        return start > 0
                && start < 100
                && end < 100
                && end >0
                && start > end && !GameEssentials.snake.containsKey(start);
    }
}
