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
        setFirstName(firstName);//_firstName = firstName;
        setLastName(lastName);//_lastName = lastName;
        setAge(age);//_age = age;
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
    	if (!ValidateNameString(value))
    	{
    		throw new IllegalArgumentException("Name must "
    				+ "only contain characters. Symbols, numbers, "
    				+ "and punctuation are not allowed.");
    	}
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
    	if (!ValidateNameString(value))
    	{
    		throw new IllegalArgumentException("Name must "
    				+ "only contain characters. Symbols, numbers, "
    				+ "and punctuation are not allowed.");
    	}
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
    	if (value < 0)
    	{
    		throw new IllegalArgumentException("Age must be greater than "
    				+ "or equal to 0");
    	}
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
    	if ((o == null ) || !(o instanceof Person)) { return 1; }
    	
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
    	{ return 1; }
    	//flip side is one set on the right side and none set on the left side
    	if ((thisLastNameNull && thisFirstNameNull && thisAgeZero) 
    		&& (!objLastNameNull || !objFirstNameNull || !objAgeZero))
    	{ return -1; }
    	
    	//all set on one side, one or more not set on the other side
    	if ((!thisLastNameNull && !thisFirstNameNull && !thisAgeZero) 
    			&& (objLastNameNull || objFirstNameNull || objAgeZero))
    	{ return 1; }
    	//flip it
    	if ((thisLastNameNull || thisFirstNameNull || thisAgeZero)
    		&& (!objLastNameNull && !objFirstNameNull && !objAgeZero))
    	{ return -1; }
    	
    	//left has last name, right does not
    	if (!thisLastNameNull && objLastNameNull) { return 1; }
    	//right has last name, left does not
    	if (thisLastNameNull && !objLastNameNull) { return -1; }
    	
    	//both have a last name:
    	if (!thisLastNameNull && !objLastNameNull)
    	{
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
    	if (_returnValue > 1) { return 1; } //could be _returnValue = 1;
    	else if (_returnValue < -1) { _returnValue = -1; } //could be return -1;
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

    /**
     * Override Equality
     * @param o The object to test for equality
     * @return boolean representing whether or not the incoming
     * 			object is equal to this object.
     */
    public boolean equals(Object obj)
    {
    	//an object cannot be equal to null
    	//and an object Person must be passed in or the 
    	//    two objects are not equal
    	if (obj == null || !(obj instanceof Person))
    	{
    		return false;
    	}
    	
    	//now we know that the incoming object is a person
    	Person p = (Person)obj;
    	
    	//determine the properties to compare for equality
    	//in this case, lastname, firstname, age
    	//good practice would be to test the one that is MOST likely not equal
    	//in this case, that would be the last name or age.
    	//this will just help the method end more quickly if something doesn't match
    	//in the end, we need to make sure that all properties aren't equal, and it could
    	//be done in any order, as long as it's done correctly.
    	
    	//we know we have two non-null Person objects at this point, but properties may not
    	//be set.  So we need to keep that in mind as we go.  Let's do Last Name, age, first name
    	//as our order of least likely to be equal (it's really arbitrary!)
    	
    	//first get the state of each side
    	boolean thisLastNameNull = this.getLastName() == null;
    	boolean thisFirstNameNull = this.getFirstName() == null;
    	boolean thisAgeZero = this.getAge() == 0;
    	boolean objLastNameNull = p.getLastName() == null;
    	boolean objFirstNameNull = p.getFirstName() == null;
    	boolean objAgeZero = p.getAge() == 0;
    	boolean _returnValue = false;
    	
    	if (thisLastNameNull && objLastNameNull)
    	{
    		//last names null
    		if (thisFirstNameNull && objFirstNameNull)
    		{
    			//first names null, can just return equality on ages
    			//handles both set and unset ages
    			return this.getAge() == p.getAge();
    		}
    		else if (!thisFirstNameNull && !objFirstNameNull)
    		{
    			//remember, we already know from our grid that
    			//if only one is null, then objects are automatically 
    			//not equal so we don't have to code those two if statements!
    			//also, we can rely on string equality
    			//NOTE: If case matters to you, then you have to use equalsIgnoreCase
    			_returnValue = this.getFirstName().equals(p.getFirstName());
    			if (_returnValue)
    			{
    				_returnValue = this.getAge() == p.getAge();
    			}
    			return _returnValue;
    		}
    		//in case you're wondering, we don't need return false here
    		//as the code will fall all the way to the end where we return false
    	}
    	else if (!thisLastNameNull && !objLastNameNull)
    	{
    		//anticipating the next states, we'll just set to a value
    		//remember, case-sensitivity would require equalsIgnoreCase
    		_returnValue = this.getLastName().equals(p.getLastName());
    		if (_returnValue)
    		{
    			if ((thisFirstNameNull && !objFirstNameNull) ||
    					(!thisFirstNameNull && objFirstNameNull))
    			{
    				//both first names must NOT BE NULL, or they aren't equal
        			return false;
    			}
    			else if (!thisFirstNameNull && !objFirstNameNull)
    			{
    				//compare the first names
    				//remember to handle case sensitivity if needed
    				_returnValue = this.getFirstName().equals(p.getFirstName());
    			}
    			else if (thisFirstNameNull && objFirstNameNull)
    			{
    				//both firsts are null
    				_returnValue = true;
    			}
    			
    			//age only matters if first hasn't prevented it from mattering
				if (_returnValue)
				{
					//code for also having first name/age set will go here
					//age comparison
					_returnValue = this.getAge() == p.getAge();
				}
    		}
    		//return the result
    		return _returnValue;
    	}

    	//if code gets here, something is not matching or has unequal null/not-null settings
    	return false;
    }

    /**
     * Validate a String contains only characters.
     * @param nameToValidate String to check
     * @return true if pattern matches, else false.
     */
    private boolean ValidateNameString(String nameToValidate)
    {
    	//allow null and "" at this point...
    	if (nameToValidate != null && !nameToValidate.equals(""))
    	{
	    	//regex to validate String
	    	String pattern = "[A-Za-z]*";
	    	return nameToValidate.matches(pattern);
    	}
    	return true;
    }
}