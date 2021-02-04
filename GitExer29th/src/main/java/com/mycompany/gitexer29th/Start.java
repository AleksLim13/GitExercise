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
    
    public TurnTaker getTurnTaker(){
        return turnTaker; 
    }
    
    public void setTurnTaker(TurnTaker newTurnTaker){
     this.turnTaker = newTurnTaker; 
    }

    public static void main(String[] args) {
        
        
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
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
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
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
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
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
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
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
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
                new InputStuff(),
                new ArrayList<>(),
                new String(),
                new String(),
                new ArrayList<>()
        );

        InputStuff inputStuff = turnTaker.getInputStuff();
        String uGuess = inputStuff.promptStringUser(new Scanner(System.in));
        String coinToss = turnTaker.coinToss(uGuess);
        System.out.println(coinToss);
    }
    
    public void test06(){
    
    //Step 1: Create turn taker object and inject dependencies 
        TurnTaker turnTaker = new TurnTaker();
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
    }
    
    
    public TurnTaker step1_CreateTurnTaker(TurnTaker turnTaker){
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
        return turnTaker; 
    }
    
    public TurnTaker step2_CreatePlayers(TurnTaker turnTaker){
        //Step 2: Create players
        System.out.println("Setting up players...");
        turnTaker.setHuman(turnTaker.playerSetUp(new Player()));
        turnTaker.setComp(turnTaker.playerSetUp(new Player()));
        return turnTaker; 
    }
    
    public TurnTaker step3_StartCoinToss(TurnTaker turnTaker, InputStuff inputStuff){
        //Step 3: Start coin toss
        inputStuff = turnTaker.getInputStuff();
        System.out.println("Heads or tails: ");
        turnTaker.setGuess(inputStuff.promptStringUser(new Scanner(System.in)));
        turnTaker.setCoinToss(turnTaker.coinToss(turnTaker.getGuess()));
        System.out.println(turnTaker.getCoinToss());
        return turnTaker; 
    }
    
    public TurnTaker step4_StartTurnStarter(TurnTaker turnTaker){
    //Step 4: Start turn starter 
        if (turnTaker.getCoinToss().equals("correct")) {
            System.out.println("Your correct");
            turnTaker.setInPlayList(turnTaker.turnStarter(turnTaker.getHuman(), turnTaker.getComp(), new ArrayList<>()));
        } else {
            System.out.println("Sorry wrong answer");
            turnTaker.setInPlayList(turnTaker.turnStarter(turnTaker.getComp(), turnTaker.getHuman(), new ArrayList<>()));
        }
        return turnTaker; 
    }
    
    public TurnTaker step5_BeginFirstRound(TurnTaker turnTaker){
    //Step 5: Begin turn with player in play
        turnTaker.setUpdPlayerList(turnTaker.beginTurn(turnTaker.getInPlay(), turnTaker.getNotInPlay()));
        return turnTaker; 
    }
    
    
    public TurnTaker step6_SwitchWhosInPlay(TurnTaker turnTaker){
    //Step 6: Switch players in play
        turnTaker.setInPlayList(turnTaker.turnSwitcher(turnTaker.getInPlay(), turnTaker.getNotInPlay(), new ArrayList<>()));
        return turnTaker; 
    }
    
    public TurnTaker step7_DocStats(TurnTaker turnTaker){
        
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
    
    public TurnTaker step8_StartUpdGame(TurnTaker turnTaker){
        //Step 7: Begin turn with switched player in play
         turnTaker.setUpdPlayerList(turnTaker.beginTurn(turnTaker.getInPlay(), turnTaker.getNotInPlay()));
         return turnTaker; 
    }

}//End class
