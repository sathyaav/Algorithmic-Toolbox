import java.util.*;

class EditDistance {
	
	
	public static int editDistance(String s, String t) {
		int s_len = s.length()+1;  
		int t_len = t.length()+1;  
		int[][] a = new int[s_len][t_len];
		fillUpMatrix(a, s_len, t_len);
		
		for(int x=1 ; x < s_len ; x++)
			for(int y=1 ; y < t_len; y++) 
				if(s.charAt(x-1) == t.charAt(y-1))
					a[x][y] = findMin(a[x-1][y-1]  , a[x][y-1]+1 , a[x-1][y]+1);
				else 
					a[x][y] = findMin(a[x-1][y-1]+1, a[x][y-1]+1 , a[x-1][y]+1);
		
		return a[s_len-1][t_len-1];
	}

	private static int findMin(int i, int j, int k) {
		return  Math.min(i, Math.min(j, k));
	}

	private static void fillUpMatrix(int[][] a, int j, int k) {
		for(int m=0 ; m<j ; m++) 
			a[m][0] = m;
		for(int m=0 ; m<k ; m++)
			a[0][m] = m;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(editDistance(s, t));
		scan.close();
	}

}
