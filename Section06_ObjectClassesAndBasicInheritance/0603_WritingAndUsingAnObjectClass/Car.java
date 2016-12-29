/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
}
