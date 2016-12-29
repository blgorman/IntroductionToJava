import java.util.*;
/**
 *
 * @author Brian
 */
public class CodingWithMethods {

    //this is a method!!!
    public static void main(String[] args)
    {
        //we've already started using methods that others have written.
        //for example, the math Methods, such as absolute value:
        System.out.printf("The absolute value of -32 is %d\n", Math.abs(-32));
        //and power
        System.out.printf("The value of 8 to the 9th power is %.0f\n"
                            , Math.pow(8, 9));
        
        //even printf is a method!
        
        //but we type it ALL THE TIME.  Wouldn't it be nice if we could
        //just shorten our work?
        PrintText("This is awesome!");
        
        //and
        String textToPrint = String.format("The value of 8 "
                                + "to the 9th power is %.0f\n"
                                , Math.pow(8, 9));
        PrintText(textToPrint);
        //what if we needed this for a lot of numbers?
        PrintXraisedToY(8,9);
        PrintXraisedToY(9,8);
        PrintXraisedToY(2,3);
        PrintXraisedToY(4,5);
        
        //and sometimes we need to do calculations or other operations
        //multiple times that have the same algorithm
        //then use the result in other methods/algorithms
        
        //for example -- easily run five calculations:
        RunCalculation();
        RunCalculation();
        RunCalculation();
        //NOTE: if we didn't put the calculate in a method, we'd
        //      have to write the code THREE TIMES (and it would be
        //      exactly the same each time!)
        //      adding a fourth calculation would mean we'd write it all again!
        //      This means that putting our code into methods
        //      allows for a bit of reuse, but is MUCH EASIER to maintain
        //      or change if something is wrong with our code!!
    }
    
    //saves some typing here and there:
    public static void PrintText(String text)
    {
        System.out.println(text);
    }
    
    //repetitive use saves a lot of typing!
    public static void PrintXraisedToY(int x, int y)
    {
        System.out.printf("The value of %d raised to %d is %.0f\n"
                            , x
                            , y
                            , Math.pow(x,y));
    }
    
    /**
     * Running a calculation is going to be the same
     * Every time we want to run it, so why not put it in a method?
     */
    public static void RunCalculation()
    {
        double calculationResult = 0.0;
        String getNumbers = "Enter two doubles, separated by a space:";
        String getOperationText = "Enter the number of the operation you want"
                + " to peform:\n1 for add\n2 for subtract\n"
                + "3 for multiply\n4 for divide";
        
        PrintText(getNumbers);
        Scanner input = new Scanner(System.in);
        double n1 = input.nextDouble();
        double n2 = input.nextDouble();
        input.nextLine(); //clear the read buffer to the next newline char
        PrintText(getOperationText);
        int opNumber = input.nextInt();
        input.nextLine(); //clear the read buffer to the next newline char
        
        //call the calculation:
        calculationResult = Calculate(opNumber, n1, n2);
        //use the returned value to print the result!
        PrintCalculationResult(n1, n2, opNumber, calculationResult);
    }
    
    /**
     * Here we are going to do repeated calculations
     * @param operation -- the operation to perform by number
     * @param x  -- the first number
     * @param y  -- the second number
     * @return  -- the result
     */
    public static double Calculate(int operation, double x, double y)
    {
        double returnValue = 0.0;
        //good place for a switch if you learned that idea - try it here instead
        if (operation == 1)
        {
            returnValue = x + y;
        }
        else if (operation == 2)
        {
            returnValue = x - y;
        }
        else if (operation == 3)
        {
            returnValue = x * y;
        }
        else if (operation == 4)
        {
            returnValue = x / y;
        }
        //something must always be returned if the method is not void:
        return returnValue;
    }
    
    /**
     * Print the calculated result.
     * @param n1 -- the first number in the operation
     * @param n2 -- the second number in the operation
     * @param opNumber -- the operation number
     * @param result  -- the result of the calculation
     */
    public static void PrintCalculationResult(double n1, double n2
                , int opNumber, double result)
    {
        String operation = "";
        if (opNumber == 1)
        {
            operation = "added to";
        }
        else if (opNumber == 2)
        {
            operation = "minus";
        }
        else if (opNumber == 3)
        {
            operation = "multiplied by";
        }
        else if (opNumber == 4)
        {
            operation = "divided by";
        }
        
        System.out.printf("The result of %.2f %s %.2f is: %.2f\n"
                            , n1
                            , operation
                            , n2
                            , result);
    }
}
