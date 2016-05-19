package finalProject.trafficSimulator.road.intersection;

import java.util.concurrent.ThreadLocalRandom;

import finalProject.agent.Agent;
import finalProject.agent.World;
import finalProject.trafficSimulator.TrafficSimulatorParameters;

public class IntersectionStaticFactory 
{
	private IntersectionStaticFactory() {}
	
	static public Intersection newIntersection(double length, double greenDuration, double yellowDuration)
	{
		IntersectionBuilder intersectionBuilder = new IntersectionBuilder();
		intersectionBuilder.setGreenDuration(greenDuration);
		intersectionBuilder.setYellowDuration(yellowDuration);
		intersectionBuilder.setLength(length);
		return intersectionBuilder.toIntersection();
	}
	
	static public void FillOutGridRoadsIntersectionPairs(Intersection emptyIntersectionsEastWest[ ][ ], Intersection emptyIntersectionsNorthSouth[ ][ ] )
	{
		if (emptyIntersectionsNorthSouth == null || emptyIntersectionsEastWest == null)
		{
			throw new IllegalArgumentException();
		}
		
		if (emptyIntersectionsNorthSouth.length !=  emptyIntersectionsEastWest.length)
		{
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < emptyIntersectionsNorthSouth.length; i++)
		{
			for (int j = 0; j < emptyIntersectionsNorthSouth[i].length; j++)
			{
				if (emptyIntersectionsNorthSouth[i].length !=  emptyIntersectionsEastWest[i].length)
				{
					throw new IllegalArgumentException();
				}
				
				emptyIntersectionsNorthSouth[i][j] = IntersectionStaticFactory.newNorthSouthIntersection();
				emptyIntersectionsEastWest[i][j] = IntersectionStaticFactory.newEastWestIntersection(emptyIntersectionsNorthSouth[i][j]);
			}
		}
	}
	
	static private Intersection newNorthSouthIntersection()
	{
		World w = World.instance;
		Intersection tempIntersection = IntersectionStaticFactory.newRandomIntersection();
		Agent tempIntersectionAgent = tempIntersection;
		w.time().enqueue(0,tempIntersectionAgent);
		return tempIntersection;
	}
	
	static private Intersection newEastWestIntersection(Intersection northSouthIntersection)
	{
		Intersection tempIntersection = IntersectionStaticFactory.newRandomIntersection();
		northSouthIntersection.addLightColorTurnListener(tempIntersection);
		tempIntersection.addLightColorTurnListener(northSouthIntersection);
		return tempIntersection;
	}
	
	static public Intersection newRandomIntersection()
	{
		double length = ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.INTERSECTION_LENGTH_MIN, TrafficSimulatorParameters.INTERSECTION_LENGTH_MAX);
		double greenDuration = ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.INTERSECTION_GREEN_DURATION_MIN, TrafficSimulatorParameters.INTERSECTION_GREEN_DURATION_MAX);
		double yellowDuration = ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.INTERSECTION_YELLOW_DURATION_MIN, TrafficSimulatorParameters.INTERSECTION_YELLOW_DURATION_MAX);
		
		return newIntersection(length, greenDuration, yellowDuration);
	}
	
}
