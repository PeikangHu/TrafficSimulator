package finalProject.trafficSimulator.road.intersection.light;

import java.util.EventObject;

public class LightColorTurnEventObject extends EventObject  
{
	private static final long serialVersionUID = 6766017786696468377L;
	
	private LightStateEnum _lightStateEnum;
	
	public LightColorTurnEventObject(LightStateEnum _lightStateEnum) {
		super(_lightStateEnum);
		this._lightStateEnum = _lightStateEnum;
	}

	public LightStateEnum getLightStateEnum() {
		return _lightStateEnum;
	}

}
