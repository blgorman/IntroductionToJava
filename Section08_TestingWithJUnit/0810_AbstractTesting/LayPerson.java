/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class LayPerson extends Person implements Comparable  {

    /**
     * Default Constructor.
     */
    public LayPerson()
    {
        //default constructor
        super();
    }
    
    /**
     * Explicit constructor.
     * @param firstName
     * @param lastName
     * @param age 
     */
    public LayPerson(String firstName, String lastName, int age)
    {
        super(firstName, lastName, age);
    }
    
    /**
     * Compare to.
     * @param obj
     * @return 
     */
    public int compareTo(Object obj)
    {
        return super.compareTo(obj);
    }
    
    /**
     * Equality.
     * @param obj
     * @return 
     */
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }
}
