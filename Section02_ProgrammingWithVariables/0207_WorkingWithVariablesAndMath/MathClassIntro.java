import java.util.*;
//http://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
/**
 * Get user input and do some math.
 * @author Brian
 */
public class MathClassIntro 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter any decimal number"
                            + ", positive or negative: ");
        double n1 = input.nextDouble();
        
        //absolute value
        //abs
        System.out.printf("The absolute value of %f is: %f\n"
                            , n1
                            , Math.abs(n1));
        
        //ceiling
        System.out.printf("The ceiling of %f is: %f\n"
                            , n1
                            , Math.ceil(n1));
        
        //floor
        System.out.printf("The floor of %f is: %f\n"
                            , n1
                            , Math.floor(n1));
        
        //hypot
        double n2;
        double n3;
        System.out.println("Enter the x value of the triangle:");
        n2 = input.nextDouble();
        System.out.println("Enter the y value of the triangle:");
        n3 = input.nextDouble();
        System.out.printf("The hypotenuse of %f and %f is: %f\n"
                            , n2
                            , n3
                            , Math.hypot(n2, n3));
        
        //log (base 2)
        System.out.printf("The log base 2 value of %f is: %f\n"
                            , n1
                            , Math.log(n1));
        //log (base 10)
        System.out.printf("The log base 10 value of %f is: %f\n"
                            , n1
                            , Math.log10(n1));
        
        //max
        System.out.printf("The maximum value of %f and %f is: %f\n"
                            , n1
                            , n2
                            , Math.max(n1, n2));
        
        //min
        System.out.printf("The minimum value of %f and %f is: %f\n"
                            , n1
                            , n2
                            , Math.min(n1, n2));
        
        //pow
        System.out.printf("%f squared is %f\n"
                            , n1
                            , Math.pow(n1, 2));
        System.out.printf("%f cubed is %f\n"
                            , n1
                            , Math.pow(n1, 3));
        
        //round
        System.out.printf("%f rounded is: %d\n"
                            , n1
                            , Math.round(n1));
        
        input.close();
    }
}
