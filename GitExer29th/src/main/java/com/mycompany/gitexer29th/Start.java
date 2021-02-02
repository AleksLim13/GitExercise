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
        PrintStuff printStuff = new PrintStuff(); 
        System.out.println("Your hand...");
        printStuff.printHand(cardHand);
        System.out.println(" ");
        int[][] countHolder = cardStuff.createScoreBoard();
        int[][] checkedHand = cardStuff.checkHand(countHolder, cardHand);
        System.out.println("Your scoreboard...");
        printStuff.printScoreBoard(checkedHand);
        ArrayList<Integer> desirableList = cardStuff.cardDecision(checkedHand, new ArrayList<Integer>());
        System.out.println("What to ask for...");
        printStuff.printHand(desirableList);
    }
    
    public void test02(){
        //This run does: creates hand, checks hand for duplicates
        //and creates a list of stuff to ask for. 
        ArrayStuff arrayStuff = new ArrayStuff();
        Cards cardStuff = new Cards();
        Player player01 = new Player();
        Player computer = new Player();
        PrintStuff printStuff = new PrintStuff(); 
        
        ArrayList<Integer> pOneInitialHand = cardStuff.createHand(new ArrayList<Integer>());  
        ArrayList<Integer> pOneSortedHand = arrayStuff.sortListAsc(pOneInitialHand);
        player01.setHand(pOneSortedHand);
        int[][] pOneCountHolder = cardStuff.createScoreBoard();
        
        
        
        ArrayList<Integer> pCompInitialHand = cardStuff.createHand(new ArrayList<Integer>());  
        ArrayList<Integer> pCompSortedHand = arrayStuff.sortListAsc(pCompInitialHand);
        computer.setHand(pCompSortedHand);
        int[][] compCountHolder = cardStuff.createScoreBoard();
        
        
        
        
        
        ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<Integer>());        
        ArrayList<Integer> cardHand = arrayStuff.sortListAsc(initialHand);
        System.out.println("Your hand...");
        printStuff.printHand(cardHand);
        System.out.println(" ");
        int[][] countHolder = cardStuff.createScoreBoard();
        int[][] checkedHand = cardStuff.checkHand(countHolder, cardHand);
        System.out.println("Your scoreboard...");
        printStuff.printScoreBoard(checkedHand);
        ArrayList<Integer> desirableList = cardStuff.cardDecision(checkedHand, new ArrayList<Integer>());
        System.out.println("What to ask for...");
        printStuff.printHand(desirableList);
    }
    
 
    
}
