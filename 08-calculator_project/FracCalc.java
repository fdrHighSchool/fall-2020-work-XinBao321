import java.util.Scanner;
public class FracCalc{

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
        continues = false; //if user type quit the while loops stops
    }else{
      //otherwise print out answer
      System.out.println("The answer is: " + produceAnswer(userInput) + "\n");//results


        } //end else statement
      } //end while loop
    }// end main

  // Name: produceAnswer()
  // Purpose: identify the operator and fractions of user inputs and retun values
  // Input: input of expression from user
  // Return: the answer and checkpoint2(results)

    public static String produceAnswer(String input){
      boolean continues = true;
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
      //System.out.println(Whole1, Numerator1, denominator1,Whole2,numerator2,denominator2 );

      String inCorrect;
      if(operator.equals("/") && operand2.equals("0")){
        //Error statmement about can't divide zero
        inCorrect = "ERROR:Cannot divide by zero,please try again!";
        return inCorrect;
      }
        //This doesn't work :(
        if(operator.length() > 1){
        inCorrect = "ERROR: Input is in an invalid format";
        return inCorrect;
      }



      //Looking for different signs and perform different operations
        String answer = "";
        String finalAnswer = "";
      if(operator.contains("*")){
        answer =  multiply(numerator1, numerator2,  whole1, whole2, denominator1, denominator2, improperFraction(numerator1,whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
        //use the results from these method and reducingFractions method could make them as the final answer
        finalAnswer = reducingFractions(answer);
        return finalAnswer;

      } //end of "*" if statment

      else if(operator.contains("+") && denominator1 != denominator2){
        answer = additionDifferentDenominator(numerator1,numerator2,whole1, whole2,denominator1,denominator2, improperFraction(numerator1,whole1,denominator1), improperFraction(numerator2, whole2, denominator2));
        finalAnswer = reducingFractions(answer);
        return finalAnswer;

      }//end of + with different denominator if statement

      else if(operator.contains("+") && denominator1 == denominator2){
        answer = additionSameDenominator(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1),improperFraction(numerator2, whole2, denominator2));
        finalAnswer = reducingFractions(answer);
        return finalAnswer;

      }//end of if statement + with same denominator
      else if(operator.contains("/")){
         answer = division(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
         finalAnswer = reducingFractions(answer);
         return finalAnswer;

      }//end of division method
      else if(operator.contains("-") && denominator1 == denominator2){
        answer = subtractionSameDenominator(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
        finalAnswer = reducingFractions(answer);
        return finalAnswer;

      }//end of if statement - with same denominator
      else if(operator.contains("-") && denominator1 != denominator2){
        answer = subtractionDifferentDenominator(numerator1,numerator2, whole1, whole2, denominator1, denominator2, improperFraction(numerator1, whole1, denominator1), improperFraction(numerator2, whole2, denominator2));
        finalAnswer = reducingFractions(answer);
        return finalAnswer;
      }//end of if statement - with different denominator

        return checkPoint2;//checkpoint 2 complete

    }//end of produceAnswer method

  // All of the contains() method checks whether a string contains a sequence of characters


  // Name: findWhole()
  // Purpose: To look for whole numbers inside a fraction
  // Input: A single fraction(String)
  // Return: The whole numbers as int

   public static int findWhole(String find){
      //test cases 4421_1/3    1234/12     5821
      if(find.contains("_")){
      //if there is a "_" sign it means it is a mixed number
       return Integer.parseInt(find.substring(0, find.indexOf("_")));
       //return everything from beginning until seeing "_" which are the whole numbers
    }
      while(find.contains("/")){
       return 0;
    //if it is a fraction return 0 as whole number
    }
    //return 0 because the input doesn't have a whole number
      return 0;
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
        return Integer.parseInt(find);
        //if there is no fraction or mixed number return the whole thing back
       }
    }//end of findNumerator method

  // Name: findDenominator()
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



  // Name: multiply()
  // Purpose: To mutiply the numerator and the denominator
  // Input: Ints like(numerator,denominator,improperFraction, and whole)
  // Return: The answer as strings but isn't reduce yet

    public static String multiply(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //Variables to store new results
      int firstNumerator = 0;
      int firstDenominator = 0;
      String answer = "";
     if(whole1 == 0 && whole2 == 0){
      //if there is no whole numbers
      //just multiply fraction because there is no whole number in this case
      firstNumerator = numerator1 * numerator2;
      firstDenominator = denominator1 * denominator2;
      answer = firstNumerator + "/" + firstDenominator;
    }else

      if(whole1 != 0 && whole2 != 0 ){
      //remove the whole numbers
      //you times them after in improper fraction
      firstNumerator = improperFraction1 * improperFraction2;
      firstDenominator = denominator1 * denominator2;
      //simpily multiply the denominator
      answer = firstNumerator + "/" + firstDenominator;
    }else

      if(whole1 != 0 && whole2 == 0){
        //when fraction1 has a whole numbers but fraction2 doesn't
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

  // Name: additionDifferentDenominator()
  // Purpose: Add fractions when they have different denominator
  // Input: Ints like(numerator,denominator,improperFraction, and whole)
  // Return: The answer as strings but isn't reduce yet

    public static String additionDifferentDenominator(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //Variables to store new results
      //if the denominator are not the same
      int firstNumerator = 0;
      int firstDenominator = 0;
      String answer = "";
      if(whole1 != 0 && whole2 != 0){
      //if both fraction has a whole number
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

  // Name: additionSameDenominator()
  // Purpose: Add fractions when they have same denominator
  // Input:  Ints like(numerator,denominator,improperFraction, and whole)
  // Return: The answer as strings but isn't reduce yet

    public static String additionSameDenominator(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //Variables to store new results
      //if denominators are the same
        int firstNumerator;
        String answer = "";
       if(whole1 != 0 && whole2 != 0){
         //if both fractions has a whole number
         firstNumerator = improperFraction1 + improperFraction2;
         //when the denominator are the same you can just keep the denominator
          answer = firstNumerator + "/" + denominator1;

      }else
        if(whole1 == 0 && whole2 == 0){
           //when they are no whole numbers just add the numerators
          firstNumerator = numerator1 + numerator2;
          answer = (firstNumerator + "/" + denominator1);
          //when the denominator are the same you can just keep the denominator
      }else
        //when fraction 1 has a whole number but fraction2 doesn't
        if(whole1 != 0 && whole2 == 0){
          firstNumerator = improperFraction1 + numerator2;
          answer = (firstNumerator + "/" + denominator1);

      }else
       //when fraction 2 has a whole number but fraction1 doesn't
        if(whole2 != 0 && whole1 == 0){
          firstNumerator = improperFraction2 + numerator1;
          answer = (firstNumerator + "/" + denominator1);
      }
       return answer;
    }//end additionDifferentNumerator

  // Name: subtractionDifferentDenominator
  // Purpose: Subtract fractions when they have different denominator
  // Input: Ints like(numerator,denominator,improperFraction, and whole)
  // Return: The answer as strings but isn't reduce yet

    public static String subtractionDifferentDenominator(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //Variables to store new results
      int firstDenominator = 0;
      int firstNumerator = 0;
      String answer = "";
      if(whole1 != 0 && whole2 != 0){
        //when both fractions have a whole numbers
        firstNumerator = (improperFraction1 * denominator2) - (improperFraction2 * denominator1);
        //multiply the denominator to get new denominator
        firstDenominator = (denominator1 * denominator2);
        answer = (firstNumerator + "/" + firstDenominator);
    }else
      if(whole1 == 0 && whole2 == 0){
        //when there are no whole numbers
        firstNumerator = (denominator2 * numerator1) - (denominator1 * numerator2);
        firstDenominator = (denominator2 * denominator1);
        answer = (firstNumerator + "/" + firstDenominator);
    }else
       //when fraction 1 has a whole number fraction 2 doesn't
      if(whole1 != 0 && whole2 == 0){
        firstNumerator = (denominator2 * improperFraction1) - (denominator1 * numerator2);
        firstDenominator = (denominator1 * denominator2);
        answer = (firstNumerator + "/" +firstDenominator);
    }else
       //when fraction 2 has a whole number fraction 1 doesn't
      if(whole2 != 0 && whole1 == 0){
        firstNumerator = (numerator1 * denominator2) - (denominator1 * improperFraction2);
        firstDenominator = (denominator1 * denominator2);
        answer = (firstNumerator + "/" + firstDenominator);
    }
      return answer;
    }//end subtractionDifferentDenominator method

  // Name: subtractionSameDenominator
  // Purpose: Subtract fractions when they have same denominator
  // Input: Ints like(numerator,denominator,improperFraction, and whole)
  // Return: The answer as strings but isn't reduce yet

    public static String subtractionSameDenominator(int numerator1, int numerator2, int whole1,int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
    //Variables to store new results
    int firstDenominator = 0;
    int firstNumerator = 0;
    String answer = "";
    if(whole1 != 0 && whole2 != 0){
      firstNumerator = improperFraction1 - improperFraction2;
      //when the denominator are the same you can just keep the denominator
      answer = (firstNumerator + "/" + denominator1);
  }else
    if(whole1 != 0 && whole2 == 0){
      //when fraction 1 has a whole number fraction 2 doesn't
      firstNumerator = improperFraction1 - numerator2;
      //System.out.println(improperFraction1);
      answer = (firstNumerator + "/" + denominator1);
  }else
    if(whole2 != 0 && whole1 == 0){
      //when fraction 2 has a whole number fraction 1 doesn't
      firstNumerator = numerator1 - improperFraction2;

      answer = (firstNumerator + "/" + denominator1);
  }else
    if(whole1 == 0 && whole2 == 0){
      //when both fraction doesn't have whole numbers
      firstNumerator = numerator1 - numerator2;
      answer = (firstNumerator + "/" + denominator1);
  }
      return answer;
  }//end subtractionSameDenominator method


  // Name: division()
  // Purpose: Divide fractions using numerator and denominator
  // Input: Ints like(numerator,denominator,improperFraction, and whole)
  // Return: The answer as strings but isn't reduce yet

    public static String division(int numerator1, int numerator2, int whole1, int whole2, int denominator1, int denominator2, int improperFraction1, int improperFraction2){
      //Variables to store new results
      int firstDenominator = 0;
      int firstNumerator = 0;
      String answer = "";
      String convertMixNumber1 = "";

      if(whole1 != 0 && whole2 != 0){
        //when both fractions have a whole number
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

  // Name: improperFraction
  // Purpose: To change from mixed number to improperFraction
  // Input: Ints like(numerator,denominator, and whole)
  // Return: The answer as strings but isn't reduce yet

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

  // Name: gcf()
  // Purpose: To find the gcf of the fractions
  // Input: Ints like(numerator,denominator, and whole)
  // Return: The greatestcommon number between these two fractions

    public static int gcf(int numerator1, int denominator1){
      //gcf must be at least 1
      //gcf should be smaller than the numerator and the denominator
      int potentialGCF = 2;
      int greatestNumber = 0;
      int gcf = 1;
      //check the absolute value of numerator and denominator to see which one is bigger
      if(Math.abs(numerator1) > Math.abs(denominator1)){
        greatestNumber = Math.abs(numerator1);
      }else
       if(Math.abs(numerator1) < Math.abs(denominator1)){
        greatestNumber = Math.abs(denominator1);
      }//end if method for comparing numerator and denominator

      while(potentialGCF < greatestNumber){
      //when numerator has a remainder of 0 that means it might be the gcf
        if(numerator1 % potentialGCF == 0 && denominator1 % potentialGCF  == 0){
          gcf = potentialGCF;
      }//end if statment
        potentialGCF++;
      }//end while statement
      return gcf;
    }//end of gcf method


  // Name: reducingFractions
  // Purpose: Reduce the two fractions by using the gcf
  // Input: Ints like(numerator,denominator, and whole) and strings
  // Return: The answer reduce and as mixed number

    public static String reducingFractions(String answer){
      /* Debugging codes
        System.out.println(answer);
        System.out.println(findNumerator(answer));
        System.out.println(findDenominator(answer));
        System.out.println(denominator1);
      */
      //strings that could be useful
      String fractionRemainder = "";
      String finalAnswer = "";
      int remainder = 0;
      //get the gcf of the two numbers
      int numerator1 =  findNumerator(answer) / gcf(findNumerator(answer),findDenominator(answer));
      int denominator1 =  findDenominator(answer) / gcf(findNumerator(answer), findDenominator(answer));
      //System.out.println(gcf(findNumerator(answer),findDenominator(answer)));
      int wholeNumber = numerator1;
      //negative number cases
      if(Integer.toString(numerator1).contains("-") && Integer.toString(denominator1).contains("-")){
       //two negative sign = postive number
       numerator1 = Math.abs(numerator1);
       denominator1 = Math.abs(denominator1);
       }//end of if statement to see if denominator or numerator is bigger

      if(Math.abs(numerator1) > Math.abs(denominator1)){
        remainder = numerator1 % denominator1;
        wholeNumber = numerator1 / denominator1;
        //when remaider isn't zero it means that it can still be reduce
      if(remainder != 0){
          //when both numerator and whole number is negative it will be postive
      if(Integer.toString(remainder).contains("-") && Integer.toString(wholeNumber).contains("-")){
         fractionRemainder = Integer.toString(remainder).replace("-","");
         remainder = Integer.parseInt(fractionRemainder);
       }//end of if statement about checking whole is negative or not
         finalAnswer = (wholeNumber + "_" + remainder + "/" + denominator1);
         return finalAnswer;
       }//end of if statmenet about numerator greater than denominator

      if(denominator1 == 1){
        return Integer.toString(wholeNumber);
      }//end of if statment when denominator shouldn't be print out
     }//end of aboslue value if numerator or denominator or the same
        finalAnswer = (numerator1 + "/" + denominator1);
      //if there are no whole numbers just return fraction instead of mixed number
        return finalAnswer;
    }//end of reducing method
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
