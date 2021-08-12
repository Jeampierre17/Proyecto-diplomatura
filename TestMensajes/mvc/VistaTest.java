package mvc;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Soporte.SoporteParaProbarLaVista;
import mvc.Controlador;
import mvc.Modelo;
import mvc.Vista;

public class VistaTest {

	private Modelo m;
	private Vista vista=  new SoporteParaProbarLaVista(m);
	@Before
	public void setUp() throws Exception {
		m = new Modelo();
	}

	@After
	public void tearDown() throws Exception {
		m=null;
	}

	@Test
	public void testVista() {
		assertTrue(m instanceof Modelo);
	}

	@Test
	public void testProcesarCambioEnElModelo() {
		
		m.agregrarOyenteDeCambiosEnElModelo(vista);
		Controlador con = new Controlador(m, vista);
		con.procesarActualizarMensaje("Esto es un mensaje de Prueba unitaria");
		boolean correcto= ((SoporteParaProbarLaVista)vista).getNotificacion();
		assertTrue(correcto);
	}

	@Test
	public void testAgregarOyenteDeAccionDelUsuario() {
		Controlador con = new Controlador(m, vista );
		vista.agregarOyenteDeAccionDelUsuario(con);
		m.setMensaje("Prueba unitaria");
		boolean correcto= ((SoporteParaProbarLaVista)vista).getNotificacion();
		assertTrue(correcto);

	}

	@Test
	public void testMostrarPantalla() {
		fail("No implementado aun");
	}

}
