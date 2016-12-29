import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonTest {
	private String firstName = "James";
	private String lastName = "Kirk";
	private int age = 50;
	private Person myPerson;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		myPerson = new Person();
	}

	@After
	public void tearDown() throws Exception {
		myPerson = null;
	}

	@Test
	public void testConstructors() {
		Person p1 = null;
		assertNull("Person was not null as expected", p1);
		
		assertNotNull("Person was not instantiated as expected", myPerson);
		
		Person p2 = new Person();
		assertNotNull("Person was not instantiated as expected", p2);
		
		Person p3 = new Person(firstName, lastName, age);
		assertNotNull("Person was not instantiated as expected", p3);
		
		assertEquals("First Name was not set as expected"
				, firstName
				, p3.getFirstName());
		assertEquals("Last Name was not set as expected"
				, lastName
				, p3.getLastName());
		assertEquals("Age was not set as expected"
				, age
				, p3.getAge());
	}
	
	@Test
	public void testGetSetFirstName()
	{
		Person p1 = new Person();
		p1.setFirstName(firstName);
		//String myValue = p1.getFirstName();
		assertEquals("First Name was not set as expected"
						, firstName
						, p1.getFirstName());
	}
	
	@Test
	public void testGetSetLastName()
	{
		myPerson.setLastName(lastName);
		assertEquals("Last Name was not set as expected"
						, lastName
						, myPerson.getLastName());
	}
	
	@Test
	public void testGetSetAge()
	{
		myPerson.setAge(age);
		assertEquals("Age was not set as expected"
						, age
						, myPerson.getAge());
	}

	@Test
	public void testToString()
	{
		myPerson.setFirstName(firstName);
		myPerson.setLastName(lastName);
		myPerson.setAge(age);
		
		String personString = myPerson.toString();
		assertTrue("Person toString does not contain firstName"
					, personString.contains(firstName));	
		assertTrue("Person toString does not contain lastName"
				, personString.contains(lastName));
		assertTrue("Person toString does not contain age"
				, personString.contains(String.format("%d", age)));	
	}

	@Test
	public void testComparable()
	{
		Object o = null;						//null object
        Object o2 = "This is really a String";  //a String, not a Person
        Person p = new Person();   				//used to compare to myPerson
        int expected1 = 1;						//expected when myPerson > p
        int expected0 = 0;						//expected when myPerson == p
        int expectedm1 = -1;					//expected when myPerson < p
        
        //cannot compare against null, so we are coding this to
        //return 1.  We have to remember here -- this is how we
        //coded it for this system.  It could have been different elsewhere!
        assertEquals("Null value should be less than our person!"
                        , expected1, myPerson.compareTo(o));
        //cannot compare against non person, we stated that person
        //would be greater if the value is null or not a person
        //so again this is arbitrary based on our system
        assertEquals("Non-person should be less than our person!"
                        , expected1, myPerson.compareTo(o2));
        
        /****************Add this at the top, right after the two asserts 
         				 for null and non-person objects */
        //check the case when both are instantiated but nothing is set
        assertEquals("Person objects should be equal when both are instantiated"
        			+ " and no properties are set"
        			, 0, myPerson.compareTo(p));
        assertEquals("Person objects should be equal when both are instantiated"
	    			+ " and no properties are set"
	    			, 0, p.compareTo(myPerson));
    
        
        //let's check the case where one side has something set and the other side has nothing set:
        //last name set on one
        myPerson.setLastName(lastName);
        assertEquals("Person with nothing set should be less than person with last name set"
        				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with last name set"
        				, expectedm1, p.compareTo(myPerson));	
        myPerson.setLastName(null);
        
        //first name set on one
        myPerson.setFirstName(firstName);
        assertEquals("Person with nothing set should be less than person with first name set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with first name set"
				, expectedm1, p.compareTo(myPerson));	
        myPerson.setFirstName(null);
        
        //age set on one
        myPerson.setAge(age);
        assertEquals("Person with nothing set should be less than person with age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with age set"
				, expectedm1, p.compareTo(myPerson));	
        
        
        //no ln set, first name set on left, no ln, no fn set on right. age irrellevant
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        assertEquals("Person with nothing set should be less than "
        				+ "person with first name and age set"
        				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than "
        				+ "person with first name and age set"
    					, expectedm1, p.compareTo(myPerson));
        p.setAge(age);
        assertEquals("Person with only age set should be less than "
				+ "person with first name and age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with only age set should be less than "
				+ "person with first name and age set"
				, expectedm1, p.compareTo(myPerson));
        
        //no ln, fn set on both, left has age, right does not
        myPerson.setLastName(null);
        p.setLastName(null);
        myPerson.setFirstName(firstName);
        p.setFirstName(firstName);
        myPerson.setAge(age);
        p.setAge(0);
        assertEquals("Person with no last name, first name set, and no age set "
				+ "should be less than person with no last name, first name set, and age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with no last name, first name set, and no age set "
				+ "should be less than person with no last name, first name set, and age set"
				, expectedm1, p.compareTo(myPerson));
        
        
        //left has last name, right does not.  Anything else set would be irrellevant in this case
        myPerson.setLastName(lastName);
        myPerson.setFirstName(null);
        myPerson.setAge(age);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(age);
        assertEquals("Person with no last name set "
					+ "should be less than person with last name set"
					, expected1, myPerson.compareTo(p));
        assertEquals("Person with no last name set "
					+ "should be less than person with last name set"
					, expectedm1, p.compareTo(myPerson));
        
        //left and right have a last name.  Left has first name, right does not. Age is irrellevant
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(0);
        assertEquals("Person with last name set but no first name set"
				+ "should be less than person with last and first name set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with last name set but no first name set"
				+ "should be less than person with last and first name set"
				, expectedm1, p.compareTo(myPerson));
    
        //left and right have a last name. Neither has a first name.  One side has age
        myPerson.setLastName(lastName);
        myPerson.setFirstName(null);
        myPerson.setAge(age);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(0);
        assertEquals("Person with last name set but no first name set and no age set"
				+ "should be less than person with last name, no first name, and an age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with last name set but no first name set and no age set"
				+ "should be less than person with last name, no first name, and an age set"
				, expectedm1, p.compareTo(myPerson));
        
        // all versus one or more not set
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(age);
        assertEquals("Person with one or more properties not set "
				+ "should be less than person with all properties set "
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with one or more properties not set "
				+ "should be less than person with all properties set "
				, expectedm1, p.compareTo(myPerson));
        
        
        /************************* 
         * Now check for the ones that have identical properties set
         * but maybe not identical values!!!!!!!!!!!
         *************************/
        
        /**************************** JUST AGE SET *******************************/
        //just age set on both sides
        myPerson.setLastName(null);
        myPerson.setFirstName(null);
        myPerson.setAge(age);
        p.setLastName(null);
        p.setFirstName(null);
        p.setAge(age);
        assertEquals("Person with just age set "
				+ "should be equal to person with just age set "
				, expected0, myPerson.compareTo(p));
        assertEquals("Person with just age set "
				+ "should be equal to person with just age set "
				, expected0, p.compareTo(myPerson));
        
        //age greater on left
        myPerson.setLastName(null);
        myPerson.setFirstName(null);
        myPerson.setAge(100);
        p.setLastName(null);
        p.setFirstName(null);
        p.setAge(age);
        assertEquals("Person with age set higher should be greater than person "
        		+ "with age set lower"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with age set higher should be greater than person "
        		+ "with age set lower"
				, expectedm1, p.compareTo(myPerson));
        
        //age greater on right
        myPerson.setLastName(null);
        myPerson.setFirstName(null);
        myPerson.setAge(age);
        p.setLastName(null);
        p.setFirstName(null);
        p.setAge(100);
        assertEquals("Person with age set lower should be less than person "
        		+ "with age set higher"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with age set lower should be less than person "
        		+ "with age set higher"
				, expected1, p.compareTo(myPerson));
        
        /***************** JUST FIRST NAMES SET *********************************/
        //just age set on both sides
        myPerson.setLastName(null);
        myPerson.setFirstName(firstName);
        myPerson.setAge(0);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(0);
        assertEquals("Person with just first name set "
				+ "should be equal to person with just first name set "
				, expected0, myPerson.compareTo(p));
        assertEquals("Person with just first name set "
				+ "should be equal to person with just first name set "
				, expected0, p.compareTo(myPerson));
        
        //age greater on left
        myPerson.setLastName(null);
        myPerson.setFirstName(firstName);
        myPerson.setAge(0);
        p.setLastName(null);
        p.setFirstName("Andrew");
        p.setAge(0);
        assertEquals("Person with first name set higher should be greater than person "
        		+ "with first name set higher"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with first name set higher should be greater than person "
        		+ "with first name set higher"
				, expectedm1, p.compareTo(myPerson));
        
        //age greater on right
        myPerson.setLastName(null);
        myPerson.setFirstName("Andrew");
        myPerson.setAge(0);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(0);
        assertEquals("Person with first name set lower should be less than person "
        		+ "with first name set higher"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with first name set lower should be greater than person "
        		+ "with first name set higher"
				, expected1, p.compareTo(myPerson));
        

        /******************* BOTH FIRST NAME AND AGE ARE SET *************************
         					 ORDER OF PRECEDENCE = FIRST NAME THEN AGE  
         					 AGE WILL ONLY MATTER WHEN FIRST NAMES ARE EQUAL
         					 FIRST NAME EQUALITY IS ALREADY TESTED
         					 SO JUST NEED TO TEST AGE EQUALITY         
         *****************************************************************************/
        myPerson.setLastName(null);
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(10);
        assertEquals("Person with first name set equal and age set higher "
        		+ "should be greater than person with lower age"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with first name set equal and age set higher "
        		+ "should be greater than person with lower age"
				, expectedm1, p.compareTo(myPerson));
        
        myPerson.setLastName(null);
        myPerson.setFirstName(firstName);
        myPerson.setAge(10);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(age);
        assertEquals("Person with first name set equal and age set lower "
        		+ "should be lesser than person with greater age"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with first name set equal and age set lower "
        		+ "should be lesser than person with greater age"
				, expected1, p.compareTo(myPerson));
        
        myPerson.setLastName(null);
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        p.setLastName(null);
        p.setFirstName(firstName);
        p.setAge(age);
        assertEquals("Person with first name set equal and age set equal "
        		+ "should be equal to person with equal first name and age"
				, expected0, myPerson.compareTo(p));
        assertEquals("Person with first name set equal and age set equal "
        		+ "should be equal to person with equal first name and age"
				, expected0, p.compareTo(myPerson));
        
        
        /************************** BOTH ONLY HAVE LAST NAME ************************/
        myPerson.setLastName("Zimmer");
        myPerson.setFirstName(null);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(0);
        assertEquals("Person with last name set higher "
        		+ "should be greater than person with lower last name"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with last name set higher "
        		+ "should be greater than person with lower last name"
				, expectedm1, p.compareTo(myPerson));
        
        myPerson.setLastName("Andrews");
        myPerson.setFirstName(null);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(0);
        assertEquals("Person with last name set lower "
        		+ "should be lesser than person with higher last name"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with last name set lower "
        		+ "should be lesser than person with higher last name"
				, expected1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(null);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(0);
        assertEquals("Person with only last name set should be equal"
        		+ " to another person with only last name set when both"
        		+ " last names are the same"
				, expected0, myPerson.compareTo(p));
        assertEquals("Person with only last name set should be equal"
        		+ " to another person with only last name set when both"
        		+ " last names are the same"
				, expected0, p.compareTo(myPerson));
        
        /********************** BOTH LAST NAMES SET, BOTH AGES SET, NO FN SET **********/
        /************** AGAIN: IF LAST NAMES ARE NOT EQUAL, THE AGE IS IRRELLEVANT 
         						SO WE ONLY NEED TO ADD TESTS FOR THE AGE EQUALITY TESTING
        ********************************************************************************/
        myPerson.setLastName(lastName);
        myPerson.setFirstName(null);
        myPerson.setAge(100);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(age);
        assertEquals("Person with last name equal, no first name set,and greater age "
        		+ "should be greater than person with last name equal, no first name"
        		+ ", and lesser age"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with last name equal, no first name set,and greater age "
        		+ "should be greater than person with last name equal, no first name"
        		+ ", and lesser age"
				, expectedm1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(null);
        myPerson.setAge(age);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(100);
        assertEquals("Person with last name equal, no first name set,and lesser age "
        		+ "should be lesser than person with last name equal, no first name"
        		+ ", and greater age"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with last name equal, no first name set,and lesser age "
        		+ "should be lesser than person with last name equal, no first name"
        		+ ", and greater age"
				, expected1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(null);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(null);
        p.setAge(0);
        assertEquals("Person with only last name set should be equal"
        		+ " to another person with only last name set when both"
        		+ " last names are the same"
				, expected0, myPerson.compareTo(p));
        assertEquals("Person with only last name set should be equal"
        		+ " to another person with only last name set when both"
        		+ " last names are the same"
				, expected0, p.compareTo(myPerson));
        
        
        /***** BOTH LAST NAMES SET, BOTH FIRST NAMES SET, AGES NOT SET ******
         * 			HERE WE JUST NEED TO ADD TESTS FOR AGE EQUALITY
         ********************************************************************/
        myPerson.setLastName(lastName);
        myPerson.setFirstName("Andrew");
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(firstName);
        p.setAge(0);
        assertEquals("Person with last name equal, lesser name, and no age set "
        		+ "should be less than than person with last name equal, greater first name"
        		+ ", and no age set"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with last name equal, lesser name, and no age set "
        		+ "should be less than than person with last name equal, greater first name"
        		+ ", and no age set"
				, expected1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName("Andrew");
        p.setAge(0);
        assertEquals("Person with last name equal, greater name, and no age set "
        		+ "should be greater than than person with last name equal, lesser first name"
        		+ ", and no age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with last name equal, greater name, and no age set "
        		+ "should be greater than than person with last name equal, lesser first name"
        		+ ", and no age set"
				, expectedm1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(0);
        p.setLastName(lastName);
        p.setFirstName(firstName);
        p.setAge(0);
        assertEquals("Person with equal last name and first name but no age set "
        		+ "should be equal to person with equal last name and first name "
        		+ "but no age set"
				, expected0, myPerson.compareTo(p));
        assertEquals("Person with equal last name and first name but no age set "
        		+ "should be equal to person with equal last name and first name "
        		+ "but no age set"
				, expected0, p.compareTo(myPerson));
        
        /****************************************************************************
         * EVERYTHING SET, ONLY THING WE NEED TO TEST IS AGE EQUALITY
         ****************************************************************************/
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(100);
        p.setLastName(lastName);
        p.setFirstName(firstName);
        p.setAge(age);
        assertEquals("Person with last name equal, first name equal, and age set higher "
        		+ "should be greater than person with last name equal, first name equal "
        		+ ", and age set lower"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with last name equal, first name equal, and age set higher "
        		+ "should be greater than person with last name equal, first name equal "
        		+ ", and age set lower"
				, expectedm1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        p.setLastName(lastName);
        p.setFirstName(firstName);
        p.setAge(100);
        assertEquals("Person with last name equal, first name equal, and age set lower "
        		+ "should be less than person with last name equal, first name equal "
        		+ ", and age set higher"
				, expectedm1, myPerson.compareTo(p));
        assertEquals("Person with last name equal, first name equal, and age set lower "
        		+ "should be less than person with last name equal, first name equal "
        		+ ", and age set higher"
				, expected1, p.compareTo(myPerson));
        
        myPerson.setLastName(lastName);
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        p.setLastName(lastName);
        p.setFirstName(firstName);
        p.setAge(age);
        assertEquals("Two person objects with all three properties set equally"
        		+ "should be equal "
				, expected0, myPerson.compareTo(p));
        assertEquals("Two person objects with all three properties set equally"
        		+ "should be equal "
				, expected0, p.compareTo(myPerson));
	}
	
	@Test
	public void testEquality()
	{
		//<object>.equals(null) should be false!
		assertFalse("Person should not be equal to null once instantiated"
						, myPerson.equals(null));
		//<object>.equals(<differentObject>) should be false!
		assertFalse("Person should not be equal to a non-person object"
						, myPerson.equals("This is a String"));
		
		//test all default state --> first/last = null && age = 0
		Person p = new Person();
		assertTrue("Two person objects should be equal when no properties are set"
						+ "on either object"
						, myPerson.equals(p));
		assertTrue("Two person objects should be equal when no properties are set"
				+ "on either object"
				, p.equals(myPerson));

		//just age to compare
		//default
		myPerson = new Person();
		p = new Person();
		assertTrue("Person objects should be equal when there is no last name, "
				+ "no first name, ages match"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when there is no last name, "
				+ "no first name, and ages match"
				, p.equals(myPerson));
		
		//ages don't match
		myPerson.setLastName(null);
		myPerson.setFirstName(null);
		myPerson.setAge(100);
		p.setLastName(null);
		p.setFirstName(null);
		p.setAge(age);
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "no first name, and ages do not match"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "no first name, and ages do not match"
				, p.equals(myPerson));
		
		//ages match not default
		myPerson.setLastName(null);
		myPerson.setFirstName(null);
		myPerson.setAge(age);
		p.setLastName(null);
		p.setFirstName(null);
		p.setAge(age);
		assertTrue("Person objects should be equal when there is no last name, "
				+ "no first name, ages match"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when there is no last name, "
				+ "no first name, and ages match"
				, p.equals(myPerson));
		
		//just first name set
		//one name is null -- makes sure that we handle that case
		myPerson.setLastName(null);
		myPerson.setFirstName(firstName);
		myPerson.setAge(0);
		p.setLastName(null);
		p.setFirstName(null);
		p.setAge(0);
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "only one has a first name set, and ages are not set"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "only one has a first name set, and ages are not set"
				, p.equals(myPerson));
		
		//names don't match
		myPerson.setLastName(null);
		myPerson.setFirstName("Andrew");
		myPerson.setAge(0);
		p.setLastName(null);
		p.setFirstName(firstName);
		p.setAge(0);
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "first names do not match, and ages match"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "first names do not match, and ages match"
				, p.equals(myPerson));
		
		//ages match not default
		myPerson.setLastName(null);
		myPerson.setFirstName(firstName);
		myPerson.setAge(0);
		p.setLastName(null);
		p.setFirstName(firstName);
		p.setAge(0);
		assertTrue("Person objects should be equal when there is no last name, "
				+ "first names match, and ages are not set"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when there is no last name, "
				+ "first names match, and ages are not set"
				, p.equals(myPerson));
		
		//does case matter?  you have to make that call!
		//if this should be equal for your system
		//you have to set the asserts to True, explain the details
		//and make sure to change the code in Person equality to use
		//equals, instead of equalsIgnoreCase
		myPerson.setLastName(null);
		myPerson.setFirstName("anyFirstName");
		myPerson.setAge(0);
		p.setLastName(null);
		p.setFirstName("AnYFIrstNAME");
		p.setAge(0);
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "first names do not match on case, and ages are not set"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "first names do not match on case, and ages are not set"
				, p.equals(myPerson));
		
		/******* No Last Name, but first and age are set *********/
		//we've already tested when one first name is null. Age can't be null
		//both equal
		myPerson.setLastName(null);
		myPerson.setFirstName(firstName);
		myPerson.setAge(age);
		p.setLastName(null);
		p.setFirstName(firstName);
		p.setAge(age);
		assertTrue("Person objects should be equal when there is no last name, "
				+ "first names match, and ages match"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when there is no last name, "
				+ "first names match, and ages match"
				, p.equals(myPerson));
		
		//first equal, age not equal
		myPerson.setLastName(null);
		myPerson.setFirstName(firstName);
		myPerson.setAge(age);
		p.setLastName(null);
		p.setFirstName(firstName);
		p.setAge(100);
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "first names match, and ages do not match"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "first names match, and ages do not match"
				, p.equals(myPerson));
		
		//first not equal, age doesn't matter in this case
		myPerson.setLastName(null);
		myPerson.setFirstName(firstName);
		myPerson.setAge(age);
		p.setLastName(null);
		p.setFirstName("Andrew");
		p.setAge(100);
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "and first names do not match"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when there is no last name, "
				+ "and first names do not match"
				, p.equals(myPerson));
		
		
		/****** JUST LAST NAME SET **************/
		//equal
		myPerson.setLastName(lastName);
		myPerson.setFirstName(null);
		myPerson.setAge(0);
		p.setLastName(lastName);
		p.setFirstName(null);
		p.setAge(0);
		assertTrue("Person objects should be equal when last names match, "
				+ "first names are not set, and ages are not set"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when last names match, "
				+ "first names are not set, and ages are not set"
				, p.equals(myPerson));
		
		//last names not equal (first name and age irrelevant)
		myPerson.setLastName(lastName);
		myPerson.setFirstName(null);
		myPerson.setAge(0);
		p.setLastName("Andrews");
		p.setFirstName(null);
		p.setAge(0);
		assertFalse("Person objects should not be equal when last names do not match, "
				+ "regardless of first name and age"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when last names do not match, "
				+ "regardless of first name and age"
				, p.equals(myPerson));
		
		//last name case-sensitivity
		myPerson.setLastName("anyLastName");
		myPerson.setFirstName(null);
		myPerson.setAge(0);
		p.setLastName("AnYLAsTNaME");
		p.setFirstName(null);
		p.setAge(0);
		assertFalse("Person objects should not be equal when last names do not match"
				+ " on case.  FirstName and Age are irrelevant"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when last names do not match"
				+ " on case.  FirstName and Age are irrelevant"
				, p.equals(myPerson));
		
		/********** LAST NAME AND AGE ONLY, NO FIRST NAME *************************/
		//equal
		myPerson.setLastName(lastName);
		myPerson.setFirstName(null);
		myPerson.setAge(age);
		p.setLastName(lastName);
		p.setFirstName(null);
		p.setAge(age);
		assertTrue("Person objects should be equal when last names match, "
				+ "first names are not set, and ages match"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when last names match, "
				+ "first names are not set, and ages match"
				, p.equals(myPerson));
		
		//ages not equal
		myPerson.setLastName(lastName);
		myPerson.setFirstName(null);
		myPerson.setAge(age);
		p.setLastName(lastName);
		p.setFirstName(null);
		p.setAge(100);
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names are not set, and ages do not match"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names are not set, and ages do not match"
				, p.equals(myPerson));
		
		//we don't need to test if lastnames aren't equal, as we've already don that
		
		/******************* LAST NAME AND FIRST NAME ONLY **********************/
		//equal
		myPerson.setLastName(lastName);
		myPerson.setFirstName(firstName);
		myPerson.setAge(0);
		p.setLastName(lastName);
		p.setFirstName(firstName);
		p.setAge(0);
		assertTrue("Person objects should be equal when last names match, "
				+ "first names match, and ages are not set"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when last names match, "
				+ "first names match, and ages are not set"
				, p.equals(myPerson));
		
		//equal except case on first (last already handled)
		myPerson.setLastName(lastName);
		myPerson.setFirstName(firstName.toUpperCase());
		myPerson.setAge(0);
		p.setLastName(lastName);
		p.setFirstName(firstName.toLowerCase());
		p.setAge(0);
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names do not match case, and ages are not set"
				, myPerson.equals(p));
		assertFalse("Person objects should be equal when last names match, "
				+ "first names do not match case, and ages are not set"
				, p.equals(myPerson));
		
		//first names not equal (we've already handled last names not equal)
		myPerson.setLastName(lastName);
		myPerson.setFirstName(firstName);
		myPerson.setAge(0);
		p.setLastName(lastName);
		p.setFirstName("Andrew");
		p.setAge(0);
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names do not match, and ages are not set"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names do not match, and ages are not set"
				, p.equals(myPerson));
		
		//one first name null when last is set
		myPerson.setLastName(lastName);
		myPerson.setFirstName(firstName);
		myPerson.setAge(0);
		p.setLastName(lastName);
		p.setFirstName(null);
		p.setAge(0);
		assertFalse("Person objects should not be equal when last names match, "
				+ "one first name is null, and ages are not set"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when last names match, "
				+ "one first name is null, and ages are not set"
				, p.equals(myPerson));
		
		
		//last, first, and age set
		//last, first and ages equal
		myPerson.setLastName(lastName);
		myPerson.setFirstName(firstName);
		myPerson.setAge(age);
		p.setLastName(lastName);
		p.setFirstName(firstName);
		p.setAge(age);
		assertTrue("Person objects should be equal when last names match, "
				+ "first names match, and ages match"
				, myPerson.equals(p));
		assertTrue("Person objects should be equal when last names match, "
				+ "first names match, and ages match"
				, p.equals(myPerson));
		
		//ages not equal
		myPerson.setLastName(lastName);
		myPerson.setFirstName(firstName);
		myPerson.setAge(age);
		p.setLastName(lastName);
		p.setFirstName(firstName);
		p.setAge(100);
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names match, and ages do not match"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when last names match, "
				+ "first names match, and ages do not match"
				, p.equals(myPerson));
		
		/***********  FINAL TESTS FOR SECURITY OF CODE ***************/
		//both last names must be null or set, can't be a mix:
		myPerson.setLastName(lastName);
		myPerson.setFirstName(null);
		myPerson.setAge(0);
		p.setLastName(null);
		p.setFirstName(null);
		p.setAge(0);
		assertFalse("Person objects should not be equal when one last name is null"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when one last name is null"
				, p.equals(myPerson));
		
		myPerson.setLastName(lastName);
		myPerson.setFirstName(null);
		myPerson.setAge(0);
		p.setLastName(lastName);
		p.setFirstName(firstName);
		p.setAge(0);
		assertFalse("Person objects should not be equal when one first name is null"
				, myPerson.equals(p));
		assertFalse("Person objects should not be equal when one first name is null"
				, p.equals(myPerson));
		
		//ages are integers so they can't be null, but one could be set and one could be 0.
		//the thing is, that's just a standard integer comparison, and we hit that even with 
		//both of the other properties being null so there is no need for another test
		
		/************** TEST REFLEXIVE AND TRANSITIVE ****************************/
		myPerson = new Person(lastName, firstName, age);
		assertTrue("Equality must be reflexive"
					, myPerson.equals(myPerson));
		
		p = new Person(lastName, firstName, age);
		Person p2 = new Person(lastName, firstName, age);
		assertTrue("Two person objects with identical properties should be equal"
				, myPerson.equals(p));
		assertTrue("Two person objects with identical properties should be equal"
					, p.equals(p2));
		assertTrue("Two person objects with identical properties should be equal"
				+ " by transitive property of equality"
				, myPerson.equals(p2));
		
	}

}
