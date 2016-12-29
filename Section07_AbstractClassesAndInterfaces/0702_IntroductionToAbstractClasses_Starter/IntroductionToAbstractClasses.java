/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoabstractclasses;

import java.util.ArrayList;

/**
 *
 * @author Riker
 */
public class IntroductionToAbstractClasses 
{
    public static void main(String[] args)
    {
        //common objects used throughout:
        Car c = new Car();
        Truck t = new Truck();
        Motorcycle m = new Motorcycle();
        
        //NOTE: Interfaces cannot be instantiated:
        //Vehicle v1 = new Vehicle();
        
        //instead, the TYPE can be used but it has
        //to be instantiated as one of the implementing classes.
        //This is the first step in polymorphism!
        Vehicle v = new Car();
        
        
        //Can you put a truck in a car array?
        //what about a car in a truck array?
        //Where can a motorcycle go?
        Car[] cars = new Car[10];
        cars[0] = c;
        //cars[1] = t;
        //cars[2] = m;
        Truck[] truck = new Truck[10];
        truck[0] = t;
        //truck[1] = c;
        //truck[2] = m;
        Motorcycle[] cycles = new Motorcycle[10];
        cycles[0] = m;
        //cycles[1] = c;
        //cycles[2] = t;
        
        //by using the common interface type, 
        //all "Vehicles" can be stored in a common array:
        //[this is polymorphism in action,
        // where a common type is used as we've
        // "coded to the interface"]
        Vehicle[] vehicles = new Vehicle[10];
        vehicles[0] = c;
        vehicles[1] = t;
        vehicles[2] = m;
        
        //see it in action:
        c.setMake("Ford");
        c.setModel("Mustang GT");
        c.setYear(2013);
        c.setMileage(25.2);
        c.setVIN("1F2352G2359870H13");
        
        t.setMake("Chevy");
        t.setModel("Silverado");
        t.setYear(2012);
        t.setMileage(16725.2);
        t.setVIN("1C8265C9376835R26");
        
        m.setMake("Kawasaki");
        m.setModel("Ninja");
        m.setYear(1992);
        m.setMileage(23582.2);
        m.setVIN("3GWN218923SENRL");
        
        //enhanced for iteration of the vehicle array
        for (Vehicle veh : vehicles)
        {
            if (veh == null) break;
            System.out.printf("Vehicle| Make: %s\tModel: %s\n"
                    , veh.getMake()
                    , veh.getModel());
        }
        
        //or ArrayList
        ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
        allVehicles.add(c);
        allVehicles.add(t);
        allVehicles.add(m);
        
        for (Vehicle veh : allVehicles)
        {
            System.out.println(veh.toString());
        }
    }
}
