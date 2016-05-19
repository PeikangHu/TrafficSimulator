package finalProject.trafficSimulator.road.intersection.light;

import java.util.EventListener;

public interface LightColorTurnListener extends EventListener
{
	public void lightEventExecute(LightColorTurnEventObject event);
}
