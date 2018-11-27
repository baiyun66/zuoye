import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;


public class TestDoubleLinkedList {
	
	@Test
	public void testClassEntry(){
		// null, this, this
		DoubleLinkedList dll = new DoubleLinkedList();
		assertTrue(dll.header.nonNullPointers());
		assertTrue(dll.header.repOK());
		
		// null, null, null
		dll.header.next = null;
		dll.header.previous = null;
		assertFalse(dll.header.nonNullPointers());
		
		// null, null, null
		dll.header.next = null;
		dll.header.previous = dll.header;
		assertFalse(dll.header.nonNullPointers());
		
		// null, null, null
		dll.header.next = dll.header;
		dll.header.previous = null;
		assertFalse(dll.header.nonNullPointers());
		assertFalse(dll.header.repOK());
	}

	public List<Integer> getList(int num){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num; i++){
			list.add(i);
		}
		return list;
	}

	/**
	 * test toArray(), addBefore(), remove()
	 */
	@Test
	public void test1() {
		// toArray()
		DoubleLinkedList dll = new DoubleLinkedList(getList(10));
		Object[] a = new Object[] {21, 22, 23, 24, 25};
		assertArrayEquals(dll.toArray(a), getList(10).toArray());
		
		dll = new DoubleLinkedList(getList(4));
		assertEquals(dll.toArray(a)[4], null);
		
		// addBefore()
		dll.addBefore(101, dll.header);
		
		// remove()
		try{
			dll.remove(dll.header);
		}catch(NoSuchElementException e){
			assertEquals(e.getMessage(), null);
		}
		
		dll.remove(dll.header.next);
		
		
	}
	
	/**
	 * lastIndexOf(), indexOf(), entry()
	 */
	@Test
	public void test2(){
		DoubleLinkedList dll = new DoubleLinkedList(getList(10));
		
		assertEquals(1, dll.lastIndexOf(1));		// lastIndexOf();
		assertEquals(1, dll.indexOf(1));			// indexOf
		// entry
		assertEquals(1, dll.entry(1).element);
		try{
			dll.entry(-1);
		}catch(IndexOutOfBoundsException e){
			assertThat(e.getMessage(), containsString("Index: "));
		}

		try{
			dll.entry(11);
		}catch(IndexOutOfBoundsException e){
			assertThat(e.getMessage(), containsString("Index: "));
		}
		
		
		assertEquals(-1, dll.lastIndexOf(99));// lastIndexOf();
		assertEquals(-1, dll.indexOf(99));// indexOf
		
		assertEquals(-1, dll.lastIndexOf(null));// lastIndexOf();
		assertEquals(-1, dll.indexOf(null));// indexOf
		
		dll.header.next.element = null;
		assertEquals(0, dll.lastIndexOf(null));// lastIndexOf();
		assertEquals(0, dll.indexOf(null));// indexOf
	}
	
	/**
	 * get(), size(), addAll(), addAll()
	 */
	@Test
	public void test3(){
		DoubleLinkedList dll = new DoubleLinkedList(getList(5));
		
		assertEquals(1, dll.get(1));
		
		dll.add(dll.size(), 99);
		assertEquals(dll.get(dll.size() - 1), 99);
		dll.add(1, 100);
		assertEquals(dll.get(1), 100);
		
		dll.remove(6);
		assertEquals(dll.indexOf(99), -1);
		
		dll.clear();
		assertEquals(dll.size(), 0);
		
		dll.addAll(getList(0));
		assertEquals(dll.size(), 0);
		dll.addAll(getList(5));
		assertEquals(dll.size(), 5);
		
		dll.addAll(dll.size() - 1, getList(6));
		assertEquals(dll.size(), 11);
	}
	
	/**
	 * remove(Object),contains(Object), inList(Entry) 
	 */
	@Test
	public void test4(){
		DoubleLinkedList dll = new DoubleLinkedList(getList(2));
		assertEquals(dll.size() , 2);
		dll.remove((Object)null);

		dll.header.next.element = null;
		dll.remove((Object)null);
		
		
		dll.remove((Object)0);
		assertEquals(dll.size(), 1);
		
		dll = new DoubleLinkedList(getList(3));
		dll.remove((Object)2);
		assertEquals(dll.size(), 2);
		
		dll.add(99);
		assertEquals(dll.size(), 3);
		
		assertTrue(dll.contains((Object)99));
		assertFalse(dll.contains((Object)999));
		
		dll = new DoubleLinkedList(getList(3));
		assertTrue(dll.inList(dll.header));
		assertTrue(dll.inList(dll.header.next));
		assertFalse(dll.inList(null));
	}

	@Test
	public void test5(){
		DoubleLinkedList dll = new DoubleLinkedList();
		assertTrue(dll.repOK());
		dll.header = null;
		assertFalse(dll.repOK());
		
		dll = new DoubleLinkedList(getList(2));
		assertEquals(dll.header.next.element, dll.header.previous.previous.element);
		assertTrue(dll.repOK());

		dll.header.next.next = null;
		assertFalse(dll.repOK());
		
		dll = new DoubleLinkedList(getList(2));
		dll.header.next.previous = null;
		assertFalse(dll.repOK());
		

		dll = new DoubleLinkedList(getList(2));
		dll.header.previous = dll.header.next;
		dll.header.next.next = dll.header;
		assertFalse(dll.repOK());
	}
}
