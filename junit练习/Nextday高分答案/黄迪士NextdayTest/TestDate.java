import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestDate {
	private Date date; 
	
	@Before
	public  void initialize(){
		date=new Date(6,15,2016);
	}

	@Test
	public void testIncrement() {
		date.increment();
		date=new Date(6,30,2016);
		date.increment();
		assertEquals(1,date.getDay().getDay());
		date=new Date(12,31,2016);
		date.increment();
		assertEquals(1,date.getMonth().getMonth());
	}
	
	@Test
	public void testEquals(){
		assertFalse(date.equals(new Object()));
		Date date1=new Date(1,2,2016);
		assertFalse(date.equals(date1));
		Date date2=new Date(6,15,2016);
		assertEquals(date,date2);
	}
	
	@Test
	public void testToString(){
		String str="6/15/2016";
		assertEquals(str,date.toString());
	}
}
