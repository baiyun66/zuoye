import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Test;

public class TestDoubleLinkedList {

	@Test
	public void testRepOk() {
		DoubleLinkedList list1 = new DoubleLinkedList();
		assertEquals(true, list1.repOK());
		list1.header = null;
		assertEquals(false, list1.repOK());
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		DoubleLinkedList list2 = new DoubleLinkedList(al);
		assertEquals(true, list2.repOK());
		list2.header.next.previous = list2.header.next.next;
		assertEquals(false, list2.repOK());
		list2.header.next.previous = null;
		assertEquals(false, list2.repOK());
		ArrayList<Integer> al_1 = new ArrayList<Integer>();
		al_1.add(1);
		DoubleLinkedList list3 = new DoubleLinkedList(al_1);
		list3.size = 4;
		assertEquals(false, list3.repOK());
		list3.size = 1;
		list3.header.previous = null;
		assertEquals(false, list3.repOK());
	}

	@Test
	public void testInList() {
		DoubleLinkedList list1 = new DoubleLinkedList();
		assertEquals(true, list1.inList(list1.header));
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		DoubleLinkedList list2 = new DoubleLinkedList(al);
		assertEquals(true, list2.inList(list2.header.next));
		assertEquals(true, list2.inList(list2.header.next.next));
		assertEquals(false, list2.inList(list1.header.next));
	}

	@Test
	public void testContains() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		assertEquals(true, list1.contains(1));
		assertEquals(false, list1.contains(3));
	}

	@Test
	public void testSize() {
		DoubleLinkedList list1 = new DoubleLinkedList();
		assertEquals(0, list1.size());
	}

	@Test
	public void testAdd() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		assertEquals(true, list1.add(3));
	}

	@Test
	public void testRemove() {
		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		Object obj = null;
		assertEquals(false, list1.remove(obj));
		assertEquals(true, list1.remove(list1.header.next.next.element));
		list1.header.next.element = null;
		assertEquals(true, list1.remove(obj));
		obj = new Integer(5);
		assertEquals(false, list1.remove(obj));

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddAllIndex() {
		ArrayList<Integer> al = new ArrayList<Integer>();

		DoubleLinkedList list1 = new DoubleLinkedList();
		assertEquals(false, list1.addAll(al));
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		list1.size = 4;
		assertEquals(true, list1.addAll(2, al));

		list1.addAll(100, al);
		list1.addAll(-1, al);
	}

	@Test
	public void testClear() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		list1.clear();
	}

	@Test
	public void testGet() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		assertEquals(list1.header.next.next.element,list1.get(1));
	}

	@Test
	public void testAddIndex() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		list1.add(1, 6);
		list1.add(5,7);
	}

	@Test
	public void testRemoveIndex() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		assertEquals(2,list1.remove(1));
	}

	@Test
	public void testEntry() {
	
	}

	@Test
	public void testIndexOf() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		Object obj = null;
		assertEquals(-1,list1.indexOf(obj));
		list1.header.next.element = null;
		assertEquals(0,list1.indexOf(obj));
	}

	@Test
	public void testLastIndexOf() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		assertEquals(-1,list1.lastIndexOf(2));
		assertEquals(0,list1.lastIndexOf(list1.header.next.element));
		
		Object obj = null;
		assertEquals(-1,list1.lastIndexOf(obj));
		list1.header.next.next.element = null;
		assertEquals(1,list1.lastIndexOf(obj));	
	}
	
	@Test
	public void testNonNullPointers(){
		//ArrayList<Integer> al = new ArrayList<Integer>();
		DoubleLinkedList list1 = new DoubleLinkedList();
		list1.header.next = null ;list1.header.previous = null;
		assertEquals(false,list1.header.nonNullPointers());
		
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testEntryRemove(){
		DoubleLinkedList list1 = new DoubleLinkedList();
		list1.remove(list1.header);
	}
	
	@Test
	public void testToArray(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		DoubleLinkedList list1 = new DoubleLinkedList(al);
		Object[] res = {1,2,3,4};
		assertEquals(true,equals(res,list1.toArray(res)));
		Object[] res1 = new Object[2];
		assertEquals(false,equals(res1,list1.toArray(res1)));
		Object[] res2 = new Object[10];
		assertEquals(true,equals(res2,list1.toArray(res2)));
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
