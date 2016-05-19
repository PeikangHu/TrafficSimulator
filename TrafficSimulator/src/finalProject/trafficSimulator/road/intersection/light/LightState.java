package finalProject.trafficSimulator.road.intersection.light;


public interface LightState 
{
	public LightState turnColor();
	public double getDuration();
	public LightStateEnum getLightStateEnum();
}
