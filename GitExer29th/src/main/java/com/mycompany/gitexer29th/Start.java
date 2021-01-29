/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public Start(){
            
    }
    
    public static void main(String[] args){
        //begin statements
        Cards cardStuff = new Cards();
    ArrayList<Integer> initialHand = cardStuff.createHand(new ArrayList<Integer>()); 
    Start game = new Start();
    ArrayList<Integer> cardHand = game.arrayStuff.sortListAsc(initialHand);
    cardStuff.printHand(cardHand);
    } 
    
    
    public LocalDate getDate(){
    return LocalDate.now();
    }
    
}
