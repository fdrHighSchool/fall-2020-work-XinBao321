import java.util.Scanner;

class GPA{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double total = 0;
    double manyGrade = 0;



    System.out.println("How many class do you have? ");
    manyGrade = input.nextDouble();

    for(int f = 0; f <  manyGrade; f++){
      System.out.println("What grade did you got? ");
      double grade = input.nextDouble();
      total = (total + grade);



      }
      double average = total / manyGrade;
      System.out.println("Your average is " + average + "!!");
    }
}
