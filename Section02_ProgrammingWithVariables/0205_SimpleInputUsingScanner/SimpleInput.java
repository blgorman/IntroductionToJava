//Here we import the java.util package!
//http://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
import java.util.Scanner;
//import java.util.*;

/**
 * Create a Scanner to get user input.
 * @author Brian
 */
public class SimpleInput {

    public static void main(String[] args)
    {
        String name = null;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name:");
        name = input.nextLine();
        
        System.out.printf("Your name is: %s\n", name);
        input.close();
    }
}
