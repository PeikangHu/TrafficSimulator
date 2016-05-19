package finalProject.trafficSimulator.road.obstacle;

class CarBuilder 
{
	private double _maxVelocity;
	private double _brakeDistance;
	private double _stopDistance;
	private double _Length;
	
	void setMaxVelocity(double maxVelocity)
	{
		_maxVelocity = maxVelocity;
	}

	void setBrakeDistance(double brakeDistance)
	{
		_brakeDistance = brakeDistance;
	}
	
	void setStopDistance(double stopDistance)
	{
		_stopDistance = stopDistance;
	}
	
	void setLength(double length)
	{
		_Length = length;
	}
	
	CarObj toCar()
	{
		return new CarObj(_Length, _maxVelocity, _brakeDistance, _stopDistance);
	}
}
