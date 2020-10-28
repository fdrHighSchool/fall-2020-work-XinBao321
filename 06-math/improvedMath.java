import java.util.Scanner;
import java.lang.*;

public class Main{
public static void main(String[] args) {
    //get two points from the user (x, y)
    //ex: (3, 5)...stored as a String
    Scanner s = new Scanner(System.in);

    System.out.print("Enter point 1: ");
    String point1 = s.nextLine();

    System.out.print("Enter point 2: ");
    String point2 = s.nextLine();


    //System.out.printf("The distance between %s and %s is...\n", point1, point2);
    //parse, meaning, get ints from String, the information from the inputs
    //(3, 4) --> x1 = 3, y1 = 4

    int x1 = getX(point1);
    int x2 = getX(point2);
    int y  = getY(point1);
    int y2 = getY(point2);

   /* System.out.println(x1);
    System.out.println(x2);
    System.out.println(y);
    System.out.println(y2);
    test cases
    */


    //send data to methods to calculate distance

    System.out.println("\nDistance using euclidean formula is:  " + euclideanDistance(x1,y,x2,y2));
    System.out.println("\nThe distance for taxicab formula is: " + taxiCab(x1,x2,y,y2));

    /*
    TEST CASES:
    (0, 0) & (3, 4) --> euclideanDistance = 5, taxicabDistance = 7
    (0, 0) & (5, 12) --> euclideanDistance = 13, taxicabDistance = 17
    Do negative coordinates work? If not, how would you go about fixing that?
    */

  }//end main

public static int getX(String point){
    //locate the comma
    int comma = point.indexOf(",");
    //we know the x-value in the String starts at index 1
    //we now know where the comma is
    //so, the x-value is from index 1 to the location of the comma
    String x = point.substring(1, comma);
    return Integer.parseInt(x);
  }//end getX method

public static int getY(String point){

    int closing = point.indexOf(")");
    int comma = point.indexOf(",");
    String y = point.substring((comma + 2 ), closing);
    return Integer.parseInt(y);
  }//end getY method

 /*  wut happened
   * N: euclideanDistance
   * P: determine the distance between any two points on x/y axis (diagonal)
   * I: pass in x1, y1, x2, y2
   * R: the result of the distance formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
   *
  */
public static double euclideanDistance(int x1, int y, int x2, int y2){
    double distance = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y), 2));
    return distance;
  }//end cartesianDistance method

  /*
   * N: taxicabDistance
   * P: determine distance between any two points on graph
   * I: pass in x1, y1, x2, y2
   * R: the result of the taxiCab formula：|x2-x1| + |y2-y1|
   */
    //taxiCab formula：|x2-x1| + |y2-y1|
public static double taxiCab(int x1, int x2, int y, int y2){
    double distance1 = Math.abs(x2-x1) + Math.abs(y2-y);
    return distance1;
  } // end taxicab method
}//end class
