package comunicaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sun.jvm.hotspot.ui.table.SortHeaderCellRenderer;

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
	
	//implemnetamos la interfaz Runnable para posibilitar varios subprocesos Threands
	class LaminaMarcoCliente extends JPanel implements Runnable{
		
		
		private JTextField campo1, nick, ip;
		
		private JButton boton1;
		
		private JTextArea campochat;
		
		
		
		
		public LaminaMarcoCliente() {
			
			nick = new JTextField(5);
			
			add(nick);
			
			JLabel texto = new JLabel("-Chat-");
			
			add(texto);
			
			ip = new JTextField(8);
			
			add(ip);
			campochat = new JTextArea(12,20);
			
			add(campochat);
			
			campo1= new JTextField(20);
			
			add(campo1);
			boton1= new JButton("Enviar");
			enviarTexto e = new enviarTexto();
			
			boton1.addActionListener(e);
			
			add(boton1);
			
		//Ponemos en funcionamiento el Threads dentro de la misma clase
			
			Thread hilo = new Thread(this);
			
			hilo.start();
			
		}
		
		
		private class enviarTexto implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					//Creamos un socket que va servir de comunicador de un chat cliente-servidor
					//toma como primer argumento el constructor la direccion IP
					//y como segundo argumento el Puerto 
					Socket mysocket= new Socket("192.168.0.115", 9999);
				
					//Se va enviar un objeto 
					//se instacia la clase con  el objeto
					
					paqueteDeEnvio datos = new paqueteDeEnvio();
					
					//obtemos el texto que se ingrese en los TextFields
					//dicho valor se almacenara en la nueva clase creada "paqueteDeEnvio"
					datos.setNick(nick.getText());
					
					datos.setIp(ip.getText());
					
					datos.setMensaje(campo1.getText());
					
					//---Envio de Objeto
					
					//DataOS para salida de datos toma como parametro en el contructor
					//el socket sobre la cual va hacer el flujo de datos
					ObjectOutputStream paquete = new ObjectOutputStream(mysocket.getOutputStream());					
					
					
					//escribir soble el flujo de salida el paquete a enviar
					
					paquete.writeObject(datos);
				
					
					
					//cerrar el socket
					mysocket.close();
					
					
					/*---Envio en caso de ser un Texto 
					 * 
					//DataOS para salida de datos toma como parametro en el contructor
					//el socket sobre la cual va hacer el flujo de datos
					
					DataOutputStream salida = new DataOutputStream(mysocket.getOutputStream());
					
					
					salida.writeUTF(campo1.getText());
				
				*/	
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
			}
			
		
		}


		@Override
		public void run() {
			
			
			
			
		try {
			//recibe el puerto para recibir ServerSockert
			ServerSocket recibir = new ServerSocket(9090);
			
			Socket cliente;
			
			paqueteDeEnvio paqueteRecibido;
			
			
			while(true) {
				//aceptamos el serversocket en el canal donde viajan los datos
				cliente= recibir.accept();
				
				ObjectInputStream flujoDeEntrada = new ObjectInputStream(cliente.getInputStream());

				paqueteRecibido= (paqueteDeEnvio) flujoDeEntrada.readObject();
			
			//escrbir en el TextArea
				
				campochat.append("\n"+paqueteRecibido.getNick()+": " + paqueteRecibido.getMensaje());
			
			}
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		}
	}

	
}



//Creamos una clase que va ser el paquete con el "Objeto" se va enviarse en el socket 
//implementamos la interfaz para serializarla, para poder ser enviada por la red
class paqueteDeEnvio implements Serializable {
	private String nick, ip, mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}