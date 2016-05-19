package finalProject.trafficSimulator;

public class TrafficSimulatorParameters 
{
	public static double SIMULATION_TIME_STEP = 0.1;
	
	public static int SIMULATION_RUN_TIME = 10000;
	
	public static TrafficPatternEnum TRAFFIC_PATTERN = TrafficPatternEnum.Simple;
	
	public static double CAR_MAX_VELOCITY_MIN = 10.0;
	public static double CAR_MAX_VELOCITY_MAX = 30.0;
	
	public static double CAR_BRAKE_DISTANCE_MIN = 9.0;
	public static double CAR_BRAKE_DISTANCE_MAX = 10.0;

	public static double CAR_STOP_DISTANCE_MIN = 0.5;
	public static double CAR_STOP_DISTANCE_MAX = 5.0;
	
	public static double CAR_GENERATION_DELAY_MIN = 2.0;
	public static double CAR_GENERATION_DELAY_MAX = 25.0;
	
	public static double CAR_LENGTH_MIN = 5.0;
	public static double CAR_LENGTH_MAX = 10.0;
	
	public static double INTERSECTION_GREEN_DURATION_MIN = 30.0;
	public static double INTERSECTION_GREEN_DURATION_MAX = 180.0;

	public static double INTERSECTION_YELLOW_DURATION_MIN = 4.0;
	public static double INTERSECTION_YELLOW_DURATION_MAX = 5.0;
	
	public static double INTERSECTION_LENGTH_MIN = 10.0;
	public static double INTERSECTION_LENGTH_MAX = 15.0;
	
	public static int ROAD_HORIZONTAL_NUMBER = 3;
	public static int ROAD_VERTICAL_NUMBER = 2;
	
	public static double ROAD_LENGTH_MIN = 200.0;
	public static double ROAD_LENGTH_MAX = 500.0;
	
	public static int LIGHT_DIAMETER = 10;
	//public static double LIGHT_LOCAL_X = ROAD_WIDTH - LIGHT_DIAMETER;
	public static int LIGHTS_SAME_DIRECTION_INTERVAL = 20;
	
	public static int WINDOW_WIDTH = 900;
	public static int WINDOW_HEIGHT = 900;
	public static int UI_ROAD_LENGTH = 900;
	public static int UI_ROAD_WIDTH = 50;
	public static int UI_CAR_WIDTH = 15;
}
