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

    private TurnTaker turnTaker;

    public Start() {

    }

    public TurnTaker getTurnTaker() {
        return turnTaker;
    }

    public void setTurnTaker(TurnTaker newTurnTaker) {
        this.turnTaker = newTurnTaker;
    }

    public static void main(String[] args) {

        Start testGame = new Start();

        testGame.setTurnTaker(testGame.step1_CreateTurnTaker(new TurnTaker()));
        testGame.setTurnTaker(testGame.step2_CreatePlayers(testGame.getTurnTaker()));
        testGame.setTurnTaker(testGame.step3_StartCoinToss(testGame.getTurnTaker(), new InputStuff()));
        testGame.setTurnTaker(testGame.step4_StartTurnStarter(testGame.getTurnTaker()));
        testGame.setTurnTaker(testGame.printDocStats(testGame.getTurnTaker()));
        testGame.setTurnTaker(testGame.step5_BeginFirstRound(testGame.getTurnTaker()));
        testGame.setTurnTaker(testGame.updateGameStats(testGame.getTurnTaker()));
        //Maybe add a while loop starting here...
        //Remeber to update scoreboard and desirable list when hands change 
        boolean flag = true;
        while (flag) {
            testGame.setTurnTaker(testGame.step6_SwitchWhosInPlay(testGame.getTurnTaker()));
            testGame.setTurnTaker(testGame.printDocStats(testGame.getTurnTaker()));
            testGame.setTurnTaker(testGame.step7_StartUpdGame(testGame.getTurnTaker()));
            testGame.setTurnTaker(testGame.updateGameStats(testGame.getTurnTaker()));
            //Note: addCard from Cards class being called twice when should be once...
            //Scratch That: I'm not updating scoreboard when in play player draws a card after
            //Their turn finishes.
        }

    }

    public void test01(TurnTaker turnTaker) {

        //Step 1: Create turn taker object and inject dependencies 
        turnTaker = new TurnTaker();
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
        );

        //Step 2: Create players
        System.out.println("Setting up players...");
        turnTaker.setHuman(turnTaker.playerSetUp(new Player()));
        turnTaker.setComp(turnTaker.playerSetUp(new Player()));

        //Step 3: Start coin toss
        InputStuff inputStuff = turnTaker.getInputStuff();
        System.out.println("Heads or tails: ");
        turnTaker.setGuess(inputStuff.promptStringUser(new Scanner(System.in)));
        turnTaker.setCoinToss(turnTaker.coinToss(turnTaker.getGuess()));
        System.out.println(turnTaker.getCoinToss());

        //Step 4: Start turn starter 
        if (turnTaker.getCoinToss().equals("correct")) {
            System.out.println("Your correct");
            turnTaker.setInPlayList(turnTaker.turnStarter(turnTaker.getHuman(), turnTaker.getComp(), new ArrayList<>()));
        } else {
            System.out.println("Sorry wrong answer");
            turnTaker.setInPlayList(turnTaker.turnStarter(turnTaker.getComp(), turnTaker.getHuman(), new ArrayList<>()));
        }

        //A: Documenting: Set player who's in play 
        turnTaker.setInPlay(turnTaker.getInPlayList().get(0));
        turnTaker.setNotInPlay(turnTaker.getInPlayList().get(1));//At Index 1 always not in play

        //B: Documenting: printing stats  
        System.out.println("Printing stats: ");
        System.out.println("In Play: " + turnTaker.getInPlay().getName());
        System.out.println("Not In Play: " + turnTaker.getNotInPlay().getName());
        turnTaker.showGameDetails(turnTaker.getInPlay());
        turnTaker.showGameDetails(turnTaker.getNotInPlay());

        //Step 5: Begin turn with player in play
        turnTaker.setUpdPlayerList(turnTaker.beginTurn(turnTaker.getInPlay(), turnTaker.getNotInPlay()));

        //Add new update step here...
        turnTaker.setInPlay(turnTaker.updateScoreBoard(turnTaker.getInPlay()));
        turnTaker.setInPlay(turnTaker.updateDesirableList(turnTaker.getInPlay()));
        turnTaker.setNotInPlay(turnTaker.updateScoreBoard(turnTaker.getNotInPlay()));
        turnTaker.setNotInPlay(turnTaker.updateDesirableList(turnTaker.getNotInPlay()));

        turnTaker.getNotInPlay().setHand(turnTaker.getUpdPlayerList().get(1).getHand());

        //Step 6: Switch players in play
        turnTaker.setInPlayList(turnTaker.turnSwitcher(turnTaker.getInPlay(), turnTaker.getNotInPlay(), new ArrayList<>()));

        //A: Documenting: Set player who is/isn't in play 
        turnTaker.setInPlay(turnTaker.getInPlayList().get(0));
        turnTaker.setNotInPlay(turnTaker.getInPlayList().get(1));//At Index 1 always not in play

        //B: Documenting: Print stats 
        System.out.println("Printing stats: ");
        System.out.println("In Play: " + turnTaker.getInPlay().getName());
        System.out.println("Not In Play: " + turnTaker.getNotInPlay().getName());
        turnTaker.showGameDetails(turnTaker.getInPlay());
        turnTaker.showGameDetails(turnTaker.getNotInPlay());

        //Step 7: Begin turn with switched player in play
        turnTaker.setUpdPlayerList(turnTaker.beginTurn(turnTaker.getInPlay(), turnTaker.getNotInPlay()));

        //Step 8: Repeat steps 1-7...
        turnTaker.setInPlay(turnTaker.updateScoreBoard(turnTaker.getInPlay()));
        turnTaker.setInPlay(turnTaker.updateDesirableList(turnTaker.getInPlay()));
        turnTaker.setNotInPlay(turnTaker.updateScoreBoard(turnTaker.getNotInPlay()));
        turnTaker.setNotInPlay(turnTaker.updateDesirableList(turnTaker.getNotInPlay()));
    }

    public TurnTaker step1_CreateTurnTaker(TurnTaker turnTaker) {
        //Step 1: Create turn taker object and inject dependencies 
        turnTaker.setDependencies(
                new ArrayStuff(),
                new Cards(),
                new Player(),
                new Player(),
                new Player(),
                new Player(),
                new PrintStuff(),
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
        );

        //Bring it back now..
        return turnTaker;

    }//End 

    public TurnTaker step2_CreatePlayers(TurnTaker turnTaker) {

        //Step 2: Create players
        System.out.println("Setting up players...");
        turnTaker.setHuman(turnTaker.playerSetUp(new Player()));
        turnTaker.setComp(turnTaker.playerSetUp(new Player()));

        //Copy that...
        return turnTaker;

    }//End 

    //Start the coin toss as game catalyst 
    public TurnTaker step3_StartCoinToss(TurnTaker turnTaker, InputStuff inputStuff) {

        //Step 3: Start coin toss
        inputStuff = turnTaker.getInputStuff();
        System.out.println("Heads or tails: ");
        turnTaker.setGuess(inputStuff.promptStringUser(new Scanner(System.in)));
        turnTaker.setCoinToss(turnTaker.coinToss(turnTaker.getGuess()));
        System.out.println(turnTaker.getCoinToss());

        //Remember updates...
        return turnTaker;

    }//End 

    //After this step call printDocStats() 
    public TurnTaker step4_StartTurnStarter(TurnTaker turnTaker) {

        //Step 4: Start turn starter 
        if (turnTaker.getCoinToss().equals("correct")) {
            System.out.println("Your correct");
            turnTaker.setInPlayList(turnTaker.turnStarter(turnTaker.getHuman(), turnTaker.getComp(), new ArrayList<>()));
        } else {
            System.out.println("Sorry wrong answer");
            turnTaker.setInPlayList(turnTaker.turnStarter(turnTaker.getComp(), turnTaker.getHuman(), new ArrayList<>()));
        }

        //Bring it back now...
        return turnTaker;

    }//End 

    //Get it started now
    public TurnTaker step5_BeginFirstRound(TurnTaker turnTaker) {

        //Step 5: Begin turn with player in play
        turnTaker.setUpdPlayerList(turnTaker.beginTurn(turnTaker.getInPlay(), turnTaker.getNotInPlay()));

        //Remember updates...
        return turnTaker;

    }//End 

    //After this step call printDocStats() 
    public TurnTaker step6_SwitchWhosInPlay(TurnTaker turnTaker) {

        //Step 6: Switch players in play
        turnTaker.setInPlayList(turnTaker.turnSwitcher(turnTaker.getInPlay(), turnTaker.getNotInPlay(), new ArrayList<>()));

        //Copy that..
        return turnTaker;

    }//End 

    public TurnTaker printDocStats(TurnTaker turnTaker) {

        //A: Documenting: Set player who's in play 
        turnTaker.setInPlay(turnTaker.getInPlayList().get(0));
        turnTaker.setNotInPlay(turnTaker.getInPlayList().get(1));//At Index 1 always not in play

        //B: Documenting: printing stats  
        System.out.println("Printing stats: ");
        System.out.println("In Play: " + turnTaker.getInPlay().getName());
        System.out.println("Not In Play: " + turnTaker.getNotInPlay().getName());
        turnTaker.showGameDetails(turnTaker.getInPlay());
        turnTaker.showGameDetails(turnTaker.getNotInPlay());

        //C: Bring changes back 
        return turnTaker;
    }

    public TurnTaker step7_StartUpdGame(TurnTaker turnTaker) {

        //Step 7: Begin turn with switched player in play
        turnTaker.setUpdPlayerList(turnTaker.beginTurn(turnTaker.getInPlay(), turnTaker.getNotInPlay()));

        //Bring it back now
        return turnTaker;

    }//End 

    //This updates scoreboard and desirable list for 
    //Player in play and not in play.
    public TurnTaker updateGameStats(TurnTaker turnTaker) {
        
        //A: Player 01
        turnTaker.setInPlay(turnTaker.updateScoreBoard(turnTaker.getInPlay()));
        turnTaker.setInPlay(turnTaker.updateDesirableList(turnTaker.getInPlay()));
        
        //B: Player 02
        turnTaker.setNotInPlay(turnTaker.updateScoreBoard(turnTaker.getNotInPlay()));
        turnTaker.setNotInPlay(turnTaker.updateDesirableList(turnTaker.getNotInPlay()));
        
        //C: Remember changes
        return turnTaker;
    }//End 

}//End class
