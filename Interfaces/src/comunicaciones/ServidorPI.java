package comunicaciones;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;


import java.net.*;

public class ServidorPI {
	
	public static void main(String[] args) {
		MarcoServidor marco =new MarcoServidor();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoServidor extends JFrame implements Runnable{
	
	private JTextArea parrafo;
	public MarcoServidor() {
		setBounds(600, 300, 280, 350);
		setTitle("Servidor");
		
		
		JPanel lamina = new JPanel();
		
		
		
		

		lamina.setLayout(new BorderLayout());
		
		parrafo = new JTextArea();
		
		lamina.add(parrafo, BorderLayout.CENTER);
		
		add(lamina);
		setVisible(true);
		
		
		//instaciamos un hilo tomando como referncia a la misma clase
		Thread hilo = new Thread(this);
		//theads se ejecuta con el metodo stat()
		hilo.start();
	}

	@Override
	public void run() {
		//ServerSocket espera a que lleguen solicitudes a través de la red
		try {
			
			ServerSocket servidor =  new ServerSocket(9999);

			String nick, ip, mensaje;
			
			paqueteDeEnvio paquete;
			
			
			//con un bucle while true nuestro codigo se ejecuta infinitamente
			while(true) {
			
			
			//acepta los metodos que vienen desde el exterior
			Socket misocket= servidor.accept();
			
			// --Recibir Objeto
			
			ObjectInputStream datos = new ObjectInputStream(misocket.getInputStream());
			
			paquete =  (paqueteDeEnvio) datos.readObject();
			
			
			//obtener del paquete los datos recibidos
			
			ip = paquete.getIp();
			
			nick =  paquete.getNick();
			
			mensaje = paquete.getMensaje();
			
			//agregar al TextArea
			
			parrafo.append("\n"+ nick+ ": "+mensaje+ " para: "+ ip);
			
			
			
			
			
			//cerramos socket
			
			misocket.close();
			
			
			
			/* -- Recibir texto
			
			DataInputStream entrada =  new DataInputStream(misocket.getInputStream());
			
			String texto= entrada.readUTF();
			
			// append agrega el texto dato
			parrafo.append("\n"+texto);
			
			
			misocket.close();
			*/
			
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
}

