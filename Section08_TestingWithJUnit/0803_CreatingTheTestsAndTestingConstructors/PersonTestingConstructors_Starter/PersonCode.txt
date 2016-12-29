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
}