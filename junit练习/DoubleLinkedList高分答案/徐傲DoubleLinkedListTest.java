import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Objects;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;





public class DoubleLinkedListTest {

	@Test
	public void testDoubleLinkedListCol(){
		ArrayList b=new ArrayList();
		b.add(1);
		b.add(2);
		DoubleLinkedList a =new DoubleLinkedList(b);	
	}
	@Test
	public void testRepOK() {
		DoubleLinkedList a =new DoubleLinkedList();	
		assertEquals(true,a.repOK());
		a.header=null;
		assertEquals(false,a.repOK());
		DoubleLinkedList b =new DoubleLinkedList();		
		assertEquals(false,a.repOK());
		b.add(1);
		assertEquals(true ,b.repOK());
		b.size=-1;
		assertEquals(false,b.repOK());
		b.size=1;
		b.header.previous=null;
		assertEquals(false,b.repOK());
		DoubleLinkedList c =new DoubleLinkedList();	
		b.header.previous=b.header;
		b.header.next.previous=c.header;
		assertEquals(false,b.repOK());
		}

	@Test
	public void testInList() {
		DoubleLinkedList a =new DoubleLinkedList();	
		assertEquals(true,a.inList(a.header));
		DoubleLinkedList b =new DoubleLinkedList();	
		assertEquals(false,a.inList(b.header));
		a.add(1);
		b.add(1);
		assertEquals(true,a.inList(a.header.next));
		assertEquals(false,a.inList(b.header.next));
	}

	@Test
	
	public void testContains() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		/*assertEquals(false,a.contains(null));
		a.add(null);
		assertEquals(true,a.contains(null));*/
		assertEquals(false,a.contains(6));
		assertEquals(true,a.contains(3));
	}

	@Test
	public void testSize() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		assertEquals(2,a.size());
	}

	@Test
	public void testAddObject() {
		/*DoubleLinkedList a =new DoubleLinkedList();	
		a.header.element=0;
		assertEquals(true,a.add(1));*/
	}

	@Test
	public void testRemoveObject() {
		DoubleLinkedList a =new DoubleLinkedList();
		a.add(1);
		a.add("b");
		a.add(null);
		Objects b=null;
		String c="b";
		assertEquals(true,a.remove(b));
		assertEquals(false,a.remove(b));
		assertEquals(true,a.remove(c));
		assertEquals(false,a.remove(c));
	}
	

	@Test
	public void testAddAllCollection() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.header.element=0;
		ArrayList b=new ArrayList();
		assertEquals(false,a.addAll(b));
		b.add(1);
		b.add(2);
		assertEquals(true,a.addAll(b));
	}

	@Test
	public void testAddAllIntCollection() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.header.element=0;
		//DoubleLinkedList c =new DoubleLinkedList();	
		//c.header.element=0;
		ArrayList b=new ArrayList();
		assertEquals(false,a.addAll(0,b));
		b.add(1);
		b.add(2);
		assertEquals(true,a.addAll(0,b));
		//c.addAll(0,b);
		Object [] d= new Object[3];
		//Object [] e= new Object[3];
		d= a.toArray(d);
		//e= c.toArray(e);
		//assertArrayEquals(d,e);
		assertEquals(true,a.addAll(1,b));
		
		
	}

	@Test
	public void testClear() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		a.add(3);
		a.clear();
		assertEquals(a.header.next,a.header);
		assertEquals(a.header.previous,a.header);
	}

	@Test
	public void testGet() {
		
	}

	@Test
	public void testAddIntObject() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		a.add(1,3);
		assertEquals(3, a.header.next.next.element);
		a.add(3,3);
		assertEquals(3, a.header.next.next.next.next.element);
		
	}

	@Test
	public void testRemoveInt() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		assertEquals(2,a.remove(1));
	}
	
	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void testEntry() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);				
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: " + 4 + ", Size: "
                 + a.size);
		a.entry(4);
		a.entry(-2);
		assertEquals(2,a.entry(1));
	}

	@Test
	public void testIndexOf() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		a.add(2);
		assertEquals(-1,a.indexOf(null));
		a.add(null);
		assertEquals(3,a.indexOf(null));
		assertEquals(-1,a.indexOf(3));
		assertEquals(1,a.indexOf(2));
	}

	@Test
	public void testLastIndexOf() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		a.add(2);
		assertEquals(-1,a.lastIndexOf(null));
		a.add(null);
		a.add(null);
		assertEquals(4,a.lastIndexOf(null));
		assertEquals(-1,a.lastIndexOf(3));
		assertEquals(2,a.lastIndexOf(2));
	}

	@Test
	public void testAddBefore() {
		
	}

	
	@Test(expected=Exception.class)
	public void testRemoveEntry() {
		DoubleLinkedList a =new DoubleLinkedList();
		a.add(1);
		a.add("b");
		a.add(null);
		a.remove(a.header);		
		a.remove("b");
		
		assertEquals(a.get(1),null);
	}

	@Test
	public void testToArray() {
		DoubleLinkedList a =new DoubleLinkedList();	
		a.add(1);
		a.add(2);
		Object[] b =new Object[1];
		b=a.toArray(b);
		DoubleLinkedList c =new DoubleLinkedList();	
		c.add(1);
		c.add(2);
		Object[] d=new Object[2];
		d=c.toArray(d);
		assertArrayEquals(d,b);
		d=new Object[3];
		d=c.toArray(d);
		assertEquals(d[2],null);
	}
	@Test
	public void testNonNullPointers(){
		DoubleLinkedList a =new DoubleLinkedList();	
		assertEquals(true,a.header.nonNullPointers());
		a.header.next=null;
		assertEquals(false,a.header.nonNullPointers());
		a.header.next=a.header;
		a.header.previous=null;
		assertEquals(false,a.header.nonNullPointers());
		a.header.next=null;
		assertEquals(false,a.header.nonNullPointers());
	}
	@Test
	public void testRepOKEntry(){
		DoubleLinkedList a =new DoubleLinkedList();	
		assertEquals(true, a.header.repOK());
		a.header.next.previous=null;
		assertEquals(false, a.header.repOK());
	}

}
