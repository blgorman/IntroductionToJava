import java.util.*;
/**
 *
 * @author Brian
 */
public class SimplePhysicsCalculator {
    final static double theSpeedOfLight = 299792458.00; //m/s
    public static Scanner input;
    
    public static void main(String[] args)
    {
        //welcome the user
        System.out.println("Welcome to the new Physics Calculator!");
        //run it:
        RunSPC();
        
        //ask if want to run another
        System.out.println("Would you like to run another calculation [y/n]?");
        String runAgain = input.nextLine();
        if (!runAgain.toUpperCase().contains("Y"))
        {
            return;
        }
        RunSPC();
        
        //could keep asking...?
    }
    
    /**
     * Run the menu and choice selection to drive the SPC.
     */
    public static void RunSPC()
    {
        PrintMenu();
        input = new Scanner(System.in);
        int option = input.nextInt();
        input.nextLine();//clear the buffer to next line
        
        //using a switch is the best option here
        //-- this is just if/else condensed into 
        //a more efficient form.
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
        System.out.println(PrintStars());
        System.out.println("Which calculation would you like to run:");
        System.out.println("Enter '1' for Density Calculations");
        System.out.println("Enter '2' for Energy Calculations");
        System.out.println("Enter '3' for Force Calculations");
        System.out.println("Enter '4' for Momentum Calculations");
        System.out.println("Enter '5' for Speed Calculations");
        System.out.println(PrintStars());
    }
    
    public static String PrintStars()
    {
        return "*********************************************************";
    }
    
    /**
     * Run the Density Calculation:
     */
    public static void RunDensityCalculation()
    {
        //density = mass / volume
        double mass;
        double volume;
        double density;
        System.out.println("Welcome to the density calculator!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        System.out.println("Please enter the volume (in cubic meters):");
        volume = input.nextDouble();
        input.nextLine();
        density = mass / volume;
        System.out.printf("The density is %.5f kg/m^3!\n", density);
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
}
