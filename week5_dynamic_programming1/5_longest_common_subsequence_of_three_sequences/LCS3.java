import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
    	int a_l = a.length + 1;
        int b_l = b.length + 1;
        int c_l = c.length + 1;
        int [][][] memo = new int[a_l][b_l][c_l];
        //fillUpMatrix(memo, a_l, b_l, c_l);
        
        for(int x=1 ; x < a_l ; x++)
			for(int y=1 ; y < b_l; y++) 
				for(int z=1 ; z < c_l; z++) {
					if(a[x-1] == b[y-1] && a[x-1] == c[z-1]) {

						memo[x][y][z] = 1 + memo[x-1][y-1][z-1];
					}
						
					else 
						memo[x][y][z] = findMax(memo[x][y-1][z-1] , memo[x-1][y][z-1], memo[x-1][y-1][z]);
			
				}
				
		return memo[a_l-1][b_l-1][c_l-1];
        
    }


	private static int findMax( int j, int k, int l) {
    	return  (Math.max(j, Math.max(k, l)));
		
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(lcs3(a, b, c));
    }
}

