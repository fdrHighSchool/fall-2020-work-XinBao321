import java.util.Scanner;
class math {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double x1,x2,y1,y2;
    double distance;
    System.out.println("Hello,Welcome to distance calculator!");
    System.out.println("Enter the first x point");
    x1 = input.nextDouble();
    System.out.println("Enter the second x point");
    x2 = input.nextDouble();
    System.out.println("Enter the first y point");
    y1 = input.nextDouble();
    System.out.println("Enter the second y point");
    y2 = input.nextDouble();

    distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
    System.out.println("\nDistancebetween"+"("+ x1 + "," + y1 +")," + "(" +x2+ "," +y2 + ")is: " + distance);
    System.out.println("\nThis is the taxiCab calculator!");
    System.out.println("\nThe distance for taxicab is " + taxiCab(1.0,1.0,1.0,1.0,1.0));
    input.close();
  }
  //taxiCab formula：|x2-x1| + |y2-y1|
  public static double taxiCab(double x1,double x2, double y1, double y2, double distance1){
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the first x point");
      x1 = input.nextDouble();
      System.out.println("Enter the second x point");
      x2 = input.nextDouble();
      System.out.println("Enter the first y point");
      y1 = input.nextDouble();
      System.out.println("Enter the second y point");
      y2 = input.nextDouble();

      distance1 = Math.abs(x2-x1) + Math.abs(y2-y1);
      return distance1;

  } // end taxicab method
} //end math class
