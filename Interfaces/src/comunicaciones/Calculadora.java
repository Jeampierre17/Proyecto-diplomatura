package comunicaciones;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame{
	
	public static void main(String[] args) {
		Calculadora run= new Calculadora();
		run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public Calculadora() {
		
		setVisible(true);
		setBounds(100, 100, 300,500);
		
		Panel panel = new Panel();
		
		add(panel);
		
	}

}

class Panel extends JPanel{
	private JTextField pantalla;
	
	public Panel() {
		
		setLayout(new BorderLayout());
		
		pantalla= new JTextField("0");
		add(pantalla, BorderLayout.NORTH);
		
		
		
		
	}
}