import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestMonth {
	
	private Year leapYear;
	private Year year;
	
	@Before
	public void initalized(){
		leapYear=new Year(2008);
		year=new Year(2015);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetMonthIllegal(){
		Month month1=new Month(13,year);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetYearIllagal(){
		Month month=new Month(6,null);
	}
	
	@Test
	public void testIncrement() {
		Month month=new Month(6,year);
		Month month1=new Month(12,year);
		assertTrue(month.increment());
		assertFalse(month1.increment());
	}

	@Test
	public void testIsValid() {
		Month month=new Month(6,year);
		assertTrue(month.isValid());	
	}

	@Test
	public void testGetMonth() {
		Month month=new Month(6,year);
		assertEquals(6,month.getCurrentPos());
	}

	@Test
	public void testGetMonthSize() {
		Month month=new Month(2,leapYear);
		Month month1=new Month(2,year);
		assertEquals(29,month.getMonthSize());
		assertEquals(28,month1.getMonthSize());
	}

	@Test
	public void testEqualsObject() {
		Month month=new Month(6,year);
		Month month1=new Month(6,year);
		Month month2=new Month(12,year);
		
		assertEquals(month,month1);
		assertFalse(month.equals(month2));
		assertFalse(month.equals(new Object()));
		
	}

}
