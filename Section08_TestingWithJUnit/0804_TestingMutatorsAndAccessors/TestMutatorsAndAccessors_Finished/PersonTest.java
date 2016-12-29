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
}
