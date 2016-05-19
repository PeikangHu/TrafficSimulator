package finalProject.trafficSimulator.road.intersection;

import static org.junit.Assert.*;

import org.junit.Test;

import finalProject.trafficSimulator.TrafficSimulatorParameters;

public class IntersectionStaticFactoryTest {

	@Test
	public void testNewIntersection() {
		Intersection intersectionObj = IntersectionStaticFactory.newIntersection(10.0, 13.0, 15.0);
		assertTrue(intersectionObj.getGreenDuration() == 13.0);
		assertTrue(intersectionObj.getYellowDuration() == 15.0);
		assertTrue(intersectionObj.getLength() == 10.0);
		try { IntersectionStaticFactory.newIntersection(0.0, 13.0, 15.0); fail(); } catch ( IllegalArgumentException e ) {}
		try { IntersectionStaticFactory.newIntersection(1, -1, 15.0); fail(); } catch ( IllegalArgumentException e ) {}
		try { IntersectionStaticFactory.newIntersection(2, 13.0, -1); fail(); } catch ( IllegalArgumentException e ) {}
	}

	@Test
	public void testFillOutGridRoadsIntersectionPairs() {
		Intersection intersectionsEastWest[ ][ ] = new Intersection[1][2];
		Intersection intersectionsNorthSouth[ ][ ] = new Intersection[1][2];
		
		IntersectionStaticFactory.FillOutGridRoadsIntersectionPairs(intersectionsEastWest, intersectionsNorthSouth);
		
		for (int i = 0; i < intersectionsEastWest.length; i++)
		{
			for (int j = 0; j < intersectionsEastWest[i].length; j++)
			{
				if (intersectionsEastWest[i][j] == null)
				{
					fail();
				}
			}
		}
		
		for (int i = 0; i < intersectionsNorthSouth.length; i++)
		{
			for (int j = 0; j < intersectionsNorthSouth[i].length; j++)
			{
				if (intersectionsNorthSouth[i][j] == null)
				{
					fail();
				}
			}
		}
		
	}

	@Test
	public void testNewRandomIntersection() {
		for (int i = 0; i < 1000; i ++)
		{
			Intersection intersectionObj = IntersectionStaticFactory.newRandomIntersection();
			assertTrue(intersectionObj.getGreenDuration() >= TrafficSimulatorParameters.INTERSECTION_GREEN_DURATION_MIN);
			assertTrue(intersectionObj.getGreenDuration() < TrafficSimulatorParameters.INTERSECTION_GREEN_DURATION_MAX);
			assertTrue(intersectionObj.getYellowDuration() >= TrafficSimulatorParameters.INTERSECTION_YELLOW_DURATION_MIN);
			assertTrue(intersectionObj.getYellowDuration() < TrafficSimulatorParameters.INTERSECTION_YELLOW_DURATION_MAX);
			assertTrue(intersectionObj.getLength() >= TrafficSimulatorParameters.INTERSECTION_LENGTH_MIN);
			assertTrue(intersectionObj.getLength() < TrafficSimulatorParameters.INTERSECTION_LENGTH_MAX);
		}
	}

}
