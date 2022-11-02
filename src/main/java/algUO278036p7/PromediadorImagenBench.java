package algUO278036p7;

import algUO278036p7.PromediadorImagen;


public class PromediadorImagenBench extends BranchAndBound {
	

	private static String REAL_IMG = "target/einstein_1_256.png";
	private static String BAD_IMG = "target/einstein_1_256.png";
	private static String OUT_DIR_G = "target/out_g";
	private static String OUT_DIR_B = "target/out_bt";
	private static int N_IMGS = 3; 
	private static double PORCENTAJE_BAD = 25; // %
	private static double S_NOISE = 5.0; 
		
//	public static void main(String[] args) {
//		
//		int n_real, n_bad;
//		PromediadorImagen img_avger;
//		
//		
//		n_bad = (int) ((PORCENTAJE_BAD/100.)*N_IMGS);
//		n_real = N_IMGS - n_bad;
//		img_avger = new PromediadorImagen(REAL_IMG, BAD_IMG, n_real, n_bad, S_NOISE);
//				
//		System.out.print("TESTING VORAZ:\n");
//		img_avger.splitSubsetsGreedy(N_IMGS);
//		System.out.printf("  -ZNCC: %f\n",  img_avger.zncc());
//		System.out.printf("  -Contador: %d\n",  img_avger.getCounter());
//		img_avger.saveResults(OUT_DIR_G);
//		
//		System.out.print("TESTING BACKTRACKING SIN BALANCEO:\n");
//		img_avger.splitSubsetsBacktracking();
//		System.out.printf("  -ZNCC: %f\n",  img_avger.zncc());
//		System.out.printf("  -Contador: %d\n",  img_avger.getCounter());
//		img_avger.saveResults(OUT_DIR_B);
//		
//		
//
//		System.out.print("TESTING Branck and Bound:\n");
//		img_avger.branchAndBoundCall();
//		System.out.println(img_avger.bestNode.heuristicValue*(-1));
//		System.out.printf("  -ZNCC: %f\n",  img_avger.zncc());
//		System.out.printf("  -Contador: %d\n",  img_avger.getCounter());
//
//	}
	
	public static void main(String[] arg) {
        long t1, t2;
        int nVeces = Integer.parseInt(arg[0]);
        int n_real, n_bad;
        PromediadorImagen img_avger;
        System.out.println("N\tTiempo\tZNCC\tNodos");
        for (int n = 2; n <= 1_000; n++) {

            n_bad = (int) ((PORCENTAJE_BAD/100.)*n);
            n_real = n - n_bad;

            N_IMGS = n;
            
            img_avger = new PromediadorImagen(REAL_IMG, BAD_IMG, n_real, n_bad, S_NOISE);
            img_avger.splitSubsetsGreedy(N_IMGS);
            t1 = System.currentTimeMillis();

            for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
                img_avger.branchAndBoundMethod();
            }
            t2 = System.currentTimeMillis();

            System.out.println(n+"\t"+(t2-t1)+"\t"+img_avger.zncc()+"\t"+img_avger.getCounter());

        }
    }
	
}