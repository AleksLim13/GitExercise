/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * I guess this is like the controller in MVC architecture. 
 * 
 * @author Ally Cat @ Sheridan College 2021
 */
public class TurnTaker {
    
    
    private ArrayStuff arrayStuff; 
    private Cards cardStuff;
    private Player player01;
    private Player computer;
    private PrintStuff printStuff; 
    private InputStuff inputStuff; 
                    
                    
    public TurnTaker(){}
    
    
    
    public void setDependencies
        (
            ArrayStuff arrayStuff,
            Cards cardStuff,
            Player player01,
            Player computer,
            PrintStuff printStuff,
            InputStuff inputStuff
    ){
        this.arrayStuff = arrayStuff; 
        this.cardStuff = cardStuff; 
        this.player01 = player01;
        this.computer = computer;
        this.printStuff = printStuff; 
        this.inputStuff = inputStuff; 
        
    }
        
        public Player playerSetUp(Player player){
        //Step 1: Create the stuff
        String uName = getPlayerName();
        ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<Integer>());  
        ArrayList<Integer> sortedHand = arrayStuff.sortListAsc(initialHand);
        int[][] initialHolder = cardStuff.createScoreBoard();
        int[][] countHolder = cardStuff.checkHand(initialHolder, sortedHand);
        ArrayList<Integer> desirableList = cardStuff.cardDecision(countHolder, new ArrayList<Integer>());
        
        //Step 2: Set the stuff 
        player.setName(uName);
        player.setHand(sortedHand);
        player.setScoreBoard(countHolder);
        player.setDesirableList(desirableList); 
        return player;
        
    }
        
      
        
        public String getPlayerName(){
            String humanName = inputStuff.promptStringUser(new Scanner(System.in));
            return humanName;
        }
       
        
        public void showGameDetails(Player player){
            printStuff.newLineMaker(2);
            System.out.println("Welcome to Go Fish!");
           System.out.println(player.getName()); 
           printStuff.newLineMaker(2);
            System.out.println("Here is your hand...");
           printStuff.printHand(player.getHand());
           printStuff.newLineMaker(2);
            System.out.println("Here is your score board...");
           printStuff.printScoreBoard(player.getScoreBoard());
           printStuff.newLineMaker(2);
            System.out.println("Here's what you should ask for...");
           printStuff.printList(player.getDesirableList());
        }
        
        //Prolly need a while loop and flag 
        public Player beginTurn(Player human, Player computer, Player nextPlayer){
         boolean flag = true; 
         while(flag){
             int desired = cardStuff.askForACard(new InputStuff());
             boolean hasIt = cardStuff.goFish(computer, desired);
             if(!hasIt){
                 flag = false;
                 nextPlayer = computer; 
             }
             else
             {
             flag = true; 
             }
         }
        return nextPlayer; 
        }
        
        
        
        
}//End class
