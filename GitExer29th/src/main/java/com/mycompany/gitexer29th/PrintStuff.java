/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

/**
 *
 * @author aleks
 */
public class PrintStuff {
    public PrintStuff(){}
    
    public static void formatter(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("_______________________");
        System.out.println(" ");
        System.out.println(" ");
    }
    
    public void handIntro(){
        System.out.println("Your hand is ...");
    }
    
    public void scoreBoardIntro(){
        System.out.println("Your score board is ...");
    }
    
    public void askForACard(int card){
        System.out.println("I'm looking for a: " + card );
    }
    
    public void rejectCardAsk(int card){
        System.out.println("I'm sorry, I don't have any: " + card + " 's");
    }
    
    
    
}//End class 
