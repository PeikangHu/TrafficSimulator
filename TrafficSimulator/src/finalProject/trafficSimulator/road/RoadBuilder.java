package finalProject.trafficSimulator.road;

import finalProject.trafficSimulator.road.intersection.Intersection;

final class RoadBuilder 
{
	private Intersection[] _intersections;
	private double[] _segmentsLength;
	private RoadType _roadType;
	
	RoadBuilder(int intersectionNumber)
	{
		_intersections = new Intersection[intersectionNumber];
	}
	
	void setSegmentLength(int index, double segmentLength)
	{
		_segmentsLength[index] = segmentLength;
	}
	
	double[] getSegmentsLength()
	{
		return _segmentsLength;
	}

	void setSegmentsLength(double[] segementsLength)
	{
		_segmentsLength = segementsLength;
	}
	
	void setRoadType(RoadType roadType)
	{
		_roadType = roadType;
	}
	
	void setIntersection(int index, Intersection intersection)
	{
		_intersections[index] = intersection;
	}
	
	Road toRoad()
	{
		return new RoadObj(_segmentsLength, _roadType, _intersections);
	}

}
