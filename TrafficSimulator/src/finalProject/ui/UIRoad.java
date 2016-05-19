package finalProject.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.Observable;
import java.util.Observer;

import finalProject.trafficSimulator.TrafficSimulatorParameters;

public class UIRoad extends JPanelWithoutLayout implements Observer
{
	private static final long serialVersionUID = -8043279695176392200L;
	
	private Point _startPosition;
	private Point _endPosition;
	

	public UIRoad(Point startPosition, Point endPosition)
	{
		super(	startPosition.x==0?0:startPosition.x - TrafficSimulatorParameters.UI_ROAD_WIDTH/2, startPosition.y==0?0:startPosition.y-TrafficSimulatorParameters.UI_ROAD_WIDTH/2, 
				startPosition.x==0?endPosition.x+1:TrafficSimulatorParameters.UI_ROAD_WIDTH, startPosition.y==0?endPosition.y+1:TrafficSimulatorParameters.UI_ROAD_WIDTH);
		_startPosition = startPosition;
		_endPosition = endPosition;
	}
	
	public void paintComponent(Graphics g)  
	{		 
		super.paintComponent(g);  
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.black);
		
		GeneralPath path = new GeneralPath();
		path.moveTo(_startPosition.x==0?0: TrafficSimulatorParameters.UI_ROAD_WIDTH/2, _startPosition.y==0?0:TrafficSimulatorParameters.UI_ROAD_WIDTH/2);
		path.lineTo(_startPosition.x==0?_endPosition.x:_startPosition.x==0?0: TrafficSimulatorParameters.UI_ROAD_WIDTH/2, _startPosition.y==0?_endPosition.y:_startPosition.y==0?0:TrafficSimulatorParameters.UI_ROAD_WIDTH/2);
		
		g2.draw(path);
	}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		UICarAbstract car = (UICarAbstract)arg1;
		
		this.add(car);	
		//this.repaint();
	}
	
	
}
