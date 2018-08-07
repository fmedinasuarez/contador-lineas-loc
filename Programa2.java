/**
 * Clase Programa2: calcula la cantidad de lineas de codigo LOC de un programa.
 * @autor: Fernando Medina
 */

package programa2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programa2 {
	
	/*
	 * Funcion que calcula la cantidad de lineas de codigo LOC.
	 * Recibe como entrada la ruta donde se encuantran las clases del programa a analizar.
	 */
	public int ContadorLineasLOC(String ruta) {
		/*Creo el directorio donde se encuentran las clases*/
		File directorio = new File(ruta);
		/*Creo un array con los nombres de los archivos del directorio*/
		String [] archivos = directorio.list();
		
		int tamañoPrograma = 0;
		int cantidadArchivos = archivos.length;
		
		for(int i=0; i < cantidadArchivos; i++) {
			try {
				/*
				 * Creo el FileReader con la ruta y el nombre del archvio, 
				 * para comenzar a leer sus lineas.
				 */
				FileReader fr = new FileReader(ruta + archivos[i]);
				BufferedReader br = new BufferedReader(fr);
				
				int contadorLineas = 0;
				int contadorMetodos = 0;
				
				String linea = br.readLine();
				while(linea != null) {
					linea = linea.trim();
					
					/*Condiciones para que una linea no se tome en cuenta*/
					boolean comentario1 = linea.startsWith("/*");
					boolean comentario2 = linea.startsWith("*");
					boolean comentario3 = linea.startsWith("*/");
					boolean lineaVacia = (linea.length() == 0);
					
					if(!(comentario1 || comentario2 || comentario3 || lineaVacia)) {
						contadorLineas++;
						
						/*Creo una exp regular para reconocer los cabezales de los metodos*/
						Pattern patron = Pattern.compile("^((public|private)?( )?(static)?( )?\\w+ \\w+\\()");
						Matcher matcher = patron.matcher(linea);
	
						boolean metodo = matcher.find();
				        if(metodo) {
				        	contadorMetodos++;
				        }
					}
					
					linea = br.readLine();
				}
				System.out.println("\nNombre de Clase: " + archivos[i]);
				System.out.println("Numero de Items: "+contadorMetodos);
				System.out.println("Tamaño de Clase: "+contadorLineas);
				
				tamañoPrograma = tamañoPrograma + contadorLineas;
				br.close();
			}
			catch (IOException e) {
		        e.printStackTrace();
		        System.out.println("exception");
		    }
		}
		return tamañoPrograma;
	}
}
