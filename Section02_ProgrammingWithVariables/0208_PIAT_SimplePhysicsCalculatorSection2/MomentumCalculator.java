import java.util.*;

/**
 * Calculate Momentum
 * @author Brian
 */
public class MomentumCalculator {
    //momentum = mass * velocity
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double mass;
        double velocity;
        double momentum;
        System.out.println("Welcome to the momentum calculator!");
        System.out.println("Please enter the mass (in kg):");
        mass = input.nextDouble();
        System.out.println("Please enter the velocity (in meters per second):");
        velocity = input.nextDouble();
        momentum = mass * velocity;
        System.out.printf("The momentum is %.5f kg*m/s!\n", momentum);
        input.close();
    }
}
