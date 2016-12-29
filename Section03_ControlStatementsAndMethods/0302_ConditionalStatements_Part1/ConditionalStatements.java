/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class ConditionalStatements {
    public static void main(String[] args){
        //conditional statements allow us to take specific paths
        //based on the value of true or false when evaluating
        //conditional statements
        int x = 2;  //one equals? --> assignment
        int index = 1;
        
        //greater than >
        if (x > 10)
        {
            System.out.printf("%d) x is greater than 10!\n", index);
        }
        else
        {
            System.out.printf("%d) x is less than or equal to 10\n", index);
        }
        index++;  
        
        //less than <
        if (x < 10)
        {
            System.out.printf("%d) x is less than than 10!\n", index);
        }
        else
        {
            System.out.printf("%d) x is greater than or equal to 10\n", index);
        }
        index += 1;  //index += 2; index += 3
        
        //equal to: == *NOTE DO NOT USE only one =
        if (x == 10)
        {
            System.out.printf("%d) x is equal to 10!\n", index);
        }
        else
        {
            System.out.printf("%d) x is not equal to 10\n", index);
        }
        index = index + 1;  //index = index + n
        
        //greater than or equal to >=
        if (x >= 10)
        {
            System.out.printf("%d) x is greater than or equal to 10!\n", index);
        }
        else
        {
            System.out.printf("%d) x is less than 10\n", index);
        }
        index++;
        
        //less than or equal to <=
        if (x <= 10)
        {
            System.out.printf("%d) x is less than or equal to 10!\n", index);
        }
        else
        {
            System.out.printf("%d) x is greater than 10\n", index);
        }
        index++;
        
        //NOT EQUAL !=  
        if (x != 11)
        {
            System.out.printf("%d) x is not equal to 11!\n", index);
        }
        else
        {
            System.out.printf("%d) x is equal to 11!\n", index);
        }
        index++;
        
        //of course these don't have to be done with numbers:
        boolean isValid = true;
        boolean isIncluded = false;
        
        if (isValid)
        {
            System.out.println("The switch is valid!");
        }
        
        if (isIncluded)
        {
            System.out.println("Batteries are included!");
        }
        else
        {
            System.out.println("Batteries are not included!");
        }
        
        //combining to get basic true/false statements:
        isValid = x >= 10;
        if (isValid)
        {
            System.out.printf("%d) is valid is true "
                                + "because %d >= 10 is true\n"
                                , index
                                , x);
        }
        else
        {
            System.out.printf("%d) is valid is false "
                                + "because %d >= 10 is false\n"
                                , index
                                , x);
        }
        
    }
}
