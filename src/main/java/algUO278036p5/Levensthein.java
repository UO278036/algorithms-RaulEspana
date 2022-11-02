package algUO278036p5;
import java.util.Random;


public class Levensthein {
	int [][] matriz;
	String[] palabra1;
	String[] palabra2;
	

	/**
	 * Metodo main en el que lanzamos el constructor de 
	 * levensthein y posteriormente medimos tiempos creando
	 * palabras aleatorias gracias al metodo generadorPalabras()
	 * 
	 * @param arg numero de repeticiones, se pasa de parametro 
	 * principalmente para realiar las mediciones
	 */
	public static void main (String arg []) 
    {
		long t1,t2;
		int nVeces= Integer.parseInt (arg [0]);
		Levensthein lev;

		lev = new Levensthein("LOCOS","LOCA");
		System.out.println("Resultado: "+lev.distanciaLevensthein());
		lev.show();
		
//		for (int n=100;n<=1000000;n*=2)
//        {
//			//generadorPalabras(n)
//			lev = new Levensthein(generadorPalabras(n),generadorPalabras(n));	
//			t1 = System.currentTimeMillis ();
//			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++) 
//			{
//				lev.distanciaLevensthein();
//			}
//			t2 = System.currentTimeMillis ();
//			System.out.println (" n="+n+ "TIEMPO="+(t2-t1)+"nVeces="+nVeces);
//        }
    }
	
	/**
	 * Constructor de levensthein, creamos los arrays de
	 * las palabras 1 y 2 para despues poder lanzar el metodo
	 * de Levensthein sobre ellas, creamos las palabras del
	 * tamaño de los strings pasados como parametro +1 debido
	 * a las "" del problema.
	 * 
	 * @param uno, palabra uno de tipo string
	 * @param dos, palabra dos de tipo string
	 */
	public Levensthein(String uno, String dos) {
		palabra1 = new String[uno.length() +1];
		palabra2 = new String[dos.length() +1];
		
		matriz = new int[palabra1.length][palabra2.length];
		
		palabra1[0] = "";
		palabra2[0] = "";
		int i=1;	
		for(String letra : uno.split("")) {
			palabra1[i] = letra;
			i++;
		}
		int j=1;
		for(String letra : dos.split("")) {
			palabra2[j] = letra;
			j++;
		}
	}
	
	/**
	 * Metodo que nos devuelve un entero, el cual es el numero de 
	 * intercambios realizados, en este metodo creamos el algoritmo 
	 * de levensthein, en este despues de crear toda la matriz en base
	 * a las correspondientes palabras recibidas devolvemos el numero
	 * de intercambios resultantes.
	 * 
	 * @return de tipo int, numero de intercambios realizados
	 */
	private int distanciaLevensthein() {
		for(int i=0; i< palabra1.length; i++) {
			matriz[i][0] = i;
		}
		for(int i=0; i< palabra2.length; i++) {
			matriz[0][i] = i;
		}
		for(int i=1; i< palabra1.length; i++) {
			for(int j=1; j<palabra2.length; j++) {
			if(palabra2[j].equals(palabra1[i])) {
				matriz[i][j] = matriz[i-1][j-1];
			} // O(n²) debido a bucles anidados
			else {		
				matriz[i][j] = Math.min(matriz[i-1][j-1],matriz[i-1][j]);
				matriz[i][j] = Math.min(matriz[i][j],matriz[i][j-1])+1;
			}
			}
		}
		
		int result = matriz[palabra1.length-1][palabra2.length-1];
		
		return result;
	}
	
	/**
	 * Metodo creado para imprimir el resultado de la matriz creada
	 * al calcular la distanciaLevensthein, utilizado para pruebas
	 */
	public  void show() {
		for(int j=0; j<matriz[0].length;j++) {		
			for(int i=0;i<matriz.length;i++) {		
				System.out.print(matriz[i][j] +"\t") ;
			}
			System.out.println() ;
		}
		System.out.println("---------------------------------");
	}
	
	/**
	 * Metodo el cual genera palabras aleatorias 
	 * 
	 * @param n, longitud de la palabra
	 * @return de tipo String, la palabra generada
	 */
	public static String generadorPalabras(int n) {
		 
	    int izq = 97; // letter 'a'
	    int der = 122; // letter 'z'
	    int largo = n;
	    Random random = new Random();
	    
	    StringBuilder buffer = new StringBuilder(largo);
	    for (int i = 0; i < largo; i++) {
	        int limit = izq + (int) 
	          (random.nextFloat() * (der - izq + 1));
	        
	        buffer.append((char) limit);
	    }
	    String generatedString = buffer.toString();

	    return generatedString;
	}

}
