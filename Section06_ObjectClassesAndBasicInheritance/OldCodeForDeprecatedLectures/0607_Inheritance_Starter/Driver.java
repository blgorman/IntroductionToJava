/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Driver 
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the auto lot!");
        
        Vehicle[] myVehicles = new Vehicle[5];
        Car[] myCars = new Car[5];
        
        Vehicle myFirstCar = new Vehicle("Oldsmobile", "Cutlass", 1978, 83500.2);
        Vehicle mySecondCar = new Vehicle("Pontiac", "Grand Am", 1987, 102500.7);
        
        Car myThirdCar = new Car("Ford", "Mustang", 2010, 23456.7, "Blue");
        String make = "Chevy";
        String model = "Camaro";
        int year = 2012;
        double miles = 25231.8;
        Car myFourthCar = new Car(make, model, year, miles, "Yellow");
        Car myFifthCar = new Car("Toyota", "Camry", 2008, 34567.9, 45, "Green");
        
        
        /*
        boolean success = mySecondCar.accelerate();
        success = myThirdCar.accelerate(35);
        double curSpeed = myFourthCar.accelerateGetSpeed();
        curSpeed =myFourthCar.accelerateGetSpeed(45);
        System.out.println(myFourthCar);
        System.out.println(Common.Stars(50));
        
        mySecondCar.accelerate(45);
        
        System.out.printf("Car 2 is speeding? %b\n"
                , Common.IsSpeeding(mySecondCar.getSpeed()));
        
        Common.CurrentSpeedLimit = 25;
        System.out.printf("Car 2 is speeding? %b\n"
                , Common.IsCurrentlySpeeding(mySecondCar.getSpeed()));
        */
    }
}
