package directorios;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1 = new miMarco();
		
		//1)Creamos un objeto de MenuBar
		JMenuBar mb =  new JMenuBar();
		
		//Inicializamos dentro de un contenedor de menu, como un frame(marco1)
		marco1.setJMenuBar(mb);
		
		//2)Creamos objetos menu
		JMenu m1 = new JMenu("File");
		JMenu m2 =  new JMenu("Edit");
		JMenu m3 =  new JMenu("Help");
		
		//Agregamos objetos a la barra de menu
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		
		//Agregamos objetos de MenuItem
		
		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Save");
		JMenuItem mi3 = new JMenuItem("Load");
		JMenuItem mi4 = new JMenuItem("Quit");
		
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
	
		 //instaciar envetos de Teclado
		 
		 EventosTeclado teclado = new EventosTeclado();
		 
		 addKeyListener(teclado);

		
		
	}
	


	
	}

class Lamina1 extends JPanel{
	
	//Creamos un marco para un Panel
	public void paintComponent(Graphics g) {
		
	
		
		super.paintComponent(g);
		
		setLayout(null);
		
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
		 //DIBUJAR UN MEDIO ARCO
		 g2.drawArc(220, 200, 200, 200, 100, 100);
		 
		 
		 //creacion de poligano/ declarar un array
		int pentagonox[] = {50, 50,  90, 90, 150, 90, 90};
		int pentagonoy[]= {55, 85, 85, 110, 70, 30, 55};
		 g2.setColor(Color.GREEN);
		 g2.drawPolygon(pentagonox, pentagonoy, 7);
		 
		 //Creacion de recatgulo3d
		 /*g2.setColor(Color.PINK);
		 g2.draw3DRect(10, 10, 50, 100, true);*/
		 
		 
		 //Instaciamos los cuadros de textos
	
		 Cuadro1 = new JTextField();
		 
		 Cuadro2= new JTextField();
		 
		 Cuadro1.setBounds(200, 40, 150, 20);
		 
		 Cuadro2.setBounds(200, 80, 150, 20);
		 
		 add(Cuadro1);
		 add(Cuadro2);
		 
		 focus foco = new focus();
		 Cuadro1.addFocusListener(foco);
		 
	}
	
	
	//Creamos dos cuadro del Tipo cuadro de textos
	JTextField Cuadro1;
	JTextField Cuadro2;
	
	//Creamos Clase interna focus para acceder a los cuadros de textosd
	
	class focus implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
		
			
			 
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			String mail= Cuadro1.getText();
			
			boolean comprobacion= false;
			
			
				//charAt() recorre caracter por caracter
				//los datos de tipo char van con milla simple(ALT+39)
				for(int i = 0; i< mail.length(); i++) {
				while( mail.charAt(i) == '@') 
				comprobacion = true;
				
				
				
		
				}
			if(comprobacion==true) {
				System.out.println("Correcto");
			} else {
				System.out.println("Incorrecto");
			}
			
		} 
			
	}
	
}

//Clase de Evento de Teclado

class EventosTeclado implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		System.out.println("Haz precionado la tecla con el código: " + codigo);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Soltaste el Teclado");

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		char letra = arg0.getKeyChar();
		System.out.println("Haz precionado la letra: " + letra);
	}

}
	
	


