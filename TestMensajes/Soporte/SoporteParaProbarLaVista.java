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
    // si el método procesarCambioEnElModelo
    // fue invocado
    public boolean getNotificacion () {
        return notificacion;
    }

    // Rescribe el método de la vista para asegurar que el
    // mismo es invocado
     public void procesarCambioEnElModelo(Object evento) {
         notificacion = true;
     }
     
     // Rescribe el método de la vista para asegurar que el
     // mismo es invocado sin interrumpir la invocación al usar
     // el método de la superclase
     public void mostrarPantalla(String pantalla){
    	 super.mostrarPantalla(pantalla);
    	 notificacion = true;
     }
     
     // Rescribe el método de la vista para asegurar que el
     // mismo es invocado sin interrumpir la invocación al usar
     // el método de la superclase
     public void agregarOyenteDeAccionDelUsuario(Controlador con){
    	 super.agregarOyenteDeAccionDelUsuario(con);
    	 notificacion = true;
     }
}
