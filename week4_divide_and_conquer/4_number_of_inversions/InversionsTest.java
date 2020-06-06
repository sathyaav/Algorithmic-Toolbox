import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InversionsTest {

	@Test
	void testMain() {
		assertEquals(Inversions.getNumberOfInversions(new int[] {1,9,8,2,3,5,4,2,3,1}, 0, 9),27);
		
		assertEquals(Inversions.getNumberOfInversions(new int[] {1,2,3,4}, 0, 3),0);
		assertEquals(Inversions.getNumberOfInversions(new int[] {9,8,7,3,2,1},  0, 5),15);
		
		assertEquals(Inversions.getNumberOfInversions(new int[] {2,3,9,2,9}, 0, 4),2);
		System.out.println("\n---------\n");
		assertEquals(Inversions.getNumberOfInversions(new int[] {1,2,3,0,1,5,7},  0, 6),5);
		System.out.println("\n---------\n");
		assertEquals(Inversions.getNumberOfInversions(new int[] {2,3,9,2,9,1}, 0, 5),7);
	}

}
