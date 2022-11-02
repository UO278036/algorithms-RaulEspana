package algUO278036p6;

public class transformaciones {

	static int [] solucion;
	
	static int k;
	
	public static void main(String[] args) {

		k  = Integer.parseInt(args[0]);
		inicializar();
		
		

	}
	
	// a=11, b=8, k=7 11/t2/t1/t1/t1/t2/8 (5(<=7)tranformaciones)
	
	public static  void inicializar() {
		solucion = new int[k];		

		backtracking(11, 8, 0);
		
	}
	
	private static  void backtracking(int a, int b, int nivel) {
		if( a == b || nivel ==k) {   
			if( a ==  b) {
				for (int i= 0; i<nivel;i++) {
					if(solucion[i] == 0)
					       System.out.print("t1");
					else {
						 System.out.print("t2");
					}

				}
				System.out.println(" <--------- ");
			
		}}else {

			for(int i=0; i<2;i++) {

				if(nivel <= k) {	
					if (i == 0) {

						solucion[nivel] = i;

						backtracking(a*2, b,nivel +1);
					}else {
						solucion[nivel] = i;

						backtracking(a/3, b, nivel +1);
					}	
				}
				
			}
			
		}		
	}	
}
