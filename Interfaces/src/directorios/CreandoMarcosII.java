/**
 * 
 */
package directorios;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

/**
 * @author Jeampierre
 *
 */
public class CreandoMarcosII extends JFrame implements WindowFocusListener {

	/* (non-Javadoc)
	 * @see java.awt.event.WindowFocusListener#windowGainedFocus(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowGainedFocus(WindowEvent e) {
		if(e.getSource()==marco1) {
			marco1.setTitle("Tengo el Focus!!");
		}else {
			marco2.setTitle("Tengo el Focus!!");
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowFocusListener#windowLostFocus(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowLostFocus(WindowEvent e) {
			if(e.getSource()==marco1) {
			marco1.setTitle("");
		}else {
			marco2.setTitle("");
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CreandoMarcosII miVentana = new CreandoMarcosII();
		
		miVentana.iniciar();
	}
	
	public void iniciar() {
		
		marco1 = new CreandoMarcosII();
		
		marco2= new  CreandoMarcosII();
		
		marco1.setVisible(true);
		
		marco2.setVisible(true);
		
		marco1.setBounds(300, 100, 600, 350);
		
		marco2.setBounds(1000, 100, 600, 350);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
	
	
	
	
	}

	CreandoMarcosII marco1;
	CreandoMarcosII marco2;
	 
}
