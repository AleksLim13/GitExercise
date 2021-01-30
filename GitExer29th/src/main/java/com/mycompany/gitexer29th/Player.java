/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

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
    private int[] book;
    private HashMap<Integer, Integer> books = new HashMap<>();
    private LocalDate date;

    /**
     * @return the name
     */
    

    /**
     * @param givenName the name to set
     */
    public void setName(String givenName) {
        name = givenName;
    }

   

    public void setHand(ArrayList<Integer> newHand) {
        this.hand = newHand;
    }

    public void setScoreBoard(int[][] newScoreBoard) {
        this.scoreBoard = newScoreBoard;
    }
    
    
    public void setBook(int[] newBook){
        this.book = newBook; 
    }
    
    public void setBooks(HashMap<Integer, Integer> newBooks){
        this.books = newBooks; 
    }
    
    public String getName() {
        return name;
    }

     public ArrayList<Integer> getHand() {
        return hand;
    }
    public int[][] getScoreBoard() {
        return scoreBoard;
    }

    public int[] getBook() {
        return book;
    }

    public HashMap<Integer, Integer> getBooks() {
        return books;
    }

    public LocalDate getDate() {
        return date;
    }

}
