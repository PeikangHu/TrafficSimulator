package finalProject.controller;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

import finalProject.agent.Agent;
import finalProject.agent.World;
import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.Road;
import finalProject.trafficSimulator.road.obstacle.CarStaticFactory;
import finalProject.trafficSimulator.road.obstacle.Obstacle;
import finalProject.ui.UICarAbstract;
import finalProject.ui.UICarHorizontal;
import finalProject.ui.UICarVertical;

public class CarController extends Observable implements Agent
{
	private Road _road;
	
	public CarController(Road road)
	{
		_road = road;
	}
	
	@Override
	public void run() 
	{
		Obstacle obstacle = CarStaticFactory.newRandomCar();
		UICarAbstract uiCar = null;
		
		switch (_road.getRoadType())
		{
			case Horizontal: 	uiCar = new UICarHorizontal(obstacle.getLength(), _road.getSegmentsLength(), TrafficSimulatorParameters.UI_ROAD_LENGTH);	break;
			case Vertical:		uiCar = new UICarVertical(obstacle.getLength(), _road.getSegmentsLength(), TrafficSimulatorParameters.UI_ROAD_LENGTH);	break;
		}
		
		obstacle.addObstacleListener(uiCar);
		_road.addNewObstacle(obstacle);
		obstacle.addObstacleListener(_road);
		obstacle.run();
		
		setChanged();
		notifyObservers(uiCar);
		
		double delayTime = ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.CAR_GENERATION_DELAY_MIN, TrafficSimulatorParameters.CAR_GENERATION_DELAY_MAX);
		World w = World.instance;
		w.time().enqueue(delayTime + w.time().currentTime(), this);
	}
}
