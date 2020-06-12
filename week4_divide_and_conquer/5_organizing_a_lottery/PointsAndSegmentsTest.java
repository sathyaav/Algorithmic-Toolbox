import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointsAndSegmentsTest {

	@Test
	void test() {
		PointsAndSegments obj = new PointsAndSegments();
		
		assertArrayEquals(obj.fastCountSegments(new int[] {-3,-2,0,0,1,1,3,5,7,9}, new int[] {2,5,5,5,5,6,6,6,7,12}, new int[] {0,-2,-3,5,9,-4,12}), new int[] {4,2,1,7,1,0,1});
		assertArrayEquals(obj.fastCountSegments(new int[] {0,-3,7}, new int[] {5,2,10}, new int[] {1,6}), new int[] {2,0});
	}

}
