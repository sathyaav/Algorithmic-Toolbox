import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static Long getMaxPairwiseProductBF(int[] numbers) { //BruteForce
        Long max_product = 0L;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = java.lang.Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static Long getMaxPairwiseProduct(int[] numbers) {
        Long max_product = 0L;
        int max_num1=-1, max_num2=-1;
        int n = numbers.length;
        
        for (int first = 0; first < n; ++first) {
            if(numbers[first] > max_num1) {
            		max_num2 = max_num1;
            		max_num1 = numbers[first];
            	
            }else if(numbers[first] > max_num2) {
            	max_num2= numbers[first];
            }
        }
        max_product = (Integer.toUnsignedLong(max_num1) * Integer.toUnsignedLong(max_num2));
        return max_product;
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        
        //StressTest();
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    private static void StressTest() {
    	Random rand = new Random();
    	int n=0;
    	Long val1=0L, val2=0L;
    	int[] numbers= null;
    	while(true) {
    		n = rand.nextInt(15)+2;
    		numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = rand.nextInt(1000000);
            }
            val1 = getMaxPairwiseProduct(numbers);
            val2 = getMaxPairwiseProductBF(numbers);
            for (int i = 0; i < n; i++) 
                System.out.print(numbers[i]+" ");
            if(!val1.equals(val2)) {
            	System.out.println("val1: "+ val1+" Val2: "+val2);
            	
            	break;
            }else {
            	System.out.println("OK");
            }
            
    	}
    	
    	
    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
