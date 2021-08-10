package comunicaciones;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

import org.w3c.dom.views.AbstractView;


import com.sun.imageio.stream.StreamCloser.CloseAction;

import sun.awt.TimedWindowEvent;

import java.awt.event.KeyAdapter;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DropMode;

public class ChatDesing {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChatDesing chat = new ChatDesing();
		
		chat.Marco();
		
		
	}

	
	private JTextArea MensajeEntrante;
	private JTextField MensajeEnviar;
	private JButton enviar;
	private JButton salir;
	private JComboBox<String> nombresUsuario;
	private JScrollPane PanelTexto;
	private JDialog jd;
	private JFrame marco;
	
	public ChatDesing() {
		
		MensajeEntrante =  new JTextArea(10,50);
		MensajeEnviar =  new JTextField(30);
		
		PanelTexto= new JScrollPane(MensajeEntrante, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		MensajeEnviar.setToolTipText("Escribe para iniciar el chat..");

		MensajeEnviar.setHorizontalAlignment(SwingConstants.RIGHT);
		
		MensajeEnviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String mensaje = MensajeEnviar.getText();
					Object usurio = nombresUsuario.getSelectedItem();
					MensajeEntrante.append(mensaje + "\n"+ (String) usurio+"\n");
			
				}
				
			}
		});
		
		enviar =  new JButton("Enviar");
		salir = new JButton("Salir");
		//evento de mensaje salir
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s) {
			System.exit(0);
			}
		});
	
	}
	
	
	public void Marco(){
		marco =  new JFrame("Chat");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.getContentPane().setLayout(new BorderLayout());
		
		//Creamos un borde de separación entre los componentes
		marco.setLayout(new BorderLayout(10, 10));
		marco.getContentPane().add(MensajeEntrante, BorderLayout.WEST);
			JPanel p1= new JPanel();
			
			p1.add(MensajeEnviar);
		marco.getContentPane().add(p1, BorderLayout.SOUTH);
		

		//JLabel texto = new JLabel("Escribe tu mail :");
		
		
	
		
		JPanel p2= new JPanel();
		p2.setLayout( new GridLayout(2,1));
		p2.add(enviar);
		
		//p1.add(texto);
		p2.add(salir);
		
		
		//agragamos componentes de JPanel a JFrame 
		//le damos una pocision dentro de Marco
		marco.getContentPane().add(p2, BorderLayout.EAST);
		
		//marco.getContentPane().add(p1, BorderLayout.CENTER);
		
		marco.pack();
		marco.setVisible(true);
		
		DameTexto evento = new DameTexto();
		
		//con "enviar" se genera la accion al presionar dicho boton
		enviar.addActionListener(evento);
		add(p1, BorderLayout.SOUTH);
		
		//agregar ComboBox
		
		
		nombresUsuario = new JComboBox<String>();
		nombresUsuario.setFont(new Font("Arial", Font.ITALIC, 9));
		
		nombresUsuario.addItem("Pedro Ramirez, 1337dud3, Flash");
		
		nombresUsuario.addItem("Maria Jose, Ayacucho 222, Caba");
		
		nombresUsuario.addItem("Mario Perez, Tigre 233, Tigre");
		
		
		p2.add(nombresUsuario, BorderLayout.SOUTH);
				
		//putValue(Action.SHORT_DESCRIPTION,  "Escribe tu mail");
		
		

        // Crear la barra y el menú Archivo
		
		JMenuBar mb= new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenuItem salir= new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		archivo.add(salir);
		mb.add(archivo);
		marco.setJMenuBar(mb);

		
		JMenu Ayuda = new JMenu("Ayuda");
        JMenuItem jm = new JMenuItem("Acerca De...");
        jm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( jd == null ) {
	                jd = new Dialogo(marco, "Acerca De...", true);
	            }
	            jd.setVisible(true);
				
			}
		});
        Ayuda.add(jm);
        mb.add(Ayuda);
        
	}
	
	
	private void add(JPanel p1, String south) {
		// TODO Auto-generated method stub
		
	}


	private class DameTexto extends AbstractButton implements ActionListener{
		
		
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			String mensaje = MensajeEnviar.getText();
			Object usurio = nombresUsuario.getSelectedItem();
			MensajeEntrante.append(mensaje + "\n"+ (String) usurio+"\n");
		
		}
		public DameTexto() {
			
		}
		
		
	}
	
	private class Dialogo extends JDialog implements ActionListener{
		public Dialogo(JFrame padre, String titulo, boolean modal) {
			super(padre, titulo, modal);
			add(new JLabel("El Chat es una herrameinta que permite entablar conversaciones con otros clientes de char via un servidor de chat"), BorderLayout.NORTH);
			JButton b = new JButton("Aceptar");
			add(b, BorderLayout.SOUTH);
			b.addActionListener(this);
			pack();
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		      // Ocultar el cuadro de diálogo cuando se presiona Aceptar
			 setVisible(false);
		}
	}
}

class ManejadorCerrar extends WindowAdapter {
    public void windowClosing(TimedWindowEvent e) {
        System.exit(0);
    }
}

