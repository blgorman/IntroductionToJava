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
        Car secondCar = new Car("Ford", "Mustang", 2010, 23456.7);
        System.out.println(secondCar);
        System.out.println(Common.Stars(50));
        
        String make = "Chevy";
        String model = "Camaro";
        int year = 2012;
        double miles = 25231.8;
        
        Car thirdCar = new Car(make, model, year, miles);
        System.out.println(thirdCar);
        System.out.println(Common.Stars(50));
        
        Car carFour = new Car("Toyota", "Camry", 2008, 34567.9, 45);
        System.out.println(carFour);
        System.out.println(Common.Stars(50));
        
        //acc car 2
        boolean success = secondCar.accellerate();
        success = thirdCar.accellerate(35);
        double curSpeed = carFour.accellerateGetSpeed();
        curSpeed =carFour.accellerateGetSpeed(45);
        System.out.println(carFour);
        System.out.println(Common.Stars(50));
        
        secondCar.accellerate(45);
        
        System.out.printf("Car 2 is speeding? %b\n"
                , Common.IsSpeeding(secondCar.getSpeed()));
        
        Common.CurrentSpeedLimit = 25;
        System.out.printf("Car 2 is speeding? %b\n"
                , Common.IsCurrentlySpeeding(secondCar.getSpeed()));
        
    }
}
