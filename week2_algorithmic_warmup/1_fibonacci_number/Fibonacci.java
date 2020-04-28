import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
	Long memo[] = new Long[n+2];
	memo[0]=0L;
	if(n>0) memo[1]=1L;
	for(int i=2;i<=n;i++) {
		memo[i]= memo[i-1]+memo[i-2];
	}
    return memo[n];
  } 
  

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
    in.close();
  }
}
