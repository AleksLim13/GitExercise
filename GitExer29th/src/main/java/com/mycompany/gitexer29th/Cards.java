/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.ArrayList;

/**
 * A class that creates an Array of Students and populates it with 5 students
 * from the current section and then iterates over the list to print each name.
 *
 * @author dancye, Jan 2019
 */
public class Cards {

    public Cards() {
    }


   
    
    public int[][] recordTypes(int card, int[][] countHolder){



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
			countHolder[7][1]++;;
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

	public void printScoreBoard(int[][] scoreBoard){
      System.out.println(scoreBoard[0][0] + "'s : " + scoreBoard[0][1]);
      System.out.println(scoreBoard[1][0] + "'s : " + scoreBoard[1][1]);
      System.out.println(scoreBoard[2][0] + "'s : " + scoreBoard[2][1]);
      System.out.println(scoreBoard[3][0] + "'s : " + scoreBoard[3][1]);
      System.out.println(scoreBoard[4][0] + "'s : " + scoreBoard[4][1]);
      System.out.println(scoreBoard[5][0] + "'s : " + scoreBoard[5][1]);
      System.out.println(scoreBoard[6][0] + "'s : " + scoreBoard[6][1]);
      System.out.println(scoreBoard[7][0] + "'s : " + scoreBoard[7][1]);
      System.out.println(scoreBoard[8][0] + "'s : " + scoreBoard[8][1]);
      System.out.println(scoreBoard[9][0] + "'s : " + scoreBoard[9][1]);
      System.out.println(scoreBoard[10][0] + "'s : " + scoreBoard[10][1]);
      System.out.println(scoreBoard[11][0] + "'s : " + scoreBoard[11][1]);
      System.out.println(scoreBoard[12][0] + "'s : " + scoreBoard[12][1]);

	}
	public void printCount(int[] countHolder){

		for(int i = 0; i < countHolder.length; i++){

			System.out.print(countHolder[i] + " " + "|");
		}
	}

	//Simulate possibility of getting card type
	//Return actual possible type
	//Cards have 13 unique values * 4 in a deck

	public int randShuffle(){
		int cPossible = (int)(Math.random()*13) + 1;
		return cPossible;
	}

	//add random number 0-13 8 times to a integer array list to simulate card hand
	public ArrayList<Integer> createHand(ArrayList<Integer> cardHand){
		
            for(int i = 0; i < 8; i++){
            cardHand.add(randShuffle());
            }	
		return cardHand;
	}

	public int[][] createScoreBoard(){
		//array_name[row_index][column_index] = value;
		int[][] scoreBoard = new int[13][2];
		scoreBoard[0][0] = 1;
		scoreBoard[1][0] = 2;
		scoreBoard[2][0] = 3;
		scoreBoard[3][0] = 4;
		scoreBoard[4][0] = 5;
		scoreBoard[5][0] = 6;
		scoreBoard[6][0] = 7;
		scoreBoard[7][0] = 8;
		scoreBoard[8][0] = 9;
		scoreBoard[9][0] = 10;
		scoreBoard[10][0] = 11;
		scoreBoard[11][0] = 12;
		scoreBoard[12][0] = 13;

		return scoreBoard;
	}

	public void printHand(ArrayList<Integer> cardHand){
		for(int i = 0; i < cardHand.size(); i++){
			System.out.print(cardHand.get(i) + " " + "|");
		}
	}

	public int[][] checkHand(int[][] countHolder, ArrayList<Integer> cardHand){
		for(int i = 0; i < cardHand.size(); i++){
			recordTypes(cardHand.get(i), countHolder);
		}
		return countHolder;
	}

	public ArrayList<Integer> drawCard(ArrayList<Integer> cardHand){
		cardHand.add(randShuffle());
		return cardHand;
	}

	public void testProgram(){
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer >cardHand = createHand(testList);




		int[][] countHolder = createScoreBoard();
		printHand(cardHand);
		System.out.println(" ");
		System.out.println("---------------------------");
		int[][] checkedHand = checkHand(countHolder, cardHand);//Woo Hoo! You did it...Woo Hoo * 2.
		/*
			//3 times so far problems: where I'm creating objects or variables.

		 *
		 */
		printScoreBoard(checkedHand);
	}

}//End class 
