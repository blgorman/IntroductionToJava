import java.util.*;

/**
 * Calculate Force.
 * @author Brian
 */
public class ForceCalculator {

    //force = mass * acceleration
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double mass;
        double acceleration;
        double force;
        System.out.println("Welcome to the force calculator "
                            + "(not the Star Wars Type!)!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        System.out.println("Please enter the acceleration "
                            + "(in meters per second squared):");
        
        acceleration = input.nextDouble();
        force = mass * acceleration;
        System.out.printf("The force is %.5f kg*m/s^2!\n", force);
        input.close();
    }
    
}
