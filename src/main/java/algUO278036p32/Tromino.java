package algUO278036p32;

public class Tromino {
	private int[][] tablero;
	
	private static final int CASILLA_HUECO = 0;
	private static final int CASILLA_VACIA = -1;
	private int cas_rellena = 1;
	
//	public static void main (String arg []) 
//    {
//        Tromino t;
//        long t1,t2;
//        int nVeces= Integer.parseInt (arg [0]);
//        boolean b=true;
//
//        for (int n=16;n<=1000000;n*=2)
//        {
//        	
//            t = new Tromino(n, 1, 1);
//           
//            
//            t1 = System.currentTimeMillis ();
//
//            for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
//            { 
//                t.resuelveTromino(n,1,1,0,0);
//            } 
//
//            t2 = System.currentTimeMillis ();
//
//            System.out.println (b+" n="+n+ "TIEMPO="+(t2-t1)+"nVeces="+nVeces);
//          
//        }
//    }
	public static void main (String arg []) 
    {
        Tromino t = new Tromino(8,2,1);
        t.resuelveTromino(8, 2, 1, 0, 0);
    }
	
	public Tromino(int tam,int x,int y) {
		//Creamos el tablero del tama�o pasado como parametro
		tablero = new int[tam][tam];
		//Rellenamos el tablero de casillas vacias -1
		for(int i=0; i < tam;i++) {	
			for(int j=0; i<tam;i++) {
				tablero[i][j] = CASILLA_HUECO;
			}
		}
		// Asignamos el hueco al tablero
		tablero[x][y] = CASILLA_VACIA;
		
		
		
	}
	
	public  void Show() {
		for(int i=0; i<tablero.length;i++) {		
			for(int j=0;j<tablero.length;j++) {		
				System.out.print(tablero[i][j] +"\t") ;
			}
			System.out.println() ;
		}
		System.out.println("---------------------------------");
	}
	
	// Podemos pasar directamente las direcciones del hueco como parametro para 
	// no tener que buscarlo 
	public void resuelveTromino(int tam, int x, int y, int cordx, int cordy) {
		int mCuadrante = tam/2;
		int m1 = cordx + mCuadrante -1;
		int m2 = cordy + mCuadrante -1;
		
		// Buscamos el hueco en el tablero
//		for(int i=0; i<tablero.length;i++) {
//			for(int j=0; j<tablero.length;j++) {
//				if(tablero[i][j] == 0) {
//					faltax = i;
//					faltay = j;
//				}
//			}				
//		}
		//------------------------------------------
		//Resolvemos caso base(suponemos long 2 si no recursivo)
		if(tam <= 2) {
//			for(int i=x; i<x+2;i++) {
//				for(int j=y; j<y+2;j++) {
//					if(tablero[i][j] != CASILLA_VACIA) {
//						tablero [i][j] = 1;
//					}
//				}
//			}
			int punto = tablero[x][y];
			tablero[m1][m2]=cas_rellena;
			tablero[m1][m2+1]=cas_rellena;
			tablero[m1+1][m2]=cas_rellena;
			tablero[m1+1][m2+1]=cas_rellena;
			tablero[x][y]=punto;
			cas_rellena = cas_rellena ++;
			
		}

		//---------------------------------------------------
		if(tam >=4) {
			int cuadrante1x = m1; 	
			int cuadrante2x = m1;
			int cuadrante3x = m1+1;
			int cuadrante4x = m1+1;
			
			int cuadrante1y = m2;
			int cuadrante2y = m2+1;
			int cuadrante3y = m2;
			int cuadrante4y = m2+1;
			
			if(x <= m1 && y <=m2) {
				
				tablero[m1][m2+1] = cas_rellena;
				tablero[m1+1][m2] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;
				cuadrante1x = x;
				cuadrante1y = y;
											
			}
			else if (x <= m1 && y > m2) {
				tablero[m1][m2] = cas_rellena;
				tablero[m1+1][m2] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;
				cuadrante2x = x;
				cuadrante2y = y;
			}
			else if (x > m1 && y <= m2) {
				tablero[m1][m2] = cas_rellena;
				tablero[m1][m2+1] = cas_rellena;
				tablero[m1+1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;
				cuadrante3x = x;
				cuadrante3y = y;
			}
			else {
				tablero[m1][m2] = cas_rellena;
				tablero[m1+1][m2] = cas_rellena;
				tablero[m1][m2+1] = cas_rellena;
				cas_rellena = cas_rellena ++;	
				cuadrante4x = x;
				cuadrante4y = y;
				
			}
			resuelveTromino(mCuadrante,cuadrante1x,cuadrante1y,cordx,cordy);
			Show();
			resuelveTromino(mCuadrante,cuadrante2x,cuadrante2y,cordx,cordy+mCuadrante);
			Show();
			resuelveTromino(mCuadrante,cuadrante3x,cuadrante3y,cordx+mCuadrante,cordy);
			Show();
			resuelveTromino(mCuadrante,cuadrante4x,cuadrante4y,cordx+mCuadrante,cordy+mCuadrante);		
			Show();
		}  			
	}
		
}

