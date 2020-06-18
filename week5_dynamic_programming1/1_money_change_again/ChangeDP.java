import java.util.HashMap;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
    	
    	
    	HashMap<Integer,Integer> memo = new HashMap<Integer, Integer>();
    	memo.put(0,0);
    	Integer coins[] = {1,3,4};
    	
    	
    	return getMinDenominations(m,memo, coins); 
    	
    }
    

    private static int getMinDenominations(int money, HashMap<Integer,Integer> memo, Integer[] coins ) {
    	
    	
    	for(int m = 1 ; m <= money; m++) {
    		for(int i=0;i<coins.length;i++) {
        		int val = Integer.MAX_VALUE;
        		if( coins[i] <= m) 
        			val = memo.getOrDefault(m - coins[i], Integer.MAX_VALUE-1) + 1;
        		
        		if(val < memo.getOrDefault(m, Integer.MAX_VALUE-1))
        			memo.put(m,val);
        	}
    	}
    	
    	return memo.getOrDefault(money, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

