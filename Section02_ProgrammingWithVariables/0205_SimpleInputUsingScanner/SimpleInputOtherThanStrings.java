//once again, import the Scanner
import java.util.Scanner;

/**
 * Here we'll get input from the user.
 * @author Brian
 */
public class SimpleInputOtherThanStrings {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int age;
        double price;
        boolean shouldContinue;
        char ch;
        String name;
        
        System.out.println("Please enter your name:");
        name = input.nextLine();
        
        System.out.println("What is your age?");
        //age = input.nextInt(); 
        age = Integer.parseInt(input.nextLine());
        
        System.out.println("What is the price of your favorite beverage?");
        price = input.nextDouble();
        
        System.out.println("Should we continue [Enter true or false]?");
        shouldContinue = input.nextBoolean();
        
        System.out.println("Enter an random letter or number you would like: ");
        ch = input.next().charAt(0);
        
        System.out.printf("Hello %s, you are %d years old, and your "
                           + "favorite beverage costs $%.2f.\n"
                           + "You selected %b in regards to continuing.\n"
                           + "Finally, you thought '%c' was a cool character.\n"
                            , name
                            , age
                            , price
                            , shouldContinue
                            , ch);
        
        input.close();
    }
}
