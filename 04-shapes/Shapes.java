import java.util.Scanner;
import java.lang.*;
public class Shapes{
public static void main(String[] args) {


 System.out.println("\nThe area of this rectangle is: " + rectangle(1,2,3));
 System.out.println("\nThe area of this circle is: " + circle(1.0,2.0));
 System.out.println("\nThe area of the triangle is " + triangle(1.0,1.0));
 System.out.println("\nThe area of triangle using heron's formula is: " + herons(1,2,3));
 System.out.println("\nThe volume of the cube is: " + cube(1.0,1.0));
 System.out.println("\nThe volume of the triangleprism is: " + triangularPrism(1.0,1.0,1.0,1.0,1.0));
 System.out.println("\nThe volume of the rectangularprism is: " + rectangularprism(1.0,1.0,1.0,1.0));
 System.out.println("\nThe volume of the sphere is: " + sphere(1.0,1.0,1.0));
 System.out.println("\nThe volume of the cylinder is: " + cylinder(1.0,1.0,1.0));


}   //close method

public static int rectangle(int length2,int width2, int areaRectangle){
 Scanner input = new Scanner(System.in);
 System.out.println("Welcome to the shape area calcuator!");
 System.out.println("What is the length of the rectangle?");
 length2 = input.nextInt();
 System.out.println("What is the width of the rectangle?");
 width2 = input.nextInt();
 areaRectangle = length2 * width2;
 return areaRectangle;


} //close method for rectangle
public static double triangle(double base, double height){
  Scanner input = new Scanner(System.in);
  System.out.println("What is the base of the triangle ?");
  base = input.nextDouble();
  System.out.println("What is the height of the triangle ?");
  height  = input.nextDouble();
  double areaTri = base * height /2;
  return areaTri; // return statement
}//close method for triangle

public static double herons(double length1,double length2, double length3){
  Scanner input = new Scanner(System.in);
  System.out.println("What is the length of the first side?");
  length1 = input.nextDouble();
  System.out.println("What is the length of the second side?");
  length2 = input.nextDouble();
  System.out.println("What is the length of the third side?");
  length3 = input.nextDouble();
  double cool =(length1 + length2 + length3)/2;
  double area = Math.sqrt(cool*(cool - length1)*(cool - length2)*(cool - length3));
  return area; // return statement
}//end of heron's method

public static double circle(double radius, double area){
 Scanner input = new Scanner(System.in);
 System.out.println("What is the radius of the circle?");
 radius = input.nextDouble();
 area = Math.PI * radius * radius;
 return area;  // return statement
} // close method for circle

  public static double cube(double s, double areaCube){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the side of the cube ");
    s = input.nextDouble();
    areaCube = Math.pow(s,3);
    return areaCube;  // return statement
  } //close method for cube

  public static double triangularPrism(double length3, double base, double height, double volumeTri, double valueCheck ){
    Scanner input = new Scanner(System.in);
    System.out.println("What is the length of the triangleprism? ");
    length3 = input.nextDouble();
    System.out.println("What is the base of the triangleprism? ");
    base = input.nextDouble();
    System.out.println("What is the height of the triangleprism? ");
    height = input.nextDouble();
    volumeTri = length3 * base * height /2;
    return volumeTri;  // return statement
  }// close method for triangularprism

  public static double rectangularprism(double length4, double width3, double height2, double volumeRect){
    Scanner input = new Scanner(System.in);
    System.out.println("What is the length of the rectangular prism?");
    length4 = input.nextDouble();
    System.out.println("What is the width of the rectangular prism?");
    width3 = input.nextDouble();
    System.out.println("What is the height of the rectangular prism?");
    height2 = input.nextDouble();
    volumeRect = length4 * width3 * height2;
    return volumeRect;  // return statement
  }  //close method for rectangularprism

    public static double sphere(double radius, double volumeSphere,double volumeSphere1){
      Scanner input = new Scanner(System.in);
      System.out.println("What is the radius of the sphere?");
      radius = input.nextDouble();
      volumeSphere1 = Math.PI * radius * radius * radius;
      volumeSphere = volumeSphere1 * 4/3;
      return volumeSphere;  // return statement
    } // close method for sphere

    public static double cylinder(double radius, double h, double volumeCylinder){
      Scanner input = new Scanner(System.in);
      System.out.println("What is the radius of the cylinder?");
      radius = input.nextDouble();
      System.out.println("What is the height of the cylinder?");
      h = input.nextDouble();
      volumeCylinder = (radius * radius * h * Math.PI);
      return volumeCylinder;  // return statement
    }// close method for cylinder

 }//close class
