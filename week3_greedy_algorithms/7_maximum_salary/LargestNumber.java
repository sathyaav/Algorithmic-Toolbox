import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        int maxDigit = -1;
        int findLen = a[0].length();
        for (int i = 0; i < a.length; i++) {
            maxDigit = -1;
            for(String digit: a) {
            	
            	if(digit.length() == findLen && Integer.parseInt(digit)>maxDigit) {
            		maxDigit = Integer.parseInt(digit);
            	}
            }
        	
        	
        	
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

