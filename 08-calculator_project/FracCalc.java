import java.util.Scanner;
public class Main{
  //FracCalc
    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args){
      Scanner user = new Scanner(System.in); //scanner class
      boolean continues = true; //varaible that stores

      System.out.println("Welcome to FracCalc!");//greetings
      while(continues == true){ //while statement
      System.out.println("Type an equation:");
      System.out.println("Or type the word quit to leave! :)");//options
      String userInput = user.nextLine(); //store usersinput
      if (userInput.equalsIgnoreCase("quit")){//whole loop until user type quit
      continues = false; //if user type quit the while loop stops
        }else{ //otherwise print out answer
        System.out.println(produceAnswer(userInput));//results
        } //end else statement
      } //end while loop
    }// end main



    //end of while loop


        // TODO:Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.


    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
  // Name: reduceFraction()
  // Purpose: to reduce the fraction
  // Input: numerator as int and denominator as int
  // Return: return the reduced fraction
    public static String produceAnswer(String input){
      int space = input.indexOf(" "); //when there is a space
      int lastIndex = input.length(); //from the last occurrence of the whole equation
      String operand1 = input.substring(0, space); //index zero until seeing a space
      String operator = input.substring(space + 1, space + 2); //starting from the end of first space and all the way until another two space is passed then stops
      String operand2 = input.substring(space + 3, lastIndex); //starting after the third space and everything after that is included
      //return operand2;
      //checkpoint 1 complete
      String numerator1 = findNumerator(operand1);//get first numerator
      String numerator2 = findNumerator(operand2);//get second numerator
      String Whole1 = findWhole(operand1); //get first whole
      String Whole2 = findWhole(operand2); //get second whole
      String denominator1 = findDenominator(operand1); //get first denominator
      String denominator2 = findDenominator(operand2); //get second denominator
      String checkPoint2 = "Whole:" + Whole1 +"/ " + Whole2 + " Numerator:" + numerator1 + "/ " + numerator2 +  " Denominator:" + denominator1 + "/ " + denominator2;
      //printin out results
      //System.out.println(Whole1, Numerator1, denominator1,Whole2,numerator2,denominator2 );
      return checkPoint2; //checkpoint 2 complete
      //All of the contains() method checks whether a string contains a sequence of characters
    } //end of produceAnswer method

    public static String findWhole(String find){
      // 4421_1/3    1234/12     5821
      if(find.contains("_")){ //if there is a "_" sign it means it is a mixed number
       return find.substring(0, find.indexOf("_"));
       //return everything from beginning until seeing “_”
    } //end if statement
      if(find.contains("/")){
       return "0";  //if it is a fraction return 0 as whole number
    } //end of if statement
      else return find;
     //if there is no fraction sign or mixed number, everything else is whole number
    }//end of findWhole method

    public static String findNumerator(String find){
      //3_5/8   233/1   42821
      if(find.contains("_")){  //if it is a mixed number
        return find.substring(find.indexOf("_") + 1,find.indexOf("/"));
        //add one because there is a space between two the operator and the sign
        //numerator is everything in front of the "_" sign
       }else if(find.contains("/")){
        return find.substring(0, find.indexOf("/")); //get everything before the "/"
        }else{
        return "0"; //if there is no fraction or mixed number return 0 as numerator
     } //end of else statement
    }//end of findNumerator method

    public static String findDenominator(String find){
      //1_7/2   3125/42   41236
      if(find.contains("/")){
        return find.substring(find.indexOf("/") + 1);//the denomator is after the "/" sign
        //add one to get rid of the "/" sign
        //get everything after the "/"
        }else{
        return "1"; //You can't have zero as an denominator!
        }//end of else statement
    }//end of findDenominator method

    public static String mixedFraction(String find){
      return "0";
    } //end mixedFraction method
  }//end class


        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".




    // TODO: Fill in the space below with helper methods

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b){
      return 0;
    }//end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b){
      return 0;
    }//end leastCommonMultiple

}//end class
