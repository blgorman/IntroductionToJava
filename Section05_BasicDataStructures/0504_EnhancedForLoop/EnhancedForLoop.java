import java.util.Random;
/**
 *
 * @author Brian
 */
public class EnhancedForLoop {
    public static void main (String[] args)
    {
        //Up to this point we've seen the regular for loop
        //which is an excellent tool when trying to iterate an array
        //because we can use the length of the array as the limiter:
        System.out.println("Populating numbers:");
        int[] numbers = new int[10]; //has a length of 10, indexes 0-9
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(100000);
        }
       
        System.out.println(Stars(30));
        System.out.println("Reading numbers:");
        //and we could iterate the same way
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.printf("The next number is: %d\n", numbers[i]);
        }
        
        //but the enhanced for loop lets us iterate quickly over
        //the "collection" (in this case an array which isn't a real collection
        //but it is a group of some object type.
        System.out.println(Stars(30));
        System.out.println("Reading numbers with the enhanced for loop:");
        //so that it isn't confusing all we need is the type, a variable
        //and the name of the object to iterate over:
        for (int nextNum : numbers)
        {
            System.out.printf("The next number is: %d\n", nextNum);
        }
    }
    
    /**
     * Print out a string of stars based on passed in length
     * @param num
     * @return
     */
    public static String Stars(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("*");
        }
        return sb.toString();
    }
}
