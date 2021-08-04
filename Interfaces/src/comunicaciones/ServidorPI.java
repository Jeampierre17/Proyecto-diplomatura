package comunicaciones;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;

import javax.swing.*;

import javafx.beans.binding.SetBinding;
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

			//con un bucle while true nuestro codigo se ejecuta infinitamente
			while(true) {
			
			
			//acepta los metodos que vienen desde el exterior
			Socket misocket= servidor.accept();
			
			DataInputStream entrada =  new DataInputStream(misocket.getInputStream());
			
			String texto= entrada.readUTF();
			
			// append agrega el texto dato
			parrafo.append("\n"+texto);
			
			misocket.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

