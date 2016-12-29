
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class NonSerializableDoctor extends NonSerializablePerson 
                            implements Comparable {
    String specialty;
    /**
     * Default Constructor.
     */
    public NonSerializableDoctor()
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
    public NonSerializableDoctor(String firstName, String lastName, int age, String spec)
    {
        super(firstName, lastName, age);
        if (spec == null || spec.equals(""))
        {
            throw new IllegalArgumentException();
        }
        ValidateSpecialty(spec);
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
        if (value == null || value.equals(""))
        {
            throw new IllegalArgumentException();
        }
        ValidateSpecialty(value);
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
        return Common.nullSafeEquals(this.getSpecialty(), d.getSpecialty());
    }
    
    /**
     * Validate specialty is an acceptable specialty.
     * If not, throw a custom exception
     */
    private void ValidateSpecialty(String specialty)
    {
        String specialties = "aaaaa;zzzzz;physician;surgeon;anesthesiologist;dentist";
        if (!specialties.contains(specialty.toLowerCase()))
        {
            throw new DoctorSpecialtyException("Make sure the doctor has"
                    + " a valid specialty.");
        }
    }
}
