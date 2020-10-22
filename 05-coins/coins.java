import java.util.*;


class Main{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);//scanner
    String userName;
    //greet the user with a personalized message
    System.out.println("Hello, Welcome to the game!");//greetings
    System.out.println("What is your name?");
    userName = input.nextLine();
    System.out.println("Wow, " + userName + " you have been rewarded with 100 coins!");

    int coins = 100; //give the user 100 base coins


      while(true){ //always true

      System.out.println("What would you like to do " +userName+ "?");
      System.out.println("1. play");
      System.out.println("2. shop");
      System.out.println("3. quit"); //The three options
      int user = input.nextInt(); //record what user want to do

      if(user == 1){   //if user wants to play
        coins += play(coins,userName);
        System.out.println("You now have " +coins+ " coins!");//tells user new amount of coins
      }
      else if(user == 2){ // if user wants to go to the shop
        coins -= shop(coins,userName);
        System.out.println("After your purchase you now have " +coins+ " coins left");// amount of coins left
      }
      else if(user == 3){// if user wants to finish playing
        System.out.println("Thank you for playing, you finished with " + coins + " coins");
        System.out.println("Byeee"); //saying goodbye , and telling the amount of coins at the end of the game
        break; // ending the whole game
      }
    }

  }//end main method

 /*
  * Name: play
  * Purpose: simulate a round of the game, award the user a random
  * amount of coins for playing
  * Input: number of coins and username
  * Return: a random number of coins the user won that round
  * NPIR
  */
  public static int play(int coins,String userName){
    Random rand = new Random();
    System.out.println("This is play time, time to earn some coins!");
    //pick a random number between 0 and 50
    int getCoins= rand.nextInt(50);
    System.out.println("Wow " + userName + " You earned " + getCoins + " coins!");
    return getCoins;
   } //close method for play


/*
   * Name: shop
   * Purpose: simulate a shop in a game
   * Input: number of coins and username
   * Return: cost of the chosen item
   * NPIR
   */
  public static int shop(int coins,String userName){
    Scanner input = new Scanner(System.in);//scanner

    System.out.println("You have: " + coins+ " coins");
    System.out.println("What item do you want to buy, " +userName);// personalized statement
    System.out.println("1. Common item: 50 coins");// the common item available for purchase
    System.out.println("2. Rare item: 100 coins");// the rare item available for purchase
    System.out.println("3. Legendary item: 225 coins");// the legendary item available for purchase
    System.out.println("4. Exit shop");
    int user = input.nextInt(); //record what the user wants to buy

    int cost = 0;// the variable to see the cost of each item

    if(user == 1){     // if user wants to buy the common item
      if(coins>=50){
        cost = 50;
      }
      else{// if user doesn't have enough coins
        System.out.println("You need more coins before purchasing this item");
        System.out.println("You should play more to earn more coins!");
      }

    }
    else if(user == 2){// if user wants to buy the rare item
      if(coins>=100){
        cost = 100;
      }
      else if(coins<100){ // if user doesn't have enough coins
        System.out.println("You need more coins before purchasing this item");
        System.out.println("You should play more to earn more coins!");
      }

    }
    else if(user == 3){// if user wants to buy the legendary item
      if(coins>=225){
        cost = 225;
      }
      else{   // if user doesn't have enough coins
        System.out.println("You need more coins before purchasing this item");
        System.out.println("You should play more to earn more coins!");
      }

    }
    else if(user == 4){ // if user doesn't want to buy anything
      cost = 0;
    }

    return cost;
  } //close method for shop



}//end class
