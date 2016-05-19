package finalProject.trafficSimulator.road.intersection;

import finalProject.agent.Agent;
import finalProject.trafficSimulator.road.intersection.light.LightColorTurnListener;
import finalProject.trafficSimulator.road.intersection.light.LightColorTurnSubject;
import finalProject.trafficSimulator.road.obstacle.Obstacle;

public interface Intersection extends LightColorTurnSubject, Agent, LightColorTurnListener, Obstacle
{
	public double getGreenDuration();
	public double getYellowDuration();
	public double getRedDuration();
	
	public void setPosition(double position);
}
