import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

	
public class SortingTest {
	Sorting sort;
	int[][] array = new int[10][];
	@Before
	public void setUp() throws Exception {
		sort = new Sorting();
		//array[0]=new int[]{};//¿ÕÊý×é
		//array[1]=new int[]{1};
		array[2]=new int[]{1,2};
		array[3]=new int[]{2,1};
		array[4]=new int[]{1,2,3,4,5,6,7,8,9,10,11};
		array[5]=new int[]{11,10,9,8,7,6,5,4,3,2,1};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertionSort() {
		//sort.insertionSort(array[0]);
		//assertArrayEquals(new int[]{}, array[0]);
		//sort.insertionSort(array[1]);
		//assertArrayEquals(new int[]{1}, array[1]);
		sort.insertionSort(array[2]);
		assertArrayEquals(new int[]{1,2}, array[2]);
		sort.insertionSort(array[3]);
		assertArrayEquals(new int[]{1,2}, array[3]);
	} 

	@Test
	public void testIsSorted() {
		//assertEquals(true, sort.isSorted(array[0]));
		assertEquals(true, sort.isSorted(array[2]));
		assertEquals(false, sort.isSorted(array[3]));
	}

	@Test
	public void testQuicksort() {
		//Sorting.quicksort(array[3]);
		//assertArrayEquals(new int[]{1,2} , array[3]);
		Sorting.quicksort(array[4]);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11}, array[4]);
		Sorting.quicksort(array[5]);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11}, array[5]);
	}

	@Test
	public void testSwapReferences() {
		Object[] a = new Object[]{1};
		Sorting.swapReferences(a, 0, 0);
		//assertArrayEquals(new Object[]{1}, a);
		///Object[] a=new Object[]{1,2};
		//Sorting.swapReferences(a, 0, 1);
		//assertArrayEquals(new Object[]{2,1}, a);
	}

	@Test
	public void testSwap() {
		//Sorting.swap(array[1], 0, 0);
		//assertArrayEquals(new int[]{1},array[1]);
		//Sorting.swap(array[2], 0, 1);
		//assertArrayEquals(new int[]{2,1},array[2]);
	}

}
