import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestSorting {

	@Test(expected = java.lang.NullPointerException.class)
	public void testInsertionSort() {
		Sorting s1 = new Sorting();

		// empty array
		int[] a = {};
		s1.insertionSort(a);
		assertArrayEquals(new int[] {}, a);

		// sorted array
		a = new int[] { 0, 1, 2, 3 };
		s1.insertionSort(a);
		assertArrayEquals(new int[] { 0, 1, 2, 3 }, a);

		// not sorted array
		a = new int[] { 3, 2, 1, 0 };
		s1.insertionSort(a);
		assertArrayEquals(new int[] { 0, 1, 2, 3 }, a);

		// catch NullPointerException
		a = null;
		s1.insertionSort(a);
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testIsSorted() {
		Sorting s1 = new Sorting();

		// empty array
		int[] a = {};
		assertTrue(s1.isSorted(a));

		// one element sorted
		a = new int[] { 0 };
		assertTrue(s1.isSorted(a));

		// three element sorted
		a = new int[] { 0, 1, 2 };
		assertTrue(s1.isSorted(a));

		// three element not sorted
		a = new int[] { 2, 1, 0 };
		assertTrue(!s1.isSorted(a));

		// catch NullPointerException
		a = null;
		s1.isSorted(a);
	}

	@Test
	public void testSwap() {
		// normal
		int[] a = new int[] { 0, 1, 2 };
		Sorting.swap(a, 0, 1);
		assertArrayEquals(new int[] { 1, 0, 2 }, a);

		// NullPointerException
		a = null;
		try {
			Sorting.swap(a, 0, 1);
			//fail("Expected a NullPointerException to be thrown");
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), null);
		}
		
		// IndexOutOfBoundsException
		a = new int[]{0, 1};
		try{
			Sorting.swap(a, 1, 2);
		}catch(IndexOutOfBoundsException e) {
			assertThat(e.getMessage(), containsString("2"));
		}

	}
	
	@Test
	public void testSwapReference(){
		
		// NullPointerException
		Object[] o = null;
		try{
			Sorting.swapReferences(o, 0, 0);
		}catch (NullPointerException e) {
			assertEquals(e.getMessage(), null);
		}
		
		// empty object array
		o = new Object[]{};
		try{
			Sorting.swapReferences(o, 0, 0);
		}catch (IndexOutOfBoundsException e) {
			assertThat(e.getMessage(), containsString("0"));
		}
		
		// two String elements
		o = new Object[]{"One", "Two"};
		Sorting.swapReferences(o, 0, 1);
		assertArrayEquals(new Object[]{"Two", "One"}, o);
		
		// one int and one String
		o = new Object[]{1, "Two"};
		Sorting.swapReferences(o, 0, 1);
		assertArrayEquals(new Object[]{"Two", 1}, o);
		
	}
	
	@Test
	public void testInsertionSortPrivate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		// 
		Method m = Sorting.class.getDeclaredMethod("insertionSort", new Class[]{int[].class,int.class, int.class});
		m.setAccessible(true);
		
		// 
		int[] a = new int[] {0, 2, 1};
		m.invoke(null, a, 0, 2);
		assertArrayEquals(new int[]{0, 1, 2}, a);
		
		// 
		a = new int[]{9,8,7,6,5,4,3,2,1};
		m.invoke(null, a, 3, 8);
		assertArrayEquals(new int[]{9,8,7,1,2,3,4,5,6}, a);
		
	}
	
	@Test
	public void testMedian3() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		Method m = Sorting.class.getDeclaredMethod("median3", new Class[]{int[].class,int.class, int.class});
		m.setAccessible(true);
		
		int[] a = new int[]{3, 2, 1};
		assertEquals(2, m.invoke(null, a, 0, 2));
		assertArrayEquals(new int[]{1, 2, 3}, a);
		a = new int[]{1, 2, 3};
		assertEquals(2, m.invoke(null, a, 0, 2));
		assertArrayEquals(new int[]{1, 2, 3}, a);
	}
	
	@Test
	public void testQuicksortPrivate() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		Method m = Sorting.class.getDeclaredMethod("quicksort", new Class[]{int[].class,int.class, int.class});
		m.setAccessible(true);
		
		int[] a = new int[] {3, 2, 1};
		m.invoke(null, a, 0, 2);
		assertArrayEquals(new int[]{1, 2, 3}, a);
		
		a = new int[]{4, 3, 2, 1};
		m.invoke(null, a, 0, 3);
		assertArrayEquals(new int[]{1, 2, 3, 4}, a);
		
		a = new int[]{11, 10, 9,8,7,6,5,4,3,2,1};
		m.invoke(null, a, 0, 10);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11}, a);
		
		a = new int[]{1,2,3,4,5,6,7,8,9,10,11};
		m.invoke(null, a, 0, 10);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11}, a);
	}
	
	@Test
	public void testQuicksort(){
		int[] a = new int[]{3, 2, 1};
		Sorting.quicksort(a);
		assertArrayEquals(new int[]{1, 2, 3}, a);
	}

}
