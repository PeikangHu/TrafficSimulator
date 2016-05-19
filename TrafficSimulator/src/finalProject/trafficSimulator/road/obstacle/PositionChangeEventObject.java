package finalProject.trafficSimulator.road.obstacle;

import java.util.EventObject;

public class PositionChangeEventObject extends EventObject
{
	private static final long serialVersionUID = 3659677302709246967L;
	
	private double _currentPosition;
	private Obstacle _currentObstacle;
	private int _currentPositionIndex;
	
	public PositionChangeEventObject(double currentPosition, int currentPositionIndex, Obstacle obstacle) {
		super(currentPosition);
		this._currentPosition = currentPosition;
		this._currentPositionIndex = currentPositionIndex;
		this._currentObstacle = obstacle;
	}
	
	public double getPosition()
	{
		return _currentPosition;
	}
	
	public int getPosistionIndex()
	{
		return _currentPositionIndex;
	}
	
	public Obstacle getObstacle()
	{
		return _currentObstacle;
	}
}
