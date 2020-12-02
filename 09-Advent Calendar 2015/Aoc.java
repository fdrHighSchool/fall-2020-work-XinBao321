import java.util.Scanner;
import java.io.*;
public class Aoc{
  public static void main(String[] args) {

    int answer = 0;
    int result = 0;

    try{
    Scanner input = new Scanner(new File("/Users/User/Desktop/javapro/fall-2020-work-XinBao321/09-Advent Calendar 2015/data.txt"));

      while(input.hasNext()){
        int number = Integer.parseInt(input.next());
        result = (number / 3) - 2;
        answer += result;

    }//end while loop

      input.close();
  }//end try

  catch (Exception  e){
      System.out.println("File not found");
    }//end catch
      System.out.println(answer);
  }//end main
}//end class
