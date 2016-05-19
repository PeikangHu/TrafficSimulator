package finalProject.main;

import finalProject.agent.Agent;
import finalProject.trafficSimulator.TrafficSimulatorParameters;


public class AnimationAgent implements Agent
{

	@Override
	public void run() 
	{
		try 
		{
			Thread.sleep((long) (TrafficSimulatorParameters.SIMULATION_TIME_STEP * 1000));
	    } catch (InterruptedException e) {
	        System.out.println("Main thread interrupted");
	    }
	}
	
}
