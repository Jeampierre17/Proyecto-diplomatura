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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.w3c.dom.views.AbstractView;

import com.sun.glass.events.WindowEvent;
import com.sun.imageio.stream.StreamCloser.CloseAction;

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
	private JComboBox nombresUsuario;
	
	
	public ChatDesing() {
		
		MensajeEntrante =  new JTextArea(10,50);
		MensajeEnviar =  new JTextField(30);
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
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s) {
			System.exit(0);
			}
		});
	
	}
	
	
	public void Marco(){
		JFrame marco =  new JFrame("Chat");
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
		
		
		nombresUsuario = new JComboBox();
		nombresUsuario.setFont(new Font("Arial", Font.ITALIC, 9));
		
		nombresUsuario.addItem("Pedro Ramirez, 1337dud3, Flash");
		
		nombresUsuario.addItem("Maria Jose, Ayacucho 222, Caba");
		
		nombresUsuario.addItem("Mario Perez, Tigre 233, Tigre");
		
		
		p2.add(nombresUsuario, BorderLayout.SOUTH);
				
		//putValue(Action.SHORT_DESCRIPTION,  "Escribe tu mail");
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
}

class ManejadorCerrar extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

