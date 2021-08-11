package mvc;

//Deber� agregar 5 l�neas de c�digo en cada uno de los lugares 
//indicados. Los podr� reconocer porque se encuentran 
//indicaciones en l�neas de comentarios

public class Controlador {
	// Referencias con el modelo y la vista
    private Modelo modelo;
    private Vista vista;
    private static int nroDeControlador=0;
    private int idControlador;
    
    
    public Controlador(Modelo modelo, Vista vista) {
        idControlador = ++nroDeControlador;
        System.out.println("Controlador " + idControlador +
                ": Controlador(modelo, vista)");
        this.modelo = modelo;
        this.vista = vista;
        vista.agregarOyenteDeAccionDelUsuario(this);
		// ** 1 Acci�n Requerida: falta una l�nea de c�digo
		// ** Pista 1: El Controlador debe registrartse a si mismo como listener
		// ** (oyente) de las acciones del usuario (presi�n de botones) en la vista
		// ** Pista 2: Llamar al m�todo agregarOyenteDeAccionDelUsuario() 
		// ** del objetovista y pasarle la referencia de este objeto Controlador

    }
    
    // m�todos para gestionar las acciones del usuario
    public void procesarObtenerMensaje() {
        System.out.println("Controlador " + idControlador +
                ": procesarObtenerMensaje() ");
        vista.mostrarPantalla("Clima");
		// ** 2 Acci�n Requerida: falta una l�nea de c�digo
		// ** Pista 1: El Controlador debe consultar la vista para mostrar
		// ** su p�gina de mensaje
		// ** Pista 2: Llamar al m�todo mostrarPantalla() del objeto
		// ** vista y pasarle el string "mensaje"

    }
    
    public void procesarObtenerClima() {
        System.out.println("Controlador " + idControlador +
                ": procesarObtenerClima() ");
        modelo.setClima("Clima");
		// ** 3 Acci�n Requerida: falta una l�nea de c�digo
		// ** Pista 1: El Controlador debe consultar la vista para mostrar
		// ** su p�gina de clima
		// ** Pista 2: Llamar al m�todo mostrarPantalla() del objeto
		// ** vista y pasarle pasarle el string "clima"

    }
    
    public void procesarActualizarMensaje(String mensaje) {
        System.out.println("Controlador " + idControlador +
                ": procesarActualizarMensaje() ");
        modelo.setMensaje(mensaje);
		// ** 4 Acci�n Requerida: falta una l�nea de c�digo
		// ** Pista 1: El Controlador debe actualizar el modelo con el
		// ** nuevo mensaje almacenado en el par�metro mensaje
		// ** Pista 2: Llamar al m�todo setMensaje() del objeto
		// ** modelo y pasarle el par�metro mensaje

    }
    
    public void procesarActualizarClima(String clima) {
        System.out.println("Controlador " + idControlador +
                ": procesarActualizarClima() ");
        this.procesarActualizarClima(clima);
		// ** 5 Acci�n Requerida: falta una l�nea de c�digo
		// ** Pista 1: El Controlador debe actualizar el modelo con la nueva
		// ** informaci�n del clima almacenado en el par�metro clima
		// ** Pista 2: Llamar al m�todo setClima() del objeto
		// ** modelo y pasarle el par�metro clima

    }
}
