/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class Doctor extends Person implements Comparable {
    String specialty;
    
    /**
     * Default Constructor.
     */
    public Doctor()
    {
        //do nothing.
    }
    
    /**
     * An explicit constructor for Doctor.
     * @param firstName first name.
     * @param lastName last name
     * @param age age
     * @param spec specialty
     */
    public Doctor(String firstName, String lastName, int age, String spec)
    {
        super(firstName, lastName, age);
        this.specialty = spec;
    }
    
    /**
     * Get the specialty
     * @return the specialty
     */
    public String getSpecialty()
    {
        return specialty;
    }
    
    /**
     * Set the specialty
     * @param value the specialty
     */
    public void setSpecialty(String value)
    {
        specialty = value;
    }
    
    /**
     * Print the doctor as a string
     * @return 
     */
    public String toString()
    {
        return String.format("%s\tSpecialty: %s\n"
                            , super.toString()
                            , this.getSpecialty());
    }
    
    /**
     * Compare one doctor to another.
     * @param obj
     * @return 
     */
    public int compareTo(Object obj)
    {
        int compareValue = super.compareTo(obj);
        //if super compare comes back not = 0 then use it.
        if (compareValue != 0)
        {
            return compareValue;
        }
        
        //make sure it's a doctor
        if (!(obj instanceof Doctor))
        {
            return 1;
        }
        
        //now compare specialty
        Doctor d = (Doctor)obj;
        if (d.getSpecialty() == null && this.getSpecialty() != null)
        {
            return 1;
        }
        else if (this.getSpecialty() == null && d.getSpecialty() != null)
        {
            return -1;
        }
        //get the value
        compareValue = this.getSpecialty().compareTo(d.getSpecialty());
        
        //make sure value is -1/0/1
        if (compareValue < -1)
        {
            compareValue = -1;
        }
        else if (compareValue > 1)
        {
            compareValue = 1;
        }
        return compareValue;
    }
    
    /**
     * Override the equality
     * @param obj the object to compare
     * @return 
     */
    public boolean equals(Object obj)
    {
        if (!super.equals(obj))
        {
            return false;
        }
        
        if (!(obj instanceof Doctor))
        {
            return false;
        }
        
        Doctor d = (Doctor)obj;
        return nullSafeEquals(this.getSpecialty(), d.getSpecialty());
    }
}
