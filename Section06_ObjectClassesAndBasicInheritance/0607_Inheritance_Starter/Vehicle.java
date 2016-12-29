/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Vehicle 
{
    private String _make;
    private String _model;
    private int _year;
    private double _miles;
    private double _speed;
    private double _defaultIncrement;
    
    /**
     * Default vehicle Constructor.
     */
    public Vehicle()
    {
        //do nothing.
    }
    
    //explicit
    /**
     * A new Vehicle with params
     * @param make the make
     * @param model the model
     * @param year the year
     * @param miles the miles
     */
    public Vehicle(String make, String model, int year, double miles)
    {
        this._make = make;
        this._miles = miles;
        this._model = model;
        this._year = year;
        this._speed = 0;
    }
    
    /**
     * A new Vehicle with params
     * @param make the make
     * @param model the model
     * @param year the year
     * @param miles the miles
     */
    public Vehicle(String make, String model, int year, double miles
                    , double speed)
    {
        this._make = make;
        this._miles = miles;
        this._model = model;
        this._year = year;
        this._speed = speed;
    }
    
    /**
     * Get the make of the vehicle
     * @return the make as a string
     */
    public String getMake()
    {
        return this._make;
    }
    
    /**
     * Set the make of the vehicle
     * @param value The make of the Vehicle
     */
    public void setMake(String value)
    {
        this._make = value;
    }
    
    /**
     * Get the miles of the vehicle
     * @return the miles as a double
     */
    public double getMiles()
    {
        return this._miles;
    }
    
    /**
     * Set the miles of the vehicle
     * @param value the number of miles for the vehicle
     */
    public void setMiles(double value)
    {
        this._miles = value;
    }
    
    /**
     * Get the model of the vehicle
     * @return the model of the vehicle as a String
     */
    public String getModel()
    {
        return this._model;
    }
    /**
     * Set the model of the vehicle
     * @param value the vehicle model
     */
    public void setModel(String value)
    {
        this._model = value;
    }
    
    /**
     * Get the year
     * @return the year as an integer
     */
    public int getYear()
    {
        return this._year;
    }
    /**
     * Set the year
     * @param value the year of the vehicle 
     */
    public void setYear(int value)
    {
        this._year = value;
    }
    /**
     * Get the speed.
     * @return the speed as a double.
     */
    public double getSpeed()
    {
        return this._speed;
    }
    /**
     * Set the speed.
     * @param value the speed as a double.
     */
    public void setSpeed(double value)
    {
        this._speed = value;
    }
    
    /**
     * Set the default increment.
     * @param value the value for the default increment.
     */
    public void setDefaultIncrement(double value)
    {
        this._defaultIncrement = value;
    }
    
    /**
     * Overrides base toString() on object.
     * @return The string representation of the object.
     */
    public String toString()
    {
        return String.format("Make: %s\tModel: %s\tMiles: %.1f\tYear: %d\t"
                                + "Speed: %.2f Miles Per Hour\n"
                            , this.getMake()
                            , this.getModel()
                            , this.getMiles()
                            , this.getYear()
                            , this.getSpeed());
    }
    
    /**
     * Accelerate the vehicle by default increment
     * @return true on success, else false.
     */
    public boolean accelerate()
    {
        _speed += _defaultIncrement;
        return true;
    }
    
    /**
     * Accelerate by increment
     * @param numMPH the number of mph to increment the speed by.
     * @return true on success, else false.
     */
    public boolean accelerate(int numMPH)
    {
        _speed += numMPH;
        return true;
    }
    
    /**
     * Accelerate by default increment and get the speed.
     * @return the speed after acceleration.
     */
    public double accelerateGetSpeed()
    {
        _speed += _defaultIncrement;
        return this.getSpeed();
    }
    
    /**
     * Accelerate by increment. Get the speed back as a double
     * @param numMPH the speed to accelerate by.
     * @return the speed of the vehicle after acceleration
     */
    public double accelerateGetSpeed(int numMPH)
    {
        _speed += numMPH;
        return this.getSpeed();
    }
}
