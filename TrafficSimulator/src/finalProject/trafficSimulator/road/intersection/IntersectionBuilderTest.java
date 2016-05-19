package finalProject.trafficSimulator.road.intersection;

import static org.junit.Assert.*;

import org.junit.Test;


public class IntersectionBuilderTest {

	@Test
	public void testSetLength() {
		IntersectionBuilder intersectionBuilder = new IntersectionBuilder();
		try { intersectionBuilder.setLength(0); fail(); } catch ( IllegalArgumentException e ) {}
		intersectionBuilder.setLength(10.0);
	}

	@Test
	public void testSetGreenDuration() {
		IntersectionBuilder intersectionBuilder = new IntersectionBuilder();
		try { intersectionBuilder.setGreenDuration(0); fail(); } catch ( IllegalArgumentException e ) {}
		intersectionBuilder.setGreenDuration(10.0);
	}

	@Test
	public void testSetYellowDuration() {
		IntersectionBuilder intersectionBuilder = new IntersectionBuilder();
		try { intersectionBuilder.setYellowDuration(0); fail(); } catch ( IllegalArgumentException e ) {}
		intersectionBuilder.setYellowDuration(10.0);
	}

	@Test
	public void testToIntersection() {
		IntersectionBuilder intersectionBuilder = new IntersectionBuilder();
		intersectionBuilder.setLength(10.0);
		intersectionBuilder.setYellowDuration(15.0);
		intersectionBuilder.setGreenDuration(11.0);
		Intersection intersection = intersectionBuilder.toIntersection();
		
		assertTrue(10.0 == intersection.getLength());
		assertTrue(11.0 == intersection.getGreenDuration());
		assertTrue(15.0 == intersection.getYellowDuration());
	}

}
