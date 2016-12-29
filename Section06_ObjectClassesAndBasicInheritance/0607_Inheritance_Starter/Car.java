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
    private String _color;
    
    //default is always there
    public Car() 
    {
        //do nothing...
    }
    
    //explicit constructor
    
    
    /**
     * Return the color.
     * @return the color as a String
     */
    public String getColor()
    {
        return _color;
    }
    /**
     * Set the color.
     * @param value the value to set as a color.
     */
    public void setColor(String value)
    {
        _color = value;
    }
    
    /**
     * Return the car object as a String
     * @return the string representing the car.
     */
    public String toString()
    {
        return String.format("%s\n", getColor());
    }
}
