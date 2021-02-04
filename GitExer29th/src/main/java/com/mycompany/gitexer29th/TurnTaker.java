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
    private ArrayList<Player> inPlayList;

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
            InputStuff inputStuff,
            ArrayList<Player> inPlayList
    ) {
        this.arrayStuff = arrayStuff;
        this.cardStuff = cardStuff;
        this.human = human;
        this.computer = computer;
        this.inPlay = inPlay;
        this.notInPlay = notInPlay;
        this.printStuff = printStuff;
        this.inputStuff = inputStuff;
        this.inPlayList = inPlayList;

    }

    
    //Start getters... -> 9 in total
    
    public ArrayStuff getArrayStuff(){
        return arrayStuff;
    }
    
    public Cards getCardStuff(){
    return cardStuff; 
    }
    
    public Player getHuman() {
        return human;
    }

    public Player getComp() {
        return computer;
    }
    
    public Player getInPlay(){
        return inPlay;
    }
    
    public Player getNotInPlay() {
        return notInPlay;
    }
    
    public PrintStuff getPrintStuff(){
        return printStuff; 
    }
    
    public InputStuff getInputStuff(){
    return inputStuff;
    }

    public ArrayList<Player> getInPlayList(){
        return inPlayList; 
    }
    

    //Start setters... -> 9 in total 

  public void setArrayStuff(ArrayStuff newArrayStuff){
      this.arrayStuff = newArrayStuff; 
  }
  
  public void setcardStuff(Cards newcardStuff){
      this.cardStuff = newcardStuff; 
  }
   
  public void setHuman(Player newHuman){
      this.human = newHuman; 
  }
  
  public void setComp(Player newComp){
      this.computer = newComp; 
  }
 
    public void setInPlay(Player newInPlay) {
        this.inPlay = newInPlay;
    }
    
    public void setNotInPlay(Player newNotInPlay) {
        this.notInPlay = newNotInPlay;
    }
    
    public void setPrintStuff(PrintStuff newPrintStuff){
      this.printStuff = newPrintStuff; 
  }
    
    public void setInputStuff(InputStuff newInputStuff){
      this.inputStuff = newInputStuff; 
  }
    
   public void setInPlayList(ArrayList<Player> newInPlayList){
      this.inPlayList = newInPlayList; 
  }
   
   //End setters...
    
    
   //Start turn related methods
   
    public Player playerSetUp(Player player) {
        //Step 1: Create the stuff
        String uName = getPlayerName();
        ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<>());
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
        boolean hasIt;
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
    public ArrayList<Player> turnSwitcher(Player inPlay, Player notInPlay, ArrayList<Player> inPlayList) {

        //Step 1: go fish 
        //At end of turn in play player needs to go fish
        //Do this before switching player that's in play. 
        ArrayList<Integer> targetHand = inPlay.getHand();
        ArrayList<Integer> updHand = cardStuff.drawCard(targetHand);
        ArrayList<Integer> sortedHand = arrayStuff.sortListAsc(updHand);
        inPlay.setHand(sortedHand);

        //Step 2: Switch who's in play
        Player temp;
        temp = inPlay;
        inPlay = notInPlay;
        notInPlay = temp;
        
        //Add them to in play list
        inPlayList.add(inPlay);
        inPlayList.add(notInPlay);
        
        //Bring it back now 
        return inPlayList;
    }
    
    //Start turn and record who's in play
    public ArrayList<Player> turnStarter(Player player01, Player player02, ArrayList<Player> playerList) {
        
        //Step 1: Assign who's in play
        Player vInPlay = player01;
        Player vNotInPlay = player02; 
        
        //Step 2: Add updated status to array list of players
        playerList.add(vInPlay);//At index 0
        playerList.add(vNotInPlay);//At index 1
   
        return playerList;
    }

    //Deciding which player goes first 
    public String coinToss(String guess) {
        String[] coin = {"heads", "tails"};
        int decision = (int) (Math.random() * 2);
        String flipped = coin[decision];
        String result;
        if (guess.equals(flipped)) {
            result = "correct";
        } else {
            result = "incorrect";
        }
        return result;
    }

}//End class
