package comunicaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientePI {

	public static void main(String[] args) {
		MarcoCliente m = new MarcoCliente();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCliente extends JFrame {
	public MarcoCliente() {
		setBounds(600, 300, 280, 350);
		setTitle("Chat");
		LaminaMarcoCliente lamina = new LaminaMarcoCliente();
		
		add(lamina);
		setVisible(true);
		
	
	}
	
	
	class LaminaMarcoCliente extends JPanel{
		
		
		private JTextField campo1;
		
		private JButton boton1;
		
		public LaminaMarcoCliente() {
			JLabel texto = new JLabel("Cliente");
			
			add(texto);
			
			campo1= new JTextField(20);
			
			add(campo1);
			boton1= new JButton("Enviar");
			enviarTexto e = new enviarTexto();
			
			boton1.addActionListener(e);
			
			add(boton1);
			
		
			
		}
		
		
		private class enviarTexto implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					//Creamos un socket que va servir de comunicador de un chat cliente-servidor
					//toma como primer argumento el constructor la direccion IP
					//y como segundo argumento el Puerto
					Socket mysocket= new Socket("192.168.0.115", 9999);
					
					//DataOS para salida de datos toma como parametro en el contructor
					//el socket sobre la cual va hacer el flujo de datos
					DataOutputStream salida = new DataOutputStream(mysocket.getOutputStream());
					
					
					salida.writeUTF(campo1.getText());
				
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
			}
				
		
			
		
		
		
		}
	}

	
}
