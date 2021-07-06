package graficos;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons{
	
public static void main (String[] args) {
	
	//Instaciamos un objeto del tipo JFrame
	Window btt = new Window();

	btt.setVisible(true);
	

	//close por defecto
	btt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

}

//Clase Window hereda de JFrame
class Window extends JFrame{
	

	public Window() {
		setTitle("Botones");
		setBounds(400, 400, 550, 750);
		
		setVisible(true);
		
		//Instaciamos la clase EventButtons que hereda de la clase JPanel 
		// y se agreda como parametro el objeto de tipo JPanel
		

		EventsButtons evento = new EventsButtons();
		

		add(evento);
		
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
