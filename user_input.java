import java.util.*;
public class user_input {
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("enter ur name: ");
    String name=s.nextLine();
    System.out.println("ur name is: "+name);
    s.close();
}
}
