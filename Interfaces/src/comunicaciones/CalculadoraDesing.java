package comunicaciones;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculadoraDesing extends JFrame{
	
	public static void main(String[] args) {
		CalculadoraDesing run= new CalculadoraDesing();
		
		run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	
	public CalculadoraDesing() {
		
		setTitle("Calculadora");
		setVisible(true);
		setBounds(100, 100, 304,350);
		
	
		
		//getContentPane().add(panel, BorderLayout.SOUTH);

		
		
		//getContentPane().add(panel2, BorderLayout.SOUTH);

		//pack();
		
		
		
		
		
		
		
		panel= new JPanel();
		
		panel.setBorder(new EmptyBorder(4,4,4,4));
		panel.setLayout(new BorderLayout());
		
		setContentPane(panel);
		
		pantalla= new JTextField("0");
		panel.add(pantalla, BorderLayout.NORTH);
		
		
		panel2= new JPanel();
		
		panel2.setLayout(new GridLayout(4,4,0,0));
			
		 
	ActionListener inserta = new InsertaNumero();
	
	ActionListener accion = new operaciones();
	//se lee solo al iniciar una vez
	principio=true;
	
	ponerBoton("7", inserta);
	
	ponerBoton("8", inserta);
	
	ponerBoton("9", inserta);

	ponerBoton("/", accion);

	ponerBoton("4", inserta);
	
	ponerBoton("5", inserta);
	
	ponerBoton("6", inserta);
	

	
	
	ponerBoton("*", accion);
	
	ponerBoton("1", inserta);

	ponerBoton("2", inserta);
		
	ponerBoton("3", inserta);
	
	
	ponerBoton(".", inserta);

	ponerBoton("0", inserta);
	
	ponerBoton("-", accion);
	
	
	ponerBoton("+", accion);

	ponerBoton("=", accion);
	
	panel.add(panel2, BorderLayout.CENTER);
	
	ultimaOperación = "=";
	
}

		


private void ponerBoton(String boton, ActionListener accion) {
	
	JButton numero = new JButton(boton);
	
	numero.addActionListener(accion);
	panel2.add(numero);
}
 
private class InsertaNumero implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String entrada =  e.getActionCommand();
		//se usa para cuando inicie se borre el 0
		if(principio) {
			
			pantalla.setText("");
			
			principio= false;
		}
		pantalla.setText(pantalla.getText()+entrada);
	
	}
	
	
		 
	 }
	
	
	private JPanel panel;
	
	private JTextField pantalla;
	
	private JPanel panel2;
	
	private boolean principio ;

	private double resultado;
	
	private String ultimaOperación;
	
	
	private class operaciones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//devuelve el comando de pantalla
			String numero= e.getActionCommand();
			
			//coversion de tipo a double con parseDouble
			calcular(Double.parseDouble(pantalla.getText()));
			
			
			ultimaOperación= numero;
			//elimina el 0 por defecto
			principio = true;
			
			
		}
		
		public void calcular(double x) {
			
			if(ultimaOperación.equals("+")) {
				resultado+=x;
			}
			if(ultimaOperación.equals("-")) {
				resultado-=x;
			}
			if(ultimaOperación.equals("*")) {
				resultado*=x;
			}if(ultimaOperación.equals("/")) {
				resultado/=x;
			}
			
			else if(ultimaOperación.equals("=")) {
				resultado=x;
			}
		
			pantalla.setText(""+resultado);
		}
	}
	}

	
	



