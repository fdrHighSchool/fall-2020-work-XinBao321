 public class StudentDriver {
   public static void main(String[] args) {
     Student student1 = new Student("Chen" , "220345425");

     System.out.println(student1);

     student1.setName("XinBao");
     System.out.println(student1);

    student1.addGrade(30);
    student1.addGrade(23);
    student1.addGrade(100);
    student1.addGrade(29);
    student1.addGrade(69);
    student1.addGrade(114);
  } //end main method

 } // end class
