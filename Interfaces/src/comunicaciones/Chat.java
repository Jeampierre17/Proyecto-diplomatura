package comunicaciones;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.w3c.dom.views.AbstractView;

public class Chat {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Chat chat = new Chat();
		
		chat.Marco();
	}

	
	private JTextArea MensajeEntrante;
	private JTextField MensajeEnviar;
	private JButton enviar;
	private JButton salir;
	
	public Chat() {
		
		MensajeEntrante =  new JTextArea(10,50);
		MensajeEnviar =  new JTextField(50);
		
		enviar =  new JButton("Enviar");
		salir = new JButton("Salir");
	
	}
	
	
	public void Marco(){
		JFrame marco =  new JFrame("Chat");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setLayout(new BorderLayout());
		
		marco.add(MensajeEntrante, BorderLayout.WEST);
		
		marco.add(MensajeEnviar, BorderLayout.SOUTH);
		

		//JLabel texto = new JLabel("Escribe tu mail :");
		
		
		JPanel p1= new JPanel();
		p1.setLayout( new GridLayout(2,1));
		p1.add(enviar);
		//p1.add(texto);
		p1.add(salir);
		
		marco.add(p1, BorderLayout.CENTER);
		
		marco.pack();
		marco.setVisible(true);
		
		DameTexto evento = new DameTexto();
		
		//con "enviar" se genera la accion al presionar dicho boton
		enviar.addActionListener(evento);
		p1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String mensaje = MensajeEnviar.getText();
					MensajeEntrante.setText(mensaje);
				}
			}
		});
		
				
		//putValue(Action.SHORT_DESCRIPTION,  "Escribe tu mail");
	}
	
	
	private class DameTexto extends AbstractButton implements ActionListener{
		
		
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			String mensaje = MensajeEnviar.getText();
			MensajeEntrante.setText(mensaje);
		
		}
		public DameTexto() {
			
		}
		
		
	}
}
