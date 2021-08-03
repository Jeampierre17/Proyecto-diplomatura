import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilidadesDeTextoTest {

	private UtilidadesDeTexto u;
	
	@BeforeEach
	void setUp() throws Exception {
		u = new UtilidadesDeTexto();
	}

	@AfterEach
	void tearDown() throws Exception {
		u= null;
	}

	@Test
	void testContarPalabras() {
	String completo= "uno mas uno mas uno menos uno";
	int c = u.contarPalabras(completo, "uno");
	assertEquals(4,  c);
	}

}
