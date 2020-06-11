import java.util.*;

public class CoveringSegments {

    private static ArrayList<Long> optimalPoints(Segment[] segments) {
       
    	//Sort the array
    	Arrays.sort(segments);
    	Long end=0L;
    	int n = segments.length;
    	ArrayList<Long> output = new ArrayList<Long>();
    	
    	for(int i=0;i<n;i++) {
    		
    		//Initially the ending window will be the end time of first job
    		end = segments[i].end;
    		
    		//For each iteration, find the end time if the job timing is overlapping 
    		// overlapping: if end time of first job is more than the end time of next job
    		for(; i+1<n && segments[i+1].start <=end;i++)  	
    			
    			// the minimum value should be taken, after that the i'th job expires. 
    			end = Math.min(end, segments[i+1].end);    	
    		
    		// if condition breaks, then the end time is to be taken
    		output.add(end); 								
    		
    	}
    	return output;
    }

    private static class Segment implements Comparable<Segment>{
        Long start, end;

        Segment(Long start2, Long end2) {
            this.start = start2;
            this.end = end2;
        }

		@Override
		public int compareTo(Segment o) {
			return (this.start < o.start)? -1: 1;
		}

		
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            Long start, end;
            start = scanner.nextLong();
            end = scanner.nextLong();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Long> points = optimalPoints(segments);
        System.out.println(points.size());
        for (Long point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
 
