package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1 = new miMarco();
		//1)Creamos un objeto de MenuBar
		MenuBar mb =  new MenuBar();
		
		//Inicializamos dentro de un contenedor de menu, como un frame(marco1)
		marco1.setMenuBar(mb);
		
		//2)Creamos objetos menu
		Menu m1 = new Menu("File");
		Menu m2 =  new Menu("Edit");
		Menu m3 =  new Menu("Help");
		
		//Agregamos objetos a la barra de menu
		mb.add(m1);
		mb.add(m2);
		mb.setHelpMenu(m3);
		
		//Agregamos objetos de MenuItem
		
		MenuItem mi1 = new MenuItem("New");
		MenuItem mi2 = new MenuItem("Save");
		MenuItem mi3 = new MenuItem("Load");
		MenuItem mi4 = new MenuItem("Quit");
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.addSeparator();
		m1.add(mi4);
		
		
		//Cierre por defecto del procesador al cerrar la pagina
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Titulo de el marco
		marco1.setTitle("Tree");
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		//Colocar Icono al Frame, del objeto de tipo Toolkit
		
		Image icono =  pantalla.getImage("C:/Users/Jeampierre/Desktop/ProgramacionDiplomatura/Ejercicios Práctica/icono.png");
		marco1.setIconImage(icono);
		
		
		
		
	}

}



class miMarco extends JFrame {
	
	private JButton button1, button2, button3;
	
	
	public miMarco() {
		//Tamaño y centralizacion de la Ventana
		Toolkit mipantalla= Toolkit.getDefaultToolkit();
		Dimension SizePantalla = mipantalla.getScreenSize();
		int alturaPantalla = SizePantalla.height;
		int anchoPantalla = SizePantalla.width;
		setSize(anchoPantalla/2, alturaPantalla/2);
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		setVisible(true);	
		
				//Instaciamos Lamina y la llamamos
				
				Lamina1 lamina = new Lamina1();
				
				add(lamina);
					//Dar color por defecto del sistema operativo a la lamina
		lamina.setBackground(SystemColor.window);
		//Dar color a todas la letras del panel
		lamina.setForeground(Color.RED);
		
		/*Como saber la fuentes que tiene el sistema operativo de la PC
		String [] nombresFuestes =  GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	 for(String s : nombresFuestes) {
		 System.out.println(s);
	 }*/
	
		

		
		
	}
	


	
	}

class Lamina1 extends JPanel{
	
	//Creamos un marco para un Panel
	public void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		
		g.setColor(Color.PINK.darker());
		//dibuja un cuadrado
		g.drawRect(120, 120, 300, 70);
		//ESCRIBE TEXTO 
		
		

		//Dar tamano y estilo a la letras
		 

		g.setFont( new Font("Courier", Font.BOLD, 18));
		g.drawString("Estamos aprendiendo Swing", 135, 160);
		
		//didujar linea
		g.drawLine(50, 150, 100, 150);
		
		
		//Refundicion de g 
		Graphics2D g2 =(Graphics2D) g;
		//Color para el rectagulo		
		g2.setPaint(Color.RED);
		Rectangle2D rectagulo = new Rectangle2D.Double(200, 195, 115 ,126.66 );
	//Aplicar  color

		//Relleno de interior
		g2.fill(rectagulo);
		
		//Color y dibujo del borde del rectagulo
		g2.setPaint(Color.GREEN);
		g2.draw(rectagulo);
		//uso de draw en g2 con el parametro rectagulo
		g2.draw(rectagulo);
		
		//Color pra Ovalo
		g2.setPaint(new Color(0, 179, 202));
		
		//Rellenar ovalo dentro del rectagulo, 
		g2.fillOval(200, 196,  115 ,(int) 126.66 );
		g2.setFont(new Font("Arial", Font.ITALIC, 20));
		g2.setColor(Color.WHITE);
		g2.drawString("Tree = Life", 210, 265);
		//dibujar y Color del circulo
		  g2.setPaint(Color.ORANGE.darker()	);
		 g2.drawOval(180, 175, 155, 166);
		
		 
		 }
}
