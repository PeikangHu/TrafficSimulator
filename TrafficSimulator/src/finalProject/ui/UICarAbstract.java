package finalProject.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.obstacle.PositionChangeEventObject;
import finalProject.trafficSimulator.road.obstacle.PositionChangeListener;

public abstract class UICarAbstract extends JPanel implements PositionChangeListener 
{
	private static final long serialVersionUID = -8919953767495352310L;
	
	private double _length;
	protected double _width;
	protected double _positionMiddle;
	protected double _position;
	
	protected double _uiLength;
	
	private int _uiRoadLength;
	
	private Color _color = new Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	
	private double[] _segmentPositions;
	private double[] _scaledSegmentPositions;
	
	private double[] _scales;
	
	public UICarAbstract(double length, double[] roadSegments, int uiRoadLength)
	{
		double roadWidth = TrafficSimulatorParameters.UI_ROAD_WIDTH;
		_width = TrafficSimulatorParameters.UI_CAR_WIDTH;
		_positionMiddle = (roadWidth - _width) / 2;
		_length = length;
		
		_uiRoadLength = uiRoadLength;
		
		
		createScales(roadSegments);
		
		createSegmentPositions(roadSegments);
		
		this.setLayout(null);
		//setCarBounds();
	}

	private void createScales(double[] roadSegments) 
	{
		_scales = new double[roadSegments.length];
		
		for (int i = 0; i < roadSegments.length; i++)
		{
			_scales[i] = _uiRoadLength /roadSegments.length  / roadSegments[i];
		}
	}

	private void createSegmentPositions(double[] roadSegments) {
		_segmentPositions = new double[roadSegments.length + 1];
		_scaledSegmentPositions  = new double[roadSegments.length + 1];
		_segmentPositions[0] = 0.0;
		double tempSegmentLength = 0;
		double tempScaledSegmentLength = 0;
		
		for (int i = 1; i < roadSegments.length + 1; i++)
		{
			tempSegmentLength += roadSegments[i - 1];
			tempScaledSegmentLength += roadSegments[i - 1] * _uiRoadLength /roadSegments.length  / roadSegments[i-1];
			
			_segmentPositions[i] = tempSegmentLength;
			_scaledSegmentPositions[i] = tempScaledSegmentLength;
		}
	}
	
	public void paintComponent(Graphics g)  
	{		 
		 super.paintComponent(g);
		 Graphics2D graphics2 = (Graphics2D) g;
		 Rectangle2D rectangle = drawRectangle();

	     graphics2.setColor(_color);
	     graphics2.fill(rectangle);
	}
	
	@Override
	public void positionChangeExecute(PositionChangeEventObject positionChangeEventObject) 
	{
		if (positionChangeEventObject.getPosistionIndex() >= 0)
		{
			int positionIndex = positionChangeEventObject.getPosistionIndex();
			
			if (positionIndex == 0)
			{
				_position = positionChangeEventObject.getPosition() * _scales[0];
			}
			else 
			{
				_position = (positionChangeEventObject.getPosition() - _segmentPositions[positionIndex]) * _scales[positionIndex] + 
							_scaledSegmentPositions[positionIndex];
			}
			_uiLength = _length * _scales[positionIndex];

			setCarBounds();
		}
	}
	
	protected abstract void setCarBounds();
	protected abstract Rectangle2D drawRectangle();
}
