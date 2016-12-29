/**
 * A Person.
 * @author Brian
 */
public class Person implements Comparable
{
    private String _firstName;
    private String _lastName;
    private int _age;
    private int _returnValue = -99;
    
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
    
    /**
     * override comparable so can compare person objects for sorting.
     * @param o -- the object to compare this person to
     * @return -1 if less than, 0 if equal, 1 if greater than
     */
    public int compareTo(Object o)
    {
    	//make sure that null or non-person-objects are less than
    	//our Person object
    	if ((o == null ) || !(o instanceof Person))
    	{
    		return 1;
    	}
    	
    	//if we get here, we have a Person object coming in, so cast it
    	Person p = (Person)o;
    	
    	//first get the state of each side
    	boolean thisLastNameNull = this.getLastName() == null;
    	boolean thisFirstNameNull = this.getFirstName() == null;
    	boolean thisAgeZero = this.getAge() == 0;
    	boolean objLastNameNull = p.getLastName() == null;
    	boolean objFirstNameNull = p.getFirstName() == null;
    	boolean objAgeZero = p.getAge() == 0;
    	
    	//case 1: one or more set on one side; nothing set on other side
    	//one left side not null, right side all null
    	if ((!thisLastNameNull || !thisFirstNameNull || !thisAgeZero)
    			&& (objLastNameNull && objFirstNameNull && objAgeZero))
    	{
    		//left side is greater
    		return 1;
    	}
    	//flip side is one set on the right side and none set on the left side
    	if ((thisLastNameNull && thisFirstNameNull && thisAgeZero) 
    		&& (!objLastNameNull || !objFirstNameNull || !objAgeZero))
    	{
    		//right side is greater
    		return -1;
    	}
    	
    	//all set on one side, one or more not set on the other side
    	if ((!thisLastNameNull && !thisFirstNameNull && !thisAgeZero) 
    			&& (objLastNameNull || objFirstNameNull || objAgeZero))
    	{
    		//left side is full, right side has one or more missing
    		return 1;
    	}
    	//flip it
    	if ((thisLastNameNull || thisFirstNameNull || thisAgeZero)
    		&& (!objLastNameNull && !objFirstNameNull && !objAgeZero))
    	{
    		return -1;
    	}
    	
    	//left has last name, right does not
    	if (!thisLastNameNull && objLastNameNull)
    	{
    		return 1;
    	}
    	//right has last name, left does not
    	if (thisLastNameNull && !objLastNameNull)
    	{
    		return -1;
    	}
    	
    	//both have a last name:
    	if (!thisLastNameNull && !objLastNameNull)
    	{
    		//again, we need to start working with a return value
    		//once age equality is important
    		_returnValue = this.getLastName().compareTo(p.getLastName());
    		
    		if (_returnValue == 0)
    		{
    			
    			if (!thisFirstNameNull && objFirstNameNull)
	    		{
	    			//left has first name set, right does not have anything set
	    			return 1;
	    		}
	    		else if (thisFirstNameNull && !objFirstNameNull)
	    		{
	    			//right has a first name set, left does not
	    			return -1;
	    		}
	    		else if (thisFirstNameNull && objFirstNameNull)
	    		{
	    			//neither has a first name
	    			//now look at age
	    			if (!thisAgeZero && objAgeZero)
	    			{
	    				//left side has an age, right does not
	    				return 1;
	    			}
	    			else if (thisAgeZero && !objAgeZero)
	    			{
	    				//right side has an age, left side does not
	    				return -1;
	    			}
	    			else
	    			{
	    				return compareAges(this.getAge(), p.getAge());
	    			}
	    		}
    			else
	    		{
    				//age equality matters because both are set
    	    		_returnValue = this.getFirstName().compareTo(p.getFirstName());
	    			
    	    		if (_returnValue == 0)
    	    		{
    	    			return compareAges(this.getAge(), p.getAge());
    	    		}
	    		}
    		}
    	}
    	
    	//both have no last name:
    	if (thisLastNameNull && objLastNameNull)
    	{
    		if (!thisFirstNameNull && objFirstNameNull)
    		{
    			//left has first name set, right does not have anything set
    			return 1;
    		}
    		else if (thisFirstNameNull && !objFirstNameNull)
    		{
    			//right has a first name set, left does not have anything set
    			return -1;
    		}
    		else if (!thisFirstNameNull && !objFirstNameNull)
    		{
    			//compare first names.  We know they are not null
				//so can rely on String equality.
				_returnValue = this.getFirstName().compareTo(p.getFirstName());
				
				if (_returnValue == 0)
				{
					//set _returnValue to a bad number
					//to fail the test.  This breaks our code when ages
					//are equal (breaks the just first name set test)
					_returnValue = -99;
					
	    			//compare: are ages set or not set
	    			if (!thisAgeZero && objAgeZero)
	    			{
	    				//left side has age, right side does not
	    				return 1;
	    			}
	    			else if (thisAgeZero && !objAgeZero)
	    			{
	    				//right side set, left side not set for age
	    				return -1;
	    			}	
	    			//here we need to return 0 if ages are equal
	    			else
	    			{
	    				return compareAges(this.getAge(), p.getAge());
	    			}
				}
    		}
    		else if (thisFirstNameNull && objFirstNameNull)
    		{
    			if (thisAgeZero && objAgeZero)
    			{
    				//everything is unset for both objects
    				//so they are equal
    				return 0;
    			}
    			else
    			{
    				return compareAges(this.getAge(), p.getAge());
    			}
    		}
    	}
    	
    	//make sure the return value is not < -1 and is not > 1
    	if (_returnValue > 1)
    	{
    		return 1;
    	}
    	else if (_returnValue < -1)
    	{
    		_returnValue = -1;
    	}
    	
    	return _returnValue;
    }
    
    /**
     * Compare two ints for comparability
     * @param left the int on which to call compareTo
     * @param right the integer to pass to left int's compare to
     * @return <=-1 if less than, 0 if equal, >=1 if greater than
     */
    private int compareAges(int left, int right)
    {
    	//using Integer compare to (can't compareTo on primitive int)
		Integer l = left; //
		Integer r = right; //p.getAge();
		return l.compareTo(r);
    }
}