
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;


public class UtilidadesDeEnterosTest {
 
	
	private UtilidadesDeEnteros u;
	@Before
	public void setUp() throws Exception {
		u= new UtilidadesDeEnteros();
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}

	@Test
	public void testPotencia() {
		long l = u.potencia(2, 3);
		assertEquals(8l, l);
	}

}
