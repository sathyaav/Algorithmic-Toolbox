import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    public int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int total = starts.length;
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i =0;
        for ( int p : points) {
        	
        	cnt[i++] = countSegements(starts, ends, p , total);
        	System.out.println(cnt[i-1]);
        }


// -3 0  7  
//  2 5 10
        // 3 - 1 - 0   =2 -- 1 
        // 3 - 1 - 2   = 0 -- 6
        
        
        return cnt;
    }

    private int countSegements(int[] starts, int[] ends, int p, int total) {
    	int leftCount=0, rightCount=0;
    	leftCount= total- (findLeftIndex(starts, p)+1);
    	rightCount = (findRightIndex(ends,p)+1);
    	
    	return total-leftCount-rightCount;
    	
		//return 0;
	}
   
   private int findLeftIndex(int[] a, int num) {
	   int left = 0;
	   int right = a.length-1;
	   int mid = left + (right - left)/2;
	   int idx = -1;
	   idx = findLeftIdxByBinarySearch(a,left, mid, right, num);
	   System.out.println("num: "+num + " idx "+idx);
	   
	   return idx;
   }

   private int findRightIndex(int[] a, int num) {
	   int left = 0;
	   int right = a.length-1;
	   int mid = left + (right - left)/2;
	   int idx = -1;
	   idx = findRightIdxByBinarySearch(a,left, mid, right, num);
	   System.out.println("num: "+num + " idx "+idx);
	   
	   return idx;
   }
   
    private int findLeftIdxByBinarySearch(int[] a, int left, int mid, int right, int num) {
    	if(num > a[right] ) return right;
    	else if(num< a[left]) return -1;
    	else if(mid == right ) return -1;
    	else if(mid < right && a[mid] <= num && a[mid+1] > num)
    		return mid;
    	else if(a[mid] > num)
    		return findLeftIdxByBinarySearch(a, left, left+(mid-left)/2 , mid, num);
    	else if(a[mid] <= num)
    		return findLeftIdxByBinarySearch(a, mid, mid+(right-mid)/2, right, num);
    	else 
    		return -1;
	
}
    private int findRightIdxByBinarySearch(int[] a, int left, int mid, int right, int num) {
    	if(num > a[right] ) return right;
    	else if(num< a[left]) return -1;
    	else if(mid == right ) return -1;
    	else if(mid < right && a[mid] < num && a[mid+1] >= num)
    		return mid;
    	else if(a[mid] >= num)
    		return findRightIdxByBinarySearch(a, left, left+(mid-left)/2 , mid, num);
    	else if(a[mid] <= num)
    		return findRightIdxByBinarySearch(a, mid, mid+(right-mid)/2, right, num);
    	else 
    		return -1;
	
    }
    
	private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
    	PointsAndSegments obj = new PointsAndSegments();
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        for (int x : PointsAndSegments.naiveCountSegments(starts, ends, points)) {
            System.out.print(x + " ");
        }
        //use fastCountSegments
        int[] cnt = obj.fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

