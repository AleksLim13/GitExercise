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
 * A class that represents tasks related to a deck of cards 
 * utilized in a Go Fish card game.
 * 
 *
 * @author Ally Cat @ Sheridan College 2021

*/
public class Cards {

    public Cards() {
    }

   
    //Every call will compare each card (8) to this switch
    //And the left column in score board is values from 1-13
    //Simulating standard deck values. When each case value that
    //associated with left column of scoreboard will be incremented
    //Each time that card is seen. 
    //Example: | 3's : 3 | where it means theres three 3's in the players card hand.
    //1 more 3 and the player has 4 of a kind: a book. 
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

    //left column goes from 1-13 vertically. 
    //Right column is empty now but will represent like tally 
    //ticks incrementing every time the same card is seen. 
    public int[][] createScoreBoard() {
        //array_name[row_index][column_index] = value;
        int[][] scoreBoard = new int[13][2];
       
        for(int i = 0; i < 13; i++){
            scoreBoard[i][0] = i + 1;
        }
        return scoreBoard;
    }

    
    //Calls record types on each card and ticks the matching tallies in scoreBoard
    public int[][] checkHand(int[][] countHolder, ArrayList<Integer> cardHand) {
        for (int i = 0; i < cardHand.size(); i++) {
            recordTypes(cardHand.get(i), countHolder);
        }
        return countHolder;
    }

    //This just adds a possible 1-13 value to the players hand
    //Meant to be a "go fish" or "sorry don't have that card dude." 
    public ArrayList<Integer> drawCard(ArrayList<Integer> cardHand) {
        cardHand.add(randShuffle());
        return cardHand;
    }

  
    //This method takes the score board previously had tallies
    //incremented every time a duplicate card value was seen.
    //Now it will take card values with more than 1 duplicate into
    //a array list and return it so it can be used elsewhere to
    //simulate asking a player for a card.
    public ArrayList<Integer> cardDecision(int[][] scoreBoard, ArrayList<Integer> dupesHolder) {
           //Rows [i] and columns [j]
        for (int i = 0; i < 13; i++) {
            if (scoreBoard[i][1] > 1) {
                dupesHolder.add(scoreBoard[i][0]);
            }
        }
        return dupesHolder;
    }

    //This takes the array list of possible cards a player should ask for 
    //And uses it to remove the right card from my hand when I have to give the 
    //card to the other player. 
    //It calls another method who knows how to delete cards from a hand
    public ArrayList<Integer> checkHandAndRemove(ArrayList<Integer> cardHand, ArrayList<Integer> dupesHolder) {
        
        if (dupesHolder != null) {
            cardHand = deleteCard(cardHand, dupesHolder.get(0));
        }
        return cardHand;
    }
    
    //Notice: player's hand is assumed to be ordered ascendingly already
    public Player checkBooks(Player player){
        
        //Step 1: 
        ArrayList<Integer> targetHand = player.getHand(); 
        int[][] targetSB = player.getScoreBoard();
        HashMap<Integer, Integer> books = player.getBooks();
        int posit; 
        
        //Step 2: 
        for(int i = 0; i < 13; i++){
            if(targetSB[i][1] >= 4){
                
                //A: 
                books.put(targetSB[i][0], targetSB[i][1]);
                
                //B: 
                posit = findPosit(targetHand, targetSB[i][0]);
                
                //C: 
                targetHand = deleteCard(targetHand, posit);
                targetHand = deleteCard(targetHand, posit + 1);
                targetHand = deleteCard(targetHand, posit + 2);
                targetHand = deleteCard(targetHand, posit + 3);
                
                //D: 
                player.setHand(targetHand);
            }
        }
        
        //Step 3: 
        return player; 
    }

    //Takes value as parameter and uses it to remove that card from 
    //a simulated card hand also passed to it. 
    public ArrayList<Integer> deleteCard(ArrayList<Integer> cardHand, int posit) {
        ArrayList<Integer> resultHand = cardHand;
        resultHand.remove(posit);
        return resultHand;
    }

    //Adds a value passed to it's card hand list also passed to it 
    //To simulate receiving the card from your opponent and
    //Putting it in your hand. 
    public ArrayList<Integer> addCard(ArrayList<Integer> cardHand, int value) {

        cardHand.add(value);
        return cardHand;
    }
    
    //Takes as parameter a hash map with left key as card number and
    //right value is just the 4 amount value to indicate a book was made. 
    //Returns the players book
    public HashMap<Integer, Integer> updateBooks(HashMap<Integer, Integer> books, int[][] scoreBoard){
        for(int i = 0; i < 13; i++){
            if(scoreBoard[i][1] >= 4){
                books.put(scoreBoard[i][0], scoreBoard[i][1]);
            }
        }
        return books; 
    }
    
    //compares player objects field var books. 
    //Comparison is based on nunber of key value pairs in books 
    public Player determineWinner(Player human, 
                                  Player computer,
                                  HashMap<Integer, Integer> hBook,
                                  HashMap<Integer, Integer> cBook,
                                  Player winner){
         
        if(hBook.size() > cBook.size()){
            winner = human;
            
        }
        else {
            winner = computer; 
        }
        
        return winner; 
    }
    
    //This prompts for a card it knows about from a 
    //Param value taken from elsewhere to simulate a card ask of 
    //a opponent. It has validation for a value from 1-13(deck values)
    //and to make sure it's a number. 
    //Human player will respond to this method directly. 
    public int askForACard(InputStuff input){
        boolean flag = true; 
        System.out.println("What card do you want");
        int target = input.promptIntUser(new Scanner(System.in));
        if(target < 1 || target > 13){
            while(flag){
            System.out.println("Notice: Cards in a standard deck range from 1-13");
            target = input.promptIntUser(new Scanner(System.in));
            if(target >= 1 && target <= 13){
                flag = false; 
                return target;
            }
        } 
        }
        else {return target;}
        
        return target; 
        }   
    
    
    //This works as a check if card is in opponents hand 
    //so there turn keeps going
    public boolean goFish(ArrayList<Integer> hand, int card){
    
        boolean shouldKeepGoing = false; 
        
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i) == card){
                shouldKeepGoing = true;
                return shouldKeepGoing;
            }
      
        }
        return shouldKeepGoing;  
    }
    
    //Need to know what the index of the card need to remove 
    //from hand
    public int findPosit(ArrayList<Integer> hand, int card){
    
        int posit = 0; 
        
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i) == card){
                posit = i;
                return posit;
            }
      
        }
        return posit;  
    }

}//End class 
