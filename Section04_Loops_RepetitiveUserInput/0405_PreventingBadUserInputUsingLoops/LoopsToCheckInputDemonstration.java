/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Brian
 */
public class LoopsToCheckInputDemonstration {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        //as we've seen before we were relying on the user to 
        //give us the correct input.  This is not a very good thing to do!
        //users will always make mistakes, and some will purposefully try
        //to break our programs.  Therefore, we must anticipate the possible
        //entries a user might give, and make sure to "trap" bad input
        
        int x = 0;
        do
        {
            //note, this prevents bad numbers, but does it prevent bad letters
            //or other characters?
            System.out.println("Please enter a number [1-10]");
            String userInput = input.nextLine();
            x = Integer.parseInt(userInput);
        } while (x <= 0 || x > 10);
        System.out.printf("1) Your number is: %d\n", x);
        
        //in some cases we need to limit input even further
        //as we saw above, we don't want to accept input that is a String
        //that is not convertible to an integer.
        //This is where ascii codes can be very useful, since there are only
        //a limited number of characters we want to include as valid:
        //http://www.asciitable.com
        //or http://www.ascii.cl/htmlcodes.htm
        /* 0 ==> 48, 1 ==> 49, ..., 9 ==> 57 */
        
        x = -1;
        while (x <= 0 || x > 10)
        {
            System.out.println("Please enter a number [1-10]");
            String userInput = input.nextLine();
            if (!ValidNumber(userInput))
            {
                x = -1;
                //use continue to stop the current
                //iteration and continue with the loop from the start again.
                continue;
            }
            //if get to here, we are good to go on the input
            //it may still not be a valid input but at least
            //we know for sure it is a number at this point:
            x = Integer.parseInt(userInput);
        }
        System.out.printf("2) Your number is: %d\n", x);
        
        System.out.println("Demonstration Complete!");
    }
    
    /**
     * Validate a string for containing only numbers
     * @param checkString
     * @return 
     */
    public static boolean ValidNumber(String checkString)
    {
        boolean isValid = true;
        //loop on all characters
        for (int i = 0; i < checkString.length(); i++)
        {
            char checkChar = checkString.charAt(i);
            if (checkChar < 48 || checkChar > 57)
            {
                //set isValid to false
                isValid = false;
                System.out.printf("Invalid character in response: %s\n"
                        , checkChar);
                System.out.println("Please enter only numbers");
                //use break to exit a loop before all iterations if
                //something has caused the condition to be invalid
                //there is no need to keep looping on the rest of the input.
                break;
            }
        }
        
        //if get to here, all chars are valid
        return isValid;
    }
}
