import java.util.Arrays;
import java.util.Scanner;




/*  
Task: You are given a set of points on a line and a set of segments on a line. The goal is to compute, for
each point, the number of segments that contain this point.   

Input:
3 2
0 5
-3 2
7 10
1 6

Output:
2 0

Here, we have two segments and three points. The first point lies only in the first segment while the
remaining two points are outside of all the given segments.
*/
public class PointsAndSegments {
    // 
	
	// 2nLog(n) + 2Log(n)  =   O(p+nLog(n))
    public int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int total = starts.length;
        Arrays.sort(starts);			// O(nLog(n))
        Arrays.sort(ends);				// O(nLog(n))
        int i =0;
        for ( int p : points) {			// O(p)
        	
        	cnt[i++] = countSegements(starts, ends, p , total);
        	//System.out.println(cnt[i-1]);
        	
        }


        return cnt;
    }
    
    // Number of segments which contain the point will be total - (no of start points which is greater than P) - ( No of end points which is lesser than P)
    private int countSegements(int[] starts, int[] ends, int p, int total) {
    	int leftCount=0, rightCount=0;
    	int left = 0;
 	    int right = starts.length-1;
 	    int mid = left + (right - left)/2;
    	leftCount= total- (findLeftIdxByBinarySearch(starts,left, left + (right - left)/2, right, p)  + 1);   	//Log(n)
    	rightCount = (findRightIdxByBinarySearch(ends,left, mid, right, p) + 1);								//Log(n)
    	
    	return total-leftCount-rightCount;
    	
	}
   
    // find the starting index of the point using binary search so that the index to the right is greater than num
    private int findLeftIdxByBinarySearch(int[] a, int left, int mid, int right, int num) {
    	if(num >= a[right] ) return right;
    	else if(num< a[left]) return -1;
    	else if(mid == right ) return -1;
    	
    	// checks if next index is greater than num and current index is less than or equal to num
    	else if(mid < right && a[mid] <= num && a[mid+1] > num)
    		return mid;
    	else if(a[mid] > num)
    		return findLeftIdxByBinarySearch(a, left, left+(mid-left)/2 , mid, num);
    	else if(a[mid] <= num)
    		return findLeftIdxByBinarySearch(a, mid, mid+(right-mid)/2, right, num);
    	else 
    		return -1;
	
    }
    
    // find the starting index of the point using binary search so that the index to the left is lesser than num
    private int findRightIdxByBinarySearch(int[] a, int left, int mid, int right, int num) {
    	if(num > a[right] ) return right;
    	else if(num< a[left]) return -1;
    	else if(mid == right ) return -1;
    	
    	// checks if next index is greater than or equal to num and current index is less than num
    	else if(mid < right && a[mid] < num && a[mid+1] >= num)
    		return mid;
    	else if(a[mid] >= num)
    		return findRightIdxByBinarySearch(a, left, left+(mid-left)/2 , mid, num);
    	else if(a[mid] < num)
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
		/*
		 * for (int x : PointsAndSegments.naiveCountSegments(starts, ends, points)) {
		 * System.out.print(x + " "); }
		 */
        //use fastCountSegments
        int[] cnt = obj.fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

