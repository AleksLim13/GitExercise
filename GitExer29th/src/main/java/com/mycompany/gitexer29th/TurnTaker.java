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
    private Player inPlay;
    private Player notInPlay;
    private PrintStuff printStuff;
    private InputStuff inputStuff;

    public TurnTaker() {
    }

    public void setDependencies(
            ArrayStuff arrayStuff,
            Cards cardStuff,
            Player human,
            Player computer,
            Player inPlay,
            Player notInPlay,
            PrintStuff printStuff,
            InputStuff inputStuff
    ) {
        this.arrayStuff = arrayStuff;
        this.cardStuff = cardStuff;
        this.human = human;
        this.computer = computer;
        this.inPlay = inPlay;
        this.notInPlay = notInPlay; 
        this.printStuff = printStuff;
        this.inputStuff = inputStuff;

    }

    public Player getHuman() {
        return human;
    }

    public Player getComp() {
        return computer;
    }

    public Player playerSetUp(Player player) {
        //Step 1: Create the stuff
        String uName = getPlayerName();
        ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<Integer>());
        ArrayList<Integer> sortedHand = arrayStuff.sortListAsc(initialHand);
        int[][] initialHolder = cardStuff.createScoreBoard();
        int[][] countHolder = cardStuff.checkHand(initialHolder, sortedHand);
        ArrayList<Integer> desirableList = cardStuff.cardDecision(countHolder, new ArrayList<>());

        //Step 2: Set the stuff 
        player.setName(uName);
        player.setHand(sortedHand);
        player.setScoreBoard(countHolder);
        player.setDesirableList(desirableList);
        return player;

    }

    public String getPlayerName() {
        String humanName = inputStuff.promptStringUser(new Scanner(System.in));
        return humanName;
    }

    public void showGameDetails(Player player) {
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

    //Simulates a turn in go fish
    //Takes 2 player objects as params
    //Returns a list of player objects 
    public ArrayList<Player> beginTurn(Player inPlay, Player notInPlay) {

        //Step 1: setup variables needed 
        ArrayList<Integer> inPlHand = inPlay.getHand();
        ArrayList<Integer> notInPlHand = notInPlay.getHand();
        ArrayList<Player> playerList = new ArrayList<>();
        boolean hasIt = false;
        int desired = cardStuff.askForACard(new InputStuff());
        hasIt = cardStuff.goFish(notInPlHand, desired);
        int posit = getPosition(notInPlHand, desired);

        //Step 2: If opponent has card you want step inside here...
        //Update players hands accordingly 
        if (hasIt == true) {
            ArrayList<Integer> updNIPHand = cardStuff.deleteCard(notInPlHand, posit);
            notInPlay.setHand(updNIPHand);
            ArrayList<Integer> updIPlHand = cardStuff.addCard(inPlHand, desired);
            ArrayList<Integer> sortedHand = arrayStuff.sortListAsc(updIPlHand);
            inPlay.setHand(sortedHand);
            playerList.add(notInPlay);
            playerList.add(inPlay);
            beginTurn(inPlay, notInPlay);
        } else {
            System.out.println("Sorry, don't have that card mate");
        }
        //Step 3:  return both players updated hands in here...
        return playerList;
    }

    //Get index position of card value to know where to delete card
    public int getPosition(ArrayList<Integer> hand, int desired) {
        int posit = cardStuff.findPosit(hand, desired);
        return posit;
    }

    //Need official method to switch whos turn it is
    //And keep it documented. 
    public Player turnSwitcher(Player inPlay, Player notInPlay) {
        Player temp;
        temp = inPlay;
        inPlay = notInPlay;
        notInPlay = temp;
        return inPlay;
    }

    //Deciding which player goes first 
    public String coinToss(String guess) {
        String[] coin = {"heads", "tails"};
        int decision = (int) (Math.random() * 2);
        String flipped = coin[decision];
        String result = " ";
        if (guess == flipped) {
            result = "correct";
        } else {
            result = "incorrect";
        }
        return result;
    }

}//End class
