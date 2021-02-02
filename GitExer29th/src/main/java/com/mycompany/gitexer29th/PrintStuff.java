/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.HashMap;

/**
 *
 * @author aleks
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
    public void askForACard(int card){
        System.out.println("I'm looking for a: " + card );
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
    
    public void declareWinner(HashMap<Integer, Integer> winner){
        
    }
    
    
    
}//End class 
