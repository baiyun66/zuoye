import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestDay {
	private Year year;
	private Month month;
	
	@Before
	public void initialize(){
		year=new Year(2015);
		month=new Month(6,year);
	}

	@Test
	public void testIncrement() {
		Day day=new Day(15,month);
		Day day1=new Day(30,month);
		assertTrue(day.increment());
		assertFalse(day1.increment());
	}

	@Test
	public void testIsValid() {
		Day day=new Day(15,month);
		assertTrue(day.isValid());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetDayIllegal() {
		Day day=new Day(31,month);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetMonthIllegal() {
		Day day=new Day(30,null);
	}

	
	@Test
	public void testGetDay() {
		Day day=new Day(15,month);
		assertEquals(15,day.getDay());
	}

	@Test
	public void testEqualsObject() {
		Day day1=new Day(15,month);
		Day day2=new Day(15,month);
		Day day3=new Day(20,month);
		assertEquals(day1,day2);
		assertFalse(day1.equals(day3));
		assertFalse(day1.equals(new Object()));
	}

}
