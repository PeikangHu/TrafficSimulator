package finalProject.trafficSimulator.road.intersection;


import java.util.Vector;

import finalProject.agent.World;
import finalProject.trafficSimulator.road.intersection.light.LightColorTurnListener;
import finalProject.trafficSimulator.road.intersection.light.LightColorTurnEventObject;
import finalProject.trafficSimulator.road.intersection.light.LightState;
import finalProject.trafficSimulator.road.intersection.light.LightStateEnum;
import finalProject.trafficSimulator.road.intersection.light.LightStaticFactory;
import finalProject.trafficSimulator.road.obstacle.Obstacle;
import finalProject.trafficSimulator.road.obstacle.ObstacleAbstractObj;

class IntersectionObj extends ObstacleAbstractObj implements Intersection
{
	private LightState _lightState;
	
	private Vector<LightColorTurnListener> vectorListeners=new Vector<LightColorTurnListener>();
	
	private double _greenDuration;
	private double _yellowDuration;
	private double _redDuration = 10000.0;
	

	private boolean _canStop;
	private boolean _canBrake;
	
	IntersectionObj(double length, double greenDuration, double yellowDuration)
	{
		super(length);
		_lightState = LightStaticFactory.newGreenLightState(greenDuration, yellowDuration, _redDuration);
		//_lightState = LightStaticFactory.newRedLightState(greenDuration, yellowDuration, _redDuration);

		_canStop = true;
		_canBrake = true;
		
		_greenDuration = greenDuration;
		_yellowDuration = yellowDuration;
	}
	
	public void run()
	{
		_lightState = _lightState.turnColor();		
		
		World w = World.instance;
		w.time().enqueue(_lightState.getDuration()+w.time().currentTime(), this);
		
		
		switch (_lightState.getLightStateEnum())
		{
			case Green:		this._canStop = false;	this._canBrake = false;		break;
			case Red:		this._canStop = true;	this._canBrake = false;		break;
			case Yellow:	this._canStop = true;	this._canBrake = true;		break;
		}
		
		notifyLightColorTurnListeners();
	}
	
	public void lightEventExecute(LightColorTurnEventObject event) 
	{
		if	(event.getLightStateEnum() == LightStateEnum.Red)
		{
			run();
		}
	}
	
	@Override
	public int compareTo(Obstacle obstacle) 
	{
		if (this.getPosition() < obstacle.getPosition())
		{
			return -1;
		}
		else if (this.getPosition() > obstacle.getPosition())
		{
			return 1;
		}

		return 0;
	}
	
	public boolean equals(Object thatObject) {
		  if (thatObject == this)
			  return true;
		  if (!(thatObject instanceof IntersectionObj))
			  return false;
		  IntersectionObj vo = (IntersectionObj)thatObject;
		  return 
			  vo._length == this._length &&
			  vo._greenDuration == this._greenDuration &&
			  vo._yellowDuration == this._yellowDuration &&
			  vo._position == this._position &&
			  vo._redDuration == this._redDuration &&
			  vo._positionIndex == this._positionIndex &&
			  vo._canStop == this._canStop &&
			  vo._canBrake == this._canBrake;
	  }
	
	  public int hashCode() 
	  {
		  int result = 17;
		  result = 37*result + (int)_length;
		  result = 37*result + (int)_greenDuration;
		  result = 37*result + (int)_yellowDuration;
		  result = 37*result + (int)_position;
		  result = 37*result + (int)_redDuration;
		  result = 37*result + _positionIndex;
		  
		  return result;
	  }

	public void addLightColorTurnListener(LightColorTurnListener eventListener)
	{
		if	(eventListener == null)
		{
			throw new IllegalArgumentException();
		}
		vectorListeners.addElement(eventListener);
	}
	
	public void removeLightColorTurnListener(LightColorTurnListener eventListener)
	{
		if (!vectorListeners.contains(eventListener))
		{
			throw new IllegalArgumentException();
		}
		vectorListeners.removeElement(eventListener);
	}
	
	public void notifyLightColorTurnListeners()
	{
		for(int i=0;i<vectorListeners.size();i++)
        {
			LightColorTurnListener lightEventListener = vectorListeners.elementAt(i);
			LightColorTurnEventObject lightEventObject = new LightColorTurnEventObject(_lightState.getLightStateEnum());			
			lightEventListener.lightEventExecute(lightEventObject);
        }
	}

	
	public double getGreenDuration() {
		return _greenDuration;
	}

	public double getYellowDuration() {
		return _yellowDuration;
	}
	
	public double getRedDuration() {
		return _redDuration;
	}

	
	public void setPosition(double position) {
		_position = position;
	}



	@Override
	public boolean canStop() {

		return _canStop;
	}

	@Override
	public boolean canBrake() {

		return _canBrake;
	}

	@Override
	public void setDistanceToObstacle(double distance) {
		
	}




	@Override
	public double getBrakeDistance() {
		return 0;
	}
}
