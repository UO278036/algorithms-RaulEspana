package algUO278036.p0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class MatrizOperaciones {
	
	/**
	 * Atributos de la clase MatrizOperaciones
	 */
	
	private int[][] matriz;
	
	
	Random rand = new Random();

	/**
	 * Contructor para la clase MatrizOperaciones en el cual creamos
	 * una matriz de tamaño nxn y la rellenamos con valores aleatorios
	 * en el rando min max
	 * 
	 * @param n, de tipo int el tamaño de la matriz
	 * @param min,de tipo int numero minimo para los aleatorios generados
	 * @param max, de tipo int numero maximo para los aleatorios generados
	 */
	public MatrizOperaciones(int n, int min, int max) {
		crearMatriz(n,min,max);
		
	}
	
	/**
	 * Constructor de la matriz con los siguientes par�metros
	 * @param nomFich:	fichero que cuenta con los datos de la matriz
	 */
	public MatrizOperaciones(String nomFich) {
		cargarArchivosClientes(nomFich, matriz);
	}

	/**
	 * Metodo auxiliar para crear matrices aleatorios del tamaño
	 * definido 
	 * @param n tamaño de la matrix
	 * @param min minimo para numero aleatorio
	 * @param max maximo para numero aleatorio
	 */
	private void crearMatriz(int n, int min, int max) {
		for(int i=0; i < n; i++) {
			for(int j=0; i < n; j++) {				
				matriz[i][j] = rand.nextInt(max-min);
			}
		}
		
	}
	
	/**
	 * Metodo que devuelve el tamano de la matriz
	 * @return tam:	tamano de la matriz
	 */
	public int getTam() {
		return matriz.length;
	}
	
	
	/**
	 * Metodo que Muestra el contenido de la matrix por pantalla
	 */
	public void escribir() {
		String let = "";
		
		for (int i = 0; i < matriz.length; i++) {
			for (int c = 0; c < matriz[0].length; c++) {
				
				let = let + matriz[i][c] +"\t";
			}
			
			let = let + "\n";
		}
		
		System.out.print(let);
	}
	/**
	 * Metodo que devuelve la suma de la diagonal de la matriz
	 * Recorre todos los elementos
	 * 
	 * @return resultado:	resultado de la suma de los elementos  de la diagonal
	 */
	public  int sumarDiagonal1() {
		int resultado = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (j == i) {
					resultado = resultado + matriz[i][j];
				}
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo que devuelve la suma de la diagonal de la matriz
	 * Recorre solo los elementos de la diagonal
	 * 
	 * @return result:	suma de los elementos
	 */
	public  int sumarDiagonal2() {
		int resultado = 0;
		for (int i = 0; i < matriz.length; i++) {
			resultado = resultado + matriz[i][i];
		}
		return resultado;
	}
	
	/**
	 * Metodo para trazar un camino dentro de una matriz 
	 * partiendo de las posiciones i,j que pasamos como parametro
	 * utilizando como codigos de direcciones 1 arriba 2 derecha
	 * 3 abajo 4 izquierda
	 * utilizaremos el numero -1 para marcar el camino ya 
	 * recorrido, el proceso finalizara cuando nos salgamos de los limites
	 * de la matriz o nos encontremos con un -1
	 * 
	 * @param i: coordenada x de la matriz 
	 * @param j: coordenada y de la matriz
	 */
	public void recorrerCamino(int i, int j) {
		try {
			checkDatos(i);
			checkDatos(j);
			checkMatrix();
			
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
		
		while (matriz[i][j] != -1) {
			if (matriz[i][j] == 1) {
				matriz[i][j] = -1;
				i = i - 1;
			} else if (matriz[i][j] == 2) {
				matriz[i][j] = -1;
				j = j + 1;
			} else if (matriz[i][j] == 3) {
				matriz[i][j] = -1;
				i = i + 1;
			} else {
				matriz[i][j] = -1;
				j = j - 1;
			}		
			if (i >= matriz.length ||  i < 0 || j >= matriz.length || j < 0) {
				break;
			}
		}
	}
		

	
	/**
	 * Metodo para contruir una matriz atraves de los datos introducidos 
	 * mediante un fichero
	 * @param Fichero:	Nombre del fichero a leer
	 * @param matriz:	Matriz en la que almacenaremos los datos leidos mediante fichero
	 */
	private void cargarArchivosClientes(String Fichero, int[][] matriz) {
		String linea;
		String[] datosMatriz;
		int contador = 0;
		int fila = 0;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(Fichero));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosMatriz = linea.split("\n");
				if (contador == 0) {
					contador++;
					int tam = Integer.parseInt(datosMatriz[0]);
					this.matriz = new int[tam][tam];
				} else {
					procesaFila(matriz, fila, datosMatriz);
					fila++;
				}
			}
			fichero.close();
		} catch (FileNotFoundException fallo) {
			System.out.println("Archivo no encontrado");
		} catch (IOException ei) {
			new RuntimeException("Error inesperado");
		}
	}
	
	/**
	 * Metodo para parsear y procesar las lineas del fichero de entrada
	 * 
	 * @param matriz: Matriz para almacenar los numeros
	 * @param fila:	fila en la que almacenaremos los datos
	 * @param datosMatriz: cadena con la informacion
	 * 
	 */
	private void procesaFila(int[][] matriz, int fila, String[] datosMatriz) {
		String[] numeros = datosMatriz[0].split("\t");
		
		for (int i = 0; i < numeros.length; i++) {
			this.matriz[fila][i] = Integer.parseInt(numeros[i]);
		}
	}
	

	/**
	 * M�todo que verifica que la coordenada pasada como par�metro
	 * es v�lida
	 * @param num:	n�mero que se checkea
	 * @throws Exception
	 */
	private void checkDatos(int num) throws Exception {
		if (num >= matriz.length || num < 0) {
			throw new Exception("Valor inv�lido de la matriz:" + num);
		}
	}
	
	/**
	 * Verifica que todos los elementos de la matriz se encuentran en el rango correcto
	 * @throws Exception
	 */
	private void checkMatrix() throws Exception {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] > 4 || matriz[i][j] < 1) {
					throw new Exception("Algun numero no es correcto");
				}
			}
		}
	}
			

}
