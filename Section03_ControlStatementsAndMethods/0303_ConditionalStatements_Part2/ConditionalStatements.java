import java.util.*;

/**
 *
 * @author Brian
 */
public class ConditionalStatements {
    public static void main(String[] args){
        int age1 = 18;  //legal voting age in the U.S.
        int age2 = 16;  //legal driving age in some states in the U.S.
        
        boolean canVote = false;  //default to false;
        boolean canDrive = false; //default to false;
        
        int index = 1;
        
        //NESTED 
        if (age1 == 18)
        {
            if (age2 == 16)
            {
                System.out.printf("%d) age1 is equal to 18 and "
                                    + " age2 is equal to 16\n"
                                        , index);
            }
            else
            {
                System.out.printf("%d) age1 is equal to 18 "
                                    + "but age2 is not equal to"
                                    + "16\n", index);
            }
        }
        else
        {
            System.out.println("age1 is not equal to 18!");
        }
        
        //careful tracking this!
        if (age1 >= 18)
        {
            canVote = true;
            if (age2 >= 16)
            {
                canDrive = true;
            }
            else
            {
                canDrive = false;
            }
        }
        else
        {
            canVote = false;
            if (age2 >= 16)
            {
                canDrive = true;
            }
            else
            {
                canDrive = false;
            }
        }
        
        System.out.printf("\nAfter all is said and done, age1 is %d\n"
                            + "and age2 is %d\nWhich makes canVote: %b\n"
                            + "and canDrive: %b!\n"
                            , age1
                            , age2
                            , canVote
                            , canDrive);
        
        /////NOTE: MAKE A TABLE! ///////////
        /*          canVote         canDrive
            true    x >= 18         y >=16
            false   x < 18          y < 16
        
            But what happens if the values aren't identical and
            of if the conditions don't make sense?
            Can a person have two ages?
            But what if you are testing a group of people with various ages?
            Answer: very complicated, very quickly!
        */
        
        //obviously, tracking multiple true/false
        //can get tricky.  For this reason, it is sometimes 
        //more desirable to do combinations:
        
        
        //NEW TABLE
        /*                      canDrive     canVote
             age < 16           false       false
             age >= 16          true        false?
             16 <= age < 18     true        false
             age = 18           true        true
             age > 18           true        true
        */
        
        //AND && 
        System.out.println("Please enter the age of the person:");
        Scanner input = new Scanner(System.in);
        int currentAge = input.nextInt();
        input.nextLine();
        if (currentAge < 16)
        {
            canVote = false;
            canDrive = false;
        }
        else if (currentAge >= 16 && currentAge < 18)
        {
            //notice how we can eliminate some code and
            //simply/reduce the chance of making errors
            //by combining conditions here
            canVote = true;
            canDrive = false;
        }
        else if (currentAge >= 18)
        {
            canVote = true;
            canDrive = true;
        }
        
        System.out.printf("In the first condition, current age is: %d\n"
                            + "canDrive: %b\n"
                            + "canVote: %b\n"
                            , currentAge
                            , canDrive
                            , canVote);
        
        //OR ||
        //what if it is possible to drive at age 14 if a parent is present
        //or they have a school permit to drive to and from school?
        
        //NEW TABLE
        /*                      canDrive     canVote
         NO PARENT
             age < 16           false       false
             16 <= age < 18     true        false
             age >= 18           true        true
         PARENT OR PERMIT
             age < 14           false       false
             14 <= age < 18     true        false
             age >= 18           true        true
         *  
        */
        
        boolean parentIsPresent = false;
        boolean hasAPermit = false;
        String parentPresent = "N";
        String hasPermit = "N";
        if (currentAge >= 14 && currentAge < 16)
        {
            System.out.println("Is a Parent Present [y/n]?");
            parentPresent = input.nextLine();
            System.out.println("Does the student have a permit [y/n]?");
            hasPermit = input.nextLine();
        }
        if (parentPresent.toUpperCase().contains("Y"))
        {
            parentIsPresent = true;
        }
        if (hasPermit.toUpperCase().contains(("Y")))
        {
            hasAPermit = true;
        }
        
        //now consider the following consolidations:
        if (currentAge < 14)
        {
            canDrive = false;
            canVote = false;
        }
        else if (
                    (currentAge < 16 && parentIsPresent)
                    ||
                    (currentAge < 16 && hasAPermit)
                )
        {
            canDrive = true;
            canVote = false;
        }
        else if (currentAge >= 16 && currentAge < 18)
        {
            canDrive = true;
            canVote = false;
        }
        else if (currentAge >= 18)
        {
            canDrive = true;
            canVote = true;
        }
        
        System.out.printf("In the second condition, current age is: %d\n"
                            + "parent is present: %b\n"
                            + "has permit: %b\n"
                            + "canDrive: %b\n"
                            + "canVote: %b\n"
                            , currentAge
                            , parentIsPresent
                            , hasAPermit
                            , canDrive
                            , canVote);
    }
}
