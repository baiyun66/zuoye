import static org.junit.Assert.*;

import javax.security.auth.login.FailedLoginException;

import org.junit.Before;
import org.junit.Test;


public class TestNextDay {
	Nextday nextday;
	
	@Before
	public void setUp(){
		nextday=new Nextday();
	}
	
	@Test
	public void testYear() {
		Year year;
		try{
			year=new Year(0);
			fail("There should be an exceptiion");
		}
		catch(Exception expected){
			assertTrue(true);
		}
		
		year =new Year(2000);
		assertEquals(2000,year.getYear());
		
	
		//isLeap
		assertEquals(true, year.isLeap());
		year=new Year(-1997);
		assertTrue(year.isLeap());
		year=new Year(1995);
		assertFalse(year.isLeap());
		
		//increment
		year.currentPos=-1;
		year.increment();
		assertEquals(1,year.getYear());
		year.increment();
		assertEquals(2, year.getYear());
		
		//equals
		Month month=new Month(1,year);
		assertFalse(year.equals(month));
		Year year2=new Year(2);
		assertTrue(year.equals(year2));
		year2=new Year(-1996);
		assertFalse(year.equals(year2));
		
	}
	
	@Test
	public void testMonth(){
		Month month;
		Year year=null;
		try{
			month=new Month(1, year);
			fail("There should be an exception");
		}
		catch(Exception e){
			assertTrue(true);
		}
		year=new Year(1);
		try{
			month=new Month(0, year);
			fail("There should be an exception");
		}
		catch(Exception e){
			assertTrue(true);
		}
		
		month=new Month(2,year);
		year=new Year(1996);
		Month month2=new Month(2, year);
		assertFalse(month.equals(month2));
		
		//monthsize
		assertEquals(28,month.getMonthSize());
		assertEquals(29,month2.getMonthSize());
		
		//increment
		month=new Month(12,year);
		assertFalse(month.increment());
		
		month=new Month(1,year);
		assertEquals(true,month.increment());
		
		//equals
		assertFalse(month.equals(year));
		month2=new Month(2,year);
		assertTrue(month.equals(month2));
	}
	
	@Test
	public void testDay(){
		Year year;
		Month month;
		Day day;
		
		//setDay
		year=new Year(1996);
		month=new Month(2, year);
		try{
			day=new Day(30,month);
			fail("There should be an exception");
		}
		catch(Exception e){
			assertTrue(true);
		}
		month=null;
		try{
			day=new Day(30,month);
			fail("There should be an exception");
		}
		catch(Exception e){
			assertTrue(true);
		}
		month=new Month(2, year);
		day=new Day(29,month);
		assertTrue(day.isValid());
		
		//increment
		assertFalse(day.increment());
		day=new Day(27, month);
		assertTrue(day.increment());
		
		//equals
		assertFalse(day.equals(month));
		Day day2=new Day(27,month);
		assertFalse(day.equals(day2));
		day2.increment();
		assertTrue(day.equals(day2));
		
	}
	
	@Test
	public void testDate(){
		Date date,date2;
		
		//increment
		date=new Date(1, 1, 1999);
		date2=new Date(1, 2, 1999);
		
		date.increment();
		assertEquals(date, date2);
		
		date=new Date(2, 29, 1996);
		date2=new Date(3, 1, 1996);
		date.increment();
		assertEquals(date, date2);
		
		date=new Date(12, 31, 1996);
		date2=new Date(1,1, 1997);
		date.increment();
		assertEquals(date, date2);
		
		//euqals
		assertTrue(date.equals(date2));
		assertFalse(date.equals(date2.getDay()));
		date2.increment();
		assertFalse(date.equals(date2));
	}
		
}
