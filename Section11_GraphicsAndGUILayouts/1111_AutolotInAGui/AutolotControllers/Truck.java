package AutolotControllers;

import java.io.Serializable;
/**
 * A Truck.
 * @author Brian
 */
public class Truck extends VehicleBase implements FourWheelDrive, Serializable
{
    private boolean isFWD = false;
    
    /**
     * Default Constructor.
     */
    public Truck()
    {
    
    }
    
    /**
     * Explicit Constructor.
     * @param make make of the truck
     * @param model model of the truck
     * @param year year of the truck
     * @param miles miles on the truck
     * @param VIN the ID Of the truck
     * @param isFWD set fwd value of the truck
     */
    public Truck(String make, String model, int year, double miles
                    , String VIN, boolean isFWD)
    {
        super(make, model, year, miles, VIN);
        toggleFourWheelDrive(isFWD);
    }
    
    /**
     * ToString.
     * @return String representing a truck.
     */
    public String toString()
    {
        return String.format("Type = %s\tIs FWD: %b\t%s"
                                , Common.TRUCKTYPE
                                , this.isFourWheelDrive()
                                , super.toString());
    }

    /**
     * Mutate the four wheel drive value
     * @param value true or false for isFWD
     */
    public void toggleFourWheelDrive(boolean value)
    {
        isFWD = value;
    }
    
    /**
     * Get the four wheel drive value
     * @return true if is FWD, else false.
     */
    public boolean isFourWheelDrive()
    {
        return this.isFWD;
    }
}

