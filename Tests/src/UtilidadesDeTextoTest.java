
import org.junit.*;

import static org.junit.Assert.*;


public class UtilidadesDeTextoTest {

	private UtilidadesDeTexto u;
	
	@Before
	public void setUp() throws Exception {
		u = new UtilidadesDeTexto();
	}

	@After
	public void tearDown() throws Exception {
		u= null;
	}

	@Test
	public void testContarPalabras() {
	String completo= "uno mas uno mas uno menos uno";
	int c = u.contarPalabras(completo, "uno");
	assertEquals(4,  c);
	}

}
