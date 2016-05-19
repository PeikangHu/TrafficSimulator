package finalProject.trafficSimulator.road.intersection.light;

abstract class LightStateAbstractObj implements LightState
{
	protected double _greenDuration;
	protected double _yellowDuration;
	protected double _redDuration;
	LightStateAbstractObj(double greenDuration, double yellowDuration, double redDuration)
	{
		if	(greenDuration <= 0 || yellowDuration <= 0 || redDuration <= 0)
		{
			throw new IllegalArgumentException();
		}
		_greenDuration = greenDuration;
		_yellowDuration = yellowDuration;
		_redDuration = redDuration;
	}
}
