package finalProject.trafficSimulator.road.intersection.light;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightStaticFactoryTest {

	@Test
	public void testNewGreenLightState() 
	{
		LightState _lightState = LightStaticFactory.newGreenLightState(200.0, 300.0, 5000.0);
		assertTrue(_lightState.getDuration() == 200.0);
		
		LightState _lightState1 = LightStaticFactory.newGreenLightState(200.11, 300.0, 5000.0);
		assertTrue(_lightState1.getDuration() == 200.11);
		
		

	}
	
	@Test
	public void testConstructor()
	{
		try { LightStaticFactory.newGreenLightState(0.0, 300.0, 5000.0);fail(); } catch ( IllegalArgumentException e ) {}
		try { LightStaticFactory.newGreenLightState(1.0, 0.0, 5000.0);fail(); } catch ( IllegalArgumentException e ) {}
		try { LightStaticFactory.newGreenLightState(1.0, 1.0, 0.0);fail(); } catch ( IllegalArgumentException e ) {}
	}

	@Test
	public void testNewRedLightState() {
		LightState _lightState = LightStaticFactory.newRedLightState(200.0, 300.0, 5000.0);
		assertTrue(_lightState.getDuration() == 5000.0);
	}

	@Test
	public void testNewYellowLightState() {
		LightState _lightState = LightStaticFactory.newYellowLightState(200.0, 300.0, 5000.0);
		assertTrue(_lightState.getDuration() == 300.0);
	}

}
