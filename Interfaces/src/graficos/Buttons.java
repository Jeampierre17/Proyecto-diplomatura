package graficos;


import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons{
	
public static void main (String[] args) {
	
	//Instaciamos un objeto del tipo JFrame
	Window btt = new Window();

	btt.setVisible(true);
		btt.setTitle("Botones");
		btt.setBounds(500, 100, 500, 300);

	//close por defecto, al cerrarla se cierran el resto de las ventanas
	btt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Hacer que el tamaño del Frame se ajuste a los componentes(Label)
	btt.pack();

	//Creo segundo marco
	
	Window wd = new Window();
	 wd.setTitle("Ventana Oyente");
	 wd.setBounds(300, 300, 500, 300);
	 wd.pack();
	//Con DISPONE_ON_CLOSE  permite que no se cierren todas las ventanas al cerrar alguna
	
	wd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}

}

//Clase Window hereda de JFrame
class Window extends JFrame{
	

	public Window() {
		//setTitle("Botones");
		//setBounds(400, 400, 550, 750);
		
		setVisible(true);
		
		//Instaciamos la clase EventButtons que hereda de la clase JPanel 
		// y se agreda como parametro el objeto de tipo JPanel
		
		EventsButtons evento = new EventsButtons();
		
		add(evento);
		
	
		
		//Agregamos eventos de tipo Window Listener 
		/*Ventana oyenteWindow = new Ventana();
		//Agregamos el objeto instanciado
		  addWindowListener(oyenteWindow);*/
		
		//Simplificamos el codigo anadiendo una nueva intacia directa en el metodo addWindowListener
		addWindowListener(new Ventana());
		
		
		//Instacia para el cambio de estado del evento
		CambioEstado newState = new CambioEstado();
		addWindowStateListener(newState);

		//Intacia para los eventos con Mouse 
		
		EventsMouse m =  new EventsMouse();
		addMouseListener(m);
	
		//Creamos las dispocicion de los componentes
		//Le damos como paramentro al constructor la ubicacion que queremos darle
	 FlowLayout disposicion =   new FlowLayout(FlowLayout.CENTER);
	 
	 //usamos el objeto de tipo JPanel para instaciar la disposicion
	
	 evento.setLayout(disposicion);
	 
	 //instacia de eventos de MotioMouse
	
	 
	 movimientoMouse motion = new movimientoMouse();
	 
	 
	 addMouseMotionListener(motion);	 
	 
	
	 
	}
	

	

}

//Clase EventsButtons hereda de JPanel
//E implementa la interfaz ActionListener 

class EventsButtons extends JPanel implements ActionListener{
	
	
		
	
		JButton b1 = new JButton("OK");
		JButton b2 =  new JButton("Open");
		JButton b3 =  new JButton("Close");
	//Creamos metodo a instaciar en la clase Main
	
		/*public void LanzarButton() {
		setLayout(new FlowLayout());
		
		//Agregar Botones/Buttons a la clase JFrame, y le damos una ubicacion al border de la Window con BorderLayout
		 add(b1, BorderLayout.NORTH);
		//add(b2, BorderLayout.SOUTH);
		//add(b3, BorderLayout.WEST);
		
		
		//Definimos tamaño
		pack();
		setSize(100, 100);
		
		
	}*/

		public EventsButtons() {
		
		setVisible(true);
		add(b1);
		add(b2);
		add(b3);
		
	//desencadena evento teniendo como parametro la misma clase
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		}

		
		//Define la accion a ejecutar
	@Override
	public void actionPerformed(ActionEvent e) {
		//Obtenemos el desencadedante de la acción con getSource 
		Object boton = e.getSource();
		
		//Condicionamos dicho desencadenante para darle una funcion especifica a cada uno 
		if (boton == b1) {
		setBackground(Color.PINK);
	} else if(boton == b2) {
		setBackground(Color.YELLOW);
	} else if (boton == b3) {
		setBackground(Color.GREEN);
	}
	

}
	
	
}

class EventsMouse implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
System.out.println("Hiciste un click en las coordenadas X: "+ e.getX()+ " y en las coordenadas Y: "+ e.getY());		
	System.out.println("Haz hecho "+e.getClickCount()+" click");
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
System.out.println("Pasaste por un contenedor");		
}

	@Override
	public void mouseExited(MouseEvent e) {
System.out.println("Saliste de contededor");		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Presionaste el botón del mouse");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Soltaste el botón del mouse");
		
	}
	
	
	
}





//Clase de Movimiento de Mouse : MotionMouseListener


class movimientoMouse implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Estás arrastrando el mouse");		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Estás moviendo el ratón");
	}
	
	
	
}



//Clase de Evento para cuando la ventana cambia de estado

class CambioEstado implements WindowStateListener{

	
	
	@Override
	public void windowStateChanged(WindowEvent e) {
		System.out.println("La Ventana ha cambiado de estado");			
	
		System.out.println(JFrame.MAXIMIZED_BOTH + e.getOldState());
		
	}
	
}
  


class Ventana implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) {
	 System.out.println("Ventana Activada");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("La Ventana ha sido cerrada");
		}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Cerrando Ventana");	
	}   

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana Desactivada");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana Restaurada");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana Minimizada");
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana Abierta");
	}
	
	
}
