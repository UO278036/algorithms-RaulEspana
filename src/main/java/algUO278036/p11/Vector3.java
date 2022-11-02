package algUO278036.p11;

public class Vector3 {
	static int[] v;
	final static int MAX_TAM = 10000000;
	public static void main(String[] args) {
		long t1, t2;
	
		for(int n=10; n<MAX_TAM; n = n * 3) {			
			v = new int [n];
			Vector1.rellena(v);
			
			 t1 = System.currentTimeMillis();
					
			 @SuppressWarnings("unused")
			int s=Vector1.suma(v);
		
			 t2 = System.currentTimeMillis();
					
			 long duracion = t2-t1;
		
			 System.out.println("Tiempo que tarda suma para "+n+"elementos (ms) "+duracion);
	}
	}
}
