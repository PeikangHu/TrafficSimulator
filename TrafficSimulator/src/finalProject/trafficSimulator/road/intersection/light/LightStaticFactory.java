package finalProject.trafficSimulator.road.intersection.light;

public class LightStaticFactory 
{
	private LightStaticFactory() {}
	
	static public LightState newGreenLightState(double greenDuration, double yellowDuration, double redDuration)
	{
		return new GreenLightState(greenDuration, yellowDuration, redDuration);
	}
	
	static public LightState newRedLightState(double greenDuration, double yellowDuration, double redDuration)
	{
		return new RedLightState(greenDuration, yellowDuration, redDuration);
	}
	
	static public LightState newYellowLightState(double greenDuration, double yellowDuration, double redDuration)
	{
		return new YellowLightState(greenDuration, yellowDuration, redDuration);
	}
}
