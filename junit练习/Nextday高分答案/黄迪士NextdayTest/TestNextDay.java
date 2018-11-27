import static org.junit.Assert.*;

import org.junit.Test;


public class TestNextDay {

	@Test
	public void testNextDay() {
		Date date=new Date(6,15,2016);
		Date date1=new Date(6,16,2016);
		assertEquals(date1,Nextday.nextDay(date));
	}

}
