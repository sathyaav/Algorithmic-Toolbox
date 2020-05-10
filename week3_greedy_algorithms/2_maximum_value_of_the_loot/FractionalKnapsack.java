import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class FractionalKnapsack {
	class Knapsack implements Comparable<Knapsack> {
		private Double weight;
		private Double value;
		private Double cost;
		
		public Knapsack(Double weight, Double value) {
			this.weight = weight;
			this.value = value;
			this.cost = value / weight;
		}
		
		public Double getCost() {
			return this.cost;
		}

		public Double getWeight() {
			return this.weight;
		}

		public Double getValue() {
			return this.value;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		@Override
		public int compareTo(Knapsack obj) {
			if(this.getCost()==obj.getCost()) return (this.getWeight() < obj.getWeight()) ? -1 : 1;
			return (this.getCost() > obj.getCost()) ? -1 : 1;
		}

	}

	private static double getOptimalValue(Double capacity, Double[] values, Double[] weights) {
		double value = 0;
		int total = values.length;
		FractionalKnapsack obj = new FractionalKnapsack();
		Knapsack items[] = new Knapsack[total];
		for (int i = 0; i < total; i++) {
			items[i] = obj.new Knapsack(weights[i], values[i]);
		}
		
		Arrays.sort(items);
		//System.out.println("\n~~~\n");
		for (int i = 0; i < total; i++) {
			if (capacity == 0)
				break;
			//System.out.println("Value: "+items[i].getValue()+" Weigth: "+items[i].getWeight()+" Cost: "+items[i].getCost());
			
			Double a = Math.min(capacity, items[i].getWeight());
			value = value +  a* ( items[i].getValue()/ items[i].getWeight());
			capacity = capacity - a;
			items[i].setWeight(items[i].getWeight().intValue() - a);
			//System.out.println("Capacity: "+capacity+" Fraction: "+a+" value: "+value);
		}

		value = Math.round((value * 10000.0)) / 10000.0;
		return value;
	}

	
	//Copied from geeksforgeeks for stresstesting
	private static double getMaxValue(Double capacity,Double[] val, Double[] wt ) {
		ItemValue[] iVal = new ItemValue[wt.length];

		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new ItemValue(wt[i], val[i], i);
		}

		//sorting items by value; 
		Arrays.sort(iVal, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				return o2.cost.compareTo(o1.cost);
			}
		});

		Double totalValue = 0d;

		for (ItemValue i : iVal) {

			Double curWt = i.wt;
			Double curVal =  i.val;
			System.out.println("Value: "+curVal+" Weigth: "+curWt+" Cost: "+i.cost);
			
			if (capacity - curWt >= 0) {
				// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
				System.out.println("Capacity: "+capacity+" Fraction: "+0+" value: "+totalValue);

			} else {
				// item cant be picked whole
				Double fraction = (capacity /  curWt);
				totalValue += (curVal * fraction);
				capacity = (capacity - (curWt * fraction));
				System.out.println("Capacity: "+capacity+" Fraction: "+fraction+" value: "+totalValue);
				break;
				
			}
			
		}
		totalValue = Math.round((totalValue * 10000.0)) / 10000.0;
		
		return totalValue;
	}

	static class ItemValue  
    { 
        Double cost; 
        double wt, val, ind; 
          
        // item value function 
        public ItemValue(Double wt, Double val, int ind) 
        { 
            this.wt = wt; 
            this.val = val; 
            this.ind = ind; 
            cost = (val/wt ); 
        } 
    } 
	
	public static void main(String args[]) {
		
		//stressTest();
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Double capacity = scanner.nextDouble();
		Double[] values = new Double[n];
		Double[] weights = new Double[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextDouble();
			weights[i] = scanner.nextDouble();
		}
		scanner.close();
		System.out.println(getOptimalValue(capacity, values, weights));
		
	}

	private static void stressTest() {
		
		while(true) {
			Random r = new Random();
			int n=50;
			Double capacity=1000000d;
			Double[] values = new Double[n];
			Double[] weights = new Double[n];
			for (int i = 0; i < n; i++) {
				values[i] = r.nextDouble()*Math.pow(10,6);
				weights[i] = r.nextDouble()*Math.pow(10,6)+1;
			}
			Double val2 = getMaxValue(capacity, values, weights);
			System.out.println("\n\n-----\n\n");
			Double val1 = getOptimalValue(capacity, values, weights);
			if(!val1.equals(val2)) {
				for(int i=0;i<n;i++) {
					System.out.print(values[i]+" ");
				}
				System.out.println();
				for(int i=0;i<n;i++) {
					System.out.print(weights[i]+" ");
				}
				System.out.println();
				System.out.println(val1 +"   "+  val2);
				break;
			}
			
		}
	}
}
