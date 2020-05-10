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

		for (int i = 0; i < total; i++) {
			if (capacity == 0)
				break;

			Double a = Math.min(capacity, items[i].getWeight());
			value = value +  a* ( items[i].getValue()/ items[i].getWeight());
			capacity = capacity - a;
			items[i].setWeight(items[i].getWeight().intValue() - a);
		}

		value = Math.round((value * 10000.0)) / 10000.0;
		return value;
	}


	public static void main(String args[]) {


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

}
