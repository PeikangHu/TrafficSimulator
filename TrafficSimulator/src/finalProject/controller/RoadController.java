package finalProject.controller;

import java.awt.Point;

import javax.swing.JFrame;

import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.Road;
import finalProject.trafficSimulator.road.RoadStaticFactory;
import finalProject.ui.UIIntersection;
import finalProject.ui.UIRoad;

public class RoadController
{	
	private double[] _intersectionPositionXs;
	private double[] _intersectionPositionYs;
	
	private double _horizentalSegementLength;
	private double _verticalSegementLength;
	
	private double _roadLength;
	
	public RoadController(int roadHorizontalNumber, int roadVerticalNumber)
	{
		fillOffIntersectionPositions(roadHorizontalNumber, roadVerticalNumber);
		
		InersectionController intersectionController = new InersectionController(_intersectionPositionXs, _intersectionPositionYs);
		
		RoadStaticFactory.initGridRoads(intersectionController.getEastWestIntersections(), 
										intersectionController.getNorthSouthIntersections());

		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Traffic Simulator");
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);  
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		mainFrame.setSize(TrafficSimulatorParameters.WINDOW_WIDTH, TrafficSimulatorParameters.WINDOW_HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		
		Road[] northSouthRoads = RoadStaticFactory.getNorthSouthRoads().toArray(new Road[0]);
		Road[] eastWestRoads = RoadStaticFactory.getEastWestRoads().toArray(new Road[0]);
		 
		for (int i = 0; i < northSouthRoads.length; i++)
		{
			Point startPoint = 	new Point((int)((i + 1) * _verticalSegementLength),0);
			Point endPoint = 	new Point((int)((i + 1) * _verticalSegementLength), (int)_roadLength);
			createUIRoad(northSouthRoads[i], mainFrame, i, startPoint, endPoint);
		}
		
		for (int i = 0; i < eastWestRoads.length; i++)
		{
			Point startPoint = 	new Point(0, (int)((i + 1) * _horizentalSegementLength));
			Point endPoint = 	new Point((int)_roadLength, (int)((i + 1) * _horizentalSegementLength));
			createUIRoad(eastWestRoads[i], mainFrame, i, startPoint, endPoint);
		}
		
		UIIntersection[][] uiIntersectionEastWest = intersectionController.getEastWestUIIntersections();
		UIIntersection[][] uiIntersectionNorthSouth = intersectionController.getNorthSouthUIIntersections();
		
		for(int i = 0; i < uiIntersectionEastWest.length; i ++)
		{
			for(int j = 0; j < uiIntersectionEastWest[i].length; j++)
			{
				mainFrame.add(uiIntersectionEastWest[i][j]);
				mainFrame.add(uiIntersectionNorthSouth[i][j]);
			}
		}

		
	}


	private void createUIRoad(Road road, JFrame mainFrame, int i, Point startPoint, Point endPoint) {
		UIRoad tempUIRoad = new UIRoad(startPoint, endPoint);
		mainFrame.add(tempUIRoad);
		
		CarController carController = new CarController(road);
		carController.addObserver(tempUIRoad);
		carController.run();
	}
	
	
	private void fillOffIntersectionPositions(int roadHorizontalNumber, int roadVerticalNumber)
	{
	  	_roadLength = TrafficSimulatorParameters.UI_ROAD_LENGTH;
	  	_intersectionPositionXs = new double[roadVerticalNumber]; 
	  	_intersectionPositionYs = new double[roadHorizontalNumber]; 
			
		_horizentalSegementLength = _roadLength / (roadHorizontalNumber + 1);
		_verticalSegementLength = _roadLength / (roadVerticalNumber + 1);
		
		for (int i = 0; i < roadHorizontalNumber; i ++)
		{
			double tempY = _horizentalSegementLength * (i + 1);
			_intersectionPositionYs[i] = tempY;
		}
		
		for (int i = 0; i < roadVerticalNumber; i ++)
		{
			double tempX = _verticalSegementLength * (i + 1);
			_intersectionPositionXs[i] = tempX;
		}
	}
}
