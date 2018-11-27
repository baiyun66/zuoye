import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestTcas {
	@Before
	public void initialize(){
		Tcas.initialize();
	}
	
	@Test
	public void testALIM(){
		Tcas.Alt_Layer_Value=0;
		assertEquals(400,Tcas.ALIM());
	}
	
	@Test
	public void test_Inhibit_Biased_Climb(){
		Tcas.Up_Separation=500;
		Tcas.Climb_Inhibit=1;
		assertEquals(600,Tcas.Inhibit_Biased_Climb());
		Tcas.Climb_Inhibit=0;
		assertEquals(500,Tcas.Inhibit_Biased_Climb());
		
	}
	
	@Test
	public void test_Non_Crossing_Biased_Climb(){
		Tcas.Down_Separation=500;
		Tcas.Up_Separation=500;
		Tcas.Climb_Inhibit=1;
		Tcas.Alt_Layer_Value=0;
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		assertTrue(Tcas.Non_Crossing_Biased_Climb());
		Tcas.Own_Tracked_Alt=100;
		Tcas.Other_Tracked_Alt=200;
		assertFalse(Tcas.Non_Crossing_Biased_Climb());
		Tcas.Down_Separation=700;
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		Tcas.Cur_Vertical_Sep=400;
		assertTrue(Tcas.Non_Crossing_Biased_Climb());
		Tcas.Cur_Vertical_Sep=200;
		assertFalse(Tcas.Non_Crossing_Biased_Climb());
		
	}
	
	@Test
	public void test_Non_Crossing_Biased_Descend(){
		Tcas.Down_Separation=500;
		Tcas.Up_Separation=500;
		Tcas.Climb_Inhibit=1;
		Tcas.Own_Tracked_Alt=100;
		Tcas.Other_Tracked_Alt=200;
		Tcas.Cur_Vertical_Sep=400;
		Tcas.Alt_Layer_Value=0;
		assertTrue(Tcas.Non_Crossing_Biased_Descend());
		Tcas.Cur_Vertical_Sep=200;
		assertFalse(Tcas.Non_Crossing_Biased_Descend());
		Tcas.Down_Separation=700;
		assertTrue(Tcas.Non_Crossing_Biased_Descend());
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		Tcas.Up_Separation=300;
		assertFalse(Tcas.Non_Crossing_Biased_Descend());
		
	}
	
	@Test
	public void test_Own_Below_Threat(){
		Tcas.Own_Tracked_Alt=100;
		Tcas.Other_Tracked_Alt=200;
		assertTrue(Tcas.Own_Below_Threat());
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		assertFalse(Tcas.Own_Below_Threat());
	}
	
	@Test
	public void test_Own_Above_Threat(){
		Tcas.Own_Tracked_Alt=100;
		Tcas.Other_Tracked_Alt=200;
		assertFalse(Tcas.Own_Above_Threat());
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		assertTrue(Tcas.Own_Above_Threat());
	}
	
	@Test
	public void test_Alt_Sep_Test(){
		Tcas.High_Confidence=true;
		Tcas.Own_Tracked_Alt_Rate=500;
		Tcas.Cur_Vertical_Sep=700;
		Tcas.Two_of_Three_Reports_Valid=true;
		Tcas.Other_RAC=0;
		Tcas.Other_Capability=1;
		
		Tcas.Own_Tracked_Alt=100;
		Tcas.Other_Tracked_Alt=200;
		Tcas.Up_Separation=500;
		Tcas.Climb_Inhibit=1;
		Tcas.Alt_Layer_Value=0;
		Tcas.Down_Separation=300;
		
		assertEquals(1,Tcas.alt_sep_test());
		
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		Tcas.Down_Separation=700;
		assertEquals(2,Tcas.alt_sep_test());
		
		Tcas.Own_Tracked_Alt=200;
		Tcas.Other_Tracked_Alt=100;
		Tcas.Down_Separation=700;
		Tcas.Alt_Layer_Value=2;
		assertEquals(0,Tcas.alt_sep_test());
		
		Tcas.High_Confidence=false;
		assertEquals(0,Tcas.alt_sep_test());
		
		Tcas.High_Confidence=true;
		Tcas.Other_Capability=0;
		assertEquals(0,Tcas.alt_sep_test());
		
		Tcas.Other_Capability=1;
		Tcas.Two_of_Three_Reports_Valid=false;
		assertEquals(0,Tcas.alt_sep_test());
			
	}
	
	@Test
	public void testMain(){
		String[]args={"1","2"};
		Tcas.main(args);
		
		String[]args1={"0","700","0","0","200","300","400","500","600","700","800","900","1000"};
		Tcas.main(args1);
		
		String[]args2={"0","700","1","1","200","300","400","500","600","700","800","900","1000"};
		Tcas.main(args2);
	}

}
