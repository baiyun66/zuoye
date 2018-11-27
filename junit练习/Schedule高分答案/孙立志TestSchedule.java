import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.mooctest.plugin.util.plugin.WorkspaceUtil;

import org.junit.Before;
import org.junit.Test;


public class TestSchedule {
	Work []works=null;
	public Schedule schedule=new Schedule();
	@Test
	public void testFCFS() {
		works=new Work[3];
		for(int i=0;i<3;i++)
			works[i]=new Work(i+"",0,3-i);
		
		List<Work> ins = new ArrayList<Work>();
		for(int i=0;i<3;i++)
			ins.add(works[i]);
		
		List<Double> lst = new ArrayList<Double>();
		double avgCircleTime = 0;
		double avgCircleTimeWP = 0;
		
		avgCircleTime=14/3.0;
		avgCircleTimeWP=9.5/3;
		lst.add(avgCircleTime);
		lst.add(avgCircleTimeWP);
		assertEquals(schedule.FCFS(ins),lst);
	}
	
	@Test
	public void testSJC(){
		List<Work> ins1 = new ArrayList<Work>();
		List<Work> ins2 = new ArrayList<Work>();
		Work works2[]=new Work[10];
		works=new Work[10];
		
		for(int i=0;i<5;i++){
			works[i]=new Work(i+"",1, 6-i);
			
			works2[i]=new Work("i", 1, i+2);
		}
		for(int i=5;i<10;i++){
			works[i]=new Work(i+"",i, 22-i);
			works2[i]=new Work("i", 14-i, 8+i);
		}
		
		for(int i=0;i<10;i++){
			ins1.add(works[i]);
			ins2.add(works2[i]);
		}
		
		List<Double> lst1 = new ArrayList<Double>();
		List<Double> lst2 = new ArrayList<Double>();
		
		lst1=schedule.FCFS(ins2);
		lst2=schedule.SJF(ins1);
		assertEquals(lst1,lst2);
	}

}
