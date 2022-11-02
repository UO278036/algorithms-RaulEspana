package algUO278036.p12;

public class Bucle5 {

	public static long bucle5(int n)
	{
		long cont = 0;
		int s = 0;
		for (int i=1; i<=n;i++)
			 for (int j=1; j<=i; j++)
				 for (int k=1; k<=j; k++)
					 s = 1; 
					 while (s<n)
					 { 
						 s=s*4;
					 }
		return cont;

	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;
		int nVeces = Integer.parseInt(arg[0]);

		for (int n = 8; n <= 100_000; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				c += bucle5(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(n+"\t"+(t2-t1)+"\t"+c);

		} 

	} 
} 