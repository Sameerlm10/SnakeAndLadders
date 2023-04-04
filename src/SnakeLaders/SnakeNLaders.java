package SnakeLaders;


import Service.GameImpl;

import java.util.Scanner;

public class SnakeNLaders {
    Scanner scan = new Scanner(System.in);
    GameImpl gameImpl = new GameImpl();


    public void initializeLaders(){
        System.out.println("How many ladders you want");
        int noOfLader = scan.nextInt();
        for (int i=0;i<noOfLader;i++){
            System.out.println("please input your start and end for lader: " +(i+1) );
            gameImpl.addLadder(scan.nextInt(),scan.nextInt());
        }
    }
    public void initializeSnake(){
        System.out.println("How many snakes you want");
        int noOfLader = scan.nextInt();
        for (int i=0;i<noOfLader;i++){
            System.out.println("please input your start and end for snake: " +(i+1) );
            gameImpl.addSnakes(scan.nextInt(),scan.nextInt());
        }
    }


    public void startGame() {
        System.out.println("How many people want to play this game");
        int noOfPeople= scan.nextInt();
        scan.nextLine();
        for(int i=0;i<noOfPeople;i++){
            System.out.println("please input name of player:" +(i+1));
            gameImpl.addPeople(scan.nextLine(),i+1);
        }

        gameImpl.startTheGame();

    }




}
