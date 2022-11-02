package algUO278036.p2 ;



/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrÃ¡tico)Â· 
	Es la INSERCIÃ“N DIRECTA
 */
public class Insercion extends Vector
{
	
	public Insercion(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por inserción directa
	 */
	@Override
	public void ordenar() {
		int n = elements.length;
		for (int i = 1; i < n; i++) {
			int x = elements[i];
			int j = i -1;
			while (j >= 0 && x < elements[j]) {
				elements[j +1] = elements[j];
				j = j-1;
			}
			elements[j +1] = x;
		}
	} 

	@Override
	public String getNombre() {
		return "Inserción directa";
	} 
} 
