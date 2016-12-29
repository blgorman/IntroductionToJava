/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
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
        
        //to compare, we need to determine a property to compare by
        //for names, we compare by last name, and if they are equal
        //then we compare by first name.  if they are both equal the objects
        //would be considered equal
        
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
        //if the incoming object is null, they are not equal
        //additionally, if the incoming type is not of same type
        //the objects are not equal.  These should be your first
        //checks in any equality method.  There is no sense in comparing
        //objects if the base things aren't equal.
        if (obj == null || !(obj instanceof Person))
        {
            return false;
        }
        
        //now, when writing equality methods, you must analyze your system
        //what EXACTLY makes two objects equal.  Is it one of the properties?
        //all of them? some of them?  It's ENTIRELY up to you, but you
        //should really consider why you would want to have equality if every
        //single property doesn't match exactly...is a person of age 23 equal
        //to a person of age 50?  What if one is Jim and the other is Sandy but 
        //they are both 50?  What if both have the same name but different ages?
        //i.e. John Smith 50 and John Smith 18?
        //take your analysis and make sure your system makes sense for equality:
        
        //the final step is like others: cast and compare (only use == or .equals)
        //do not use comparable here unless you really want to, but that is just
        //extra code.  Also remember that in order to use .equals or == the 
        //objects must also override equals (for example, commander must also
        //override equals and leverage this person as well as compare the more
        //specific properties.
        Person p = (Person)obj;
        //all properties can be compared and && [anded] together
        //if any are unequal, this statement returns false:
        return (this.getLastName().equals(p.getLastName())
                && this.getFirstName().equals(p.getFirstName())
                && this.getAge() == p.getAge());
    }
}
