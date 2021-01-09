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
       index = i;
       replace = true;
     } // end if statement
   } //end for loop

   if(replace == true){
     this.grades[index] = grade;
   }
     System.out.println(Arrays.toString(this.grades));


   //System.out.println(Arrays.toString(this.grades));
 } //end of addGrade method

 public double calculateAverage(){
   return 0.0;
 } //end of calculateAverage method

 public String toString() {
   return "Student: " + this.name + " Osis: " + this.osis;
 }//end toString method

 }//end class
