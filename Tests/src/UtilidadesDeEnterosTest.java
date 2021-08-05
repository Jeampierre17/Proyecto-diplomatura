
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


class UtilidadesDeEnterosTest {
 
	
	private UtilidadesDeEnteros u;
	@BeforeEach
	void setUp() throws Exception {
		u= new UtilidadesDeEnteros();
	}

	@AfterEach
	void tearDown() throws Exception {
		u=null;
	}

	@Test
	void testPotencia() {
		long l = u.potencia(2, 3);
		assertEquals(8l, l);
	}

}
