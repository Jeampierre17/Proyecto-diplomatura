package Chat02;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.util.Properties;
import java.io.*;

public class ClienteDeChat implements Runnable {

	private Socket conexion = null;
    private BufferedReader entradaDelServidor = null;
    private PrintStream salidaAlServidor = null;
    
    private JTextArea jtaMensajesEntrantes;
    private JScrollPane jspPanelTexto;
    private JTextField jtfMensajesAEnviar;
    private JButton bEnviar;
    private JButton bSalir;
    private JFrame marco;
    private JComboBox<String> nombresUsuarios;
    private JDialog jdAcercaDe;
    
    public ClienteDeChat() {
        jtaMensajesEntrantes = new JTextArea(10,50);
        jspPanelTexto = new JScrollPane(jtaMensajesEntrantes, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jtfMensajesAEnviar = new JTextField(50);
        bEnviar = new JButton("Enviar");
        bSalir = new JButton("Salir");
        nombresUsuarios = new JComboBox<String>();
        nombresUsuarios.addItem("PeRamirez");
        nombresUsuarios.addItem("nud39");
        nombresUsuarios.addItem("Flash");
    }
    
    public void mostrarMarco() {
        marco = new JFrame("Ventana Para Chat");
        
		// Usar el gestor de salidas BorderLayout para el frame
        marco.setLayout(new BorderLayout());
        
        marco.add(jspPanelTexto, BorderLayout.WEST);
        marco.add(jtfMensajesAEnviar, BorderLayout.SOUTH);
        
		// Crea el panel con los botones
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(bEnviar);
        p1.add(bSalir);
        p1.add(nombresUsuarios);
        
		// Agregar el panel con los botones en el centro
        marco.add(p1, BorderLayout.CENTER);
 
        // Crear la barra y el menú Archivo
        JMenuBar jmb = new JMenuBar();
        JMenu jmArchivo = new JMenu("Archivo");
        JMenuItem jmiSalir = new JMenuItem("Salir");
        jmiSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmArchivo.add(jmiSalir);
        jmb.add(jmArchivo);
        marco.setJMenuBar(jmb);
        
        // Agregar la ayuda a la barra de menú
        JMenu jmAyuda = new JMenu("Ayuda");
        JMenuItem jmiAcercaDe = new JMenuItem("Acerca De...");
        jmiAcercaDe.addActionListener(new ManejadorAcercaDe());
        jmAyuda.add(jmiAcercaDe);
        jmb.add(jmAyuda);
        
        // Agregar el listener a los componentes apropiados
        bEnviar.addActionListener(new ManejadorEnviar());
        jtfMensajesAEnviar.addActionListener(new ManejadorEnviar());
        marco.addWindowListener(new ManejadorCerrar());
        bSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        marco.pack();
        marco.setVisible(true);
        
        realizarConexion();
        
        Thread thread = new Thread(this);
        
        thread.start();
        
    }
    
    private void realizarConexion() {
		FileInputStream in;
		Properties props = null;
		try {
			in = new FileInputStream("propCliente.txt");
			props = new Properties();
			props.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo de propCliente no encontrado...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se pudieron cargar las propiedades...");
			e.printStackTrace();
		}

        // Inicializar la información de la ip y el puerto del servidor
        
	
		
        try {
            // Crear la conexión al servidor de chat
        	Socket mysocket = new Socket("192.168.0.115", 2000);
        	
        	DataOutputStream envio= new DataOutputStream(mysocket.getOutputStream());
            
        	envio.writeUTF(jtfMensajesAEnviar.getText());
            // Preparar la corriente de entrada y almacenarla en una variable de instancia
            
            // Preparar la corriente de salida y almacenarla en una variable de instancia
            
            // Lanzar el thread de lectura
            envio.close();
        } catch (Exception e) {
            System.err.println("Imposible conectarse al servidor!");
            e.printStackTrace();
        }
    }
    
    private class ManejadorEnviar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = jtfMensajesAEnviar.getText();
            text = nombresUsuarios.getSelectedItem() + ": " + text + "\n";
            // Usar la corriente de salida obtenida en el socket y
            // almacenada en la variable salidaAlServidor para
            // invocar al método print() y así enviarle el trexto
            // al servidor
            salidaAlServidor.print(text);

            jtfMensajesAEnviar.setText("");
        }
    }
    
    private class ManejadorCerrar extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            exit();
        }
    }
    
    private void exit() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.err.println("Error mientras se cerraba la conexión al servidor.");
        }
        System.exit(0);
    }
    
    private class ManejadorAcercaDe implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Crear un cuadro de diálogo cuando se lo requiera
            if ( jdAcercaDe == null ) {
                jdAcercaDe = new AcercaDeDialog(marco, "Acerca De...", true);
            }
            jdAcercaDe.setVisible(true);
        }
    }
    
 	private class AcercaDeDialog extends JDialog implements ActionListener  {
		private static final long serialVersionUID = 4688687119526400797L;

		public AcercaDeDialog(Frame padre, String titulo, boolean modal) {
            super(padre,titulo,modal);
            add(new JLabel("El cliente de chat es una herramienta que permite " +
                    "entablar conversaciones con otros clientes de chat via un servidor de chat"),BorderLayout.NORTH);
            JButton b = new JButton("Aceptar");
            add(b,BorderLayout.SOUTH);
            b.addActionListener(this);
            pack();
        }

        // Ocultar el cuadro de diálogo cuando se presiona Aceptar
        public void actionPerformed(ActionEvent e) {
        	setVisible(false);
        	}
    }   
    
    
    public static void main(String[] args) {
        ClienteDeChat c = new ClienteDeChat();
        c.mostrarMarco();
    }

class LectorRemoto implements Runnable{

	@Override
	public void run() {
		try {
			ServerSocket recibir = new ServerSocket(2000);
			
			String texto;
			Socket socket;
			
			while(true) {
				
			socket =  recibir.accept();
			
        	DataInputStream lectura = new DataInputStream(socket.getInputStream());
        	
        	texto= lectura.readUTF();
        	
        	jtaMensajesEntrantes.append("\n"+texto);
			}
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	
	
}

@Override
public void run() {
	// TODO Esbozo de método generado automáticamente
	
}
}