import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    private static List<Long> optimalSummands(Long n) {
        List<Long> summands = new ArrayList<Long>();
        Long i=1l, t=1l, r=n-t;
        Long pr=n;
        while(i+1<=r) {
        	summands.add(i);
        	i=i+1;
        	t= t+i;
        	pr=r;
        	r = n-t;
        }
        summands.add(pr );
        	
        
        
        return summands;
    }
    
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        List<Long> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Long summand : summands) {
            System.out.print(summand + " ");
        }
    }
	/*
	 * @Test public void manualTest() { List<Long> list =
	 * Arrays.asList(1l,2l,3l,4l,5l); Assert.assertEquals(list,
	 * DifferentSummands.optimalSummands(15l));
	 * 
	 * list = Arrays.asList(1l,2l,3l); Assert.assertEquals(list,
	 * DifferentSummands.optimalSummands(6l));
	 * 
	 * list = Arrays.asList(1l,2l,5l); Assert.assertEquals(list,
	 * DifferentSummands.optimalSummands(8l));
	 * 
	 * list = Arrays.asList(2l); Assert.assertEquals(list,
	 * DifferentSummands.optimalSummands(2l));
	 * 
	 * list = Arrays.asList(1l,2l,3l,4l,5l, 6l, 9l); Assert.assertEquals(list,
	 * DifferentSummands.optimalSummands(30l)); }
	 * 
	 */
}

