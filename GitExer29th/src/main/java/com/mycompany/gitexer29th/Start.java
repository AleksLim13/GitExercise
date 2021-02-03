/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
JanuarySigRug9M29th
https://github.com/AleksLim13/GitExercise.git
C:\Users\aleks\Documents\NetBeansProjects

 */
package com.mycompany.gitexer29th;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ally Cat @ Sheridan College 2021
 */
public class Start {

    public Start() {

    }

    public static void main(String[] args) {

        //begin statements
        //Test turn starter 
        TurnTaker turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff()
        );
        //Create players
        System.out.println("Setting up players...");
        Player human = turnTaker.playerSetUp(new Player());
        Player computer = turnTaker.playerSetUp(new Player());

        //Start coin toss
        InputStuff inputStuff = turnTaker.getInputStuff();
        System.out.println("Heads or tails: ");
        String uGuess = inputStuff.promptStringUser(new Scanner(System.in));
        String coinToss = turnTaker.coinToss(uGuess);
        System.out.println(coinToss);
        ArrayList<Player> inPlayList;

        //Start turn starter 
        if (coinToss.equals("correct")) {
            System.out.println("Your correct");
            inPlayList = turnTaker.turnStarter(human, computer, new ArrayList<>());
        } else {
            System.out.println("Sorry wrong answer");
            inPlayList = turnTaker.turnStarter(computer, human, new ArrayList<>());
        }
        //Set player who's in play 
        Player inPlay = inPlayList.get(0);
        Player notInPlay = inPlayList.get(1);
        turnTaker.setInPlay(inPlay);
        turnTaker.setNotInPlay(notInPlay);

        //Print stats 
        System.out.println("Printing stats: ");
        turnTaker.showGameDetails(inPlay);
        turnTaker.showGameDetails(notInPlay);

        //Begin turn with player in play
        ArrayList<Player> roundOneList = turnTaker.beginTurn(inPlay, notInPlay);

    }

    public void test01() {

        TurnTaker turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff()
        );
        Player human = turnTaker.playerSetUp(new Player());
        Player computer = turnTaker.playerSetUp(new Player());
        turnTaker.showGameDetails(human);
        turnTaker.showGameDetails(computer);

    }

    public void test02() {
        TurnTaker turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff()
        );
        Player human = turnTaker.playerSetUp(new Player());
        Player computer = turnTaker.playerSetUp(new Player());
        turnTaker.showGameDetails(human);
        turnTaker.showGameDetails(computer);
        System.out.println("Testing stuff");
        System.out.println("After updates...");
        turnTaker.showGameDetails(computer);
    }

    public void test03() {
        //Good: begin turn now can continuously ask for a
        //card from opponent and update both players hands
        //accordingly as per rules of go fish.
        //Like: give the card to opponents hand and remove from
        //person giving card. 
        TurnTaker turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff()
        );
        Player human = turnTaker.playerSetUp(new Player());
        Player computer = turnTaker.playerSetUp(new Player());
        turnTaker.showGameDetails(human);
        turnTaker.showGameDetails(computer);
        ArrayList<Player> playerList = turnTaker.beginTurn(human, computer);
        Player udpComp = playerList.get(0);
        Player udpHuman = playerList.get(1);
        turnTaker.showGameDetails(udpComp);
        turnTaker.showGameDetails(udpHuman);
    }

    public void test04() {
        TurnTaker turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff()
        );
        Player human = turnTaker.playerSetUp(new Player());
        Player computer = turnTaker.playerSetUp(new Player());
        turnTaker.showGameDetails(human);
        turnTaker.showGameDetails(computer);
        ArrayList<Player> playerList = turnTaker.beginTurn(human, computer);
        Player udpComp = playerList.get(0);
        Player udpHuman = playerList.get(1);
        turnTaker.showGameDetails(udpComp);
        turnTaker.showGameDetails(udpHuman);
    }

    public void test05() {
        //Prolly first part of game is coin toss
        //So we know whos first in play
        TurnTaker turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff()
        );

        InputStuff inputStuff = turnTaker.getInputStuff();
        String uGuess = inputStuff.promptStringUser(new Scanner(System.in));
        String coinToss = turnTaker.coinToss(uGuess);
        System.out.println(coinToss);
    }

}//End class
