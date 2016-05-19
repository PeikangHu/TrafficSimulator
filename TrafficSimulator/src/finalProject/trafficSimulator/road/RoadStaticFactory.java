package finalProject.trafficSimulator.road;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.intersection.Intersection;

public class RoadStaticFactory 
{
	private static Road[] _roadsNorthSouth;
	private static Road[] _roadsEastWest;
	
	public static Collection<Road> getNorthSouthRoads()
	{
		if (_roadsNorthSouth == null || _roadsNorthSouth.length == 0)
		{
			throw new IllegalArgumentException();
		}
		return Collections.unmodifiableCollection(Arrays.asList(_roadsNorthSouth));
	}
	
	public static Collection<Road> getEastWestRoads()
	{
		if (_roadsEastWest == null || _roadsEastWest.length == 0)
		{
			throw new IllegalArgumentException();
		}
		return Collections.unmodifiableCollection(Arrays.asList(_roadsEastWest));
	}
	
	public static void initGridRoads(Intersection intersectionsEastWest[][], Intersection intersectionsNorthSouth[ ][ ])
	{
		int roadHorizontalNumber = intersectionsEastWest.length;
		int roadVerticalNumber = intersectionsEastWest[0].length;

		Road roadsNorthSouth[] = new Road[roadVerticalNumber];
		Road roadsEastWest[] = new Road[roadHorizontalNumber];
		
		_roadsNorthSouth = roadsNorthSouth;
		_roadsEastWest = roadsEastWest;
		
		Intersection[][] turnedIntersectionsNorthSouth = turnIntersections(intersectionsNorthSouth);

		for (int j = 0; j < roadVerticalNumber; j++)
		{
			RoadBuilder northSouthRoadBuilder = newRandomRoadWithoutIntersection(roadHorizontalNumber);
			for (int i = 0; i < roadHorizontalNumber; i++)
			{
				northSouthRoadBuilder.setIntersection(i, turnedIntersectionsNorthSouth[j][i]);
				northSouthRoadBuilder.setSegmentLength(i + 1, northSouthRoadBuilder.getSegmentsLength()[i+1] + turnedIntersectionsNorthSouth[j][i].getLength());
				
				northSouthRoadBuilder.setRoadType(RoadType.Vertical);
			}
			roadsNorthSouth[j] = northSouthRoadBuilder.toRoad();
		}

		
		for (int i = 0; i < roadHorizontalNumber; i++)
		{
			RoadBuilder eastWestRoadBuilder = newRandomRoadWithoutIntersection(roadVerticalNumber);
			for (int j = 0; j < roadVerticalNumber; j++)
			{
				eastWestRoadBuilder.setIntersection(j, intersectionsEastWest[i][j]);
				eastWestRoadBuilder.setSegmentLength(j + 1, eastWestRoadBuilder.getSegmentsLength()[j+1] + intersectionsEastWest[i][j].getLength());
				
				eastWestRoadBuilder.setRoadType(RoadType.Horizontal);
			}
			roadsEastWest[i] = eastWestRoadBuilder.toRoad();
		}
	}
	
	private static Intersection[][] turnIntersections(Intersection[][] intersections)
	{
		Intersection[][] turnedIntersections=new Intersection[intersections[0].length][intersections.length];
	    for(int i=0;i<intersections.length;   i++)
	    for(int j=0;j<intersections[0].length;j++)
	    	turnedIntersections[j][i] = intersections[i][j];
	    return turnedIntersections;
	}
	
	private static RoadBuilder newRandomRoadWithoutIntersection(int intersectionNumber)
	{
		RoadBuilder roadRuilder = new RoadBuilder(intersectionNumber);
		
		double[] roadSegmentsLength = new double[intersectionNumber + 1];
		
		for(int i = 0; i < intersectionNumber + 1; i++)
		{
			roadSegmentsLength[i] = ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.ROAD_LENGTH_MIN, TrafficSimulatorParameters.ROAD_LENGTH_MAX);
		}
		
		roadRuilder.setSegmentsLength(roadSegmentsLength);
		return roadRuilder;
	}
}
