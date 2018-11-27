/**
 * 
 */
package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NextdayTest {
	// 当前时间（是闰年�?
	Date date1 = new Date(11, 19, 2016);
	Date date11 = new Date(11, 11, 2000);
	Date date21 = new Date(11, 11, -5);
	Date date22 = new Date(11, 11, -15);
	Date date23 = new Date(11, 11, -101);
	// 非闰�?
	Date date2 = new Date(11, 19, 2015);
	// month + 1
	Date date3 = new Date(11, 30, 2016);
	// year + 1
	Date date4 = new Date(12, 31, 2016);
	// 年的特殊情况
	Date date5 = new Date(12, 31, -1);

	@Test
	public void testIncrement() {
		assertEquals(new Date(11, 20, 2016), Nextday.nextDay(date1));
		assertEquals(new Date(11, 20, 2015), Nextday.nextDay(date2));
		assertEquals(new Date(12, 1, 2016), Nextday.nextDay(date3));
		assertEquals(new Date(1, 1, 2017), Nextday.nextDay(date4));
		assertEquals(new Date(1, 1, 1), Nextday.nextDay(date5));

		assertEquals(new Date(11, 12, 2000), Nextday.nextDay(date11));
		assertEquals(new Date(11, 12, -5), Nextday.nextDay(date21));
		assertEquals(new Date(11, 12, -15), Nextday.nextDay(date22));
		assertEquals(new Date(11, 12, -101), Nextday.nextDay(date23));
	}

	@Test
	public void testEquals() {
		Date d = new Date(11, 11, 2011);
		assertEquals(false, d.equals(new int[] { 12, 12, 2012 }));

		assertEquals(false, d.equals(new Date(11, 11, 2012)));
		assertEquals(false, d.equals(new Date(11, 12, 2011)));
		assertEquals(false, d.equals(new Date(12, 11, 2011)));

		Year y = new Year(2011);
		assertEquals(false, y.equals(new int[] { 2011 }));

		Month m = new Month(11, y);
		assertEquals(false, m.equals(new int[] { 11 }));
		assertEquals(false, m.equals(new Month(11, new Year(2012))));

		Day day = new Day(11, m);
		assertEquals(false, day.equals(new int[] { 11 }));
		assertEquals(false, day.equals(new Day(11, new Month(12, y))));
	}

	@Test
	public void testIsValid() {

	}

	// 日期不合�?
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_throws_day() {
		try {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Not a valid day");
			new Date(11, 32, 2015);
		} catch (Exception e) {
		}

		// testIsValid()
		try {
			Day d = new Day(11, null);
			assertEquals(false, d.isValid());
		} catch (Exception e) {
		}

		Day d2 = new Day(0, new Month(11, new Year(2011)));
		assertEquals(false, d2.isValid());
	}

	@Test
	public void test_throws_month() {
		try {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Not a valid month");
			new Date(13, 3, 2015);
		} catch (Exception e) {
		}

		// testIsValid()
		Month m2 = new Month(0, new Year(2011));
		assertEquals(false, m2.isValid());
	}

	@Test
	public void test_throws_year() {
		try {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Not a valid month");
			new Date(11, 11, 0);
		} catch (Exception e) {
		}

		// testIsValid()
		Month m1 = new Month(11, null);
		assertEquals(false, m1.isValid());
	}
}
