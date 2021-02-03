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
import java.util.Scanner;


/**
 *
 * @author Ally Cat @ Sheridan College 2021
 */
public class Start {

    
   

    public Start() {
     
    }
    
    public static void main(String[] args) {
        //begin statements
        
    
    }    
    
    
    public void test01(){
       
         TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
     Player human = turnTaker.playerSetUp(new Player());
     Player computer = turnTaker.playerSetUp(new Player());
     turnTaker.showGameDetails(human);
     turnTaker.showGameDetails(computer);
 
    }
    
    public void test02(){
      TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
     Player human = turnTaker.playerSetUp(new Player());
     Player computer = turnTaker.playerSetUp(new Player());
     turnTaker.showGameDetails(human);
     turnTaker.showGameDetails(computer);
     //turnTaker.beginTurn(human.getHand(), computer.getHand());
     System.out.println("Testing stuff");
     System.out.println("After updates...");
     turnTaker.showGameDetails(computer);
    }
    
    
    public void test03(){
        //Good: begin turn now can continuously ask for a
        //card from opponent and update both players hands
        //accordingly as per rules of go fish.
        //Like: give the card to opponents hand and remove from
        //person giving card. 
        TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
     Player human = turnTaker.playerSetUp(new Player());
     Player computer = turnTaker.playerSetUp(new Player());
     turnTaker.showGameDetails(human);
     turnTaker.showGameDetails(computer);
     ArrayList<Player> playerList = turnTaker.beginTurn(human, computer);
     Player udpComp = playerList.get(0);
     Player udpHuman = playerList.get(1);
     turnTaker.showGameDetails(udpComp);
     turnTaker.showGameDetails(udpHuman);
    }
    
    public void test04(){
        TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
     Player human = turnTaker.playerSetUp(new Player());
     Player computer = turnTaker.playerSetUp(new Player());
     turnTaker.showGameDetails(human);
     turnTaker.showGameDetails(computer);
     ArrayList<Player> playerList = turnTaker.beginTurn(human, computer);
     Player udpComp = playerList.get(0);
     Player udpHuman = playerList.get(1);
     turnTaker.showGameDetails(udpComp);
     turnTaker.showGameDetails(udpHuman);
    }
    
    public void test05(){
        TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
   
     InputStuff inputStuff = turnTaker.getInputStuff();
     String uGuess = inputStuff.promptStringUser(new Scanner(System.in)); 
     String coinToss = turnTaker.coinToss(uGuess);
     System.out.println(coinToss);
    }
 
    
}//End class
