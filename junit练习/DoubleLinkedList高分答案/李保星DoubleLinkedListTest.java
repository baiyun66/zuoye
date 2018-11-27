import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {

	DoubleLinkedList[]  dllist = new DoubleLinkedList[10];
	
	
	@Before
	public void setUp() throws Exception {
		dllist[0] = new DoubleLinkedList();
		dllist[0].header.next=dllist[0].header.previous=dllist[0].header=null;
		dllist[1] = new DoubleLinkedList(new LinkedList<Integer>(){{add(1);add(null);add(2);add(3);}});
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testRepOK() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		assertEquals(false, dllist[0].repOK());
		assertEquals(true, dllist[1].repOK());
		dllist[1].add(4);
		assertEquals(true, dllist[1].repOK());
		dllist[1].entry(2).previous = dllist[1].entry(0);
		assertEquals(false, dllist[1].repOK());
		dllist[1].entry(0).next=dllist[1].entry(2);
		assertEquals(false, dllist[1].repOK());
		dllist[1].entry(2).previous = null;
		assertEquals(false, dllist[1].repOK());
		dllist[1].entry(0).next=null;
		assertEquals(false, dllist[1].repOK());
	}

	@Test
	public void testInList() {
		assertEquals(true, dllist[0].inList(dllist[0].header));
		assertEquals(true, dllist[1].inList(dllist[1].entry(1)));
		assertEquals(false, dllist[1].inList(null));
		
	}

	@Test
	public void testContains() {
		assertEquals(true, dllist[1].contains(dllist[1].get(1)));
		assertEquals(true, dllist[1].contains(dllist[1].get(3)));
		assertEquals(false, dllist[1].contains(5));
		
	}

	@Test
	public void testSize() {
		assertEquals(4, dllist[1].size());
	}

	@Test
	public void testAddObject() {
		assertTrue(dllist[1].add(4));
		assertEquals(5, dllist[1].size());
	}

	@Test
	public void testRemoveObject() {
		assertEquals(true, dllist[1].remove(dllist[1].get(1)));
		assertEquals(false, dllist[1].remove((Object)null));
		assertEquals(true, dllist[1].remove(dllist[1].get(2)));
		assertEquals(false, dllist[1].remove((Object)5));
	}

	@Test
	public void testAddAllCollection() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals(false,dllist[1].addAll(list));
		
	}

	@Test
	public void testAddAllIntCollection() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(5);
		assertEquals(true,dllist[1].addAll(0,list));
	}

	@Test
	public void testClear() {
		dllist[1].clear();
		assertEquals(0, dllist[1].size());
	}

	@Test
	public void testGet() {
		assertEquals(null, dllist[1].get(1));
	}

	@Test
	public void testAddIntObject() {
		dllist[1].add(0, null);
		dllist[1].add(5, null);
	}

	@Test
	public void testRemoveInt() {
		try {
			dllist[1].remove(-1);
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
		try {
			dllist[1].remove(4);
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
		assertEquals(2, dllist[1].remove(2));
	}

	@Test
	public void testEntry() {
		
	}

	@Test
	public void testIndexOf() {
		assertEquals(1, dllist[1].indexOf(dllist[1].get(1)));
		dllist[1].header.next=dllist[1].header;
		assertEquals(-1, dllist[1].indexOf(dllist[1].header.element));
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(1, dllist[1].lastIndexOf(dllist[1].get(1)));
		assertEquals(-1, dllist[1].lastIndexOf((Object)5));
		assertEquals(3, dllist[1].lastIndexOf(dllist[1].get(3)));
		dllist[1].header.previous=dllist[1].header;
		assertEquals(-1, dllist[1].lastIndexOf(dllist[1].header.element));
	}

	@Test
	public void testAddBefore() {
		
	}

	@Test
	public void testRemoveEntry() {
		try {
			dllist[1].remove(dllist[1].header);
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
		
	}

	@Test
	public void testToArray() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Object[] a = list.toArray();
		assertArrayEquals(new Object[]{1,null,2,3},dllist[1].toArray(a));
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		Object[] b = list2.toArray();
		assertArrayEquals(new Object[]{1,null,2,3,null},dllist[1].toArray(b));
	}

}
