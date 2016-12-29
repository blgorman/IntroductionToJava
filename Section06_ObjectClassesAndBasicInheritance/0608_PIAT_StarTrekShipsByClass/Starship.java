/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**`
 *
 * @author Brian
 */
public class Starship 
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

    
}
