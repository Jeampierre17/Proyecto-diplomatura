package mvc;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Soporte.SoporteParaProbarLaVista;
import mvc.Modelo;
import mvc.Vista;

public class ModeloTest {
	
	private Modelo m;

	@Before
	public void setUp() throws Exception {
		m = new Modelo();
	}

	@After
	public void tearDown() throws Exception {
		m =  null;
	}

	@Test
	public void testModelo() {
		assertTrue(m instanceof Modelo);
	}

	@Test
	public void testGetMensaje() {
		String mensaje= "Bienvenido a mvc";
		assertEquals(mensaje, m.getMensaje());
	}

	@Test
	public void testGetClima() {
		String clima= "Soleado";
		assertEquals(clima, m.getClima());
	}

	@Test
	public void testSetMensaje() {
		String mensaje= "Esto es una prueba unitaria";
		m.setMensaje(mensaje);
		String resultadoEsperado = m.getMensaje();
		assertEquals(mensaje, resultadoEsperado );
	}

	@Test
	public void testSetClima() {
		String mensaje= "Esto es una prueba unitaria";
		m.setClima(mensaje);
		String resultadoEsperado = m.getClima();
		assertEquals(mensaje, resultadoEsperado );
	}

	@Test
	public void testAgregrarOyenteDeCambiosEnElModelo() {
	Vista vista=  new SoporteParaProbarLaVista(m);
	m.agregrarOyenteDeCambiosEnElModelo(vista);
	m.setMensaje("Mesaje de prueba unitaria");
	boolean correcto = ((SoporteParaProbarLaVista) vista).getNotificacion();
	assertTrue(correcto);
	
	}

}
