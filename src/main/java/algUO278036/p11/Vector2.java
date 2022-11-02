package algUO278036.p11;

public class Vector2 {
	static int v[];
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		v = new int [n];
		Vector1.rellena(v);
		
		
		long t1 = System.currentTimeMillis();
					
		@SuppressWarnings("unused")
		int s=Vector1.suma(v);
		
		long t2 = System.currentTimeMillis();
					
		long duracion = t2-t1;
		
		System.out.println("Tiempo que tarda suma para "+n+"elementos (ms) "+duracion);
		
	}
}
