package algUO278036.p11;

public class Vector4 {

	private static int[] v;
	private static int[] indices;
	
	public static void main(String[] args) {
		int nVeces = 1000;
		System.out.println("n\tt");
		for (int n = 10; n < 1291401630; n = n * 3) {
			v = new int[n];
			indices = new int[2];
			
			Vector1.rellena(v);
			
			//Medición de tiempos de operación
			long t1 = System.currentTimeMillis();
			
			for(int repeticiones = 0; repeticiones < nVeces; repeticiones++) {
				Vector1.maximo(v, indices);
			}
			
			long t2 = System.currentTimeMillis();
			
			long tmedido = t2 -t1;
			System.out.println(n + "\t" +(float)tmedido/nVeces);
		}
	}

}
