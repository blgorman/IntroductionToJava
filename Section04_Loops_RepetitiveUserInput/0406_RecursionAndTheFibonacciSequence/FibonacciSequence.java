/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Brian
 */
public class FibonacciSequence {

    public static void main(String[] args)
    {
        //like loops, Recursive method calls must at SOME POINT
        //have an ending condition.
        
        //if you code a recursive method incorrectly, you will end up
        //with an error called a "Stack Overflow" error, because you will
        //run out of memory on the application stack.
        
        //Sequences are common for recursion, as are directory searches
        //We can look at recursive search for files when we get to files
        //for now, let's examine the most famous sequence: the Fibonacci Sequence.
        
        //defined as 
        // Fn = Fn-1 + Fn-2
        // ==> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
        
        Scanner input = new Scanner(System.in);
        int x = -1;
        boolean done = false;
        while (!done)
        {
            while (x < 0)
            {
                System.out.println("Please enter the sequence count as "
                    + "an integer [F(n) ==> n = your number]");

                String FofN = input.nextLine();
                if (!ValidNumber(FofN))
                {
                    x = -1;
                    continue;
                }
                x = Integer.parseInt(FofN);
            }

            //get the result by recursive iteration
            //on a method that calls itself until completion:
            int result = EvaluateFibonacci(x);
            System.out.printf("The number at f(%d) is: %d\n", x, result);
            
            boolean againIsValid = false;
            String againCheck = "";
            while (!againIsValid)
            {
                System.out.println("Would you like to run again [y/n]?");
                againCheck = input.nextLine();
                againIsValid = (againCheck.toUpperCase().substring(0,1).equals("Y") 
                                || againCheck.toUpperCase().substring(0,1).equals("N"));
            }
            done = againCheck.toUpperCase().substring(0,1).equals("N");
            if (!done)
            {
                x = -1; 
            }
        }
        
    }
    
    /**
     * The recursive method will call itself if needed
     * at some point, the evaluation always traces to 0 or 1.
     * @param iterations
     * @return the value at a particular 
     *         number f(n) ==> f(n) = f(n-2) + f(n-1);
     */
    public static int EvaluateFibonacci(int iterations)
    {
        //System.out.printf("In Evalute, iterations: %d\n", iterations);
        //here is the important note.  With most recursions, there are 
        //a certain number of things that need to happen in order to 
        //validate the need for a recursion.
        //For example, if x < 2 there is no need to recursively iterate this
        //sequence:
        int result = 0;
        if (iterations < 2)
        {
            //either it is 0, or 1:
            //0
            //1
            return iterations;
        }
        else
        {
            //since there are more than two requested iterations, we need 
            //to send input to a method that will call itself recursively:
            //what is the solution though?
            //f(n) = f(n-2) + f(n -1); //or 
            //f(n) = EvaluateFibonacci(iterations - 2) 
            //      + EvaluateFibonacci(iterations - 1)
            return EvaluateFibonacci(iterations - 2) 
                  + EvaluateFibonacci(iterations - 1);
        }
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
                isValid = false;
                System.out.printf("Invalid character in response: %s\n"
                        , checkChar);
                System.out.println("Please enter only numbers");
                break;
            }
        }
        
        //if get to here, all chars are valid
        return isValid;
    }
}
