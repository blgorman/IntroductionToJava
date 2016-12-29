/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Brian
 */
public class WhileLoopDemonstration 
{
    public static void main(String[] args)
    {
        //For this example, we're concentrating on the while loop.
        //This loop is the easiest to manage and most successfully used by 
        //someone just learning loops
        
        //All loops have a starting condition that evaluates to true of false.
        //for this example, let's loop 10 times, outputting the integer
        //of the count for each iteration of the loop
        
        //start condition --> i = 0
        int i = 0;
        //loop condition check.  Is i < 10?
        while (i < 10)
        {
            //as long as i is less than 10, print out the statement:
            System.out.printf("This is loop iteration %d\n", i);
            //critical: Don't forget to increment the count
            //          or effectively evaluate the check condition
            //          if this statement is not in place, the loop
            //          would never exit, and code following the loop
            //          would never run.
            i++;
        }
        
        //another common issue I have seen for someone just starting out
        //is the confusion between an if() {...} else {..} statement and
        //a  loop.  What is the difference?
        //That's right, loops evaluate any number of times, while an
        //if ... else block can only evaluate once:
        int x=0;  //start condition, x < 0
        //check, is x < 10?
        if (x < 10)
        {
            //if so, print this out:
            System.out.printf("%d is less than 10!\n", x);
            x++;  //does this matter?
        }
        
        //did you guess correctly that x is less than 10 and that
        //it only prints out once?  The x++ only matters if we further
        //use the variable in another statement down the line.
        
        
        //while loops can be run on any boolean statements, not just integers
        //for example, we can loop and check against string input
        Scanner input = new Scanner(System.in);
        //start condition ==> userName == "";
        String userName = "";
        //is userName == "fred" or userName == "FRED or userName == "fRED"...
        while(!userName.equalsIgnoreCase("fREd"))
        {
            //notice we used the ! (not) operator.  This can be read as
            //while "NOT" userName equals Fred (not case sensitive).
            //in other words, only STOP when Username equals "fred"
            System.out.println("Please enter your username:");
            userName = input.nextLine();
        }
        
        System.out.println("Exit!");
    }
}
