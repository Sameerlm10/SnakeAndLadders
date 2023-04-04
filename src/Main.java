import Service.GameImpl;
import SnakeLaders.SnakeNLaders;

public class Main {

    public static void main(String[] args) {
        System.out.println("******Welcome to Game");
        SnakeNLaders snl = new SnakeNLaders();
        snl.initializeLaders();
        snl.initializeSnake();
        snl.startGame();


//the game

    }
}
