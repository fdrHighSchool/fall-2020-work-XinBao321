import java.util.Scanner;
public class PersonDriver{
  public static void main(String[] args) {
    Person FF1 = new Person("Myself",14,"20 cm","Sushi","Basketball");
    Person FF2 = new Person("",1,"21","","");
    Scanner scan = new Scanner(System.in);
    System.out.println(FF1);

    FF1.getHeight();
    FF1.getFavoriteFood();
    FF1.getAge();
    FF1.setName("XinBao");

    System.out.println(FF1);

  } //end main method

} //end class method
