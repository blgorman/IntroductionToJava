import java.util.*;

/**
 * Calculate Density.
 * @author Brian
 */
public class DensityCalculator {
    //density = mass / volume
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double mass;
        double volume;
        double density;
        System.out.println("Welcome to the density calculator!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        System.out.println("Please enter the volume (in cubic meters):");
        volume = input.nextDouble();
        density = mass / volume;
        System.out.printf("The density is %.5f kg/m^3!\n", density);
        input.close();
    }
}
