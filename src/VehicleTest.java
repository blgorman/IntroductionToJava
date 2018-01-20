import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
	Vehicle v;
	
	@Before
	public void setUp() throws Exception {
		v = new Vehicle();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDefaultConstructor() {
		assertNotNull("Could not instantiate Vehicle", v);
	}

}
