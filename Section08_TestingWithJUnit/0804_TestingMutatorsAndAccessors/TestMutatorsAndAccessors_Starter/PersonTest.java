import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructors() {
		Person p1 = null;
		assertNull("Person was not null as expected", p1);
		
		Person p2 = new Person();
		assertNotNull("Person was not instantiated as expected", p2);
		
		Person p3 = new Person("James", "Kirk", 50);
		assertNotNull("Person was not instantiated as expected", p3);
		
		//TODO: Write the tests to make sure the constructor 
		//      values are set as expected
		fail("Explicit constructor values not set as expected");
	}
}
