package finalProject.trafficSimulator.road.obstacle;

import finalProject.agent.World;


class CarObj extends ObstacleAbstractObj
{
	private double _maxVelocity;
	private double _brakeDistance;
	private double _stopDistance;

	private double _distanceToObstacle;
	
	private int _timeStep;
	

	CarObj(double carLength, double maxVelocity, double brakeDistance, double stopDistance)
	{
		super(carLength);
		_timeStep = 1;
		
		_maxVelocity = maxVelocity;
		_brakeDistance = brakeDistance;
		_stopDistance = stopDistance;
	}
	
	@Override
	public void run() 
	{
		notifyObstacleListeners();
		
		
		double velocity = 0.0;
		
		if(_distanceToObstacle >= 0)
		{
			velocity = _maxVelocity / (_brakeDistance - _stopDistance)
	                * (_distanceToObstacle  - _stopDistance);			
			velocity = Math.max(0.0, velocity);
			velocity = Math.min(_maxVelocity, velocity);
			
			velocity = Math.min(_distanceToObstacle - 1, velocity);
		}
		else
		{
			velocity = _maxVelocity;
		}
		
		_position += velocity * _timeStep;
		
		World w = World.instance;
		w.time().enqueue(_timeStep + w.time().currentTime(), this);
	}
	



	@Override
	public boolean canStop() {
		return true;
	}

	@Override
	public boolean canBrake() {
		return true;
	}

	@Override
	public void setDistanceToObstacle(double distance) {
		_distanceToObstacle = distance;	
	}
	
	public boolean equals(Object thatObject) {
		  if (thatObject == this)
			  return true;
		  if (!(thatObject instanceof CarObj))
			  return false;
		  CarObj vo = (CarObj)thatObject;
		  return 
			  vo._maxVelocity == this._maxVelocity &&
			  vo._brakeDistance == this._brakeDistance &&
			  vo._stopDistance == this._stopDistance &&
			  vo._position == this._position &&
			  vo._distanceToObstacle == this._distanceToObstacle &&
			  vo._timeStep == this._timeStep &&
			  vo._length == this._length;
	  }
	
	  public int hashCode() 
	  {
		  int result = 17;
		  result = 37*result + (int)_maxVelocity;
		  result = 37*result + (int)_brakeDistance;
		  result = 37*result + (int)_stopDistance;
		  result = 37*result + (int)_position;
		  result = 37*result + (int)_distanceToObstacle;
		  result = 37*result + _timeStep;
		  result = 37*result + (int)_length;

		  return result;
	  }
	  
		@Override
		public int compareTo(Obstacle obstacle) 
		{
			if (this.getPosition() < obstacle.getPosition())
			{
				return -1;
			}
			else if (this.getPosition() > obstacle.getPosition())
			{
				return 1;
			}

			return 0;
		}


	

	@Override
	public double getBrakeDistance() {
		return _brakeDistance;
	}
}
