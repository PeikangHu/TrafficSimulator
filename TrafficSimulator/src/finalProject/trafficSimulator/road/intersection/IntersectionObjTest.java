package finalProject.trafficSimulator.road.intersection;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntersectionObjTest {

	@Test
	public void testIntersectionObj() 
	{
		IntersectionObj intersectionObj = new IntersectionObj(10.0, 13.0, 15.0);
		assertTrue(intersectionObj.getGreenDuration() == 13.0);
		assertTrue(intersectionObj.getYellowDuration() == 15.0);
		assertTrue(intersectionObj.getLength() == 10.0);

	}

	@Test
	public void testRun() {
		//fail("Not yet implemented");
		// TODO: later
	}

	@Test
	public void testAddListener() {
		IntersectionObj intersectionObj1 = new IntersectionObj(10.0, 13.0, 15.0);
		IntersectionObj intersectionObj2 = new IntersectionObj(10.0, 13.0, 15.0);
		intersectionObj1.addLightColorTurnListener(intersectionObj2);
		
		//try { intersectionObj1.addListener(null); fail(); } catch ( IllegalArgumentException e ) {}
	}

	@Test
	public void testRemoveListener() {
		IntersectionObj intersectionObj1 = new IntersectionObj(10.0, 13.0, 15.0);
		IntersectionObj intersectionObj2 = new IntersectionObj(10.0, 13.0, 15.0);
		try {intersectionObj1.removeLightColorTurnListener(intersectionObj2); fail(); } catch ( IllegalArgumentException e ) {}
		intersectionObj1.addLightColorTurnListener(intersectionObj2);
		intersectionObj1.removeLightColorTurnListener(intersectionObj2);
	}

	@Test
	public void testNotifyListeners() {
		// TODO: later
	}

	@Test
	public void testLightEventExecute() {
		// TODO: later
	}

}
