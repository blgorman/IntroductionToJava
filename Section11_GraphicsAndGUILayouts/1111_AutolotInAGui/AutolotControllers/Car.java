package AutolotControllers;

import java.io.Serializable;

/**
 * A Car.
 * @author Brian
 */
public class Car extends VehicleBase implements Serializable
{
    private final String internalType = Common.CARTYPE;
    private final double minSpeed = 0.0;
    private final double maxSpeed = 1000.0;
    private double topSpeed;
    /**
     * The default constructor.
     * Must be coded to be present when the explicit constructor is coded.
     */
    public Car()
    {
        //the super call must be the first call in the subclass constructor.
        super();
    }
    
    public Car(String makeValue, String modelValue
                        , int yearValue, double milesValue
                        , String vinValue)
    {
        //call to the super explicit constructor
        //to instantiate the object correctly
        super(makeValue, modelValue, yearValue
                , milesValue, vinValue);
    }
    
    /**
     * For testing, we need access to the determining type.
     */
    public String getInternalType()
    {
        return internalType;
    }
    
    /**
     * Top Speed accessor method.
     */
    public double getTopSpeed()
    {
        return topSpeed;
    }
    
    /**
     * Top Speed mutator method.
     * @param value the new value for the top Speed.
     */
    public void setTopSpeed(double value)
    {
        if (value < minSpeed || value > maxSpeed)
        {
            throw new IllegalArgumentException();
        }
        topSpeed = value;
    }
    
    /**
     * Returns a String representing the state of the Car.
     * @return String representing the car object
     */
    public String toString()
    {
        return String.format("Type = %s\tTop Speed: %.2f\t%s"
                                , this.internalType
                                , this.getTopSpeed()
                                , super.toString());
    }
}