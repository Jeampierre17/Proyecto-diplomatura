package mvc;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.*;

import Soporte.SoporteParaProbarLaVista;
import mvc.Controlador;
import mvc.Modelo;
import mvc.Vista;

public class ControladorTest {
	
	private Modelo m;

	@Before
	public void setUp() throws Exception {
		m = new Modelo();
	}

	@After
	public void tearDown() throws Exception {
		m= null;

	}

	@Test
	public void testControlador() {
		assertTrue(m instanceof Modelo);

	}

	@Test
	public void testProcesarObtLAMensaje() {
		Vista vista =  new SoporteParaProbarLaVista(m);
		Controlador con = new Controlador(m, vista);
		con.procesarObtenerMensaje();
		boolean correcto = ((SoporteParaProbarLaVista) vista).getNotificacion();
		assertTrue(correcto);
		
	}

	@Test
	public void testProcesarObtenerClima() {
		Vista vista =  new SoporteParaProbarLaVista(m);
		Controlador con = new Controlador(m, vista);
		con.procesarObtenerClima();
		boolean correcto = ((SoporteParaProbarLaVista) vista).getNotificacion();
		assertTrue(correcto);	
	}

	@Test
	public void testProcesarActualizarMensaje() {
		Vista vista =  new SoporteParaProbarLaVista(m);
		Controlador con = new Controlador(m, vista);
		m.agregrarOyenteDeCambiosEnElModelo(vista);
		String mensaje = ("esto es una prueba unitaria");
		con.procesarActualizarMensaje(mensaje);
	
		assertEquals(mensaje, m.getMensaje());
	}

	@Test
	public void testProcesarActualizarClima() {
		Vista vista =  new SoporteParaProbarLaVista(m);
		Controlador con = new Controlador(m, vista);
		String clima = "esto es una prueba unitaria";
		m.agregrarOyenteDeCambiosEnElModelo(vista);
		con.procesarActualizarClima(clima);
		//boolean correcto = ((SoporteParaProbarLaVista) vista).getNotificacion();
		assertEquals(clima, m.getClima());

	}

}
