/**`
 * A Starship.
 * @author Brian
 */
public class Starship implements Comparable
{
    private String _starshipClass;
    private Commander _commander;
    private String _designation;
    private String _name;
    
    //adding weaponry and propulsion objects
    private PropulsionBehavior _propulsionMethod;
    private WeaponBehavior _primaryWeapon;
    private WeaponBehavior _secondaryWeapon;
    
    
    //we could set default behaviors for the object
    //like phasers as primary weapon and warp as propulsion
    
    /**
     * Default Constructor.
     */
    public Starship()
    {
        //do nothing.
        _propulsionMethod = new WarpDrivePropulsion();
        _primaryWeapon = new PhaserWeaponry();
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
        _propulsionMethod = new WarpDrivePropulsion();
        _primaryWeapon = new PhaserWeaponry();
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
    
    //add properties to allow interchanging the behaviors for the
    //propulsion and weaponry.
    /**
     * Get the method of propulsion for this ship.
     * @return the propulsion method.
     */
    public PropulsionBehavior getPropulsionBehavior()
    {
        return this._propulsionMethod;
    }
    
    /**
     * Set the method of propulsion for this ship.
     * @param pb 
     */
    public void setPropulsionBehavior(PropulsionBehavior pb)
    {
        this._propulsionMethod = pb;
    }
    
    /**
     * Get the Primary Weaponry.
     * @return the Primary weaponry.
     */
    public WeaponBehavior getPrimaryWeaponry()
    {
        return this._primaryWeapon;
    }
    
    /**
     * Set the Primary Weaponry.
     * @param wb the new Primary Weaponry.
     */
    public void setPrimaryWeaponry(WeaponBehavior wb)
    {
        this._primaryWeapon = wb;
    }
    
    /**
     * Get the Secondary Weaponry.
     * @return the Secondary weaponry.
     */
    public WeaponBehavior getSecondaryWeaponry()
    {
        return this._secondaryWeapon;
    }
    
    /**
     * Set the Primary Weaponry.
     * @param wb the new Primary Weaponry.
     */
    public void setSecondaryWeaponry(WeaponBehavior wb)
    {
        this._secondaryWeapon = wb;
    }
    
    //Of course changing the details of the ship means
    //we also need to modify toString(), compareTo, and equality.
    
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
                                + "Propulsion: \n\t%s for %d clicks\n"
                                + "Primary Weaponry: \n\t%s\n"
                                + "Secondary Weaponry: \n\t%s\n"
                                , getStarshipClass()
                                , getCommander()
                                , getDesignation()
                                , getName()
                                , getPropulsionBehavior().flightOperation()
                                , getPropulsionBehavior().movementDistance()
                                , (getPrimaryWeaponry() == null 
                                    ? "This ship is defenseless..." 
                                    : getPrimaryWeaponry().weaponryDetails())
                                , (getSecondaryWeaponry() == null 
                                    ? "No secondary Weaponry" 
                                    : getSecondaryWeaponry().weaponryDetails()));
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
                    //if you want to take propulsion/weaponry into account
                    //you could do that here.
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
        
        //one final [advanced] note: Use the properties most likely to be unequal first
        //in this way, you can limit the processing as the statement will return
        //false once any of the statements are encountered that are false without
        //having to execute the rest.
        
        //for simplicity, lets say that ships are equal regardless
        //of weaponry.
        return this.getDesignation().equals(s.getDesignation())
                && this.getName().equals(s.getName())
                && this.getStarshipClass().equals(s.getStarshipClass())
                && this.getCommander().equals(s.getCommander())
                && this.getPropulsionBehavior().getClass().equals
                    (s.getPropulsionBehavior().getClass()
                );
    }
}
