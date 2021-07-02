package directorios;

import java.util.*;

public class Ruta {
	public static void main(String[] arogs) {
		//File archivo = new File("C:/Users/Jeampierre/Desktop/ProgramacionDiplomatura/NuevaCarperta");
		
		//archivo.mkdir();
		//System.out.println(archivo.getAbsolutePath());
		//System.out.println(archivo.exists());
		
		List lista2 = new LinkedList<>();
		lista2.add("Uno");
		lista2.add("segundo");
		lista2.add(3);
		
		ListIterator elemento = lista2.listIterator();
		
		while(elemento.hasNext()) {
			System.out.print(elemento.next()+"\t");
			
		}
		System.out.println();
		while (elemento.hasPrevious()){
			System.out.print(elemento.previous()+ "\t");
			
		}
		
	}

}
