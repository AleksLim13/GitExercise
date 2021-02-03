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
    private Player human;
    private Player computer;
    private PrintStuff printStuff; 
    private InputStuff inputStuff; 
                    
                    
    public TurnTaker(){}
    
    
    
    public void setDependencies
        (
            ArrayStuff arrayStuff,
            Cards cardStuff,
            Player human,
            Player computer,
            PrintStuff printStuff,
            InputStuff inputStuff
    ){
        this.arrayStuff = arrayStuff; 
        this.cardStuff = cardStuff; 
        this.human = human;
        this.computer = computer;
        this.printStuff = printStuff; 
        this.inputStuff = inputStuff; 
        
    }
        
        public Player getHuman(){
        return human;
        }
        
        public Player getComp(){
        return computer;
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
        
        //No while loop or flag! WTF?
        public void beginTurn(ArrayList<Integer> hHand, ArrayList<Integer> cHand){
         
       ArrayList<Player> playerList = new ArrayList<Player>();
         boolean hasIt = false;
         int desired = cardStuff.askForACard(new InputStuff());
         hasIt = cardStuff.goFish(cHand, desired);
         int posit = getPosition(cHand, desired);
         
       
            
             if(hasIt == true){
                 ArrayList<Integer> updCompHand = cardStuff.deleteCard(cHand, posit);
                 beginTurn(hHand, updCompHand);
                 
             }
             
             else{
          
                     System.out.println("Sorry, don't have that card mate");
                 
             }
             
            
        }
        
     
      
      public int getPosition(ArrayList<Integer> hand, int desired){
         int posit = cardStuff.findPosit(hand, desired);
      return posit;
      }
        
        
        
        
}//End class
