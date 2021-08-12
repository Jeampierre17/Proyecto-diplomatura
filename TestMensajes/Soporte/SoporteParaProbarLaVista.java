package Soporte;

import mvc.Controlador;
import mvc.Modelo;
import mvc.Vista;

public class SoporteParaProbarLaVista extends Vista {

    private boolean notificacion = false;

    public SoporteParaProbarLaVista(Modelo modelo) {
		super(modelo);
		// TODO Auto-generated constructor stub
	}

    // Recuperar el resultado para comprobar
    // si el m�todo procesarCambioEnElModelo
    // fue invocado
    public boolean getNotificacion () {
        return notificacion;
    }

    // Rescribe el m�todo de la vista para asegurar que el
    // mismo es invocado
     public void procesarCambioEnElModelo(Object evento) {
         notificacion = true;
     }
     
     // Rescribe el m�todo de la vista para asegurar que el
     // mismo es invocado sin interrumpir la invocaci�n al usar
     // el m�todo de la superclase
     public void mostrarPantalla(String pantalla){
    	 super.mostrarPantalla(pantalla);
    	 notificacion = true;
     }
     
     // Rescribe el m�todo de la vista para asegurar que el
     // mismo es invocado sin interrumpir la invocaci�n al usar
     // el m�todo de la superclase
     public void agregarOyenteDeAccionDelUsuario(Controlador con){
    	 super.agregarOyenteDeAccionDelUsuario(con);
    	 notificacion = true;
     }
}
