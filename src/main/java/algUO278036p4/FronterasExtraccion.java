package algUO278036p4;

import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class FronterasExtraccion {
	
public static String[] loadFile (String nombreFicheroEntrada, HashMap<String,String[]> listaFronteras) {
		
	    String linea;
	    ArrayList<String> keys = new ArrayList<String>();	   
	    String[] result; 
	    
	    try {
	    	   BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
	    		while (fichero.ready()) {
	    			linea = fichero.readLine();
	    			String[] aux = linea.split(": "); 
	    			listaFronteras.put(aux[0], aux[1].split(", "));
	    			keys.add(aux[0]);
	    		}
	    		fichero.close();
	    		result = new String[keys.size()];
	    		for (int i = 0; i < keys.size(); i++) {
	    			result[i] = keys.get(i);
	    		}
	    		return result;
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("El archivo no se ha encontrado.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("Error de entrada/salida.");
	    }
	    result = new String[keys.size()];
		for (int i = 0; i < keys.size(); i++) {
			result[i] = keys.get(i);
		}
		return result;
	  }

}
