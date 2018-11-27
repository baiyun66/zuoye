
import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*; import org.junit.Test;  
public class TcasTest { 
	@Test  
	public void test1() {   
		String[] args = 
			{ "627", "0", "0", "621", "216", "382", "1", "400", "641", "1", "1", "0" };
		Tcas.main(args);  
	}  
	@Test  
	public void test2() { 
		String[] args = 
			{ "hy", "958", "1", "1", "2597", "574", "4253", "0", "399", "400", "0", "0", "1" }; 
		Tcas.main(args); 
	}  
	@Test 
	public void test3() { 
		String[] args =
			{ "hy", "627", "0", "0", "621", "216", "382", "1", "400", "641", "1", "1", "0" };  
		Tcas.main(args);  
		Tcas t = new Tcas();   
		assertEquals(500, Tcas.ALIM());
	}  
	@Test  
	public void test4() { 
		String[] args =
			{ "hy", "627", "0", "0", "621", "216", "382", "1", "400", "641", "1", "1", "0" };   
		Tcas.main(args);  
		assertEquals(400,Tcas.Inhibit_Biased_Climb()); 
	}  
	@Test
	public void test5() {  
		String[] args =
			{ "hy", "627", "0", "0", "621", "216", "382", "1", "400", "641", "1", "1", "0" };
		Tcas.main(args);   
		assertTrue(Tcas.Own_Above_Threat()); 
	}  
	@Test 
	public void test6() { 
		String[] args = 
			{ "hy", "627", "0", "0", "621", "216", "382", "1", "400", "641", "1", "1", "0" };
		Tcas.main(args); 
		assertFalse(Tcas.Own_Below_Threat());
	} 
	@Test 
	public void test7() { 
		String[] args =
			{ "hy", "627", "0", "0", "621", "216", "382", "1", "400", "641", "1", "1", "0" }; 
		Tcas.main(args);  
		assertFalse(Tcas.Non_Crossing_Biased_Climb());
		assertFalse(Tcas.Non_Crossing_Biased_Descend());
	}  
	@Test  
	public void test8() {  
		String[] args =
			{ "hy", "958", "1", "1", "2597", "574", "4253", "0", "399", "400", "0", "0", "1" }; 
		Tcas.main(args); 
		assertTrue(Tcas.Non_Crossing_Biased_Descend()); 
		assertFalse(Tcas.Non_Crossing_Biased_Climb());
	} 
	@Test
	public void test9() { 
		String[] args = 
			{ "hy", "958", "1", "1", "2597", "574", "4253", "0", "398", "399", "0", "0", "1" };   
		Tcas.main(args); 
		assertTrue(Tcas.Non_Crossing_Biased_Climb()); 
		assertFalse(Tcas.Non_Crossing_Biased_Descend()); 
	} 
	@Test 
	public void test10() {
		String[] args =
			{ "hy", "627", "0", "0", "621", "216", "382", "1", "400", "441", "1", "1", "1" }; 
		Tcas.main(args);  
		assertTrue(Tcas.Non_Crossing_Biased_Climb());  
		assertFalse(Tcas.Non_Crossing_Biased_Descend());
	}  
	@Test
	public void test11() { 
		String[] args = 
			{ "hy", "958", "1", "1", "2597", "574", "4253", "0", "399", "400", "0", "0", "0" };  
		Tcas.main(args);  
		assertTrue(Tcas.Non_Crossing_Biased_Descend()); 
		assertFalse(Tcas.Non_Crossing_Biased_Climb());  
	} 
	@Test  
	public void test12() {  
		String[] args = 
			{ "hy", "958", "1", "1", "2597", "574", "4253", "0", "399", "400", "1", "1", "0" }; 
		Tcas.main(args);   
		assertTrue(Tcas.Non_Crossing_Biased_Descend());  
		assertFalse(Tcas.Non_Crossing_Biased_Climb()); 
	}  
	@Test 
	public void test13() {  
		String[] args = 
			{ "hy", "627", "1", "0", "621", "216", "382", "0", "400", "641", "0", "0", "1" };
		Tcas.main(args); 
		assertTrue(Tcas.Non_Crossing_Biased_Descend());  
		assertTrue(Tcas.Non_Crossing_Biased_Climb());
	} 
} 
