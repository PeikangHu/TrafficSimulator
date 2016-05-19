package finalProject.trafficSimulator.road.intersection.light;


public interface LightColorTurnSubject 
{
	public void addLightColorTurnListener(LightColorTurnListener eventListener);
	public void removeLightColorTurnListener(LightColorTurnListener eventListener);
	public void notifyLightColorTurnListeners();
}
