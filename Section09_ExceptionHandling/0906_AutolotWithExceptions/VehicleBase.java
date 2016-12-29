/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public abstract class VehicleBase implements Vehicle
{
    private String make;
    private String model;
    private int year;
    private double miles;
    private String VIN;
    private double fuel;
    private final int minYear = 1900;
    private final int maxYear = 2100;
    private final double minMileage = 0.0;
    private final double maxMileage = 5000000.0;
    private final double minFuel = 0.0;
    private final double maxFuel = 18.0;
    
    //default constructor
    public VehicleBase()
    {
        //do nothing
    }
    
    /**
     * The Explicit constructor, which overloads the default constructor.
     * This allows us to set properties of any VehicleBase object
     * at construction.
     * @param makeValue the make of the vehicle
     * @param modelValue the model of the vehicle
     * @param yearValue the year of the vehicle
     * @param milesValue the miles on the vehicle
     * @param vinValue the VIN for the vehicle
     */
    public VehicleBase(String makeValue, String modelValue
                        , int yearValue, double milesValue
                        , String vinValue)
    {
        //set the parameters using the set methods
        //this will mean we only need to have all the 
        //exceptions in one place.
        this.setMake(makeValue);
        this.setModel(modelValue);
        this.setYear(yearValue);
        this.setMileage(milesValue);
        this.setVIN(vinValue);
        this.setFuel(0.0);
    }
    
    /**
     * Gets the make of the vehicle
     * @return String make
     */
    public String getMake()
    {
        return this.make;
    }
    
    /**
     * Set the make of the vehicle
     * @param value the make of the vehicle.
     */
    public void setMake(String value)
    {
        if (value == null || value.equals(""))
        {
            throw new IllegalArgumentException("Make cannot be "
                    + "null or empty.");
        }
        this.make = value;
    }
    
    /**
     * Get the model of the vehicle
     * @return String model
     */
    public String getModel()
    {
        return this.model;
    }
    
    /**
     * Set the model of the vehicle
     * @param value 
     */
    public void setModel(String value)
    {
        if (value == null || value.equals(""))
        {
            throw new IllegalArgumentException("Model cannot be "
                    + "null or empty.");
        }
        this.model = value;
    }
    
    /**
     * Get the year of the vehicle
     * @return int year 
     */
    public int getYear()
    {
        return this.year;
    }
    
    /**
     * Set the year of the vehicle
     * @param value the year of the vehicle
     */
    public void setYear(int value)
    {
        if (value < minYear || value > maxYear)
        {
            throw new IllegalArgumentException(String.format(
                    "value must be a year between %d and %d"
                    , minYear
                    , maxYear));
        }
        this.year = value;
    }
    
    /**
     * Get the mileage of the vehicle
     * @return 
     */
    public double getMileage()
    {
        return this.miles;
    }
    
    /**
     * Set the mileage of the vehicle
     * @param value the mileage of the vehicle
     */
    public void setMileage(double value)
    {
        if (value < minMileage || value > maxMileage)
        {
            throw new IllegalArgumentException(String.format(
                    "value must be a year between %d and %d"
                    , minMileage
                    , maxMileage));
        }
        this.miles = value;
    }
    
    /**
     * Get the VIN of the vehicle
     * @return String VIN
     */
    public String getVIN()
    {
        return this.VIN;
    }
    
    /**
     * Set the VIN of the vehicle
     * @param value 
     */
    public void setVIN(String value)
    {
        if (value == null || value.equals(""))
        {
            throw new IllegalArgumentException("VIN cannot be "
                    + "null or empty.");
        }
        this.VIN = value;
    }
    
    /**
     * Get the amount of fuel in vehicle.
     * @return gallons of fuel
     */
    public double getFuel()
    {
        return this.fuel;
    }
    /**
     * Set the amount of fuel in the vehicle.
     * @param value the amount of fuel.
     */
    public void setFuel(double value)
    {
        if (value < minFuel || value > maxFuel)
        {
            throw new IllegalArgumentException("Add a valid amount of fuel");
        }
        this.fuel = value;
    }
    
    /**
     * The String representation of the Car
     * @return String Car
     */
    public String toString()
    {
        return String.format("Make: %s\t"
                + "Model: %s\tYear: %d\t"
                + "Miles: %.1f\tVIN: %s\t"
                + "Fuel: %.1f\t\n"
                , this.getMake()
                , this.getModel()
                , this.getYear()
                , this.getMileage()
                , this.getVIN()
                , this.getFuel());
    }
    
    
    /**
     * Drive it.
     */
    public String Drive()
    {
        if (this.getFuel() <= minFuel + 1.0)
        {
            throw new MustRefuelException("Your vehicle is out of gas.");
        }
        this.fuel = this.fuel - 1.0;
        return "Your vehicle is now driving...1 gallon of fuel used.";
    }
    
    /*#TODO: To make our system more robust, we should add equality
     *       and comparability. */
}
