import java.util.*;

//Given two integer n and m, output Fn mod m .   N may be really huge 10^14
public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) { //Doesnot work for huge number 
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    private static long getFibonacciHugePisano(long n, long m) { 	//using pisano period method
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        ArrayList<Long> fibo_memo = new ArrayList<Long>();
        fibo_memo.add(previous);
        fibo_memo.add(current);
        long i;
        for (i = 2; i <= n; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous%m + current%m;		 			//(a+b)%m = ((a%m)+(b%m))%m
            fibo_memo.add(current % m);
            if(previous%m==0 && current%m==1) {						//if previous two number is 0 & 1 , break loop
            	i = i-2;
            	break;
            }
            	
        }
        int total= (int)i+1;
        long mod = n%(total);
        return fibo_memo.get((int)mod)%m;
    }
    
    // This functions show the repeatation of values as per pisano method
    private static long calc_fib(int n) {
    	Long memo[] = new Long[n+2];
    	memo[0]=0L;
    	if(n>0) memo[1]=1L;
    	for(int i=2;i<=n;i++) {
    		memo[i]= memo[i-1]+memo[i-2];
    		
    		
    	}
    	for(int i=1;i<26;i++) {
    		for(int j=0; j<=n; j++) {
    			if(j+1<n && memo[j]%i == 0 && memo[j+1]%i == 1) 
    				System.out.print(" <<>> ");
    			System.out.print( memo[j]%i +" ");
    			
    		}
    		System.out.println();
    	}
    		
    	
        return memo[n];
      } 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         long n = scanner.nextLong();
         long m = scanner.nextLong();
        //System.out.println(calc_fib(30));
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHugePisano(n,m));
    }
}

