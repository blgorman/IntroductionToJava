/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**`
 *
 * @author Brian
 */
public class Starship implements Comparable
{
    private String _starshipClass;
    private Commander _commander;
    private String _designation;
    private String _name;
    
    /**
     * Default Constructor.
     */
    public Starship()
    {
        //do nothing.
    }
    
    /**
     * Explicit Constructor.
     * @param sClass the starship class type
     * @param cmdr the commander
     * @param desig the ship's designation
     * @param name the name of the ship
     */
    public Starship(String sClass, Commander cmdr, String desig, String name)
    {
        _starshipClass = sClass;
        _commander = cmdr;
        _designation = desig;
        _name = name;
    }
    
    /**
     * Get the class of the starship.
     * @return the class as the string
     */
    public String getStarshipClass()
    {
        return _starshipClass;
    }
    
    /**
     * Set the Starship class.
     * @param value The class of the ship
     */
    public void setStarshipClass(String value)
    {
        _starshipClass = value;
    }
    
    /**
     * Get the commander of the ship.
     * @return The commander.
     */
    public Commander getCommander()
    {
        return _commander;
    }
    /**
     * Set the commander of the ship.
     * @param value the Commander of the ship.
     */
    public void setCommander(Commander value)
    {
        _commander = value;
    }
    
    /**
     * Get the designation of the ship.
     * @return 
     */
    public String getDesignation()
    {
        return _designation;
    }
    /**
     * Set the designation of the ship.
     * @param value the ship designation.
     */
    public void setDesignation(String value)
    {
        _designation = value;
    }
    
    /**
     * Get the name of the starship.
     * @return 
     */
    public String getName()
    {
        return _name;
    }
    /**
     * Set the name of the starship
     * @param value The starship name
     */
    public void setName(String value)
    {
        _name = value;
    }
    
    /**
     * Get the starship as a String
     * @return a String representing the Starship 
     */
    public String toString()
    {
        return String.format("Starship Class: \n\t%s\n"
                                + "Starship Commander: \n\t%s\n"
                                + "Designation: \n\t%s\n"
                                + "Name: \n\t%s\n"
                                , getStarshipClass()
                                , getCommander()
                                , getDesignation()
                                , getName());
    }

    /**
     * Compare starships by name, then class, then designation.
     * @param o the object to compare to
     * @return -1 if less than o, 0 if equal to o, 1 if greater than o
     */
    public int compareTo(Object o) {
        if (o == null)
        {
            //greater than null
            return 1;
        }
        if (!(o instanceof Starship))
        {
            //greater than other object
            return 1;
        }
        //now set the type and compare by name, class, and designation
        Starship s = (Starship)o;
        int compareResult = this.getName().compareTo(s.getName());
        if (compareResult == 0)
        {
            compareResult = this.getStarshipClass().compareTo(
                    s.getStarshipClass());
            
            if (compareResult == 0)
            {
                compareResult = this.getDesignation().compareTo(
                        s.getDesignation());
                if (compareResult == 0)
                {
                    compareResult = this.getCommander().compareTo(
                            s.getCommander());
                            
                }
            }
        }
        return compareResult;
    }

    /**
     * Override the default equals method to check if one
     *    starship is equal to another starship.
     * @param obj the object to compare for equality.
     * @return true if the objects are equal, otherwise false.
     */
    public boolean equals(Object obj)
    {
        //remember the first two checks: null && type equality:
        if (obj == null || !(obj instanceof Starship))
        {
            return false;
        }
        
        //then cast the incoming object to the correct type so can
        //get to its properties:
        Starship s = (Starship)obj;
        
        //next, ask yourself: what makes a starship equal?
        //then write the equality checks.
        //remember that if you rely on .equals() for a complex type
        //it must also override equality (i.e. Commander)
        
        //one final [advanced] note: Use the ones most likely to be unequal first
        //in this way, you can limit the processing as the statement will return
        //false once any of the statements are encountered that are false without
        //having to execute the rest.
        return this.getDesignation().equals(s.getDesignation())
                && this.getName().equals(s.getName())
                && this.getStarshipClass().equals(s.getStarshipClass())
                && this.getCommander().equals(s.getCommander());
    }
}
