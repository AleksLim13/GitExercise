/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ally Cat @ Sheridan College 2021
 */
public class InputStuff {
    
    public InputStuff(){}
    
    //Validation that would need to happen every time
    //a double is needed from the user as input
    public double promptDoubleUser(Scanner input){
		boolean continueInput = true;
		double userNum = 0.0;

		do{
			try{

				System.out.println("Enter a double like 3.0");
			    userNum = input.nextDouble();
			    continueInput = false;
			}
			catch (InputMismatchException ex){
				System.out.println("Not a double!");
				input.nextLine();
			}

		}
		while(continueInput);


		return userNum;
	}
    
        //Validation that would need to happen every time
        //a integer is needed from the user as input
    //lets put it here and just reuse it. 
	public int promptIntUser(Scanner input){
		boolean continueInput = true;
		int userNum = 0;

		do{
			try{

				System.out.println("Enter a integer like 3");
			    userNum = input.nextInt();
			    continueInput = false;
			}
			catch (InputMismatchException ex){
				System.out.println("Not a Integer!");
				input.nextLine();
			}

		}
		while(continueInput);


		return userNum;
	}
    
        
        
}//end class
