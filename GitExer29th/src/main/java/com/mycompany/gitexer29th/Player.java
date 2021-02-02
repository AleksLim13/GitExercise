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
 * We need a way to have 
 * a unique player we can 
 * associate a bunch of specific
 * game related details with. 
 * Each instance of this class is a player
 * and you can save details with each instance
 * we will need to use elsewhere in the game. 
 * It helps us pass lots of different kinds of data
 * in one var to a method. 
 *
 * @author Ally Cat @ Sheridan College 2021
 */
public class Player {

    //To print out the players name
    private String name;
    //to have a score board linked specifically to a unique player
    private int[][] scoreBoard;
    //Each player needs a card hand linked to them with other data.
    private ArrayList<Integer> hand;
    //Each player needs a way to record how many 4 of a kinds they have
    private HashMap<Integer, Integer> books = new HashMap<>();
    //This is just for I guess pofessionalism. 
    private LocalDate date;

    public Player() {

    }

    //Something about dependecy injection 
    public Player(String name,
            int[][] scoreBoard,
            ArrayList<Integer> hand,
            HashMap<Integer, Integer> books,
            LocalDate date) {
        this.scoreBoard = scoreBoard;
        this.hand = hand;
        this.books = books;
        this.date = date;
    }

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

   

    public void setBooks(HashMap<Integer, Integer> newBooks) {
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

   

    public HashMap<Integer, Integer> getBooks() {
        return books;
    }

    public LocalDate getDate() {
        return date;
    }

}//End class 
