import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarTest {

	private Car v;
	private Car v2;
	//VIN
	private static String VIN = "235423523asdfasda235235";
	//MAKE
	private static String MAKE = "Ford";
	//MODEL
	private static String MODEL = "Mustang GT";
	//YEAR
	private static int YEAR = 2021;
	//COLOR
	private static String COLOR = "Blue";
	//Mileage
	private static double MILEAGE = 25.0;
	private static double DELTA = 0.00001;
	
	//IsConvertible
	private static boolean ISCONVERTIBLE = true;
	
	
	@Before
	public void setUp() throws Exception {
		v = new Car();
		v2 = new Car(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE, ISCONVERTIBLE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDefaultConstructor() {
		assertNotNull("Could not instantiate Vehicle", v);
	}
	
	@Test
	public void testExplicitConstructor() {
		assertNotNull("Could not instantiate Vehicle", v2);
		assertEquals("Vin was not as expected", VIN, v2.getVin());
		assertEquals("Make was not as expected", MAKE, v2.getMake());
		assertEquals("Model was not as expected", MODEL, v2.getModel());
		assertEquals("Year was not as expected", YEAR, v2.getYear());
		assertEquals("Color was not as expected", COLOR, v2.getColor());
		assertEquals("Mileage was not as expected", MILEAGE, v2.getMileage(), DELTA);
		assertTrue("Is Convertible is not set as expected", v2.getIsConvertible());
	}
	
	
	@Test
	public void testVIN() {
		v.setVin(VIN);
		assertEquals("Vin was not as expected", VIN, v.getVin());
	}
	
	
	
	@Test
	public void testMake() {
		v.setMake(MAKE);
		assertEquals("Make was not as expected", MAKE, v.getMake());
	}
	
	@Test
	public void testModel() {
		v.setModel(MODEL);
		assertEquals("Model was not as expected", MODEL, v.getModel());
	}
	
	@Test
	public void testYear() {
		v.setYear(YEAR);
		assertEquals("Year was not as expected", YEAR, v.getYear());
	}
	
	@Test
	public void testColor() {
		v.setColor(COLOR);
		assertEquals("Color was not as expected", COLOR, v.getColor());
	}
	
	@Test
	public void testMileage() {
		v.setMileage(MILEAGE);
		assertEquals("Mileage was not as expected", MILEAGE, v.getMileage(), DELTA);
	}
	
	@Test
	public void testIsConvertible() {
		v.setIsConvertible(ISCONVERTIBLE);
		assertTrue("Is Convertible is not set as expected", v.getIsConvertible());
	}

	
	@Test
	public void testIsRunningAndStartMethods() 
	{
		v.start();
		assertTrue("Could not start car as expected", v.isRunning());
	}
	
	@Test
	public void testIsRunningAndStopMethods() 
	{
		v.stop();
		assertFalse("Could not stop car as expected", v.isRunning());
	}
	
	@Test
	public void testStandardAccelleration()
	{
		double initialSpeed = v.getSpeed();
		v.accellerate();
		assertEquals("Standard accelleration didn't work as expected", initialSpeed + .5, v.getSpeed(), DELTA);
	}
	
	@Test
	public void testVariableAccelleration()
	{
		double initialSpeed = v.getSpeed();
		v.accellerate(20.0);
		assertEquals("Variable accelleration didn't work as expected", initialSpeed + 20, v.getSpeed(), DELTA);
	}

	@Test
	public void testToString()
	{
		String testingString = v2.toString();
		assertTrue("ToString does not contain VIN", testingString.contains(VIN));
		assertTrue("ToString does not contain MAKE", testingString.contains(MAKE));
		assertTrue("ToString does not contain MODEL", testingString.contains(MODEL));
		assertTrue("ToString does not contain YEAR", testingString.contains(String.format("%d",  YEAR)));
		assertTrue("ToString does not contain COLOR", testingString.contains(COLOR));
		assertTrue("ToString does not contain convertible value", testingString.contains(String.format("Is a Convertible: %b",  v2.getIsConvertible())));
		assertTrue("ToString does not contain MILEAGE", testingString.contains(String.format("%.1f",  MILEAGE)));
	}
}
