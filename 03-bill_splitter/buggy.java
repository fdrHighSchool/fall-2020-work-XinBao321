import java.util.Scanner;
public class buggy{
	public static void main(String[] args){
    int numPeople = 0;
    int userAnswer;
    int userAnswer2;

		Scanner input = new Scanner(System.in); // scanner
		System.out.println("Welcome to the Bill-Splitter!");
		System.out.print( "Enter the total, pre-tax: ");
		double total = input.nextDouble();
		System.out.print("How many people? ");
		numPeople = input.nextInt();
		double perPerson = total / numPeople;
    System.out.println("What perctange of tax do you want to give!");
    userAnswer = input.nextInt();
    double eachTax = total * userAnswer/100;
    double eachTax1 = eachTax / numPeople;


     System.out.println("What perctange of tip do you want to give!");
     userAnswer2 = input.nextInt();
     double eachTip = total * userAnswer2/100;
     double eachTip2 = eachTip / numPeople;

		System.out.println("Each person must pay $ "+ perPerson + ", plus tip: " + eachTip2 + " and plus tax: " + eachTax1);
		System.out.println("Enjoy your day!");
	}//end buggy method
} // end class
