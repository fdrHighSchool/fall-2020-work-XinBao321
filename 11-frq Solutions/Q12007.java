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


    int numbers;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your numbers");
    numbers = input.nextInt();
    System.out.println(numbers + " Is: " + selfDivsor(numbers));
  }






public static boolean selfDivsor(int numbers){
  boolean selfDivsor;
  while(numbers > 0){
    int answer;
    answer = numbers % 10;
    if(answer == 0 || answer != 0)
    return false;
    answer = answer / 10;
  }
    return true;
}//end selfDivsor

}//end class
