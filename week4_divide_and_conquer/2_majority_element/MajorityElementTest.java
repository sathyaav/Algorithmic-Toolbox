import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MajorityElementTest {

	@Test
	void testMain() {
		assertEquals(MajorityElement.getMajorityElement(new int[] {1, 2, 3,4,1,2,2,2,2,2,3,7,9,13,2,2,2},0,16 ),2);
		assertEquals(MajorityElement.getMajorityElement(new int[] {2,3,5,2,2},0,4 ),2);
		assertEquals(MajorityElement.getMajorityElement(new int[] {2,3,5,3,2},0,4 ),-1);
		assertEquals(MajorityElement.getMajorityElement(new int[] {1,2,3,1},0,3 ),-1);
		
	}

}
