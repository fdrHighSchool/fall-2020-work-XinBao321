import java.util.*;
import java.util.Scanner;
class Frq_2009 {
  /*                       PLAN
    First ask the user for amount of times cube is gonna be toss for
    Then store the input as int, make a method call getCubeTosses
    Inside getCubeTosses make a random generator from 1-7
    return it using Arrays
    Make a new method called getLongestRun
    Make some varaibles to store index, count, and times it appeared
    Use a while loop because I use for loops many times already
    Compare the two numbers with different index to see if the number appear again
    When the number appear index could get recorded and use prints statment to check my work
    If no numbers repeat then just returned -1

  */
  public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
   int tossFor;

   System.out.println("How many times is the cube toss for");
   tossFor = input.nextInt();

   int result[] = new int[getCubeTosses(tossFor).length];
   result = getCubeTosses(tossFor);

   System.out.println("The results are: " + Arrays.toString(result));
   System.out.println("The longest run is: " + getLongestRun(result));
}//end main
   public static int [] getCubeTosses(int tossFor){
     int array [] = new int [tossFor];
     Random randomNumber = new Random();
     int i = 0;

     while(tossFor > i){
      int getCoins = randomNumber.nextInt(7);
      array[i] = getCoins;
     while(getCoins == 0){
      getCoins = randomNumber.nextInt(7);
      array[i] = getCoins;
     }//end while loop
     i++;
     System.out.println("The number is: " + getCoins);
     }//end while loop
     return array;
   }//end getCubeTosses method

   public static int getLongestRun(int [] array){
     int count = 0;
     int index = 0;
     int appearMost = 0;
     int i = 0;
     while(i < array.length - 1){

        if(array[i] == array[i + 1]){
          count++;
          System.out.println("Count now is:" + count);

        if(count > appearMost){
          appearMost = count;
          index = i;
          System.out.println("Index now is:" + index);

         }
        }
        i++;
      }
      if(count == 0){
          return -1;
        }
      return array[index];
   }//end getLongestRun method
}//end class
