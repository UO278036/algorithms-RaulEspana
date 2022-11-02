package algUO278036.p2;

import algUO278036.p2.Vector;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)·
	es la SELECCION
 */
@SuppressWarnings("unused")
public class Seleccion extends Vector
{
	public Seleccion(int nElementos) {
		super(nElementos);
	}
	

	/**
	 * Ordenación por selección
	 */
	@Override
	public void ordenar() {
		int n = elements.length;
		int posmin;
		for (int i = 0; i < n-1; i++) {
			posmin = i;
			for (int j = i+1; j < n; j++) {
				if (elements[j] < elements[posmin]) {
					posmin = j;
				}
			}
			intercambiar(i, posmin);
		}
	}  

	@Override
	public String getNombre() {		
		return "Selección";
	}  
} 
