import static org.junit.Assert.*;

import org.junit.Test;
public class TestYear {
//	@Test
//	public void testIsValid(){
//		Year year=new Year(2016);
//		assertEquals(true,year.isValid());
//	}
	
	@Test
	public void testIncrement(){
		Year year=new Year(-1);
		assertEquals(true,year.increment());
		year=new Year(1);
		assertEquals(true,year.increment());
	}
	
	@Test
	public void testIsLeap(){
		Year year1=new Year(2008);
		Year year2=new Year(-2009);
		Year year3=new Year(1900);
		assertTrue(year1.isLeap());
		assertTrue(year2.isLeap());
		assertFalse(year3.isLeap());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetYearIllegal(){
		Year year=new Year(0);
	}
	
	@Test
	public void testEquals(){
		Year year1=new Year(2000);
		Year year2=new Year(2000);
		Year year3=new Year(1994);
		assertEquals(year1,year2);
		assertFalse(year1.equals(year3));
		assertFalse(year1.equals(new Object()));
	}
	
//	@Test
//	public void testGetYear(){
//		Year year=new Year(1994);
//		assertEquals(1994,year.getYear());
//	}
}
