import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test() {
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,5,8,12,13}, 8), 2);
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,5,8,12,13}, 1), 0);
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,5,8,12,13}, 23), -1);
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,5,8,12,13}, 13), 4);

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 1), 0);
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 2), 1);

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 3), 2);
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 4), 3);

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 5), 4);

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 6), -1 );

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5}, 0), -1 );

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 0), -1 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 1), 0 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 2), 1 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 3), 2 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 4), 3 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 5), 4 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 6), 5 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,2,3,4,5,6}, 10), -1 );

		assertEquals(BinarySearch.binarySearch(new Integer[] {1,1,3,4,4}, 1), 1 );
		assertEquals(BinarySearch.binarySearch(new Integer[] {1,1,3,4,4}, 4), 4 );
	}

}
