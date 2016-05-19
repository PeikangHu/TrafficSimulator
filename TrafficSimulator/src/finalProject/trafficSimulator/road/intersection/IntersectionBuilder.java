package finalProject.trafficSimulator.road.intersection;

final class IntersectionBuilder 
{
	private double _length;
	private double _greenDuration;
	private double _yellowDuration;

	void setLength(double length) 
	{
		if	(length <= 0)
		{
			throw new IllegalArgumentException();
		}
		this._length = length;
	}
	
	void setGreenDuration(double greenDuration) 
	{
		if	(greenDuration <= 0)
		{
			throw new IllegalArgumentException();
		}
		this._greenDuration = greenDuration;
	}

	void setYellowDuration(double yellowDuration) 
	{
		if	(yellowDuration <= 0)
		{
			throw new IllegalArgumentException();
		}
		this._yellowDuration = yellowDuration;
	}
	
	Intersection toIntersection()
	{
		return new IntersectionObj(_length,  _greenDuration, _yellowDuration);
	}
}
