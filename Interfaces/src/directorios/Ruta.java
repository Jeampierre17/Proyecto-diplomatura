package directorios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;



import sun.dc.pr.PathFiller;

public class Ruta {
	public static void main(String[] arogs) throws FileNotFoundException {
		FileReader archivo = new FileReader("C:/Users/Jeampierre/Desktop/ProgramacionDiplomatura/NuevaCarperta");
		
		try {
			archivo.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(archivo);
		
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
