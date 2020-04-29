import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            current%=100;
            sum += current;
            
            System.out.println("i: "+i+ "F: "+current +" Sum "+ sum%100);
        }

        return sum % 10;
    }
    
    private static long getFibonacciSum(long n) {
        //After n = 60 the values are repeated
        Integer[] memo = {0,1, 2, 4, 7, 2, 0, 3, 4, 8, 3, 2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7, 0, 8, 9, 8, 8, 7, 6, 4, 1, 6, 8, 5, 4, 0, 5, 6, 2, 9, 2, 2, 5, 8, 4, 3, 8, 2, 1, 4, 6, 1, 8, 0, 9, 0, 5 };
        n = n%60;
        return memo[(int)n];
    }
    
    public static void main(String[] args) {
    	//stressTest();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumNaive(n);
        long f = getFibonacciSum(n);
        scanner.close();
        System.out.println(f);
    }

	private static void stressTest() {
		long n=0L;
		Random r = new Random();
		while(true) {
			n= r.nextLong()% 1000000;
			if(n<0) continue;
			long v1 = getFibonacciSum(n);
			long v2 = getFibonacciSumNaive(n);
			if(v1!=v2) {
				System.out.println("n: "+n+" V1: "+ v1+ " V2: "+ v2);
				break;
			}else
				System.out.println("n: "+n+" V1: "+ v1+ " V2: "+ v2+" :: OK");
		}
		
	}
    
    
}

