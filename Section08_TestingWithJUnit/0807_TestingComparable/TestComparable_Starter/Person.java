/**
 * A Person.
 * @author Brian
 */
public class Person //implements Comparable
{
    private String _firstName;
    private String _lastName;
    private int _age;
    
    /**
     * Person default Constructor.
     */
	public Person()
	{
		//do nothing
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
    
}