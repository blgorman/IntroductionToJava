/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Brian
 */
public class ForLoopDemonstration {
    public static void main(String[] args)
    {
        //the for loop is a bit more tricky, being set up with the start
        //check condition, and condition modifier all in the same line
        //of code.  The for loop is BEST used when there is a specific number
        //of iterations that must take place, either in the positive or
        //negative direction.
        
        //important aspects of the for loop are separated by the semi-colon.
        
        //for (start condition; check condition; end condition generator)
        
        for (int i = 0; i < 10; i++)
        {
            //note, the variable i is only in scope for this "for" loop block
            System.out.printf("The value of i is %d\n", i);
        }
        
        //trying to use i outside of the for loop is an error
        //i = 10;
        
        //fastest version of 99 bottles of beer ever...
        for (int i = 99; i > 0; i--)
        {
            System.out.printf("%d bottles of beer on the wall, "
                    + "%d bottles of beer. "
                    + "take one down, pass it around, "
                    + "%d bottles of beer on the wall!\n"
                    , i, i, i-1);
        }
        
        //or, security check with limit of five iterations
        //OR LESS if credentials are correct!
        boolean isValidated = false;
        String userName = "";
        String password = "";
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5 && !isValidated; i++)
        {
            System.out.println("Please enter your username:");
            userName = input.nextLine();
            System.out.println("Please enter your password:");
            password = input.nextLine();
            isValidated = ValidateUser(userName, password);
        }
        
        if (isValidated)
        {
            System.out.println("Welcome to the system!");
        }
        else
        {
            System.out.println("Access Denied!");
        }
    }
    
    /**
     * Validate the user somehow
     * @param userName  the name to check
     * @param pwd the user password
     * @return true if username is valid
     */
    public static boolean ValidateUser(String userName, String pwd)
    {
        /*
        if (userName.equalsIgnoreCase("fred")
                && pwd.equals("Fred#1"))
        {
            return true;
        }
        return false;
        */
        
        //note, anytime you are simply
        //returning true or false
        //by writing "return true"
        //or "return false" there is a better way!
        return (userName.equalsIgnoreCase("fred")
                 && pwd.equals("Fred#1"));
    }
}
