package finalProject.trafficSimulator.road;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.intersection.Intersection;
import finalProject.trafficSimulator.road.obstacle.Obstacle;
import finalProject.trafficSimulator.road.obstacle.PositionChangeEventObject;


class RoadObj implements Road
{
	private Intersection[] _intersections;

	private double[] _segmentLengths;
	private double[] _segmentPositions;
	private RoadType _roadType;
	private  TreeSet<Obstacle> _obstacles;
	
	RoadObj(double[] segmentsLength, RoadType roadType, Intersection[] intersections)
	{
		if (segmentsLength == null || segmentsLength.length < 1)
		{
			throw new IllegalArgumentException();
		}
		
		for(double item: segmentsLength)
		{
			if (TrafficSimulatorParameters.ROAD_LENGTH_MIN > item && item > TrafficSimulatorParameters.ROAD_LENGTH_MAX )
			{
				throw new IllegalArgumentException();
			}
		}
		
		if (roadType == null)
		{
			throw  new IllegalArgumentException();
		}
		
		if (intersections == null || (intersections.length + 1) != segmentsLength.length)
		{
			throw new IllegalArgumentException();
		}
		
		_intersections = intersections;
		_segmentLengths = segmentsLength;
		_roadType = roadType;
		
		_segmentPositions = new double[_segmentLengths.length + 1];
		_segmentPositions[0] = 0.0;
		double tempSegementLength = 0;
		
		for (int i = 1; i < _segmentLengths.length + 1; i++)
		{
			tempSegementLength += _segmentLengths[i - 1];
			_segmentPositions[i] = tempSegementLength;
		}
		
		_obstacles = new TreeSet<Obstacle>();
		
		for(int i = 1; i < _segmentPositions.length - 1; i++)
		{
			_intersections[i-1].setPosition(_segmentPositions[i] - _intersections[i-1].getLength() / 2);
			_intersections[i-1].setPositionIndex(i-1);
		}
		
		for(Intersection item:_intersections)
		{
			this.addNewObstacle(item);
		}
	}
	
	void setIntersection(int index, Intersection intersection)
	{
		_intersections[index] = intersection;
	}
	

	public double[] getSegmentsLength() {
		return _segmentLengths;
	}
	

	public Collection<Intersection> getIntersections() {
		return Collections.unmodifiableCollection(Arrays.asList(_intersections));
	}

	public RoadType getRoadType() {
		return _roadType;
	}
	
	public void addNewObstacle(Obstacle obstacle)
	{
		_obstacles.add(obstacle);
	}
	
	private void removeObstacle(Obstacle obstacle)
	{
		_obstacles.remove(obstacle);
	}

	@Override
	public void positionChangeExecute(PositionChangeEventObject positionChangeEventObject) 
	{
		 TreeSet<Obstacle> newObstacles = new TreeSet<Obstacle>();
		 for(Obstacle item:_obstacles)
		 {
			 newObstacles.add(item);
		 }
		
		Obstacle currentObstacle = positionChangeEventObject.getObstacle();
		setObstaclePositionIndex(currentObstacle);
		
		if (currentObstacle.getPositionIndex() == -1)
		{
			currentObstacle.removeObstacleListener(this);
			this.removeObstacle(currentObstacle);
		}
		else
		{
			Obstacle previousObstacle = newObstacles.higher(currentObstacle);
			
			while (previousObstacle != null && !previousObstacle.canStop() )
			{
				previousObstacle = newObstacles.higher(previousObstacle);	
			}
			
			
			if (previousObstacle != null && previousObstacle.canStop())
			{
				double tempDistanceToObstacle = 0.0;
				tempDistanceToObstacle= previousObstacle.getPosition() - currentObstacle.getPosition() - previousObstacle.getLength();
				
				currentObstacle.setDistanceToObstacle(tempDistanceToObstacle);
			}
			else
			{
				currentObstacle.setDistanceToObstacle(-1);
			}
 		}
	}
	
	private void setObstaclePositionIndex(Obstacle obstacle)
	{
		obstacle.setPositionIndex(-1);
	
		for (int i = 0; i < _segmentPositions.length - 1; i++)
		{
			if (_segmentPositions[i] <= obstacle.getPosition() &&  obstacle.getPosition() <= _segmentPositions[i+1])
			{
				obstacle.setPositionIndex(i);
			}
		}
	}
}
