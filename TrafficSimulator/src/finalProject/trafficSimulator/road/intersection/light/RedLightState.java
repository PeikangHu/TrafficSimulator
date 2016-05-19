package finalProject.trafficSimulator.road.intersection.light;

class RedLightState extends LightStateAbstractObj
{
	RedLightState(double greenDuration, double yellowDuration, double redDuration) {
		super(greenDuration, yellowDuration, redDuration);
	}

	public LightState turnColor() 
	{
		return new GreenLightState(_greenDuration, _yellowDuration, _redDuration);
	}

	public LightStateEnum getLightStateEnum() {
		return LightStateEnum.Red;
	}

	public double getDuration() {
		return _redDuration;
	}
}
