import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TestSchedule {
	
	private List<Work> works;
	private Schedule schedule;
	
	
	@Before
	public void initialize(){
		works=new ArrayList<Work>();
		schedule=new Schedule();
	}
	
	

	@Test
	public void testFCFS() {
		Work work1=new Work("work1",1,2);
		Work work2=new Work("work2",3,2);
		Work work3=new Work("work3",5,2);
		works.add(work1);
		works.add(work2);
		works.add(work3);
		List<Double> expect=new ArrayList<Double>();
		expect.add(2.0);
		expect.add(1.0);
		List<Double>result=schedule.FCFS(works);
		assertEquals(expect,result);
	}
	

	@Test
	public void testSJF() {
		Work work1=new Work("work1",1,3);
		Work work2=new Work("work2",3,4);
		Work work3=new Work("work3",4,2);
		works.add(work1);
		works.add(work2);
		works.add(work3);
		List<Double>expect=new ArrayList<Double>();
		expect.add(4.0);
		expect.add(1.25);
		List<Double>result=schedule.SJF(works);
		assertEquals(expect,result);
	}

	@Test
	public void testSortByServiceTime() {
		Work work1=new Work("work1",1,3);
		Work work2=new Work("work2",3,4);
		Work work3=new Work("work3",4,2);
		works.add(work1);
		works.add(work2);
		works.add(work3);
		List<Work>expect=new ArrayList<Work>();
		expect.add(work3);
		expect.add(work1);
		expect.add(work2);
		List<Work> result=schedule.sortByServiceTime(works);
		assertEquals(expect,result);
	}

}
