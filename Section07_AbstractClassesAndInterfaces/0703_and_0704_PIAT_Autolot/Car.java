/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A Car.
 * @author Brian
 */
public class Car extends VehicleBase
{
    private final String internalType = "CAR";
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
     * Returns a String representing the state of the Car.
     * @return String representing the car object
     */
    public String toString()
    {
        return String.format("Type = %s\t%s"
                                , this.internalType
                                , super.toString());
    }
}