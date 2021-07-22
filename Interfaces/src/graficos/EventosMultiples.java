package graficos;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class EventosMultiples extends JFrame {

	public static void main(String[] args) {
		EventosMultiples action = new EventosMultiples();
		
		
		
	}
	
	public EventosMultiples() {
		
		setVisible(true);
		
		setTitle("Prueba de Action");
		
		setBounds(400, 350, 600, 300);
		
		PanelAction panel = new PanelAction();
		
		add(panel);
		
		pack();
	}
 

	
	
}

class PanelAction extends JPanel{
	
	public PanelAction() {
		
		listerButton red = new listerButton("Red" , new ImageIcon("C:/Users/Jeampierre/Desktop/ProgramacionDiplomatura/Ejercicios Proyecto Diplomatura Java/interfaces/icono_red.gif") , Color.RED);
		
		
		listerButton green = new listerButton("Green" , new ImageIcon("C:/Users/Jeampierre/Desktop/ProgramacionDiplomatura/Ejercicios Proyecto Diplomatura Java/interfaces/icono_green.gif") , Color.GREEN);

		
		listerButton blue = new listerButton("Blue" , new ImageIcon("C:/Users/Jeampierre/Desktop/ProgramacionDiplomatura/Ejercicios Proyecto Diplomatura Java/interfaces/icono_blue.gif") , Color.BLUE);

		//intaciamos dentro del add un objeto de tipo JButton(Action a)
		
		JButton a = new JButton(red);
		//add( new JButton(amarillo));
		add(a);
		add( new JButton(green));
		
		add( new JButton(blue));
		
		/**JButton b1, b2,b3;
		
		b1 = new JButton("Color Amarrillo");
		
		b2 = new JButton("Color Verde");
		
		b3 = new JButton("Color Rojo");
		
		
		add(b1);
		add(b2);
		add(b3);*/
		
		//Pasos para asignaciones de teclado
		//1) Crear Mapa de entrada
		
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		//2) Crear una combinación de teclas con la clase KeyStroke
		
		KeyStroke tecla_Red = KeyStroke.getKeyStroke("ctrl R");
		
		
		
		//3) Asiganar combinacion de teclas a objetos con InputMap, se cre un objeto 
		
		mapaEntrada.put(tecla_Red, "fondo red");
		
		//4) Asignar objetos a acciones con la clase ActionMAp
		
		ActionMap mapaAccion = getActionMap();
		
		mapaAccion.put("fondo red", red);
		
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl G"), "fondo green"); 
	
		
		mapaAccion.put("fondo gren", green);
	
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo blue");
		
		mapaAccion.put("fondo blue", blue);
	}
	
	
	//la hcemos una clase interna para uso de los metedos de JPanel
	
	class listerButton extends AbstractAction{
		
		public listerButton(String name, Icon icono, Color color) {
			// TODO Auto-generated constructor stub@Override
		
		//Nombre del Button	
		putValue(Action.NAME, name);
		
		
		//Icono del Button
		putValue(Action.SMALL_ICON, icono);
		
		
		//Descripcion al pocisionarse sobre el button
		putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color: "+ name);
		
		//Color del button
		putValue("Color de fondo", color);
		
		}
		
		
		

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//carting a Color de un getValue Key= "Color de fondo" 
			Color c= (Color) getValue("Color de fondo");
		
			setBackground(c);
			
			
			//Funcionalidad del metodo getValue: retorna una Key
			System.out.println("Nombre: "+getValue(Action.NAME) +" Descripción: "+ getValue(Action.SHORT_DESCRIPTION));
		}
		
		
	}
}

