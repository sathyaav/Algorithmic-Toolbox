import java.util.*;
import java.io.*;

public class MajorityElement {
	
	/* 1. Breakcondition - if both index are same or if nearby
	 * 2. Divide the array recursively 
	 *   2.1 pick the majority element from left sub array
	 *   2.2 pick the majority element from right sub array
	 * 3.1. if both element are same then return that element
	 * 3.2.1 else count the number of left majority element in left subarray
	 * 3.2.1      count the number of right majority element in right sub array
	 * 3.3  return the element which have the high count in both subarray.
	 */
	
    public static int getMajorityElement(int[] a, int left, int right) {
    	int majorityElement = getMajorityElementInArray(a,left,right);
    	int count =0;
    	for(int i=left;i<=right;i++)
    		if(a[i]==majorityElement)
    			count++;
    	if(count> Math.floor((right+1)/2))
    		return majorityElement;
        return -1;
    }

    private static int getMajorityElementInArray(int[] a, int left, int right) {
    	 
    	 //recursion break condition - if both index are same or if its nearby
    	 if (left == right) {
             return a[left];
         }
         if (left + 1 == right) {
             return a[left];
         }
         
         
         int mid = left+(right-left)/2;
         
         //pick the majority element from left sub array
         int left_major = getMajorityElementInArray(a, left, mid);
         //pick the majority element from right sub array
         int right_major = getMajorityElementInArray(a, mid+1, right);
         
         //if both element are same then return that element
         if(left_major == right_major)
         	return left_major;
         
         //else count the number of left majority element in left subarray
         int l_count = 0;
         for(int i= left; i<=mid;i++)
         	if(left_major == a[i])
         		l_count++;
         
         // count the number of right majority element in right sub array
         int r_count = 0;
         for(int i= mid+1; i<=right;i++)
         	if(right_major == a[i])
         		r_count++;
        
         //return the element which have the high count in both subarray.
         return (l_count>r_count)?left_major:right_major;
	}

	public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
	
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

