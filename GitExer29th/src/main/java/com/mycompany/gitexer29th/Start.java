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


/**
 *
 * @author aleks
 */
public class Start {

    
   

    public Start() {
        
    }
    
    public static void main(String[] args) {
        //begin statements
        
    }    
    
    
    public void test01(){
        //This run does: creates hand, checks hand for duplicates
        //and creates a list of stuff to ask for. 
        
        ArrayStuff arrayStuff = new ArrayStuff();
        Cards cardStuff = new Cards();
        ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<Integer>());        
        ArrayList<Integer> cardHand = arrayStuff.sortListAsc(initialHand);
        System.out.println("Your hand...");
        cardStuff.printHand(cardHand);
        System.out.println(" ");
        int[][] countHolder = cardStuff.createScoreBoard();
        int[][] checkedHand = cardStuff.checkHand(countHolder, cardHand);
        System.out.println("Your scoreboard...");
        cardStuff.printScoreBoard(checkedHand);
        ArrayList<Integer> desirableList = cardStuff.cardDecision(checkedHand, new ArrayList<Integer>());
        System.out.println("What to ask for...");
        cardStuff.printHand(desirableList);
    }
    
 
    
}
