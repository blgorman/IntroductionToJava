/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Person 
{
    private String _name;
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
    public Person(String name, int age)
    {
        _name = name;
        _age = age;
    }
    
    /**
     * Get the person's name.
     * @return the name as a String
     */
    public String getName()
    {
        return _name;
    }
    /**
     * Set the person's name.
     * @param value the name as a String
     */
    public void setName(String value)
    {
        _name = value;
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
        return String.format("Name: %s\tAge: %d"
                                , getName(), getAge());
    }
}
