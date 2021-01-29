/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class to model Student Objects each student has: a name (first an last
 * name) each student can: say their name (getName)
 *
 * @author dancye May 7, 2018
 */
public class Player {

    private String name;
    private int[][] scoreBoard;
    private ArrayList<Integer> hand;
    private int[] books;
    private LocalDate date;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param givenName the name to set
     */
    public void setName(String givenName) {
        name = givenName;
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public int[][] getScoreBoard() {
        return scoreBoard;
    }
    
    
    public int[] getBooks(){
    return books; 
    }
    
    public LocalDate getDate(){
    return date; 
    }

}
