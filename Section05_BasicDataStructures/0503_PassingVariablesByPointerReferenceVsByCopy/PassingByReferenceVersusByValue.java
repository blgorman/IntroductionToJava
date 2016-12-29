/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class PassingByReferenceVersusByValue {
    public static void main(String[] args)
    {
        //*******************************************************************
        //by reference vs. by Value
        //Up to this point, we've worked with methods and primitive types
        //when you call a method with a primitive type, the system makes a copy
        //and uses the copy in the method.  In this way, nothing is changed on 
        //the original item.  This is called passing values "By Value"
        
        //When using a complex object like an array, the system automatically
        //recognizes that the object is complex, and decides to conserve memory.
        //in order to save memory, the system passes the item "By reference" 
        //This means that a memory address is passed, and changes that are done
        //on the item can actually affect the original item back in the caller.
        
        //For example:
        int x = 32;
        int y = 0;
        System.out.printf("The value of x is: %d\n", x);
        y = CanWeChangeXInAMethod(x);
        System.out.printf("The value of x is: %d\n", x);
        System.out.printf("The value of y is: %d\n", y);
        
        //note that even though we changed x in the method, it never changed
        //this is because the method made a copy, put the copy in memory
        //and worked with the copy.  By Value.
        
        //But an array is complex, so the system will just reference the same
        //object, even in the method
        int[] importantValues = new int[5];
        importantValues[0] = 2;
        importantValues[1] = 4;
        importantValues[2] = 6;
        importantValues[3] = 8;
        importantValues[4] = 10;
        System.out.println("Original Important Values");
        for (int i = 0; i < importantValues.length; i++)
        {
            System.out.printf("The value at index [%d] is %d\n."
                                , i
                                , importantValues[i]);
        }
        System.out.println(Stars(30));
        
        System.out.println("Calling Change Method");
        int[] anotherArray = CanWeChangeArrayInAMethod(importantValues);
        
        System.out.println("Important Values:");
        for (int i = 0; i < importantValues.length; i++)
        {
            System.out.printf("The value at index [%d] is %d\n."
                                , i
                                , importantValues[i]);
        }
        System.out.println(Stars(30));
        
        System.out.println("Returned values in Another Array:");
        for (int i = 0; i < anotherArray.length; i++)
        {
            System.out.printf("The value at index [%d] is %d\n."
                                , i
                                , anotherArray[i]);
        }
        System.out.println(Stars(30));
        
        //and since they are pointed to the same memory address, changes to one
        //actually effects both, because they are really the same memory
        //addresses that are being affected.
        anotherArray[2] = 100;
        importantValues[4] = 900;
        System.out.println("Important Values:");
        for (int i = 0; i < importantValues.length; i++)
        {
            System.out.printf("The value at index [%d] is %d\n."
                                , i
                                , importantValues[i]);
        }
        System.out.println(Stars(30));
        System.out.println("Another Array:");
        for (int i = 0; i < anotherArray.length; i++)
        {
            System.out.printf("The value at index [%d] is %d\n."
                                , i
                                , anotherArray[i]);
        }
    }
    
    public static int CanWeChangeXInAMethod(int x){
        x = x * 2;
        System.out.printf("The value of x in the method is: %d\n", x);
        return x;
    }
    
    public static int[] CanWeChangeArrayInAMethod(int[] someArray)
    {
        System.out.println("Changing values of passed in array...");
        for (int i = 0; i < someArray.length; i++)
        {
            someArray[i] = i;
        }
        return someArray;
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


