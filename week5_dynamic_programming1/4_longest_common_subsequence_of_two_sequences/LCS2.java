import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int a_l = a.length + 1;
        int b_l = b.length + 1;
        int [][] memo = new int[a_l][b_l];
        fillUpMatrix(memo, a_l, b_l);
        
        for(int x=1 ; x < a_l ; x++)
			for(int y=1 ; y < b_l; y++) 
				if(a[x-1] == b[y-1])
					memo[x][y] = 1 + memo[x-1][y-1];
				else 
					memo[x][y] = findMax(memo[x-1][y-1], memo[x][y-1] , memo[x-1][y]);
		
		return memo[a_l-1][b_l-1];
        
        
     }
    
    private static int findMax(int i, int j, int k) {
		return  Math.max(i, Math.max(j, k));
	}

	private static void fillUpMatrix(int[][] a, int j, int k) {
		for(int m=0 ; m<j ; m++) 
			a[m][0] = 0;
		for(int m=0 ; m<k ; m++)
			a[0][m] = 0;
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

