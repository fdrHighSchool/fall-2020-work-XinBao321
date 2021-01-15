import java.util.Scanner;
public class Person{
  // instances variables
  Scanner scan = new Scanner(System.in);
  private String favoriteFood;
  private int age;
  private String height;
  private String name;
  private String favoriteSport;

  public Person( String n, int a, String h, String f, String fSport){
    this.name = n;
    this.age = a;
    this.height = h;
    this.favoriteFood = f;
    this.favoriteSport = fSport;
  } //end constructor
  public void setName(String n){
    this.name = n;
  } //end setName method

  public String getName(String n){
    System.out.println("Enter your name here: ");
    n = scan.nextLine();
    return  n;
  } //end of getName method

  public String getHeight(){

    System.out.println("\nThe progrom can help you check in height either in inches or cm :) ");
    System.out.println("Type 1 if you want inches to cm, type 2 if you want cm to inches! ");
    int choices = scan.nextInt();
    if(choices == 1){
      System.out.println("Please enter your height in inches: ");
      double inches = scan.nextDouble();

      double height = inches * 2.54;
      System.out.println("Your height is: " + height + " cm");

    } //end if statement
    if(choices == 2){
      System.out.println("Please enter your height in cm: ");
      double cm = scan.nextDouble();

      double height = cm / 2.54;
      System.out.println("Your height is: " + height + " inches");

    } //end if statement
      System.out.println("");
      return height;
  } //end getHeight method

  public int getAge(){

    System.out.println("It's time to caclulate your age! ");
    System.out.println("Enter the year that you were born: ");
    int bornYear = scan.nextInt();

    System.out.println("Enter the year right now: \n");
    int yearRightNow = scan.nextInt();
    int answer = yearRightNow - bornYear;

    System.out.println("Your age is: " + answer + " years old :D");
    System.out.println("");

    return answer;
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

  switch(choices){
    case 1:
      if(choices == 1){
        System.out.println(" The first pizza is thought to have been invented in Naples in the early 1500s. ");
        break;
      }

    case 2:
      if(choices == 2){
        System.out.println("Bluefin Tuna Sushi is the costliest Sushi in the world.");
        break;
      }
    case 3:
      if(choices ==3 ){
        System.out.println("Chicken is the most common type of poultry in the world. The largest serving of fried chicken (2,493 lbs) was served at Kentucky Fried Chicken");
      }
    case 4:
      if(choices == 4){
        System.out.println("The average Italian eats 60 pounds of pasta per year.");
      }
    case 5:
      if(choices == 5){
        System.out.println("Eggs are loaded with vitamins, minerals, high-quality protein, good fats and various other lesser-known nutrients");
      }
    case 6:
        if(choices == 6){
          System.out.println("The world's tallest ice cream cone was over 9 feet tall. It was scooped in Italy. Most of the vanilla used to make ice cream comes from Madagascar & Indonesia. ");
      }
    case 7:
        if(choices == 7){
          System.out.println("The word cereal comes from 'Ceres', the name of the Roman goddess of harvest and agriculture.");
      }
    case 8:
        if(choices == 8){
          System.out.println("Taco Bell is an American fast food chain known for its inventive, often whimsical, Mexican-inspired menu items");
      }

    case 9:
        if(choices == 9){
          System.out.println("Rice is the seed of the grass species Oryza sativa (Asian rice) or Oryza glaberrima (African rice). Rice is the oldest known food that is still widely consumed today.");
      }
    case 10:
        if(choices == 10){
          System.out.println("Although originated in China, the first instant ramen noodle was created in Japan and also the first kind of noodles to be consumed in space.");
      }
    case 11:
        if(choices == 11){
          System.out.println("Salmon is important part of human diet because it contains a lot of proteins, vitamin D and omega-3 fatty acids. Salmon do not eat any food during the time they swim upstream to spawn. ");
      }
    }// end switch statement;
    System.out.println(" Thanks for sharing! , choices " + choices + " is a great option :)");
    System.out.println("");


    return choices;
  } // end getFavoriteFood methods

  public String getFavoriteSport(){
    return "";
  } // end getFavoriteSport method

  public String toString() {
    return "Person: " + this.name + " Age: " + this.age + " Height: " + height + " FavoriteFood: " + this.favoriteFood + " FavoriteSport: " + this.favoriteSport;
  } // end toString method
} //end class
