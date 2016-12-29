/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package introductiontointerfaces;

/**
 *
 * @author Brian
 */
public class Motorcycle implements Vehicle
{
    private String make;
    private String model;
    private int year;
    private double miles;
    private String VIN;
    
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
        this.VIN = value;
    }
    
    /**
     * The String representation of the Car
     * @return String Car
     */
    public String toString()
    {
        return String.format("Type = Motorcycle\tMake: %s\t"
                + "Model: %s\tYear: %d\t"
                + "Miles: %.1f\tVIN: %s\n"
                , this.getMake()
                , this.getModel()
                , this.getYear()
                , this.getMileage()
                , this.getVIN());
    }
}
