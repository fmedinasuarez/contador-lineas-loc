/**
 * Clase PrincipalPrograma2: realiza la lectura de la ruta al directorio donde se 
 * encuantran los archivos(.java) de un programa, y luego cuenta la lineas de codigo LOC
 * utilizando la clase Programa2.
 * @autor: Fernando Medina
 */

package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import programa2.Programa2;

public class PrincipalPrograma2 {

	public static void main(String[] args) {
		try {
			System.out.println("IMPORTANTE: coloque todas los archivos(.java) que componen el programa en un mismo directorio.");
			System.out.print("Ahora escriba la ruta a ese directorio (ej. c:/programa/): ");
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String ruta = br.readLine();
			
			boolean rutaCorrecta = ruta.endsWith("/");
			
			if(rutaCorrecta) {
				Programa2 pr2 = new Programa2();
				int tamañoPrograma = pr2.ContadorLineasLOC(ruta);
				
				System.out.println("\nTamaño total del programa: "+tamañoPrograma);
			}
			else {
				System.out.println("\nLa ruta no es correcta, debe de terminar en \"/\" (ej. c:/programa/).");
			}
		}
		catch(final Exception e){
			e.printStackTrace();
			System.out.println("exception");
		}
	}
}
