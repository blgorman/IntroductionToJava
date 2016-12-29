
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class SimplePhysicsCalculator {
    final static double theSpeedOfLight = 299792458.00; //m/s
    public static Scanner input;
    
    /**
     * Simple Physics Calculator.
     * @param args 
     */
    public static void main(String[] args)
    {
        //welcome the user
        System.out.println("Welcome to the Simple Physics Calculator!");
        
        //allow the user to run as many calculations as they would like:
        boolean done = true;
        do 
        {
            //run the calculation at least once, and until user says to quit.
            RunSPC();
            
            //after calculation is complete, ask if want to do it again:
            System.out.println("Would you like to run another calculation [y/n]?");
            String runAgain = input.nextLine();
            done = (runAgain.toUpperCase().substring(0,1).equals("N"));
        } while (!done);
        
        //exit prompt
        System.out.println("Program Complete!");
    }
    
    /**
     * Run the menu and choice selection to drive the SPC.
     */
    public static void RunSPC()
    {
        //print the menu:
        input = new Scanner(System.in);
        boolean isValid = false;
        int option = -1;
        //make sure the user chooses a valid option:
        while(!isValid)
        {
            PrintMenu();
            //validate user choice:
            String optionString = input.nextLine();
            isValid = ValidNumber(optionString);
            if (!isValid)
            {
                //no need to go on here.
                continue;
            }
            option = Integer.parseInt(optionString);
            
            if (option < 1 || option > 5)
            {
                isValid = false;
                System.out.println("Please choose a valid option from the menu!");
                option = -1;
            }
        }
        
        //using a switch is the best solution here
        switch(option)
        {
            case 1:
                RunDensityCalculation();
                break;
            case 2:
                RunEnergyCalculation();
                break;
            case 3:
                RunForceCalculation();
                break;
            case 4:
                RunMomentumCalculation();
                break;
            case 5:
                RunSpeedCalculation();
                break;
            default:
                //we should not hit this anymore, now that we are validating!
                System.out.println("Invalid Input, Program exited!");
                return;
        }
    }
    
    /**
     * Print the menu to allow the user to select a calculation
     * to perform.
     */
    public static void PrintMenu()
    {
        System.out.println(PrintStars(50));
        System.out.println("Which calculation would you like to run:");
        System.out.println("Enter '1' for Density Calculations");
        System.out.println("Enter '2' for Energy Calculations");
        System.out.println("Enter '3' for Force Calculations");
        System.out.println("Enter '4' for Momentum Calculations");
        System.out.println("Enter '5' for Speed Calculations");
        System.out.println(PrintStars(50));
    }
    
    /**
     * Note: Stars function modified to be any number of stars!
     *       StringBuilder!
     * Returns the number of stars specified in a String.
     * @param num the number of stars to append
     * @return the string with the number of stars.
     */
    public static String PrintStars(int num)
    {
        //using the Stringbuilder to make strings
        //with appended characters is far more efficient
        //in memory usage.
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < num; i++)
        {
            sb.append("*");
        }
        return sb.toString();
    }
    
    /**
     * Run the Density Calculation:
     * Note: This program is now modified to use loops for user input
     *       validation.
     */
    public static void RunDensityCalculation()
    {
        String oneUnknown = "Only one variable can be unknown!";
        System.out.println("Welcome to the density calculator!");
        System.out.println("Enter -1 for an unknown value.");
        System.out.println(oneUnknown);
        
        //density = mass / volume
        double mass = -1;
        double volume = -1;
        double density = -1;
        
        mass = GetValidDoubleWithPrompt("Please enter the mass (in kg):");
        
        do
        {
            volume = GetValidDoubleWithPrompt("Please enter the volume "
                + "(in cubic meters):");
            if (mass < 0.0 && volume < 0.0)
            {
                System.out.println(oneUnknown);
            }
        } while (mass < 0.0 && volume < 0.0);
        
        
        if (mass < 0.0 || volume < 0.0)
        {
            do
            {
                density = GetValidDoubleWithPrompt("Please enter the density"
                                + " in kg / m^3");
                System.out.println(oneUnknown);
            } while (density < 0.0);
        }
        
        if (density < 0.0)
        {
            density = mass / volume;
            System.out.printf("The density is %.5f kg/m^3!\n", density);
        }
        else if (mass < 0.0)
        {
            mass = density * volume;
            System.out.printf("The mass is %.5f kg!\n", mass);
        }
        else if (volume < 0.0)
        {
            volume = mass/density;
            System.out.printf("The volume is %.5f m^3!\n", volume);
        }
    }
    
    
    
    /**
     * Run the Energy Calculation:
     */
    public static void RunEnergyCalculation()
    {
        //energy = mass * (the speed of light)^2
        double energy;
        double mass;
        System.out.println("Welcome to the energy calculator!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        input.nextLine();
        energy = mass * Math.pow(theSpeedOfLight, 2.0);
        System.out.printf("The energy is %.5f kg m/ s^2!\n", energy);
    }
    
    /**
     * Run the Force Calculation:
     * CHALLENGE: Fix the force calculator to validate input
     *            as well as to be flexible in the ability
     *            to calculate the equation based on what is unknown.
     */
    public static void RunForceCalculation()
    {
        //force = mass * accelleration
        double mass;
        double accelleration;
        double force;
        System.out.println("Welcome to the force calculator "
                            + "(not the Star Wars Type!)!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        System.out.println("Please enter the accelleration "
                            + "(in meter per second squared):");
        
        accelleration = input.nextDouble();
        input.nextLine();
        force = mass * accelleration;
        System.out.printf("The force is %.5f kg*m/s^2!\n", force);
    }
    
    /**
     * Run the Momentum Calculation:
     */
    public static void RunMomentumCalculation()
    {
        //momentum = mass * velocity
        double mass;
        double velocity;
        double momentum;
        System.out.println("Welcome to the momentum calculator!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        System.out.println("Please enter the velocity (in meters per second):");
        velocity = input.nextDouble();
        input.nextLine();
        momentum = mass * velocity;
        System.out.printf("The momentum is %.5f kg*m/s!\n", momentum);
    }
    
    /**
     * Run the Speed Calculation:
     * CHALLENGE: Fix this to validate input.
     */
    public static void RunSpeedCalculation()
    {
        //speed = distance traveled / time
        Scanner input = new Scanner(System.in);
        double distance;
        double time;
        double speed;
        double result;
        System.out.println("Welcome to the speed calculator!");
        System.out.println("Answer the known values (2 of 3) and enter "
                            + " a negative number for the unknown value");
        System.out.println("Please enter the distance (in miles):");
        distance = input.nextDouble();
        System.out.println("Please enter the time (in hours):");
        time = input.nextDouble();
        if (distance < 0 || time < 0)
        {
            System.out.println("Please enter the speed (miles per hour):");
            speed = input.nextDouble();
        }
        else
        {
            speed = -1;
        }
        if (speed < 0)
        {
            result = distance / time;
            System.out.printf("The speed is %.2f miles/hour!\n", result);
        }
        else if (distance < 0)
        {
            result = speed * time;
            System.out.printf("The number of miles travelled is: %.2f miles\n"
                                , result);
        }
        else if (time < 0)
        {
            result = distance / speed;
            System.out.printf("The time travelled is: %.2f hours\n"
                                , result);
        }
        else
        {
            System.out.println("No calculation for you. Bad input.");
        }
    }
    
    /*********** NEW CONCEPT : OVERLOADED METHODS! ********************/
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidNumber(String checkString)
    {
        return ValidNumber(checkString, false);
    }
    
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidNumber(String checkString
                                        , boolean ignoreDecimalAndHyphen)
    {
        boolean isValid = true;
        //loop on all characters
        for (int i = 0; i < checkString.length(); i++)
        {
            char checkChar = checkString.charAt(i);
            if (ignoreDecimalAndHyphen && (checkChar == 45 || checkChar == 46))
            {
                continue;
            }
            if (checkChar < 48 || checkChar > 57)
            {
                isValid = false;
                System.out.printf("Invalid character in response: %s\n"
                        , checkChar);
                System.out.println("Please enter only numbers");
                break;
            }
        }
        
        //if get to here, all chars are valid
        return isValid;
    }
    
    /**
     * This method will validate a String to see
     *  if it can be parsed as a double
     * @param val the value to parse
     * @return true if can be made into a double, else false;
     */
    private static boolean ValidateDouble(String val)
    {
        return ValidNumber(val, true);
    }
    
    /**
     * This method will prompt until a valid double is entered.
     * @param prompt
     * @return 
     */
    private static double GetValidDoubleWithPrompt(String prompt)
    {
        boolean isValid = false;
        double retVal = 0.0;
        while (!isValid)
        {
            System.out.println(prompt);
            String response = input.nextLine();
            isValid = ValidateDouble(response);
            if (!isValid)
            {
                continue;
            }
            
            retVal = Double.parseDouble(response);
        }
        return retVal;
    }
    
    
    
    
}
