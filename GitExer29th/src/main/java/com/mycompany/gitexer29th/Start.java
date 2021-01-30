/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
JanuarySigRug9M29th
https://github.com/AleksLim13/GitExercise.git
C:\Users\aleks\Documents\NetBeansProjects

 */
package com.mycompany.gitexer29th;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author aleks
 */
public class Start {

    private LocalDate date;    
    private ArrayStuff arrayStuff = new ArrayStuff();

    public Start() {
        
    }
    
    public static void main(String[] args) {
        //begin statements
        Cards cardStuff = new Cards();
        ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<Integer>());        
        Start game = new Start();
        ArrayList<Integer> cardHand = game.arrayStuff.sortListAsc(initialHand);
        System.out.println("Your hand...");
        cardStuff.printHand(cardHand);
        int[][] countHolder = cardStuff.createScoreBoard();
        int[][] checkedHand = cardStuff.checkHand(countHolder, cardHand);
        System.out.println("Your scoreboard...");
        cardStuff.printScoreBoard(checkedHand);
        ArrayList<Integer> desirableList = cardStuff.cardDecision(checkedHand, cardHand);
        System.out.println("What to ask for...");
        cardStuff.printHand(desirableList);
        
    }    
    
    public LocalDate getDate() {
        return LocalDate.now();
    }
    
}
