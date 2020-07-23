import java.util.*;
import java.io.*;

public class Partition3 {
	
	// We are going to find the numbers which generates the partition sum [ (sum of all number)/3 ] .
	// Then backtrack and check whether if all numbers in array A is used for generating the partition sum.
    private static int partition3(int[] A) {
    	
    	int sum=0, n=A.length;
    	
    	//finding the sum of all numbers
    	for(int i=0; i<n; i++)
    		sum += A[i];
    	
    	// if sum is not divisible by 3 then we cannot divide the numbers into 3 partition, so false
    	if(sum % 3 != 0 )
    		return 0;
    	
    	// we have to find the a partition in which the sum of number will be sums/3
    	int W = sum/3;
    	
    	// keep array will track whether the number is used or not 
    	boolean keep[][] = new boolean[n+1][W+1];
    	
    	// 2d array for storing the previous result - Dynamic programming
    	int value[][]=new int[n+1][W+1];
    	
    	// same as knapsack problem
    	for(int i=0;i<=n;i++) {
    		for(int w=0; w<=W; w++) {
    			if(i==0 || w==0) {
    				value[i][w] = 0;
    				continue;
    			}
    			int wi = A[i-1];
    			
    			// if adding current number value is more than not adding the current number
    			if(w >= wi && (value[i-1][w-wi] + wi ) >= (value[i-1][w]) ) {
    				value[i][w] = value[i-1][w-wi] + wi ;
    				keep[i][w] = true;
    			}else {
    				value[i][w] = value[i-1][w];
    				keep[i][w] = false;
    			}
    			
    			
    			
    		}
    	}
    	
    	// valuesUsed array to check whether all numbers are used to calculate the result
    	boolean[] valuesUsed = new boolean[n];
    	int k =W;
    	
    	// backtracking from final value to all values which generates the partion sum
    	for(int i=n; i>0 ; i--) {
    		if(value[i][W] != W )
    			break;
    		for(int j=n ; j>0 & k!=0; j--) {
    			if( keep[j][k] == true && valuesUsed[j-1] == false) {
    				valuesUsed[j-1] = true;
    				k = k- A[j-1];
    			}
    			
    			
    		}
    		k =W;
    		
    	}
    	
    	// if any number is not used return false
    	for(int i=0;i<n;i++)
    		if(valuesUsed[i]==false)
    			return 0;
    	
    	
    	return 1;
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
        scanner.close();
    }
}

