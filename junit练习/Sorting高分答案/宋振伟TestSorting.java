import static org.junit.Assert.*;

import org.junit.Test;

public class TestSorting {

	@Test
	public void testInsertionSort() {
		Sorting sorting = new Sorting();
		int [] a ={4,8,9,3,2};
		int [] a_r = {2,3,4,8,9};
		sorting.insertionSort(a);
		assertEquals(true,equals(a_r,a));
	}
	@Test
	public void testIsSorted(){
		Sorting sorting = new Sorting();
		int [] a = {4,6,8,9,2};
		int [] b = {2,3,4};
	    assertEquals(false,sorting.isSorted(a));
	    assertEquals(true,sorting.isSorted(b));
	}
	
	@Test
	public void testQuickSort(){
		int[] a = {12,11,10,9,8,7,6,5,4,3,2,1,0};
		int[] a_r = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		Sorting.quicksort(a);
		assertEquals(true,equals(a_r,a));
		int[] b = {6,11,0,9,8,7,10,5,4,3,2,1,12};
        int[] b_r = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		Sorting.quicksort(b);
		assertEquals(true,equals(b_r,b));
		Sorting.quicksort(b_r);
		assertEquals(true,equals(b_r,b_r));
	}
	@Test
	public void testSwapReferences(){
		Object[] a =  {1,2,3};
		Object[] a_r = {1,3,2};
		Sorting.swapReferences(a, 1, 2);
		assertEquals(true,equals(a,a_r));
	}
	
	/**
	 * param int [] a 
	 * param int [] b
	 * @return boolean
	 */
	public static boolean equals(int[] a,int[] b){
		if(a.length != b.length)
			return false;
		int length = a.length;
		int i = 0;
		for(i = 0; i < length; i ++){
			if(a[i] != b[i])
				break;
		}
		if(i == length){
			return true;
		}
		return false;
	}
	
	public static boolean equals(Object[] a,Object[] b){
		if(a.length != b.length)
			return false;
		int length = a.length;
		int i = 0;
		for(i = 0; i < length; i ++){
			if(a[i] != b[i])
				break;
		}
		if(i == length){
			return true;
		}
		return false;
	}
}
