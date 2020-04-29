import java.util.*;

//Compute Last Digit of the Sum of Squares of Fibonacci Numbers
public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
    
    
    private static long getFibonacciSumSquares(long n) {
        if (n <= 2)
            return n;
        
        long previous=getFibonacciLastDigit(n-2);
        long current = getFibonacciLastDigit(n-1);
        
        long width= (current+previous)%10;
        long height = (current);
        long square = width*height;
        return square%10;
    }
    
    
    private static long getFibonacciLastDigit(long n) {
    	return getFibonacciPartialSum(n-1,n);
    }
    
    private static long getFibonacciPartialSum(long from, long to) {
        //After n = 60 the values int unit place are repeated
    	if(from<0 || to <0) return 0L;
    	
        Long[] memo =  {0L, 1L, 2L, 4L, 7L, 12L, 20L, 33L, 54L, 88L, 143L, 232L, 376L, 609L, 986L, 1596L, 2583L, 4180L, 6764L, 10945L, 17710L, 
        		28656L, 46367L, 75024L, 121392L, 196417L, 317810L, 514228L, 832039L, 1346268L, 2178308L, 3524577L, 5702886L, 9227464L, 
        		14930351L, 24157816L, 39088168L, 63245985L, 102334154L, 165580140L, 267914295L, 433494436L, 701408732L, 1134903169L, 
        		1836311902L, 2971215072L, 4807526975L, 7778742048L, 12586269024L, 20365011073L, 32951280098L, 53316291172L, 86267571271L, 
        		139583862444L, 225851433716L, 365435296161L, 591286729878L, 956722026040L, 1548008755919L, 2504730781960L}; 
        
        to %=60;
        if(from!=0)
        	from = (from-1)%60;
        
        long diff = (memo[(int)to] - memo[(int)(from)]);
        diff = diff%10;
        if(diff<0) diff = 10+diff; //if difference is negative , then find the complement of it
        return diff;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumSquaresNaive(n);
        long r = getFibonacciSumSquares(n);
        scanner.close();
        System.out.println(r);
    }
}

