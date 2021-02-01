/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A class that creates an Array of Students and populates it with 5 students
 * from the current section and then iterates over the list to print each name.
 *
 * @author dancye, Jan 2019
 */
public class Cards {

    public Cards() {
    }

   

    public int[][] recordTypes(int card, int[][] countHolder) {

        switch (card) {
            case 1:
                countHolder[0][1]++;
                return countHolder;

            case 2:
                countHolder[1][1]++;
                return countHolder;

            case 3:
                countHolder[2][1]++;
                return countHolder;

            case 4:
                countHolder[3][1]++;
                return countHolder;
            case 5:
                countHolder[4][1]++;
                return countHolder;
            case 6:
                countHolder[5][1]++;
                return countHolder;

            case 7:
                countHolder[6][1]++;
                return countHolder;
            case 8:
                countHolder[7][1]++;
                ;
                return countHolder;
            case 9:
                countHolder[8][1]++;
                return countHolder;
            case 10:
                countHolder[9][1]++;
                return countHolder;
            case 11:
                countHolder[10][1]++;
                return countHolder;
            case 12:
                countHolder[11][1]++;
                return countHolder;
            case 13:
                countHolder[12][1]++;
                return countHolder;
        }
        // Outputs "Thursday" (day 4)
        return countHolder;
    }

    public void printScoreBoard(int[][] scoreBoard) {
        
        for(int i = 0; i < 13; i++){
             System.out.println(scoreBoard[i][0] + "'s : " + scoreBoard[i][1]);
        }
    }

    public void printCount(int[] countHolder) {

        for (int i = 0; i < countHolder.length; i++) {

            System.out.print(countHolder[i] + " " + "|");
        }
    }

    //Simulate possibility of getting card type
    //Return actual possible type
    //Cards have 13 unique values * 4 in a deck
    public int randShuffle() {
        int cPossible = (int) (Math.random() * 13) + 1;
        return cPossible;
    }

    //add random number 0-13 8 times to a integer array list to simulate card hand
    public ArrayList<Integer> createHand(ArrayList<Integer> cardHand) {

        for (int i = 0; i < 8; i++) {
            cardHand.add(randShuffle());
        }
        return cardHand;
    }

    public int[][] createScoreBoard() {
        //array_name[row_index][column_index] = value;
        int[][] scoreBoard = new int[13][2];
       
        for(int i = 0; i < 13; i++){
            scoreBoard[i][0] = i + 1;
        }
        return scoreBoard;
    }

    public void printHand(ArrayList<Integer> cardHand) {
        for (int i = 0; i < cardHand.size(); i++) {
            System.out.print(cardHand.get(i) + " " + "|");
        }
    }

    public int[][] checkHand(int[][] countHolder, ArrayList<Integer> cardHand) {
        for (int i = 0; i < cardHand.size(); i++) {
            recordTypes(cardHand.get(i), countHolder);
        }
        return countHolder;
    }

    public ArrayList<Integer> drawCard(ArrayList<Integer> cardHand) {
        cardHand.add(randShuffle());
        return cardHand;
    }

  
    public ArrayList<Integer> cardDecision(int[][] scoreBoard, ArrayList<Integer> dupesHolder) {
           //Rows [i] and columns [j]
        for (int i = 0; i < 13; i++) {
            if (scoreBoard[i][1] > 1) {
                dupesHolder.add(scoreBoard[i][0]);
            }
        }
        return dupesHolder;
    }

    public ArrayList<Integer> checkHandAndRemove(ArrayList<Integer> cardHand, ArrayList<Integer> dupesHolder) {
        
        if (dupesHolder != null) {
            cardHand = deleteCard(cardHand, dupesHolder.get(0));
        }
        return cardHand;
    }

    public ArrayList<Integer> deleteCard(ArrayList<Integer> cardHand, int value) {

        cardHand.remove(value);
        return cardHand;
    }

    public ArrayList<Integer> addCard(ArrayList<Integer> cardHand, int value) {

        cardHand.add(value);
        return cardHand;
    }
    
    public HashMap<Integer, Integer> updateBooks(HashMap<Integer, Integer> books, int[][] scoreBoard){
        for(int i = 0; i < 13; i++){
            if(scoreBoard[i][1] >= 4){
                books.put(scoreBoard[i][0], scoreBoard[i][1]);
            }
        }
        return books; 
    }
    

    public int askForACard(int target, InputStuff input){
        boolean flag = true; 
     
        while(flag){
            System.out.println("Notice: Cards in a standard deck range from 1-13");
            target = input.promptIntUser(new Scanner(System.in));
            if(target >= 1 && target <= 13){
                flag = false; 
                return target;
            }
        } 
        return target; 
        }   

}//End class 
