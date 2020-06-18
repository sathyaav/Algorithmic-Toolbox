import java.util.*;


/*
 * Task: Given an integer n, compute the minimum number of operations needed to
 * obtain the number n starting from the number 1.
 * 
 * 	Sample 1:
	Input:
	1
	Output:
	0
	1
	
	Sample 2:
	Input:
	5
	Output:
	3
	1 2 4 5
	Here, we first multiply 1 by 2 two times and then add 1. Another possibility is to first multiply by 3
	and then add 1 two times. Hence “1 3 4 5” is also a valid output in this case.
	
	Sample 3:
	Input:
	96234
	Output:
	14
	1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
	
	Again, another valid output in this case is “1 3 9 10 11 33 99 297 891 2673 8019 16038 16039 48117
	96234”.
 */

public class PrimitiveCalculator {
	/* Solution: 
	 * 
	 * Define a hashmap which have the number as key and list of array as value
	 * initialize key  0 : [0] , 1: [0] , 2: [1,2] , 3 : [1,3] 
	 * 
	 * find the min of the three values and add the value to the list. 
	 * 
	 * 
	 * */
    private static List<Integer> optimal_sequence(int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(n);
        
        ArrayList<Integer> list =  new ArrayList<Integer>();
        list.add(0);
        map.put(0, list);
        
        list =  new ArrayList<Integer>();
        list.add(0);
        map.put(1, list);
        
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        map.put(2, list);
        
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        map.put(3, list);
        
        if(map.containsKey(n))
        	return map.get(n);
        else {
        	return countOperations(n,map);
        }
        
    	
    }
    
    private static List<Integer> countOperations(int num, HashMap<Integer, ArrayList<Integer>> map) {
    	int start = 4; int min1,min2,min3;
    	ArrayList<Integer> val1 = null;
    	ArrayList<Integer> val2 = null;
    	ArrayList<Integer> val3 = null;
    	
    	//fill up the map with values from 4 to number .
        for(int i = start; i<=num;i++) {
        	min1=Integer.MAX_VALUE;
        	min2=Integer.MAX_VALUE;
        	min3=Integer.MAX_VALUE;
        	
        	// if the number is divisible by 2, then get the value i/2 from map 
        	if( i % 2 == 0) {
        		val1 = map.get(i/2);
        		min1 = val1.size();
        	}
        	// if the number is divisible by 3, then get the value i/3 from map 
        	if(i % 3 == 0) {
        		val2 = map.get(i/3);
        		min2 = val2.size();
        		
        	}
        	// then get the value i-1 from map 
        	val3 = map.get(i-1);
        	min3 = val3.size();
        	
        	//find the min of three and clone the list and add the value to the list. Add the final list to the map 
        	if( min1 < min2) 
        		if(min1 < min3)
        			addToMap(i,val1,map);
        		else
        			addToMap(i,val3,map);
        	else if(min2 < min3)
        		addToMap(i,val2,map);
        	else
        		addToMap(i,val3,map);
        	
        	
        }
		return map.get(num);
	}

	private static void addToMap(int i, ArrayList<Integer> val1, HashMap<Integer, ArrayList<Integer>> map) {
		ArrayList<Integer> list;
		list = (ArrayList<Integer>)val1.clone();
		list.add(i);
		map.put(i,list);
		
	}

	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

