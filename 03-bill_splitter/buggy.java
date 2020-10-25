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
    double taxRate = eachTax / numPeople;


    System.out.println("What perctange of tip do you want to give!");
    userAnswer2 = input.nextInt();
    double eachTip = total * userAnswer2/100;
    double tipRate = eachTip / numPeople;

		System.out.println("Each person must pay $ "+ perPerson + ", plus tip: " + tipRate + " and plus tax: " + taxRate);
		System.out.println("Enjoy your day!");
	}//end buggy method
} // end class
