package algUO278036p6;

import java.nio.file.Paths;





public class PromediadorImagenBench {
	
	// Ajustes del banco de pruebas
	private static String REAL_IMG =  "target/einstein_1_256.png";
	private static String BAD_IMG =  "target/einstein_1_256.png";
	private static String OUT_DIR_G =  "target/out_g/";
	private static String OUT_DIR_B =  "target/out_bt";
	//ASIGNAMOS NUMERO DE IMAGENES A 8
	private static int N_IMGS = 8; 
	private static double PORCENTAJE_BAD = 25; // %
	private static double S_NOISE = 5.0; // Nivel de ruido - desvición estándar de una distrubución Gaussiana
		
//	public static void main(String[] args) {
//		
//		int n_real, n_bad;
//		PromediadorImagen img_avger;
//		
//		// Generación y testeo de un conjunto de imágenes
//		n_bad = (int) ((PORCENTAJE_BAD/100.)*N_IMGS);
//		n_real = N_IMGS - n_bad;
//		img_avger = new PromediadorImagen(REAL_IMG, BAD_IMG, n_real, n_bad, S_NOISE);
//				
//		System.out.print("TESTING VORAZ:\n");
//		for(int i=0; i< 1000; i++) {
//		img_avger.splitSubsetsGreedy(N_IMGS);
//		}
//		System.out.printf("  -ZNCC: %f\n",  img_avger.zncc());
//		System.out.printf("  -Contador: %d\n",  img_avger.getCounter());
//		img_avger.saveResults(OUT_DIR_G);
//			
//		System.out.print("TESTING BACKTRACKING CON BALANCEO:\n");
//
//		long t1,t2;
//		t1 = System.currentTimeMillis();
//		for(int i=0; i< 1000; i++) {
//			img_avger.splitSubsetsBacktracking(1);
//		}
//		t2 = System.currentTimeMillis();
//		
//		System.out.printf("  -ZNCC: %f\n",  img_avger.zncc());
//		System.out.printf("  -Contador: %d\n",  img_avger.getCounter());
//		img_avger.saveResults(OUT_DIR_B);
//
//		// Medidas
//		// TODO
//	}
	
	public static void main(String[] arg) {
        int nVeces = Integer.parseInt(arg[0]);
        int n_real, n_bad;
        PromediadorImagen img_avger;
        System.out.println("Soluciones\tZNCC");
        for (int n = 7; n <= 8; n++) {

            n_bad = (int) ((PORCENTAJE_BAD/100.)*n);
            n_real = n - n_bad;

           
            
            img_avger = new PromediadorImagen(REAL_IMG, BAD_IMG, n_real, n_bad, S_NOISE);
            img_avger.splitSubsetsGreedy(N_IMGS);
        //    t1 = System.currentTimeMillis();

           
            img_avger.splitSubsetsBacktracking(n);
            
            
            
          //  t2 = System.currentTimeMillis();

            System.out.println(n+"\t"+ " "+ img_avger.zncc() );
            for(int i=0; i<img_avger.bestSol.length; i++) {
            	System.out.print(img_avger.bestSol[i]+ " ");    	
            }
          

        }
    }

}

