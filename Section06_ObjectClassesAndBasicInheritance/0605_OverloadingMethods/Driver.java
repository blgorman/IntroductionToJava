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
        /*
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
        System.out.println(userCar);
        */
        
        Car secondCar = new Car("Ford", "Mustang", 2010, 23456.7);
        System.out.println(secondCar);

        String make = "Chevy";
        String model = "Camaro";
        int year = 2012;
        double miles = 25231.8;
        
        Car thirdCar = new Car(make, model, year, miles);
        System.out.println(thirdCar);
        
        Car carFour = new Car("Toyota", "Camry", 2008, 34567.9, 45);
        System.out.println(carFour);
        
        //acc car 2
        boolean success = secondCar.accellerate();
        System.out.println(secondCar);

        success = secondCar.accellerate(35);
        System.out.println(secondCar);

        double curSpeed = carFour.accellerateGetSpeed();
        System.out.println(carFour);

        curSpeed =carFour.accellerateGetSpeed(45);
        System.out.println(carFour);

    }
}
