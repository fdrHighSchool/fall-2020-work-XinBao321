
package temperature;
import java.util.Scanner;

  public class temperature{
    public static void main(String[] args) {
      float celsius, fahrenheit;
      double cel;



       System.out.println("\n");
       Scanner answer = new Scanner(System.in);
       System.out.println("Input a degree in Fahrenheit: ");
       fahrenheit = answer.nextFloat();
       celsius = ((fahrenheit-32)*5)/9;
       System.out.println( " Degree Fahrenheit is equal to " + celsius +  " in Celsius");
       System.out.println("Input a degree in Celsius: ");
       celsius = answer.nextFloat();
       fahrenheit = celsius * 9/5 + 32;
       System.out.println(" Degree Celsius is equal to " + fahrenheit + " in Fahrenheit");


    } // end main
  } // end class
