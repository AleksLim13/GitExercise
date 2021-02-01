/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author aleks
 */
public class ArrayStuff {

    public ArrayStuff() {

    }

    // Print all the array elements
    public static void printElems(double[] myList) {
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }
    }
    
    //Print ArrayList elements 
    public static void printListElems(ArrayList<Integer> cardList){
        for (int i = 0; i < cardList.size(); i++) {
            System.out.print(cardList.get(i) + " | ");
        }
    }

    // Summing all elements
    public static double sumElems(double[] myList) {
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);
        return total;
    }

    // Finding the largest element
    public static double findMaxy(double[] myList) {
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
        }
        System.out.println("Max is " + max);
        return max;
    }
    
    

    //returns an array that is the reversal of another array 
    public static int[] getReverse(int[] list) {
        int[] result = new int[list.length];

        //i < list.length is single test condition. 
        //look for commas and where semi colon ends to see grouping. 
        //2 counters: 1 to start at beginning element and 1 for ending element slot
        //Use assignment to make last = first.
        //Then update counters to move to next slot either down or up.
        //Then swap again. 
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }

    //find specific item in array
    //You pass this method an array initialized with values
    //and an item of the same type to search for.
    //It returns a message of yes or no.
    public static boolean youThere(int[] holder, int target) {
        for (int tempVar : holder) {
            if (target == tempVar) {
                return true;
            }
        }
        return false;
    }

    // Find the index of an array element
    //You provide this method an array full of values
    //Then you have a value and don't know what index it is
    //You don't know it's place in the holder
    public static int findIndex(int[] myArray, int tValue) {
        if (myArray == null) {
            return -1;
        }
        int size = myArray.length;
        int i = 0;
        while (i < size) {
            if (myArray[i] == tValue) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    //Remove a specific element from an array
    //You know the spot you want to have it's value removed.
    //rIndex could be slot 4 or slot 9
    //The loop will start at that known slot and start
    //assigning every value in front to come back.
    //Then increment counter to mve up. 
    public static void removeIndex(int[] myArray, int rIndex) {

        for (int i = rIndex; i < myArray.length - 1; i++) {
            myArray[i] = myArray[i + 1];
        }
    }

    //Copy a array passed as a parameter. 
    //Use length property to set new arrays size correclty
    public static int[] copyArray(int[] my_array) {
        int[] new_array = new int[my_array.length];
        for (int i = 0; i < my_array.length; i++) {
            new_array[i] = my_array[i];
        }
        return new_array;
    }
    
    public static ArrayList<Integer> copyListArray(ArrayList<Integer> targetArray) {
        ArrayList<Integer> new_array = new ArrayList<Integer>();
        
        for (int i = 0; i < targetArray.size(); i++) {
            new_array.set(i, targetArray.get(i)); 
        }
        return new_array;
    }
    
    //Insert element into a array
    public static int[] insertEelem(int[] my_array, int pos, int value){
        //First shift elements up one from spot you want to insert your element
     for(int i = my_array.length-1; i > pos; i--){
    
         //Assign the elem before to the one above
    my_array[i] = my_array[i-1];
    
   }
     //Now the slot you want is empty or at least a version moved to slot above. 
     //Just insert the elem you want int he desired slot without overwriting and losing the value
   my_array[pos] = value;
   System.out.println("New Array: " + Arrays.toString(my_array));
   return my_array;
 }
    
  public static int[] sortAscending(int[] intArray){
  //Sort the array in ascending order using two for loops  
  //Trick is to start counter at right beginning slots to allow comparison. 
  //Comparing two value that dynamically change by incrementing.
  //3 main steps to this method 
  
  int temp = 0;   
        for (int i = 0; i < intArray.length; i++) {     
          for (int j = i+1; j <intArray.length; j++) {     
              if(intArray[i] > intArray[j]) {      //swap elements if not in order
                 temp = intArray[i];    
                 intArray[i] = intArray[j];    
                 intArray[j] = temp;    
               }     
            }     
        } 
        
        return intArray; 
  }
  
  //sort cards in order from small to large
  //Then return the ordered array list
  public static ArrayList<Integer> sortListAsc(ArrayList<Integer> targetList){
      
  int temp = 0;   
        for (int i = 0; i < targetList.size(); i++) {     
          for (int j = i+1; j < targetList.size(); j++) {     
              if(targetList.get(i) > targetList.get(j)) {      //swap elements if not in order
                 temp = targetList.get(i);    
                 targetList.set(i, targetList.get(j));
                 targetList.set(j, temp);
               }     
            }     
        } 
      return targetList;
  }
  //Find and report duplicate values 
  //Array needs to be sorted ascending before comparison is made
  //Still need to split array because might be two 2's and three 5's. 
  
  public static ArrayList<Integer> findDuplicates(int[] my_array){
   
  ArrayList<Integer> dupes = new ArrayList<Integer>();
  
        for (int i = 0; i < my_array.length-1; i++)
        {
            for (int j = i+1; j < my_array.length; j++)
            {
                if ((my_array[i] == my_array[j]) && (i != j))
                {
                    dupes.add(my_array[j]);//Add duplicate to array list
                }
            }
        }
        //use .size() to know how many of kind the hand has. 
        //If.size() is 4 then a full book has been made. 
        //Check any .get() value to know what kind of book has been achieved. 
        return dupes;  
  }
  
  
  //Order target hand list ascending before doing comparison for equality. 
  public static ArrayList<Integer> findListDupes(ArrayList<Integer> targetHand){
      ArrayList<Integer> dupes = new ArrayList<Integer>();
      
      for (int i = 0; i < targetHand.size()-1; i++)
        {
            for (int j = i+1; j < targetHand.size(); j++)
            {
                if ((targetHand.get(i) == targetHand.get(j)) && (i != j))
                {
                    dupes.add(targetHand.get(j));//Add duplicate to array list
                }
            }
        }
      return dupes;
  }
  //find common elems between two arrays or hands of cards. 
  //2 loop design carefully setting either start point. 
  //Standard i and j counter vars
  
  public static int compareHands(int[] array1, int[] array2){
     
  for (int i = 0; i < array1.length; i++)
        {
            for (int j = 0; j < array2.length; j++)
            {
                if(array1[i] == (array2[j]))
                {
                 return array1[i];
                 }
            }
        }
  
  return -1; 
  }
    
}
