package directorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MultiplesListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Oyentes lanzar = new Oyentes();
		
		lanzar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	
}

class Oyentes extends JFrame{

	public Oyentes() {
		
		setTitle("Prueba Varios");
		setBounds(130, 100, 300, 200);
		
		setVisible(true);
		
		
		Lamina lamina = new Lamina();
		
		add(lamina);
		pack();
	}

	
	
}

class Lamina extends JPanel{
	
	public Lamina() {
		
		JButton boton_nuevo = new JButton("Nuevo");
		
		add(boton_nuevo);
		
		 boton_cerrar = new JButton("Cerrar");

		add(boton_cerrar);
		
		setVisible(true);
		
		
		OyenteNuevo oyente = new OyenteNuevo();
		
		
		//instaciamos en boton_nuevo la  instacia de OyenteNuevo
		//con el objeto de que este genere dicho evento
		
		boton_nuevo.addActionListener(oyente);
		
	}
		//creamos clase interna que iplemnete la acccion del evento
		JButton boton_cerrar;
		private class OyenteNuevo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				Marcos marcos= new Marcos(boton_cerrar);
				
				marcos.setVisible(true);
			}
			
			
			
			
		}

}


 

class Marcos extends JFrame{
	
	public Marcos(JButton boton) {
		
		//con cada llamada al constructor se sumara a uno el contador
		contador++;
		
		setTitle("Ventana "+ contador);
		
		setBounds(40*contador, 40*contador, 300, 150);
		
		closeEvery close = new closeEvery();
		
		boton.addActionListener(close);
	
		
	}
	
	
	//Esta  es la clase oyente encargada de cerrar todas las ventanas
	private class closeEvery implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//cierra todo los componente
			dispose();
		}
		
		
		
	}
	
	//creamos un atributo static para ser usado por cada nueva ventana emergente
	private static int contador=0;
	
	

}