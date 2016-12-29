/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Brian
 */
public class DoWhileLoopDemonstration {

    public static void main(String[] args)
    {
        //the do..while loop is similar to the while loop
        //the main difference is the do..while loop is utilized when
        //something must happen at least once, no matter what.
        
        //like any other loop, the do ... while must have a start condition:
        //however it might not be as evident as with a while loop, because
        //since the do..while has to execute at least once, the start condition
        //is always true at the start, even if the check condition is NOT true
        int i = 11;
        do 
        {
            //note: even though i > 10, this executes one time
            System.out.printf("%d - executing!\n", i);
            
            //note: nothing has to be done to make the condition if
            //it is already true.  However, if you are doing this
            //why do you need a loop?
            //therefore, do something to the variable or you will never
            //have more than one iteration and you should have used an
            //if block:
            i++;
        }
        while (i < 10);  //is i < 10?  if so, continue in the loop
        //otherwise come here
        
        do 
        {
            System.out.printf("The current value of i is %d\n", i);
            i++;
        } while (i < 100); //is i < 100?
        
        
        //like while loops, any valid condition can be run:
        
        //imagine some security checks have to happen
        boolean isValidated = false;
        Scanner input = new Scanner(System.in);
        do 
        {
            //state the task:
            System.out.println("Running security check...");
            System.out.println("Enter your username:");
            //...gather input...
            String userName = input.nextLine();
            
            //check/set the ending condition, so that loop can 
            //exit:
            isValidated = userName.equalsIgnoreCase("fReD");
        } while (!isValidated); //here we loop until isValidated is true 
        
        //another common issue that new programmers have is scope.
        //to this point we haven't talked too much about scope, but you
        //may start to run into more problems here.  For example, the scope
        //of the userName variable above is within the do..while loop only.
        //this is because we declare it inside the {}'s of the loop.
        //if we want to use the userName variable outside of the loop, we
        //would be out of luck (note, this is the same for all loops and if/else
        //blocks!).
        
        //try to use userName by uncommenting the following line:
        //System.out.printf("%s is a valid user! Continuing...\n", userName);
        
        System.out.println("Demonstration complete!");
    }
}
