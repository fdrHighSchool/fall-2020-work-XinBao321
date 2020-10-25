class Strings {
  public static void main(String[] args) {
    String n = "myself";
    String w = "Cool Word";
    String x = "hahaThis is very cool right??";
    String z = "noo";
    String c = "noo";
    String q = "printoutthelet";
    String b = "even though you don't see this butBye thanks for talking to my self..";
    System.out.println(String.format("Hello %s", n)); // % something would also print out the strings after

    System.out.println(w.toLowerCase()); //lower case the string
    System.out.println(x.substring(4)); // start print out after the 4th letter
    if(z.equalsIgnoreCase(c)){
      System.out.println("The two words are the same!");
  } //end of if statement
    System.out.println("Watch me print out 14 without writing the number!");
    System.out.println(q.length()); //there is 14 letters in total which print out the number 14

    System.out.println(b.substring(34));
  } // close method
} // close string class
