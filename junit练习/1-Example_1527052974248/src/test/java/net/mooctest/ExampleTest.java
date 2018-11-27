package net.mooctest;
import static org.junit.Assert.*;

import org.junit.Test;


public class ExampleTest {
	
	int a = 1;
	int b = 3;
	
	@Test
	public void testFunction_A1() {
		int m = 6;
		int n = 4;
		Example test1 = new Example(a, b);
		assertEquals(5, test1.Function_A(m,n));
	}
	
	@Test
	public void testFunction_A2() {
		int m = 5;
		int n = 4;
		Example test1 = new Example(a, b);
		assertEquals(6, test1.Function_A(m,n));
	}
	
	@Test
	public void testFunction_A3() {
		int m = 6;
		int n = -4;
		Example test1 = new Example(a, b);
		assertEquals(5, test1.Function_A(m,n));
	}
	
	@Test
	public void testFunction_A4() {
		int m = 5;
		int n = -4;
		Example test1 = new Example(a, b);
		assertEquals(4, test1.Function_A(m,n));
	}
	
	
	@Test
	public void testFunction_B1() {
		int m = 5;
		Example test1 = new Example(a, b);
		assertEquals(5, test1.Function_B(m));
	}
	
	@Test
	public void testFunction_B2() {
		int m = 6;
		Example test1 = new Example(a, b);
		assertEquals(2, test1.Function_B(m));
	}

}
