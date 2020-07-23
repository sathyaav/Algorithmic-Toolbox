import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] items) {
        int n = items.length;
    	int value[][]=new int[n+1][W+1];
    	for(int i=0;i<=n;i++) {
    		for(int w=0; w<=W; w++) {
    			if(i==0 || w==0) {
    				value[i][w] = 0;
    				continue;
    			}
    			int wi = items[i-1];
    			if(w >= wi && (value[i-1][w-wi] + wi ) > (value[i-1][w]) ) {
    				value[i][w] = value[i-1][w-wi] + wi ;
    			}else {
    				value[i][w] = value[i-1][w];
    			}
    			
    			
    			
    		}
    	}
    	return value[n][W];
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(optimalWeight(W, w));
    }
}

