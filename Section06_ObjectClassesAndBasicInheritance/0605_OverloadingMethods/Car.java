/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * Method Signature:
 * 1) Return type
 * 2) Name of the method
 * 3) Parameters #/Type in order
 * 
 */
/**
 *
 * @author Brian
 */
public class Car
{
    private String _make;
    private String _model;
    private int _year;
    private double _miles;
    private double _speed;
    
    //default is always there
    public Car() 
    {
        //do nothing...
    }
    
    //explicit
    /**
     * A new Car with params
     * @param make the make
     * @param model the model
     * @param year the year
     * @param miles the miles
     */
    public Car(String make, String model, int year, double miles)
    {
        this._make = make;
        this._miles = miles;
        this._model = model;
        this._year = year;
        this._speed = 0;
    }
    
    /**
     * A new Car with params
     * @param make the make
     * @param model the model
     * @param year the year
     * @param miles the miles
     */
    public Car(String make, String model, int year, double miles, double speed)
    {
        this._make = make;
        this._miles = miles;
        this._model = model;
        this._year = year;
        this._speed = speed;
    }
    
    
    public String getMake()
    {
        return this._make;
    }
    
    public void setMake(String value)
    {
        this._make = value;
    }
    
    
    public double getMiles()
    {
        return this._miles;
    }
    
    public void setMiles(double value)
    {
        this._miles = value;
    }
    
    
    public String getModel()
    {
        return this._model;
    }
    
    public void setModel(String value)
    {
        this._model = value;
    }
    
    
    public int getYear()
    {
        return this._year;
    }
    
    public void setYear(int value)
    {
        this._year = value;
    }
    
    public double getSpeed()
    {
        return this._speed;
    }
    
    public void setSpeed(double value)
    {
        this._speed = value;
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
    
    public boolean accellerate()
    {
        _speed += 10;
        return true;
    }
    
    public boolean accellerate(int numMPH)
    {
        _speed += numMPH;
        return true;
    }
    
    public double accellerateGetSpeed()
    {
        _speed += 10;
        return this.getSpeed();
    }
    
    public double accellerateGetSpeed(int numMPH)
    {
        _speed += numMPH;
        return this.getSpeed();
    }
}
