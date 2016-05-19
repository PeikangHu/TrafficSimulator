package finalProject.trafficSimulator.road.intersection.light;

class YellowLightState extends LightStateAbstractObj
{
	YellowLightState(double greenDuration, double yellowDuration, double redDuration) {
		super(greenDuration, yellowDuration, redDuration);

	}

	public LightState turnColor() 
	{
		return new RedLightState(_greenDuration, _yellowDuration, _redDuration);
	}
	
	public double getDuration() 
	{	
		return _yellowDuration;
	}

	public LightStateEnum getLightStateEnum() {
		return LightStateEnum.Yellow;
	}
}
