import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DotProductTest {

	@Test
	void testMain() {
		assertEquals(23, DotProduct.maxDotProduct(new Integer[] {1,3,-5}, new Integer[] {-2,4,1}));
		assertEquals(897, DotProduct.maxDotProduct(new Integer[] {23}, new Integer[] {39}));
		assertEquals(897, DotProduct.maxDotProduct(new Integer[] {23, 0}, new Integer[] {39,-1}));
		assertEquals(4389076, DotProduct.maxDotProduct(
					new Integer[] {1,3,-5, -8, 10, 16, 27 ,0 ,-23, -343234}, 
					new Integer[] {-2,4,1, 2,10000, 3,6,9,-1,-12})
				
							
		);
	}

}
