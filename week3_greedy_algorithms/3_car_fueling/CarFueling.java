import java.util.Scanner;

public class CarFueling {
	static int computeMinRefills(Double dist, int tank, Double[] stops) {
		Integer numRefills = 0, currentRefill = 0, lastRefill = 0;
		Integer n = stops.length;
		
		if (dist <= tank)
			return 0;
		
		//Appending initial start -0 and final destination - dist to the array
		stops = appendInitialAndFinalValue(stops,n,dist);
		n = stops.length-1;
		while (currentRefill < n) {
			lastRefill = currentRefill;

 			while (currentRefill < n && stops[currentRefill + 1] - stops[lastRefill] <= tank) 
				currentRefill += 1;
			
			if (currentRefill.equals(lastRefill) && currentRefill!=n)
				return -1;
			
			if (currentRefill < n ) 
				numRefills += 1;
			
		}
	
		return numRefills;
	}

	private static Double[] appendInitialAndFinalValue(Double[] stops, Integer n, Double dist) {
		n=n+2;
		Double[] stops_new= new Double[n];
		stops_new[0] = 0d;
		stops_new[n-1] =dist;
		for(int i=1;i<n-1;i++) {
			stops_new[i] = stops[i-1];
		}
		return stops_new;
	}

	public static void main(String[] args) {
		//manualTest();
		Scanner scanner = new Scanner(System.in);
		Double dist = scanner.nextDouble();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		Double stops[] = new Double[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextDouble();
		}
		scanner.close();
		System.out.println(computeMinRefills(dist, tank, stops));
	}

	private static void manualTest() {
		Double stops[] = {200.0,300.0,400.0,500.0,600.0};
		System.out.println(computeMinRefills(650.0d, 200, stops)); // 3
		Double stops2[] = {200.0,300.0,400.0,500.0};
		System.out.println(computeMinRefills(600.0d, 200, stops2)); // 2
		Double stops3[] = {};
		System.out.println(computeMinRefills(600.0d, 200, stops3)); // -1
		Double stops4[] = {200.0,375.0d, 550.0, 750.0};
		System.out.println(computeMinRefills(950.0d, 400, stops4)); // 2
		Double stops5[] = {1.0,2.0d, 5.0, 9.0};
		System.out.println(computeMinRefills(10.0d, 3, stops5)); // -1
		Double stops6[] = {100.0,150.0};
		System.out.println(computeMinRefills(200.0d, 250, stops6)); // -1
		
	}

	
}
