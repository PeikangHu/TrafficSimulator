package finalProject.ui;

import java.awt.geom.Rectangle2D;


public class UICarVertical extends UICarAbstract
{
	private static final long serialVersionUID = 5184923579162540976L;
	
	public UICarVertical(double length, double[] roadSegments, int uiRoadLength)
	{
		super(length, roadSegments, uiRoadLength);
	}

	@Override
	protected void setCarBounds() {

		this.setBounds((int)_positionMiddle, (int)_position,  (int)_width + 1, (int)_uiLength + 1);
		
	}

	@Override
	protected Rectangle2D drawRectangle() {
		return new Rectangle2D.Double(0, 0,_width, _uiLength);
	}
}
