/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Commander extends Person implements Comparable
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
    public Commander(String firstName, String lastName
                        , int age, String rank, String serial)
    {
        //leverage the base class Person
        super(firstName, lastName, age);
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

    /**
     * Compare this commander to another commander
     * @param o the object to compare to
     * @return -1 if less than, 0 if equal, 1 if greater
     */
    public int compareTo(Object o) 
    {
        //leverage the superclass compare to
        //if not equal, just return it.
        int compareToResult = super.compareTo(o);
        
        if (compareToResult == 0)
        {
            //make sure o is a Commander (not just any person)
            if (!(o instanceof Commander))
            {
                return 1;
            }
            Commander c = (Commander)o;
            
            //if they are equal, compare by rank, then serial
            //make sure both ranks are set
            if (c.getRank() == null && this.getRank() != null)
            {
                return 1;
            }
            else if(this.getRank() == null && c.getRank() != null)
            {
                return -1; 
            }
            compareToResult = this.getRank().compareTo(c.getRank());
            if (compareToResult == 0)
            {
                if (c.getSerialNumber() == null 
                        && this.getSerialNumber() != null)
                {
                    return 1;
                }
                else if (this.getSerialNumber() == null
                            && c.getSerialNumber() != null)
                {
                    return -1;
                }
                compareToResult = this.getSerialNumber().compareTo(
                                    c.getSerialNumber());
            }
        }
        if (compareToResult > 1)
        {
            compareToResult = 1;
        }
        else if (compareToResult < -1)
        {
            compareToResult = -1;
        }
        return compareToResult;
    }
    
    /**
     * Override the default equals method to check if one
     *    commander is equal to another commander.
     * @param obj the object to compare for equality.
     * @return true if the objects are equal, otherwise false.
     */
    public boolean equals(Object obj)
    {
        //first, make sure objects are equal at the base
        //which also handles null and type for person check
        boolean baseResult = super.equals(obj);
        if (!baseResult)
        {
            return false;
        }
        
        //next, make sure it's a commander, and not just any old person
        if (!(obj instanceof Commander))
        {
            return false;
        }
        
        //cast and compare specific properties for equality:
        Commander c = (Commander)obj;
        return (this.getSerialNumber().equals(c.getSerialNumber())
                && this.getRank().equals(c.getRank()));
    }
}
