package mvc;

//Deberá agregar 5 líneas de código en cada uno de los lugares 
//indicados. Los podrá reconocer porque se encuentran 
//indicaciones en líneas de comentarios

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
		// ** 1 Acción Requerida: falta una línea de código
		// ** Pista 1: El Controlador debe registrartse a si mismo como listener
		// ** (oyente) de las acciones del usuario (presión de botones) en la vista
		// ** Pista 2: Llamar al método agregarOyenteDeAccionDelUsuario() 
		// ** del objetovista y pasarle la referencia de este objeto Controlador

    }
    
    // métodos para gestionar las acciones del usuario
    public void procesarObtenerMensaje() {
        System.out.println("Controlador " + idControlador +
                ": procesarObtenerMensaje() ");
        vista.mostrarPantalla("Clima");
		// ** 2 Acción Requerida: falta una línea de código
		// ** Pista 1: El Controlador debe consultar la vista para mostrar
		// ** su página de mensaje
		// ** Pista 2: Llamar al método mostrarPantalla() del objeto
		// ** vista y pasarle el string "mensaje"

    }
    
    public void procesarObtenerClima() {
        System.out.println("Controlador " + idControlador +
                ": procesarObtenerClima() ");
        modelo.setClima("Clima");
		// ** 3 Acción Requerida: falta una línea de código
		// ** Pista 1: El Controlador debe consultar la vista para mostrar
		// ** su página de clima
		// ** Pista 2: Llamar al método mostrarPantalla() del objeto
		// ** vista y pasarle pasarle el string "clima"

    }
    
    public void procesarActualizarMensaje(String mensaje) {
        System.out.println("Controlador " + idControlador +
                ": procesarActualizarMensaje() ");
        modelo.setMensaje(mensaje);
		// ** 4 Acción Requerida: falta una línea de código
		// ** Pista 1: El Controlador debe actualizar el modelo con el
		// ** nuevo mensaje almacenado en el parámetro mensaje
		// ** Pista 2: Llamar al método setMensaje() del objeto
		// ** modelo y pasarle el parámetro mensaje

    }
    
    public void procesarActualizarClima(String clima) {
        System.out.println("Controlador " + idControlador +
                ": procesarActualizarClima() ");
        this.procesarActualizarClima(clima);
		// ** 5 Acción Requerida: falta una línea de código
		// ** Pista 1: El Controlador debe actualizar el modelo con la nueva
		// ** información del clima almacenado en el parámetro clima
		// ** Pista 2: Llamar al método setClima() del objeto
		// ** modelo y pasarle el parámetro clima

    }
}
