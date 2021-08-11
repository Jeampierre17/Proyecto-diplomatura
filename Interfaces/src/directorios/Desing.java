package directorios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Desing extends JFrame {
	public Desing() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
	}

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente

	}

}
