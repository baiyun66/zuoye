import static org.junit.Assert.*;


import org.junit.Test;


public class SortingTest {

	Sorting sort=new Sorting();
	
	
	@Test
	public void testInsertionSort() {
		int[] a = new int[]{7,9,10,2,5,8,13,6,14,20,21,1,4,14,24};
		sort.insertionSort(a);
		assertEquals(true,sort.isSorted(a));
	}

	@Test
	public void testIsSorted() {
		int[] a = new int[]{7,9,10,2,5,8,13,6,14,20,21,1,4,14,24};
		sort.insertionSort(a);
		assertEquals(true,sort.isSorted(a));
		//交换位置一下
		int temp=a[4];
		a[4]=a[5];
		a[5]=temp;
		assertEquals(false,sort.isSorted(a));
	}

	@Test
	public void testQuicksort() {
		int[] a = new int[]{7,9,10,2,5,8,13,6,14,20,21,1,4,14,24};
		Sorting.quicksort(a);
		assertEquals(true,sort.isSorted(a));
		int[] b = new int[]{7,9,10,2,5};
		Sorting.quicksort(b);
		assertEquals(true,sort.isSorted(b));
	}

	@Test
	public void testSwapReferences() {
		
	}

	@Test
	public void testSwap() {
		
	}
	@Test
	public void testMedian3(){
		int[] a = new int[]{6,9,10,2,5,8,13,7,14,20,21,1,4,14,24};
		int[] b = new int[]{6,9,10,2,5,8,13,24,14,20,21,1,4,14,7};
		int[] c = new int[]{7,9,10,2,5,8,13,6,14,20,21,1,4,14,24};
		int[] d = new int[]{7,9,10,2,5,8,13,24,14,20,21,1,4,14,6};
		int[] e = new int[]{24,9,10,2,5,8,13,7,14,20,21,1,4,14,6};
		int[] f = new int[]{24,9,10,2,5,8,13,6,14,20,21,1,4,14,7};
		Sorting.quicksort(a);
		Sorting.quicksort(b);
		Sorting.quicksort(c);
		Sorting.quicksort(d);
		Sorting.quicksort(e);
		Sorting.quicksort(f);
		assertEquals(true,sort.isSorted(a));
		assertEquals(true,sort.isSorted(b));
		assertEquals(true,sort.isSorted(c));
		assertEquals(true,sort.isSorted(d));
		assertEquals(true,sort.isSorted(e));
		assertEquals(true,sort.isSorted(f));
		
	}

}
