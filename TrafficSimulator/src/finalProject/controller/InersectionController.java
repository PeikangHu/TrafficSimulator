package finalProject.controller;

import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.intersection.Intersection;
import finalProject.trafficSimulator.road.intersection.IntersectionStaticFactory;
import finalProject.trafficSimulator.road.intersection.IntersectionType;
import finalProject.ui.UIIntersection;
import finalProject.ui.UILight;

public class InersectionController 
{
	private UIIntersection[][] _uiIntersectionsEastWest;
	private UIIntersection[][] _uiIntersectionsNorthSouth;

	private Intersection _intersectionsEastWest[ ][ ];
	private Intersection _intersectionsNorthSouth[ ][ ];
	
	private double[] _intersectionPositionXs;
	private double[] _intersectionPositionYs;
	
	private int lightInterval;
	private int lightDiameter;

	
	public InersectionController(double[] intersectionPositionXs, double[] intersectionPositionYs)
	{
		_intersectionPositionXs = intersectionPositionXs;
		_intersectionPositionYs = intersectionPositionYs;
		
		int roadHorizontalNumber = _intersectionPositionYs.length;
		int roadVerticalNumber = _intersectionPositionXs.length;
		
		_intersectionsEastWest = new Intersection[roadHorizontalNumber][roadVerticalNumber];
		_intersectionsNorthSouth = new Intersection[roadHorizontalNumber][roadVerticalNumber];
		_uiIntersectionsEastWest = new UIIntersection[roadHorizontalNumber][roadVerticalNumber];
		_uiIntersectionsNorthSouth = new UIIntersection[roadHorizontalNumber][roadVerticalNumber];
		
		lightInterval = TrafficSimulatorParameters.LIGHTS_SAME_DIRECTION_INTERVAL;
		lightDiameter = TrafficSimulatorParameters.LIGHT_DIAMETER;
		
		IntersectionStaticFactory.FillOutGridRoadsIntersectionPairs(_intersectionsEastWest, _intersectionsNorthSouth);
		
		 fillOutUILights(_intersectionsEastWest, _uiIntersectionsEastWest, IntersectionType.EastWest);
		 fillOutUILights(_intersectionsNorthSouth, _uiIntersectionsNorthSouth, IntersectionType.NorthSouth);
		 
		 for (int i = 0; i < _intersectionPositionYs.length; i++)
		 {
			 for (int j = 0; j < _intersectionPositionXs.length; j++)
			 {
				 int totalLength = lightDiameter + lightInterval;
				 _uiIntersectionsEastWest[i][j].setBounds((int)_intersectionPositionXs[j] - totalLength / 2 , (int)_intersectionPositionYs[i] - lightDiameter/2, totalLength, lightDiameter);
				 _uiIntersectionsNorthSouth[i][j].setBounds((int)_intersectionPositionXs[j] - lightDiameter/2, (int)_intersectionPositionYs[i] - totalLength / 2, lightDiameter, totalLength);
			 }
		 }
	}
	
	private void fillOutUILights(Intersection[][] intersections, UIIntersection[][] uiIntersection, IntersectionType type)
	{
		for (int i = 0; i < uiIntersection.length; i++)
		{
			for (int j = 0; j < uiIntersection[i].length; j++)
			{
				UILight uiLightTop;
				UILight uiLightBottom;
				if	(type == IntersectionType.EastWest)
				{
					uiLightTop = new UILight(0, 0);
					uiLightBottom = new UILight(lightInterval, 0);
				}
				else
				{
					uiLightTop = new UILight(0, 0);
					uiLightBottom = new UILight(0, lightInterval);					
				}
				
				intersections[i][j].addLightColorTurnListener(uiLightTop);
				intersections[i][j].addLightColorTurnListener(uiLightBottom);
				
				uiIntersection[i][j] = new UIIntersection(uiLightTop, uiLightBottom);
			}
		}
	}
	
	public Intersection[][] getNorthSouthIntersections()
	{
		return _intersectionsNorthSouth;
	}
	
	public Intersection[][] getEastWestIntersections()
	{
		return _intersectionsEastWest;
	}
	
	public UIIntersection[][] getNorthSouthUIIntersections()
	{
			
		return _uiIntersectionsNorthSouth;
	}
	
	public UIIntersection[][] getEastWestUIIntersections()
	{
		return _uiIntersectionsEastWest;
	}
}
