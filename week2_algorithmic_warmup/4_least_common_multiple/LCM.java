import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) { //slow for input 761457 614573
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_euclid(int a,int b){
	  long gcd = gcd_euclid(a,b);
	  if(a>b) a= (int) (((long)a)/gcd);
	  else b= (int) (((long)b)/gcd);
	  
	  return (long) a * b;
  }
  
  private static int gcd_euclid(int a, int b) {
	    int temp = 1;
	    while(b!=0) {
	    	temp = a%b ;
	    	a = b;
	    	b = temp;
	    }
	    return a;
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(lcm_naive(a, b));
    System.out.println(lcm_euclid(a,b));
    scanner.close();
  }
}
