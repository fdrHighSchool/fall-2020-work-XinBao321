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
   int index = 0;
   int lowestGrade = 0;
   boolean replace = false;


   for(int i = 0; i < this.grades.length; i++){
     if(this.grades[i] == 0){
       lowestGrade = index;
       replace = true;
     }// end if statement
   else{

   if(this.grades[index] < this.grades[lowestGrade]){
        lowestGrade = this.grades[index];
       } //end if statement
   } //end else statment

      this.grades[lowestGrade] = grade;
  }// end for loop
   System.out.println(Arrays.toString(this.grades));
 } // end of addGrade method

 public double calculateAverage(){
   return 0.0;
 } //end of calculateAverage method

 public String toString() {
   return "Student: " + this.name + " Osis: " + this.osis;
 }//end toString method

 }//end class
