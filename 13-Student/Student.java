import java.util.Arrays;
public class Student{
 // instance varaibles

 private String name;
 private String osis;
 private int[] grades;

 // constructor
 public Student(String n, String o){
   this.name = n;
   this.osis = o;
   grades = new int[10];
 }

 // other methods


 public String getName(){
   return "";
 } //end of getName method

 public void setName(String name){
    this.name = name;
 } //end of setName method


 public String getOsis(){
   return "";
 } //end of getOsis method

 public void addGrade(int grade) {
    int i = 0;

    while (this.grades[i] != 0) {
      i++;
    }//end while loop

    this.grades[i] = grade;
  }//end addGrade method

 public void displayGrades() {
   System.out.println(Arrays.toString(this.grades));
 } //end getGrades()

 public double calculateAverage() {
    double sum = 0.0;
    for (double grade : this.grades) {
      sum += grade;
    } //end for loop
    return sum / this.grades.length;
  } //end calculateAverage()

 public void fillArray() {
   for (int i = 0; i < this.grades.length; i++) {
     this.grades[i] = (int)(Math.random() * 46 + 55);
   }// end for loop
 }// end fillArray method

 public String toString() {
   return "Student: " + this.name + " Osis: " + this.osis;
 }//end toString method

 }//end class
