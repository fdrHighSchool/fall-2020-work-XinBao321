import java.util.Scanner;
public class Person{
  // instances variables
  Scanner scan = new Scanner(System.in);
  private String favoriteFood;
  private String age;
  private String height;
  private String name;
  private String favoriteSport;

  public Person( String n, String a, String h, String f, String fSport){
    this.name = n;
    this.age = a;
    this.height = h;
    this.favoriteFood = f;
    this.favoriteSport = fSport;
  } //end constructor

  public String getName(String name){

    this.name = name;
    System.out.println("Enter your name here: ");
    String names = scan.nextLine();
    return names;
  } //end of getName method

  public String getHeight(){

    System.out.println("\nThe progrom can help you check in height either in inches or cm :) ");
    System.out.println("Type 1 if you want inches to cm, type 2 if you want cm to inches! ");
    int choices = scan.nextInt();
    if(choices == 1){
      System.out.println("Please enter your height in inches: ");
      double inches = scan.nextDouble();

      double height = inches * 2.54;
      System.out.println("Your height is: " + height + " inches");
    } //end if statement
    if(choices == 2){
      System.out.println("Please enter your height in cm: ");
      double cm = scan.nextDouble();

      double height = cm / 2.54;
      System.out.println("Your height is: " + height + " cm");
    } //end if statement
      System.out.println("");
     return height;
  } //end getHeight method

  public String getAge(){

    System.out.println("It's time to caclulate your age! ");
    System.out.println("Enter the year that you were born: ");
    int bornYear = scan.nextInt();

    System.out.println("Enter the year right now: \n");
    int yearRightNow = scan.nextInt();
    int answer = yearRightNow - bornYear;

    System.out.println("Your age is: " + answer + " years old :D");
    return "";
  } //end getAge method

  public String getFavoriteFood(){
    System.out.println("Choose your favorite from this list of famous food: ");
    System.out.println("1. Pizza");
    System.out.println("2. Sushi");
    System.out.println("3. Fried Chicken");
    System.out.println("4. Pasta");
    System.out.println("5. Eggs");
    System.out.println("6. Ice Cream");
    System.out.println("7. Cereal");
    System.out.println("8. Taco Bell");
    System.out.println("9. Rice");
    System.out.println("10. Noodles");
    System.out.println("11. Salmon");
    System.out.println("");

    int choices = scan.nextInt();
    if(choices <= 12){
      System.out.println("Thanks for sharing! , choices: " + choices + " is a great option :)");
    }
    return "";
  } // end getFavoriteFood methods

  public String getFavoriteSport(){
    return "";
  } // end getFavoriteSport method

  public String toString() {
    return "Person: " + this.name + " Age: " + this.age + " Height: " + this.height + " FavoriteFood: " + this.favoriteFood + " FavoriteSport: " + this.favoriteSport;
  } // end toString method
} //end class
