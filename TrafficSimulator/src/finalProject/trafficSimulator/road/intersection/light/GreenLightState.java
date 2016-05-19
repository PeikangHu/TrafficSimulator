package finalProject.trafficSimulator.road.intersection.light;

class GreenLightState extends LightStateAbstractObj
{
	GreenLightState(double greenDuration, double yellowDuration, double redDuration) {
		super(greenDuration, yellowDuration, redDuration);
	}

	public LightState turnColor()
	{
		return new YellowLightState(_greenDuration, _yellowDuration, _redDuration);
	}

	public LightStateEnum getLightStateEnum() {
		return LightStateEnum.Green;
	}

	public double getDuration() {
		return _greenDuration;
	}
}
