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
  // Name: produceAnswer()
  // Purpose: identify the operator and fractions of user inputs and printing out the results
  // Input: input of expression from user
  // Return: return the numerator, denominator, and whole as checkpoint2(results)
    public static String produceAnswer(String input){
      int space = input.indexOf(" "); //when there is a space
      int lastIndex = input.length(); //from the last occurrence of the whole equation
      String operand1 = input.substring(0, space); //index zero until seeing a space
      String operator = input.substring(space + 1, space + 2); //starting from the end of first space and all the way until another two space is passed then stops
      String operand2 = input.substring(space + 3, lastIndex); //starting after the third space and everything after that is included
      //return operand2;
      //checkpoint 1 complete
      int numerator1 = findNumerator(operand1);//get first numerator
      int denominator1 = findDenominator(operand1);;//get first denominator
      int Whole1 = findWhole(operand1); //get first whole
      int Whole2 = findWhole(operand2); //get second whole
      int numerator2 = findNumerator(operand2);//get second numerator
      int denominator2 = findDenominator(operand2);//get second denominator
      String checkPoint2 = "Whole:" + Whole2  + " Numerator:" + numerator2 +  " Denominator:" +  denominator2;
      //printin out results
      //System.out.println(Whole1, Numerator1, denominator1,Whole2,numerator2,denominator2 );

      //Looking for operations
      if(operator.contains("*")){
        System.out.println("The multiply results are: " + multiply(numerator1, numerator2,  Whole1,  Whole2,  denominator1, denominator2, improperFraction(numerator1,Whole1, denominator1), improperFraction(numerator2, Whole2, denominator2)));
      } //end of "*" if statment

      else if(operator.contains("+") && denominator1 != denominator2){
      System.out.println("The addition results are: " + additionDifferentNumerator(numerator1,numerator2,Whole1, Whole2,denominator1,denominator2, improperFraction(numerator1,Whole1,denominator1), improperFraction(numerator2, Whole2, denominator2)));
      }//end of + if statement

      else if(operator.contains("+") && denominator1 == denominator2){
        System.out.println("The addition results are: " + additionSameNumerator(numerator1, numerator2, Whole1, Whole2, denominator1, denominator2, improperFraction(numerator1, Whole1, denominator1), improperFraction(numerator2, Whole2, denominator2)));

      }//end of + if statement
      else return "0";
      return checkPoint2;//checkpoint 2 complete
    }//end of produceAnswer method

  // All of the contains() method checks whether a string contains a sequence of characters
  // Name: findWhole()
  // Purpose: To look for whole numbers inside a fraction
  // Input: Two fractions strings from the user
  // Return: If the fractions contains whole number and return results back to produceAnswer()
   public static int findWhole(String find){
      // 4421_1/3    1234/12     5821
      if(find.contains("_")){ //if there is a "_" sign it means it is a mixed number
        return Integer.parseInt(find.substring(0, find.indexOf("_")));
       //return everything from beginning until seeing “_”
    } //end if statement
      if(find.contains("/")){
       return 0;  //if it is a fraction return 0 as whole number
    } //end if statement
      else return Integer.parseInt(find);
     //if there is no fraction sign or mixed number, everything else is whole number
    }//end of findWhole method

  // Name: findNumerator()
  // Purpose: To look for numerator inside a fraction
  // Input: Two fractions strings from the user
  // Return: If the fractions contains numerator and return results back to produceAnswer()
    public static int findNumerator(String find){
      //3_5/8   233/1   42821
      if(find.contains("_")){  //if it is a mixed number
        return Integer.parseInt(find.substring(find.indexOf("_") + 1,find.indexOf("/")));
        //add one because there is a space between two the operator and the sign
        //numerator is everything in front of the "_" sign
       }else if(find.contains("/")){
        return Integer.parseInt(find.substring(0, find.indexOf("/"))); //get everything before the "/"
        }else{
        return 0; //if there is no fraction or mixed number return 0 as numerator
     } //end of else statement
    }//end of findNumerator method

  // Name: findDenominator
  // Purpose: To look for denomator inside a fraction
  // Input: Two fractions strings from the user
  // Return: If the fractions contains denominator and return results back to produceAnswer()
    public static int findDenominator(String find){
      //1_7/2   3125/42   41236
      if(find.contains("/")){
      return Integer.parseInt(find.substring(find.indexOf("/") + 1));//the denomator is after the "/"
        //add one to get rid of the "/" sign
        //get everything after the "/"
        }else{
        return 1; //You can't have zero as an denominator!
        }//end of else statement
    }//end of findDenominator method

  // Name:
  // Purpose:
  // Input:
  // Return:
    public static String multiply(int numerator1, int numerator2, int Whole1, int Whole2, int denominator1, int denominator2, int removeWhole1, int removeWhole2){
      //multiply the two fractions
     if(Whole1 == 0 && Whole2 == 0){ //if there is no whole numbers
     //just multiply fraction because there is no whole number in this case
      int firstNumerator = numerator1 * numerator2;
      int firstDenominator = denominator1 * denominator2;
      String answer = firstNumerator + "/" + firstDenominator;
      return answer;
    }else
        if(Whole1 > 0 && Whole2 > 0){ //most of time there are whole numbers
        //remove the whole numbers
        //You times them after in improper fraction
        int finalNumerator1 = removeWhole1 * removeWhole2;
        int finalDenominator = denominator1 * denominator2;//simpily multiply them
        String answer = finalNumerator1 + "/" + finalDenominator;
        return answer;
    }else
        if(Whole1 > 0 && Whole2 == 0){ //when fraction1 has a whole numbers but fraction2 doesn't
        //You times them after in improper fraction
        int answerNumerator1 = removeWhole1 * numerator1;
        int answerDenominator = denominator1 * denominator2;
        String answer = answerNumerator1 + "/" + answerDenominator;
        return answer;
      }else
        if(Whole2 > 0 && Whole1 == 0){
        //when fraction2 has a whole numbers but fraction1 doesn't
        //You times them after in improper fraction
        int answerNumerator2 = removeWhole2 * numerator2;
        int answerDenominator = denominator1 * denominator2;
        String answer = answerNumerator2 + "/" + answerDenominator;
        return answer;
    }//end if statement
      else return "0";
  }//end of multiply method

    public static String additionDifferentNumerator(int numerator1, int numerator2, int Whole1, int Whole2, int denominator1, int denominator2, int removeWhole1, int removeWhole2){
      //if the denominator are not the same
      if(Whole1 > 0 && Whole2 > 0){//greater than zero
      //System.out.println(removeWhole1);
      //System.out.println(removeWhole2);
      int firstNumerator = (removeWhole1 * denominator2) + (removeWhole2 * denominator1); //removeWhole2 is the improperFraction of fraction2
      int firstDenominator = denominator1 * denominator2;
      String answer = firstNumerator + "/" + firstDenominator;
      return answer;
    }else
      if(Whole1 == 0 && Whole2 == 0){ //if there is no whole numbers
      //just multiply fraction because there is no whole number in this case
      int firstNumerator = (numerator1 * denominator2) + (denominator2 * numerator2);
      int firstDenominator = denominator1 * denominator2;
      String answer = firstNumerator + "/" + firstDenominator;
      return answer;
    }else
     if(Whole2 > 0 && Whole1 == 0){
     //when fraction2 has a whole numbers but fraction1 doesn't
     //add them after in improper fraction
       int firstNumerator = (numerator1 * denominator2) + (removeWhole2 * denominator1); //removeWhole2 is the improperFraction of fraction2
       int firstDenominator = denominator1 * denominator2;
       String answer = firstNumerator + "/" + firstDenominator;
       return answer;
    }else
      if(Whole1 > 0 && Whole2 == 0){
      //when fraction1 has a whole numbers but fraction2 doesn't
      //add them after in improper fraction
       int firstNumerator1 = (denominator1 * numerator2) + (denominator2 * removeWhole1); //removeWhole1 is the improperFraction of fraction1
       int firstDenominator = denominator1 * denominator2;
       String answer = firstNumerator1 + "/" + firstDenominator;
       return answer;
      }else
        return "0";
      }//end of additionDifferentNumerator method


   public static String additionSameNumerator(int numerator1, int numerator2, int Whole1, int Whole2, int denominator1, int denominator2, int removeWhole1, int removeWhole2){
      //if denominators are the same
       if(Whole1 > 0 && Whole2 > 0){//if whole number is greater than zero
        int firstNumerator = removeWhole1 + removeWhole2; //removeWhole1 is the improperFraction of fraction1
        //add the two fraction to  get the result
          String answer = firstNumerator + "/" + denominator1;
          return answer;
      }else
        if(Whole1 == 0 && Whole2 == 0){
        int firstNumerator = numerator1 + numerator2; //when there is no whole numbers add the two numerator to get final numerator
        //add the two fraction to get the result
          String answer = (firstNumerator + "/" + denominator1); //results
          return answer;
      }else
        if(Whole1 > 0 && Whole2 == 0){
         int firstNumerator = removeWhole1 + numerator2; //removeWhole1 is the improperFraction of fraction1
          String answer = (firstNumerator + "/" + denominator1);
          return answer;
      }else
        if(Whole2 > 0 && Whole1 == 0){
         int firstNumerator = removeWhole2 + numerator1; //removeWhole2 is the improperFraction of fraction2
          String answer = (firstNumerator + "/" + denominator1);
          return answer;
      }
       return "0";
    }//end additionDifferentNumerator





   public static int improperFraction(int numerator1, int Whole1, int denominator1){
        int removeWhole1 = (denominator1 * Whole1) + numerator1;
        return removeWhole1;



    }//end of improperFraction method
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
