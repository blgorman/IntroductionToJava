import java.util.*;

/**
 * Calculate Speed.
 * @author Brian
 */
public class SpeedCalculator {
    //speed = distance traveled / time
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double distance;
        double time;
        double speed;
        System.out.println("Welcome to the speed calculator!");
        System.out.println("Please enter the distance (in miles):");
        distance = input.nextDouble();
        System.out.println("Please enter the time (in hours):");
        time = input.nextDouble();
        speed = distance / time;
        System.out.printf("The speed is %.2f miles/hour!\n", speed);
        input.close();
    }
}
