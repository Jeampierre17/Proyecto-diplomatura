


import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;


public class UtilidadesDeCadenaTest {

	private UtilidadesDeCadena u;
	
	@Before
	public void setUp() throws Exception {
		u = new UtilidadesDeCadena();
	}

	@After
	public void tearDown() throws Exception {
		u =null;
	}

	@Test
	public void testConcatenar() {
		String completo= "Buen día";
		String p1= "Buen";
		String p2 = "día";
		String res =u.concatenar(p1, p1);
	}

	@Test
	public void testPrimerCaracter() {
	String completo = "Buen día";
	char c= u.primerCaracter(completo);
	assertEquals(c, 'B');
	}

	@Test
	public void testUltimoCaracter() {
		String completo = "Buen día";
		char c=  u.ultimoCaracter(completo);
		assertEquals('a', c);
	}

}
