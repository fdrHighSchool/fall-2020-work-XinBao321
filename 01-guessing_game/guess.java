import java.util.Scanner;
import java.util.Random;
import java.lang.Math; // import the Scanner class
class Main{
  public static void main(String[] args) {

    //Initial Number Variables
    String name;
    int guess, highest, lowest , range;
    int attempt = 0;



    Scanner in = new Scanner(System.in);

    // asking questions

        System.out.println("What is your name?");
        name = in.nextLine();
        System.out.println("Hello," + name + " Let's play a guessing game");
        System.out.println("Choose your Lowest");
        lowest = in.nextInt();
        System.out.println("Choose your Highest");
        highest = in.nextInt();
        range = (highest - lowest + 1);
        System.out.println("Guess the number from " + lowest +  " to "   + highest);
        guess = in.nextInt();
        int answer = (int) (Math.random() * range) + lowest;





   //Number generation and loop
    while (guess != answer){

      if (answer < guess) {
          System.out.println("The answer is smaller than "   + guess +   " Try again");
          guess = in.nextInt();

      } //end of if loop

       if (answer > guess) {
          System.out.println("The answer is bigger than "  + guess +   " Try again");
          guess = in.nextInt();
          attempt++;
       } //end of if loop
    } // end of while loop
      if (guess == answer){
      System.out.println("That's Correct  it took you " + attempt +   " more  attempts  to get it right!" );
    } // end of if loop
  } //main method
}  // end class
