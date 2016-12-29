/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Commander extends Person
{
    private String _rank;
    private String _serialNumber;
    
    /**
     * Default Constructor.
     */
    public Commander()
    {
        //do nothing
    }
    
    /**
     * Explicit Constructor.
     * @param name  Commander name
     * @param rank Commander rank
     * @param serial Commander serial
     */
    public Commander(String name, int age, String rank, String serial)
    {
        //leverage the base class Person
        super(name, age);
        _rank = rank;
        _serialNumber = serial;
    }
    
    /**
     * Get the rank of the commander.
     * @return the rank as a String
     */
    public String getRank()
    {
        return _rank;
    }
    
    /**
     * Set the rank of the commander.
     */
    public void setRank(String value)
    {
        _rank = value;
    }
    
    /**
     * Get the serial number of the commander.
     * @return the serial number as a String
     */
    public String getSerialNumber()
    {
        return _serialNumber;
    }
    
    /**
     * Set the serial number of the commander.
     */
    public void setSerialNumber(String value)
    {
        _serialNumber = value;
    }
    
    /**
     * The commander as a String.
     * @return the commander object as a String
     */
    public String toString()
    {
        return String.format("%s\tRank: %s\tSerialNumber: %s"
                                , super.toString()
                                , getRank()
                                , getSerialNumber());
    }
}
