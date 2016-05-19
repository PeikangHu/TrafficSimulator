package finalProject.trafficSimulator.road.obstacle;

import java.util.concurrent.ThreadLocalRandom;

import finalProject.trafficSimulator.TrafficSimulatorParameters;

public class CarStaticFactory 
{
	static public Obstacle newRandomCar()
	{
		CarBuilder car = new CarBuilder();
		car.setMaxVelocity(ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.CAR_MAX_VELOCITY_MIN, TrafficSimulatorParameters.CAR_MAX_VELOCITY_MAX));
		car.setBrakeDistance(ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.CAR_BRAKE_DISTANCE_MIN, TrafficSimulatorParameters.CAR_BRAKE_DISTANCE_MAX));
		car.setStopDistance(ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.CAR_STOP_DISTANCE_MIN, TrafficSimulatorParameters.CAR_STOP_DISTANCE_MAX));
		car.setLength(ThreadLocalRandom.current().nextDouble(TrafficSimulatorParameters.CAR_LENGTH_MIN, TrafficSimulatorParameters.CAR_LENGTH_MAX));
		
		return car.toCar();
	}
}
