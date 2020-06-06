import java.util.*;

public class Inversions {
	private static int q=0;
	/*
	 * Questions:
	 * Can i modify the array 
	 * Can i use recursion - occupies 
	 * 1. Using mergersort algorith
	 * 2. only difference is in merge() function
	 *    "The number of inversions required to make the jth element to correct position is (mid+1 - i)"
10
1 9 8 2 3 5 4 2 3 1
	 */
    public static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        
        if (right <=left ) 
			return numberOfInversions;
        
        int mid = left+(right - left) / 2;
        
        numberOfInversions += getNumberOfInversions(a,left, mid);
        numberOfInversions += getNumberOfInversions(a, mid+1, right);
        numberOfInversions += merge(a,left,mid, right);
        
        return numberOfInversions;
    }

    private static void print(int[] a) {
		for(int i:a) {
			System.out.print(": "+i);
		}
		System.out.println("\n");
		
	}
    
	private static long merge(int[] a,  int left, int mid,int right) {
		int count=0;
		int i=left, j = mid+1;
		int k=left;
		int temp[]=new int[a.length];
		
		while( i <= mid && j <= right) {
			if(a[i]<=a[j]) {
				temp[k++] = a[i++];
			}else {
				temp[k++] = a[j++];
				
				// The number of inversions required to make the jth element to correct position is (mid+1 - i)
				count += mid-i+1;
			}
		}
		while(i<=mid) {
			temp[k++] = a[i++];
		}
		while(j<=right) {
			temp[k++] = a[j++];
		}
		while(left<=right) {
			a[left] = temp[left];
			left++;
		}
    	return count;
	}
    

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(getNumberOfInversions(a,  0, a.length-1));
       // System.out.println(q);
    }
}

