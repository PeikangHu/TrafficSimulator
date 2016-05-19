package finalProject.trafficSimulator.road.obstacle;

import java.util.Vector;

public abstract class ObstacleAbstractObj implements Obstacle
{
	protected Vector<PositionChangeListener> vectorObstacleListeners=new Vector<PositionChangeListener>();
	protected int _positionIndex;
	protected double _position;
	protected double _length;
	
	protected ObstacleAbstractObj(double length)
	{
		_position = 0;
		_length = length;
	}
	
	@Override
	public double getLength() {
		return _length;
	}
	
	@Override
	public double getPosition() {
		return _position;
	}
	
	public int getPositionIndex()
	{
		return _positionIndex;
	}
	
	@Override
	public void setPositionIndex(int index) {
		_positionIndex = index;
	}
	
	@Override
	public void addObstacleListener(PositionChangeListener eventListener) {
		if	(eventListener == null)
		{
			throw new IllegalArgumentException();
		}
		vectorObstacleListeners.addElement(eventListener);
		
	}

	@Override
	public void removeObstacleListener(PositionChangeListener eventListener) {
		if (!vectorObstacleListeners.contains(eventListener))
		{
			throw new IllegalArgumentException();
		}
		vectorObstacleListeners.removeElement(eventListener);
		
	}

	@Override
	public void notifyObstacleListeners() {
		for(int i=0;i<vectorObstacleListeners.size();i++)
        {
			PositionChangeListener positionChangeListener = vectorObstacleListeners.elementAt(i);
			PositionChangeEventObject positionChangeEventObject = new PositionChangeEventObject(_position, _positionIndex, this);			
			positionChangeListener.positionChangeExecute(positionChangeEventObject);
        }
	}
}
