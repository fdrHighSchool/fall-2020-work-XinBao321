import java.util.Scanner;

class GPA{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int total = 0;
    int manyGrade = 0;



    System.out.println("How many class do you have? ");
    manyGrade = input.nextInt();

    for(int f = 0; f <  manyGrade; f++){
      System.out.println("What grade did you got? ");
      int grade = input.nextInt();
      total = (total + grade);



      }
      int average = total / manyGrade;
      System.out.println("Your average is " + average + "!!");
    }
}
