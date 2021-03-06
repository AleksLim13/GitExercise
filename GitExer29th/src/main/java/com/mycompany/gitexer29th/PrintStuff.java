/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.ArrayList;


/**
 *
 * @author Ally Cat @ Sheridan College 2021
 */
public class PrintStuff {
    
    //Empty constructor 
    public PrintStuff(){}
    
    //Just to format console output a little for clarities sake 
    public void formatter(){
        newLineMaker(2);
        System.out.println("_______________________");
        newLineMaker(2);
    }
    
    //notice for the player to check their hand
    public void handIntro(){
        System.out.println("Your hand is ...");
    }
    
    //Just a notice for the player to know where it is
    public void scoreBoardIntro(){
        System.out.println("Your score board is ...");
    }
    
    //The prompt to the player for a card they want
    public int askForACard(int card){
        System.out.println("I'm looking for a: " + card );
        return card;
    }
    
    //message when other player doesn't have any desirables
    public void rejectCardAsk(int card){
        System.out.println("I'm sorry, I don't have any: " + card + " 's");
    }
    
    //Give it a number for how many new lines to make
    public void newLineMaker(int howMany){
        for(int i = 0; i < howMany; i++){
            System.out.println(" ");
        }
        
    }
    
    //Let the player know that they won!
    public void declareWinner(Player winner){
        System.out.println("Congradulations! " + winner.getName());
    }
    
    //print there scoreboard for strategy sake. 
    public void printScoreBoard(int[][] scoreBoard) {
        
        for(int i = 0; i < 13; i++){
             System.out.println(scoreBoard[i][0] + "'s : " + scoreBoard[i][1]);
        }
    }
    
    //Not in usage currently 
     public void printCount(int[] countHolder) {

        for (int i = 0; i < countHolder.length; i++) {

            System.out.print(countHolder[i] + " " + "|");
        }
    }
     
     //Show them their hand 
     public void printHand(ArrayList<Integer> cardHand) {
        for (int i = 0; i < cardHand.size(); i++) {
            System.out.print(cardHand.get(i) + " " + "|");
        }
    }
     
     //Generic array list printer for clarity sake 
      public void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " " + "|");
        }
    }
    
    
    
}//End class 
