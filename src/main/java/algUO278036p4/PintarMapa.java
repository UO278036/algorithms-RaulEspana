package algUO278036p4;

import java.util.ArrayList;
import java.util.HashMap;



public class PintarMapa{
    

    static String[] claves;
    ArrayList<String> colores;
    
    
    HashMap<String, String> colorPais;
    HashMap<String, String[]> paisFronteras;
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */

    public static void main(String[] args) {
//        long t1,t2;
//        
//        for (int n=1000;n<=1000000;n*=2)
//        {
//        	
//            t1 = System.currentTimeMillis ();
//
//            for (int repeticiones=1; repeticiones<=n;repeticiones++)
//            { 
//            	PintarMapa p = new PintarMapa();
//            	p.colorearMapa();
//            } 
//
//            t2 = System.currentTimeMillis ();
//
//            System.out.println (" n= "+n+ "TIEMPO="+(t2-t1));
//          
//        }
        
    	PintarMapa p = new PintarMapa();
    	p.colorearMapa();
    	p.imprimir();  	
    }
    
    
    public PintarMapa() {
    	colores = new ArrayList<String>();
    	
    	ColoresExtraccion.loadFile("target/colores.txt", colores);
    	
    	colorPais = new  HashMap<String, String>();
    	paisFronteras = new  HashMap<String, String[]>();
    	
    	claves = FronterasExtraccion.loadFile("target/fronteras.txt", paisFronteras);  	
    }
    
    
    private void imprimir() {
    	for(int i =0; i<colorPais.size();i++) {
    		System.out.println("Pais: " +claves[i] + " ;Color: " + colorPais.get(claves[i]));
    	}
    	
    }
    
    private void colorearMapa() {
    	for(int i=0; i< paisFronteras.size(); i++) {
    		String[] fronteras = paisFronteras.get(claves[i]);
    		for(int j=0; j< colores.size(); j++) {
    			boolean condicion = true;
    			if(fronteras[0].equals("NO")) {
    				colorPais.put(claves[i], colores.get(j));
    				break;
    			}else {
    				
	    			for(int f=0; f<fronteras.length ; f++) {
	    				if(colorPais.get(fronteras[f]) != null && colores.get(j) == colorPais.get(fronteras[f])) {
	    					condicion = false;
	    					break;
	    				}
	    				
	    			}
	    			if(condicion) {
	    				colorPais.put(claves[i], colores.get(j));	
	    				break;
	    			}
    			}
    		}       		
    	} 	
    }
}
