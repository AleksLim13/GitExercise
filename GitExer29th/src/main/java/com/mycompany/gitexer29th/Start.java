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
    TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
     Player human = turnTaker.playerSetUp(new Player());
     Player computer = turnTaker.playerSetUp(new Player());
     turnTaker.showGameDetails(human);
     turnTaker.showGameDetails(computer);
     Cards cardStuff = new Cards();
     boolean flag = true;
     while(flag){
         turnTaker.beginTurn(human, computer);
         int desired = cardStuff.askForACard(new InputStuff());
         int posit = turnTaker.getPosition(computer, desired);
         Player updatedPlayer = turnTaker.updateHand(computer, posit);
         turnTaker.beginTurn(human, updatedPlayer);
     }
     
         
   
    }    
    
    
    public void test01(){
       
         TurnTaker turnTaker = new TurnTaker();
     turnTaker.setDependencies(
                 new ArrayStuff(),
                 new Cards(),
                 new Player(),
                 new Player(),
                 new PrintStuff(),
                 new InputStuff()
     );
     Player human = turnTaker.playerSetUp(new Player());
     Player computer = turnTaker.playerSetUp(new Player());
     turnTaker.showGameDetails(human);
     turnTaker.showGameDetails(computer);
     turnTaker.beginTurn(human, computer);
 
    }
    
    public void test02(){
      
    }
    
 
    
}//End class
