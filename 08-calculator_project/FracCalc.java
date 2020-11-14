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
      while(continues){
      System.out.println("Type an equation:");
      System.out.println("Or type the word quit to leave! :)");//options
      String userInput = user.nextLine(); //store usersinput
      //System.out.println(gcf(100, 10));
      if(userInput.equalsIgnoreCase("quit")){
        continues = false; //if user type quit the
        }else{ //otherwise print out answer
      System.out.println(produceAnswer(userInput) + "\n");//results


        } //end else statement
      } //end while loop
    }// end main

  // Name: produceAnswer()
  // Purpose: identify the operator and fractions of user inputs and retun values
  // Input: input of expression from user
  // Return: return the numerator, denominator, and whole as checkpoint2(results)

    public static String produceAnswer(String input){
      int space = input.indexOf(" ");
      int lastIndex = input.length();
      String operand1 = input.substring(0, space);
       //start at index zero until seeing a space
      String operator = input.substring(space + 1, space + 2);
      String operand2 = input.substring(space + 3, lastIndex);
      //return operand2;
      //checkpoint 1 complete
      int numerator1 = findNumerator(operand1);
      int denominator1 = findDenominator(operand1);
      int whole1 = findWhole(operand1);
      int whole2 = findWhole(operand2);
      int numerator2 = findNumerator(operand2);
      int denominator2 = findDenominator(operand2);
      //Get all the numerator,whole,and denominator
      String checkPoint2 = "Whole2:" + whole2  + " Numerator2:" + numerator2 +  " Denominator2:" +  denominator2;

      //printing out results
      //System.out.println(Whole1, Numerator1, denominator1,Whole2,numerator2,denominator2 );


      //Looking for different signs and perform different operations

        String answer = "";
        String finalAnswer = "";
      if(operator.contains("*")){
        answer = "The multiply results are: " + multiply(numerator1, numerator2,  whole1, whole2, denominator1, denominator2, improperFraction(numerator1,whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
        return answer;


      } //end of "*" if statment

      else if(operator.contains("+") && denominator1 != denominator2){
        answer = additionDifferentDenominator(numerator1,numerator2,whole1, whole2,denominator1,denominator2, improperFraction(numerator1,whole1,denominator1), improperFraction(numerator2, whole2, denominator2));
        System.out.println(answer);
        finalAnswer = Integer.toString(gcf(findNumerator(answer),findDenominator(answer)));
        //"The addition results are: "
        return finalAnswer;
      }//end of + with different denominator if statement

      else if(operator.contains("+") && denominator1 == denominator2){
        answer = "The addition results are: " + additionSameDenominator(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1),improperFraction(numerator2, whole2, denominator2));
        return answer;
      }//end of + with same denominator if statement
      else if(operator.contains("/")){
         answer = "The divison resuts are: " + division(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
         return answer;
      }//end of division method
      else if(operator.contains("-") && denominator1 == denominator2){
        answer = "The subtraction results are: " + subtractionSameDenominator(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
        return answer;
      }
      else if(operator.contains("-") && denominator1 != denominator2){
        answer = "The subtraction results are: " + subtractionDifferentDenominator(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
        return answer;
      }

        return checkPoint2;//checkpoint 2 complete

    }//end of produceAnswer method


  // All of the contains() method checks whether a string contains a sequence of characters
  // Name: findWhole()
  // Purpose: To look for whole numbers inside a fraction
  // Input: Two fractions strings from the user
  // Return: If the fractions contains whole number and return results back to produceAnswer()

   public static int findWhole(String find){
      //test cases 4421_1/3    1234/12     5821
      if(find.contains("_")){ //if there is a "_" sign it means it is a mixed number
       return Integer.parseInt(find.substring(0, find.indexOf("_")));
       //return everything from beginning until seeing “_” which are the whole numbers
    }
      if(find.contains("/")){
       return 0; //if it is a fraction return 0 as whole number
    }
      else return 0;
       //if there is no fraction sign or mixed number, everything else is whole number
    }//end of findWhole method

  // Name: findNumerator()
  // Purpose: To look for numerator inside a fraction
  // Input: A single fraction(String)
  // Return: The numerator as int

    public static int findNumerator(String find){
      //test cases 3_5/8   233/1   42821
      if(find.contains("_")){  //if it is a mixed number
        return Integer.parseInt(find.substring(find.indexOf("_") + 1,find.indexOf("/")));
        //add one because there is a space between two of the operator
       }else if(find.contains("/")){
        return Integer.parseInt(find.substring(0, find.indexOf("/")));
       }else{
        return Integer.parseInt(find); //if there is no fraction or mixed number return the whole thing back
      }
    }//end of findNumerator method

  // Name: findDenominator
  // Purpose: To look for denomator inside a fraction
  // Input: A single fraction(String)
  // Return: The denominator as int

    public static int findDenominator(String find){
      //test cases 1_7/2   3125/42   41236
      if(find.contains("/")){
      return Integer.parseInt(find.substring(find.indexOf("/") + 1));
        //the denominator is after the "/" and add one to get rid of the "/" sign
      }else{
        return 1; //You can't have zero as an denominator!
        }
    }//end of findDenominator method



  // Name:
  // Purpose:
  // Input:
  // Return:

    public static String multiply(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      int firstNumerator = 0;
      int firstDenominator = 0;
      String answer = "";
     if(whole1 == 0 && whole2 == 0){ //if there is no whole numbers
      //just multiply fraction because there is no whole number in this case
      firstNumerator = numerator1 * numerator2;
      firstDenominator = denominator1 * denominator2;
      answer = firstNumerator + "/" + firstDenominator;
    }else

      if(whole1 != 0 && whole2 != 0 ){ //most of time there are whole numbers
        //remove the whole numbers
        //you times them after in improper fraction
      firstNumerator = improperFraction1 * improperFraction2;
      //System.out.println(removeWhole1);
      firstDenominator = denominator1 * denominator2;
        //simpily multiply them
      answer = firstNumerator + "/" + firstDenominator;
    }else

      if(whole1 != 0 && whole2 == 0){ //when fraction1 has a whole numbers but fraction2 doesn't
        //You times them after in improper fraction
         firstNumerator = improperFraction1 * numerator2;
         firstDenominator = denominator1 * denominator2;
         answer = firstNumerator + "/" + firstDenominator;
      }else

        if(whole2 != 0 && whole1 == 0){
          //when fraction2 has a whole numbers but fraction1 doesn't
          //You times them after in improper fraction
         firstNumerator = improperFraction2 * numerator1;
         firstDenominator = denominator1 * denominator2;
         answer = firstNumerator + "/" + firstDenominator;
      }//end if statement
       return answer;
  }//end of multiply method

  // Name:
  // Purpose:
  // Input:
  // Return:

    public static String additionDifferentDenominator(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //if the denominator are not the same
      int firstNumerator = 0;
      int firstDenominator = 0;
      String answer = "";
      if(whole1 != 0 && whole2 != 0){//greater than zero
      //System.out.println(improperFraction2);
      //System.out.println(improperFraction1);
      firstNumerator = (improperFraction1 * denominator2) + (improperFraction2 * denominator1);
      firstDenominator = denominator1 * denominator2;
      answer = firstNumerator + "/" + firstDenominator;

    }else
      if(whole1 == 0 && whole2 == 0){ //if there is no whole numbers
     //just multiply fraction because there is no whole number in this case
       firstNumerator = (numerator1 * denominator2) + (denominator1 * numerator2);
       firstDenominator = denominator1 * denominator2;
       answer = firstNumerator + "/" + firstDenominator;

    }else
     if(whole2 != 0 && whole1 == 0){
     //when fraction2 has a whole numbers but fraction1 doesn't
       //add them after in improper fraction
        firstNumerator = (numerator1 * denominator2) + (improperFraction2 * denominator1);
        firstDenominator = denominator1 * denominator2;
        answer = firstNumerator + "/" + firstDenominator;

    }else
      if(whole1 != 0 && whole2 == 0){
      //when fraction1 has a whole numbers but fraction2 doesn't
      //add them after in improper fraction
        firstNumerator = (denominator1 * numerator2) + (denominator2 * improperFraction1);
        firstDenominator = denominator1 * denominator2;
        answer = firstNumerator + "/" + firstDenominator;
    }
        return answer;
      }//end of additionDifferentNumerator method

  // Name:
  // Purpose:
  // Input:
  // Return:

    public static String additionSameDenominator(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //if denominators are the same
        int firstNumerator;
        String answer = "";
       if(whole1 != 0 && whole2 != 0){//if whole number is greater than zero
         firstNumerator = improperFraction1 + improperFraction2;
         //add the two fraction to  get the result
          answer = firstNumerator + "/" + denominator1;

      }else
        if(whole1 == 0 && whole2 == 0){
          firstNumerator = numerator1 + numerator2;
          //add the two fraction to get the result
          answer = (firstNumerator + "/" + denominator1);

      }else
        if(whole1 != 0 && whole2 == 0){
          firstNumerator = improperFraction1 + numerator2;
          answer = (firstNumerator + "/" + denominator1);

      }else
        if(whole2 != 0 && whole1 == 0){
          firstNumerator = improperFraction2 + numerator1;
          answer = (firstNumerator + "/" + denominator1);
      }
       return answer;
    }//end additionDifferentNumerator

    public static String subtractionDifferentDenominator(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //when both fractions have a whole numbers
      int firstDenominator = 0;
      int firstNumerator = 0;
      String answer = "";
      if(whole1 != 0 && whole2 != 0){
        firstNumerator = (improperFraction1 * denominator2) - (improperFraction2 * denominator1);
        answer = (firstNumerator + "/" + firstDenominator);
    }else
      if(whole1 == 0 && whole2 == 0){
        firstNumerator = (denominator2 * numerator1) - (denominator1 * numerator2);
        firstDenominator = (denominator2 * denominator1);
        answer = (firstNumerator + "/" + firstDenominator);
    }else
      if(whole1 != 0 && whole2 == 0){
        firstNumerator = (denominator2 * improperFraction1) - (denominator1 * numerator2);
        firstDenominator = (denominator1 * denominator2);
        answer = (firstNumerator + "/" +firstDenominator);
    }else
      if(whole2 != 0 && whole1 == 0){
        firstNumerator = (numerator1 * denominator2) - (denominator1 * improperFraction2);
        firstDenominator = (denominator1 * denominator2);
        answer = (firstNumerator + "/" + firstDenominator);
    }
      return answer;
    }//end subtractionDifferentDenominator method

  public static String subtractionSameDenominator(int numerator1, int numerator2, int whole1,int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
    int firstDenominator = 0;
    int firstNumerator = 0;
    String answer = "";
    if(whole1 != 0 && whole2 < 0){
      improperFraction2 = improperFraction2 * -1;
      firstNumerator = (improperFraction1 * denominator2) + (improperFraction2 * denominator1);
      answer = (firstNumerator + "/" + firstDenominator);
  }else
    if(whole1 != 0 && whole2 == 0){
      firstNumerator = improperFraction1 - numerator2;
      answer = (firstNumerator + "/" + denominator1);
  }else
    if(whole2 != 0 && whole1 == 0){
      firstNumerator = numerator1 - improperFraction2;
      firstDenominator = denominator1 * denominator2;
      answer = (firstNumerator + "/" + firstDenominator);
  }else
    if(whole1 == 0 && whole2 == 0){
      firstNumerator = numerator1 - numerator2;
      answer = (firstNumerator + "/" + denominator1);
  }else
    if(whole1 != 0 && whole2 != 0){
      firstNumerator = (improperFraction1 * denominator2) - (improperFraction2 * denominator1);
      answer = (firstNumerator + "/" + firstDenominator);
    }
    return answer;
  }

  //end subtractionSameDenominator method
  // Name:
  // Purpose:
  // Input:
  // Return:

    public static String division(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
        //
      int firstDenominator = 0;
      int firstNumerator = 0;
      String answer = "";
      String convertMixNumber1 = "";

      if(whole1 != 0 && whole2 != 0){
         firstNumerator = improperFraction1 * denominator2;
         firstDenominator = improperFraction2 * denominator1;
        //flip them and multiply to get new numerator and denominator
         answer = (firstNumerator + "/" + firstDenominator);

    }else
      if(whole1 != 0 && whole2 == 0){
        //when only fraction 1 has a whole numbers
        firstNumerator = improperFraction1 * denominator2;
        firstDenominator = numerator2 * denominator1;
        //multiply them using the improperFraction which has no whole numbers
        answer = (firstNumerator + "/" + firstDenominator);

    }else
      if(whole2 != 0 && whole1 == 0){
        //when only fraction 2 has a whole numbers
        firstNumerator = numerator1 * denominator2;
        firstDenominator = improperFraction2 * denominator1;
        answer = (firstNumerator + "/" + firstDenominator);

    }else
      if(whole1 == 0 && whole2 == 0){
        //multiply them since there are no whole numbers
        firstNumerator = numerator1 * denominator2;
        firstDenominator = numerator2 * denominator1;
        answer = (firstNumerator + "/" + firstDenominator);
      }
      return answer;
    }//end of division method

  // Name:
  // Purpose:
  // Input:
  // Return:

   public static int improperFraction(int numerator1, int whole1, int denominator1){
      int improperFraction1 = 0;
        if(whole1 < 0){
         //if whole nunber is a negative value then numerator is negative as well
         numerator1 = numerator1 * -1;
         improperFraction1 = (denominator1 * whole1) + numerator1;
      }else
        if(whole1 > 0){
         improperFraction1 = (denominator1 * whole1) + numerator1;
        }
        return improperFraction1;
    }//end of improperFraction method

   public static String convertMixNumber(int numerator1, int whole1, int denominator1){
     whole1 = numerator1 / denominator1; //calculate the whole number in a mix number
     numerator1 = numerator1 % denominator1;  //calculate the final numerator
     String convertMixNumber1 = whole1 + "_" + numerator1 + "/" + denominator1;
     return convertMixNumber1;
   } //end of convertMixNumber method



    public static int gcf(int numerator1, int denominator1){
     if(numerator1 == 0){
       return denominator1;
     }
     //return gcf(numerator1, denominator1 % numerator1);

  }
   //System.out.printf("GCF is: ", denominator1);
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
    /*public static int greatestCommonDivisor(int a, int b){
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
