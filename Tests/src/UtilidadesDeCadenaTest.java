import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilidadesDeCadenaTest {

	private UtilidadesDeCadena u;
	
	@BeforeEach
	void setUp() throws Exception {
		u = new UtilidadesDeCadena();
	}

	@AfterEach
	void tearDown() throws Exception {
		u =null;
	}

	@Test
	void testConcatenar() {
		String completo= "Buen día";
		String p1= "Buen";
		String p2 = "día";
		String res =u.concatenar(p1, p1);
	}

	@Test
	void testPrimerCaracter() {
	String completo = "Buen día";
	char c= u.primerCaracter(completo);
	assertEquals(c, 'B');
	}

	@Test
	void testUltimoCaracter() {
		String completo = "Buen día";
		char c=  u.ultimoCaracter(completo);
		assertEquals('a', c);
	}

}
