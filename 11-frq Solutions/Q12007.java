import java.util.Scanner;
import java.util.*;

public class Q12007{
  public static void main(String[] args) {


    //PLAN
    //Ask the user for input make sure it is postive, store the input
    //Make a boolean
    //Make a for loop that runs until all the numbers are divided
    //Make sure that it is even divided, zero is a tricky case
    //If it doesn't divide evenly then return false for boolean
    //A new method firstNumSelfDivisors that could somehow continue to see if it a selfDivsor
    //Use the selfDivsor method to see and not sure how to continue yet...

    int numbers;
    int userTimes;
    int start;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your numbers");
    numbers = input.nextInt();
    System.out.println("How many times is firstNumSelfDivisors gonna run for");
    userTimes = input.nextInt();
    System.out.println(numbers + " Is: " + selfDivsor(numbers));
    System.out.println("firstNumSelfDivisors is : " + Arrays.toString(firstNumSelfDivisors(numbers,userTimes)));
    //Arrays.toString
  } //end main






public static boolean selfDivsor(int numbers){
int answer;
 while(numbers >= 1){
   answer = numbers % 10;
   if(numbers % answer != 0 || answer == 0){
      return false;
   }else{
     numbers /= 10;
   }
 }
   return true;
}//end selfDivsor



public static int [] firstNumSelfDivisors(int numbers, int userTimes){
   int array [] = new int[numbers];
   int index;
   int answer;
   for(int i = 0; array.length > i; i++ ){

      if(selfDivsor(numbers) == true){
        array[i] = numbers;
        numbers++;
        i++;
      }

    }

      return array;
 }//end firstNumSelfDivisors method

}
