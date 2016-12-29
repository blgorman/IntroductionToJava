/**
 * A Person.
 * @author Brian
 */
public class Person implements Comparable
{
    private String _firstName;
    private String _lastName;
    private int _age;

    /**
     * Person default constructor.
     */
    public Person()
    {
        //do nothing.
    }
    
    /**
     * Person explicit constructor.
     * @param name The name of the person.
     * @param age The age of the person.
     */
    public Person(String firstName, String lastName, int age)
    {
        _firstName = firstName;
        _lastName = lastName;
        _age = age;
    }
    
    /**
     * Get the person's First name.
     * @return the first name as a String
     */
    public String getFirstName()
    {
        return _firstName;
    }
    /**
     * Set the person's First name.
     * @param value the first name as a String
     */
    public void setFirstName(String value)
    {
        _firstName = value;
    }
    
    /**
     * Get the person's Last name.
     * @return the last name as a String
     */
    public String getLastName()
    {
        return _lastName;
    }
    
    /**
     * Set the person's Last name.
     * @param value the last name as a String
     */
    public void setLastName(String value)
    {
        _lastName = value;
    }
    
    /**
     * Get the age of the person.
     * @return the age of the person.
     */
    public int getAge()
    {
        return _age;
    }
    /**
     * Set the age of the person.
     * @param value the age of the person.
     */
    public void setAge(int value)
    {
        _age = value;
    }
    
    /**
     * Get the person as a string
     * @return the person as a String.
     */
    public String toString()
    {
        return String.format("Name: %s %s\tAge: %d"
                                , getFirstName()
                                , getLastName()
                                , getAge());
    }

    /**
     * override comparable so can compare person objects for sorting.
     * @param o -- the object to compare this person to
     * @return -1 if less than, 0 if equal, 1 if greater than
     */
    public int compareTo(Object o) {
        //First, make sure incoming object is not null
        if (o == null)
        {
            //greater than null
            return 1;
        }
        //next, make sure the incoming object is actually a Person
        if (!(o instanceof Person))
        {
            //greater than another type
            return 1;
        }
       
        //if we make it here, we know o is a person, so levage that:
        Person p = (Person)o;
        int comparedValue = this.getLastName().compareTo(p.getLastName());
        if (comparedValue == 0)
        {
            //last names are equal
            comparedValue = this.getFirstName().compareTo(p.getFirstName());
        }
        //no matter what, we are set correctly now
        return comparedValue;
    }
    
    /**
     * Override the default equals method to check if one
     *    person is equal to another person.
     * @param obj the object to compare for equality.
     * @return true if the objects are equal, otherwise false.
     */
    public boolean equals(Object obj)
    {
        //make sure null & type make sense.
        if (obj == null || !(obj instanceof Person))
        {
            return false;
        }
        //cast for equality check.
        Person p = (Person)obj;
        //return true if all properties are equal
        return (this.getLastName().equals(p.getLastName())
                && this.getFirstName().equals(p.getFirstName())
                && this.getAge() == p.getAge());
    }
}
