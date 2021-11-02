import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		p1 = new Property ("Mighty Oaks", "Richmond", 4844.00, "Bryce Brown", 1,1,2,2);
		p2 = new Property ("Woodside", "Rockville", 4114, "Jarvis Jones", 5,1,2,2);
		p3 = new Property ("Primrose Cottage", "Dover", 4905, "Will Williams", 8,1,2,2);
		
		m = new ManagementCompany("Bailey", "4444444", 8);
		
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		//student add three properties, with plots, to mgmt co
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		p1=p2=p3=p4=p5=p6=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p4 = new Property ("Moore Relaxing", "Rocketman", 2613, "BillyBob Thorton",2,5,2,2);
		p5 = new Property ("Mystery Shack", "Gravity Falls", 5327, "Candice Johnson",4,5,2,2);
		p6 = new Property ("Too Many Properties", "Overcrowded", 1000, "Noel Withers",6,5,2,2);
		 
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p6),-1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(),4905.0,0);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),13863.0,0);
	}

 }
