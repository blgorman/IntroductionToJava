import java.util.*;

/**
 * Demonstrate runtime exceptions and blocks to handle them.
 * @author Brian
 */
public class ShowRuntimeExceptions 
{
    public static Scanner input;
    public static void main(String[] args)
    {
        //all Runtime Exceptions are 'unchecked'
        //This means they do not happen at compile time.
        //anything that extends Runtime Exception is a runtime exception
        //we can stop runtime exceptions by using the try..catch..finally blocks
        
        //some common runtime exceptions to be ready to handle:
        //NullPointerException -- our best "friend"
        //IndexOutOfBoundsException
        //ArithmeticException
        //IllegalArgumentException
        //remember you can always look these up in the API
        
        //Let's run a few and see it all in action:
        input = new Scanner(System.in);
        boolean continueDemo = true;
        while (continueDemo)
        {
            int option = PrintMenu();
            switch (option)
            {
                case 1:
                    System.out.println("1] Null Pointer Exception without handling");
                    NullPointerException(false);
                    break;
                case 2:
                    System.out.println("2] Null Pointer Exception with handling");
                    NullPointerException(true);
                    break;
                case 3:
                    System.out.println("3] Index Bounds Exception without handling");
                    IndexOutOfBoundsException(false);
                    break;
                case 4:
                    System.out.println("4] Index Bounds Exception with handling");
                    IndexOutOfBoundsException(true);
                    break;
                case 5:
                    System.out.println("5] Arithmetic Exception without handling");
                    ArithmeticException(false);
                    break;
                case 6:
                    System.out.println("6] Arithmetic Exception with handling");
                    ArithmeticException(true);
                    break;
                case 7:
                    System.out.println("7] Illegal Argument Exception without handling");
                    IllegalArgumentException(false);
                    break;
                case 8:
                    IllegalArgumentException(true);
                    System.out.println("8] Illegal Argument Exception with handling");
                    break;
                case 9:
                    System.out.println("9] Hierarchical Exceptions - 1");
                    HierarchicalExceptions(1);
                    break;
                case 10:
                    System.out.println("10] Hierarchical Exceptions - 2");
                    HierarchicalExceptions(2);
                    break;
                default:
                    System.out.println("Bad Input -- try again");
                    break;
            }
            
            //prompt for exit
            System.out.println("Do you want to continue [y/n]");
            String testString = input.nextLine();
            if (Common.GetFirstCharAsString(testString).equalsIgnoreCase("N"))
            {
                continueDemo = false;
            }
        }
    }
    
    /**
     * Print a menu.
     */
    public static int PrintMenu()
    {
        System.out.println(Common.CharacterGeneration(50, "*"));
        System.out.println("Please select an option:");
        System.out.println("1] Null Pointer Exception without handling");
        System.out.println("2] Null Pointer Exception with handling");
        System.out.println("3] Index Bounds Exception without handling");
        System.out.println("4] Index Bounds Exception with handling");
        System.out.println("5] Arithmetic Exception without handling");
        System.out.println("6] Arithmetic Exception with handling");
        System.out.println("7] Illegal Argument Exception without handling");
        System.out.println("8] Illegal Argument Exception with handling");
        System.out.println("9] Hierarchical Exceptions - 1");
        System.out.println("10] Hierarchical Exceptions - 2");
        System.out.println(Common.CharacterGeneration(50, "*"));
        try
        {
            String userInput = input.nextLine();
            return Integer.parseInt(userInput);
        }
        catch (Exception ex)
        {
            System.out.println("ERROR");
            ex.printStackTrace();
            return 11;
        }
    }
    
    /**
     * Null Pointer Exception demonstration
     * @param handleit whether or not to handle the exception
     */
    public static void NullPointerException(boolean handleit)
    {
        //npe can happen anytime something is null
        //either a class variable, or a slot in an array
        Person[] people = new Person[10];
        people[0] = new LayPerson("Ann","Frank",18);
        people[1] = new LayPerson("Ben","Franklin", 62);
        
        //options:
        if (!handleit)
        {
            //no handling:
            for (int i = 0; i < people.length; i++)
            {
                System.out.println(people[i].getFirstName());
            }
        }
        else
        {
            //use a try..catch block to prevent the error from breaking
            //the program
            try
            {
                //note the code was the same.  Do you think
                //that it will loop every time once a bad input
                //is encountered?
                for (int i = 0; i < people.length; i++)
                {
                    System.out.println(people[i].getFirstName());
                }
            }
            catch (NullPointerException npex)
            {
                System.out.println("A null pointer exception was trapped. "
                        + " You should implement logging...");
            }
        }
    }
    
    /**
     * Index out of bounds
     * @param handleit whether or not to handle the exception
     * NOTE: IOB ex can also happen if try to iterate past collection length
     */
    public static void IndexOutOfBoundsException(boolean handleit)
    {
        Person[] people = new Person[2];
        people[0] = new LayPerson("Ann","Frank",18);
        people[1] = new LayPerson("Ben","Franklin", 62);
        
        //options:
        if (!handleit)
        {
            //no handling:
            people[3] = new LayPerson("Thomas", "Edison", 45);
            //or
            for (int i = 0; i < 10; i++)
            {
                System.out.println(people[i]);
            }
        }
        else
        {
            //use a try..catch block to prevent the error from breaking
            //the program
            try
            {
                people[3] = new LayPerson("Thomas", "Edison", 45);
                
            }
            catch (IndexOutOfBoundsException iobex)
            {
                System.out.println("An index out of bounds "
                        + "exception was trapped. "
                        + " You should implement logging...");
            }
            
            //the other way:
            try
            {
                for (int i = 0; i < 10; i++)
                {
                    System.out.println(people[i]);
                }
            }
            catch (IndexOutOfBoundsException iobex)
            {
                System.out.println("An index out of bounds "
                        + "exception was trapped. "
                        + " You should implement logging...");
            }
        }
    }
    
    /**
     * Arithmetic Exception.
     * @param handleit whether or not to handle the exception
     */
    public static void ArithmeticException(boolean handleit)
    {
        //the most common arithmetic exception is divide by zero;
        if (!handleit)
        {
            int d = 32 / 0;
        }
        else
        {
            try
            {
                int d = 32 / 0;
            }
            catch (ArithmeticException aex)
            {
                aex.printStackTrace();
            }
        }
    }
    
    /**
     * Illegal Argument Exception.
     * @param handleit whether or not to handle the exception
     */
    public static void IllegalArgumentException(boolean handleit)
    {
        //illegal argument exceptions are used to tell the caller
        //that the value they passed to the method is not valid
        //and that they need to fix it.  This is better than just looping
        //for good input because the user can easily fix it or the system
        //will simply break.
        //NOTE: Added Illegal argument Exception throw statement to person's 
        //      set Age and also in the explicit constructor.
        Person p;
        Person p2;
        if (!handleit)
        {
            //don't handle illegal arguments
            p = new LayPerson("Tom", "Jones", -10);
            //or
            p2 = new LayPerson();
            p2.setAge(160);
        }
        else
        {
            try
            {
                p = new LayPerson("Tom", "Jones", -10);
            }
            catch (IllegalArgumentException iaex)
            {
                System.out.println(iaex.getMessage());
            }
            
            try
            {
                p = new LayPerson();
                p.setAge(162);
            }
            catch (IllegalArgumentException iaex)
            {
                System.out.println(iaex.getMessage());
            }
        }
    }
    
    /**
     * Hierarchical Exceptions.
     * @param option the path to take
     */
    public static void HierarchicalExceptions(int option)
    {
        //Exceptions are stackable, and you can nest try..catch..finally
        //blocks inside other ones..
        //additionally, you can trap any exception that is more specific
        //with a less specific exception.
        if (option == 1)
        {
            try
            {
                int x = 32/0;
            }
            catch (ArithmeticException iaex)
            {
                try
                {
                    //int y = 62/0;
                    LayPerson lp = new LayPerson("Tom", "Jones", -10);
                }
                catch (IllegalArgumentException iaex2)
                {
                    System.out.println(iaex2.getMessage());
                }
                catch (Exception ex)
                {
                    System.out.println("Your system had a massive failure");
                }
                /*
                catch (ArithmeticException iaex2)
                {
                    System.out.println(iaex2.getMessage());
                }
                */
                finally
                {
                    System.out.println("Inner Exception handled");
                }
            }
            finally
            {
                System.out.println("Outer Exception handled.");
            }
        }
        else if (option == 2)
        {
            try
            {
                LayPerson p = new LayPerson();
                p.setAge(162);
                try
                {
                    int y = 32/0;
                }
                catch(ArithmeticException ex)
                {
                    System.out.println("Problems with math?");
                }
                finally
                {
                    System.out.println("Your System had a massive failure");
                }
            }
            catch (ArithmeticException iaex)
            {
                System.out.println("Problems with math?");
            }
            catch (IndexOutOfBoundsException iobex)
            {
                System.out.println("Indexes are bad");
            }
            catch (Exception ex)
            {
                System.out.println("Failure: " + ex.getMessage());
            }
            finally
            {
                System.out.println("Were you able to track the statements?");
            }
        }
    }
}
