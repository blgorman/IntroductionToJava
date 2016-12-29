
import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class MakingCopiesOfArrays {
    public static void main(String[] args) 
    {
        // /*
        //in the coding with arrays exercise, we learned about the fact 
        //that arrays are referenced in memory, and therefore if you try 
        //to copy one, your operations on one will also affect the other.
        //let's review:
        System.out.println("******* SECTION ONE**************");
        System.out.println("Populating numbers:");
        int[] numbers = new int[10]; //has a length of 10, indexes 0-9
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(100000);
        }
        
        //"copy" the array directly.
        System.out.println("Copying the array...");
        int[] numbers2 = numbers;
        
        //uh-oh, we have a referencing issue:
        numbers[3] = 999;
        numbers2[7] = 1000;
        
        System.out.println("Printing numbers:");
        for (int n : numbers)
        {
            System.out.printf("The next number is %d\n", n);
        }
        
        System.out.println(Stars(30));
        System.out.println("Printing numbers 2:");
        for (int n : numbers2)
        {
            System.out.printf("The next number is %d\n", n);
        }
        
        System.out.println(Stars(50));
        // */
        
        /*
        System.out.println("******* SECTION TWO**************");
        
        //so, how do we get around this?
        //one method is to use the "CLONE" method, that exists on the array:
        int[] numbers3 = numbers.clone();
        numbers[3] = 700;
        numbers3[6] = 10000;
        
        System.out.println("Printing numbers:");
        for (int n : numbers)
        {
            System.out.printf("The next number is %d\n", n);
        }
        
        System.out.println(Stars(30));
        System.out.println("Printing numbers 3:");
        for (int n : numbers3)
        {
            System.out.printf("The next number is %d\n", n);
        }
        */
        
        
        //always remember this: Cloning means you create a NEW item with a NEW
        //location in memory.  This is why we now have two arrays, and changing
        //one does not affect the other.  Additionally, this means we are now
        //using twice as much memory, so that's something to consider if memory
        //is a limited resource.
        /*
        System.out.println("******* SECTION THREE**************");
        
        //Java has given us a nice method to use to do things.
        //here is another point.  If you are programming and you think that
        //you are about to do something that might be common to everyone
        //for example, copying an array, remember that sometimes java
        //programmers have already given us tools.  Do a quick web-search
        //to see if there are common libraries you can leverage!
        
        //java.lang.System
        //copy the whole array from start to end
        int[] numbers4 = new int[numbers.length];
        System.arraycopy(numbers, 0, numbers4, 0, numbers.length);
        //copy a subset of the original array
        int[] numbers5 = new int[3];
        System.arraycopy(numbers, 3, numbers5, 0, 3);
        
        System.out.println(Stars(30));
        System.out.println("Printing numbers 4:");
        for (int n : numbers4)
        {
            System.out.printf("The next number is %d\n", n);
        }
        System.out.println(Stars(30));
        System.out.println("Printing numbers 5:");
        for (int n : numbers5)
        {
            System.out.printf("The next number is %d\n", n);
        }
        System.out.println(Stars(30));
        */
        
        /*
        //but does using arraycopy "Clone" the array or is it just pointers
        //to a location in memory?  Let's find out:
        numbers[1] = 1;
        numbers4[4] = 4;
        numbers5[2] = 2;
        
        for (int n : numbers)
        {
            System.out.printf("The next number is %d\n", n);
        }
        System.out.println(Stars(30));
        for (int n : numbers4)
        {
            System.out.printf("The next number is %d\n", n);
        }
        System.out.println(Stars(30));
        for (int n : numbers5)
        {
            System.out.printf("The next number is %d\n", n);
        }
        */
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
