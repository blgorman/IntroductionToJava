/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Brian
 */
public class Driver {

    public static void main(String[] args)
    {
        System.out.println("We're creating a new car:");
        Scanner in = new Scanner(System.in);
        
        Car userCar = new Car();
        
        System.out.println("What is the make of the car?");
        userCar.setMake(in.nextLine());
        
        System.out.println("What is the model of the car?");
        userCar.setModel(in.nextLine());
        
        System.out.println("What is the miles of the car?");
        userCar.setMiles(Double.parseDouble(in.nextLine()));
        
        System.out.println("What is the year of the car?");
        userCar.setYear(Integer.parseInt(in.nextLine()));
        
        //using Object as our base --> toString();
        //System.out.println(userCar);
        System.out.printf("Make: %s\tModel: %s\tMiles: %.1f\tYear: %d\n"
                            , userCar.getMake()
                            , userCar.getModel()
                            , userCar.getMiles()
                            , userCar.getYear());
        
        
        Car secondCar = new Car("Ford", "Mustang", 2010, 23456.7);
        System.out.printf("Make: %s\tModel: %s\tMiles: %.1f\tYear: %d\n"
                            , secondCar.getMake()
                            , secondCar.getModel()
                            , secondCar.getMiles()
                            , secondCar.getYear());
        
        String make = "Chevy";
        String model = "Camaro";
        int year = 2012;
        double miles = 25231.8;
        Car thirdCar = new Car(make, model, year, miles);
        System.out.printf("Make: %s\tModel: %s\tMiles: %.1f\tYear: %d\n"
                            , thirdCar.getMake()
                            , thirdCar.getModel()
                            , thirdCar.getMiles()
                            , thirdCar.getYear());
    }
}
