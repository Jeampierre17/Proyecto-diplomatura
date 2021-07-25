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

import java.awt.event.KeyAdapter;

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
		MensajeEnviar =  new JTextField(50);
		
		MensajeEnviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String mensaje = MensajeEnviar.getText();
					
					MensajeEntrante.append(mensaje + "\n");
					
				}
				
			}
		});
		
		enviar =  new JButton("Enviar");
		salir = new JButton("Salir");
	
	}
	
	
	public void Marco(){
		JFrame marco =  new JFrame("Chat");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.getContentPane().setLayout(new BorderLayout());
		
		marco.getContentPane().add(MensajeEntrante, BorderLayout.WEST);
		
		marco.getContentPane().add(MensajeEnviar, BorderLayout.SOUTH);
		

		//JLabel texto = new JLabel("Escribe tu mail :");
		
		
		JPanel p1= new JPanel();
		p1.setLayout( new GridLayout(2,1));
		p1.add(enviar);
		//p1.add(texto);
		p1.add(salir);
		
		marco.getContentPane().add(p1, BorderLayout.CENTER);
		
		marco.pack();
		marco.setVisible(true);
		
		DameTexto evento = new DameTexto();
		
		//con "enviar" se genera la accion al presionar dicho boton
		enviar.addActionListener(evento);
		
		
				
		//putValue(Action.SHORT_DESCRIPTION,  "Escribe tu mail");
	}
	
	
	private class DameTexto extends AbstractButton implements ActionListener{
		
		
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			String mensaje = MensajeEnviar.getText();
			MensajeEntrante.append(mensaje+"\n");
		
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

