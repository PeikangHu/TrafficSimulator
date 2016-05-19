package finalProject.trafficSimulator.road.obstacle;

import finalProject.agent.Agent;

public interface Obstacle extends PositionChangeSubject, Agent, Comparable<Obstacle>
{
	public double getLength();
	public double getPosition();
	public int 	  getPositionIndex();
	public double getBrakeDistance();

	public boolean canStop();
	public boolean canBrake();
	
	public void setDistanceToObstacle(double distance);
	public void setPositionIndex(int index);
}
