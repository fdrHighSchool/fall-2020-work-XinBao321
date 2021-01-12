import java.util.Arrays;
 public class StudentDriver {
   public static void main(String[] args) {
     Student student1 = new Student("Chen" , "220345425");
     Student student2 = new Student("Anime person", "123456789");

     System.out.println(student1);


    student1.addGrade(30);
    student1.addGrade(23);
    student1.addGrade(100);
    student1.addGrade(29);
    student1.addGrade(69);

    student1.fillArray();
    student2.fillArray();
    student1.displayGrades();
    student2.displayGrades();

    System.out.println(student1.calculateAverage());
    System.out.println(student2.calculateAverage());
  } //end main method

 } // end class
