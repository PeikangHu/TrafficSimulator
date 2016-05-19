package finalProject.trafficSimulator.road;

import java.util.Collection;

import finalProject.trafficSimulator.road.intersection.Intersection;
import finalProject.trafficSimulator.road.obstacle.Obstacle;
import finalProject.trafficSimulator.road.obstacle.PositionChangeListener;

public interface Road extends PositionChangeListener
{
	public double[] getSegmentsLength();
	public RoadType getRoadType();
	
	public Collection<Intersection> getIntersections();
	
	public void addNewObstacle(Obstacle obstacle);
}
