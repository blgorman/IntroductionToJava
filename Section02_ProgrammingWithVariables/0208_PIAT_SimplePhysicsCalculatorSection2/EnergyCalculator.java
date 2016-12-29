import java.util.*;

/**
 * Calculate Energy.
 * @author Brian
 */
public class EnergyCalculator {
    //energy = mass * (the speed of light)^2
    final static double theSpeedOfLight = 299792458.00; //m/s
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double energy;
        double mass;
        System.out.println("Welcome to the energy calculator!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        
        energy = mass * Math.pow(theSpeedOfLight, 2.0);
        
        System.out.printf("The energy is %.5f kg m/ s^2!\n", energy);
        input.close();
    }
}
