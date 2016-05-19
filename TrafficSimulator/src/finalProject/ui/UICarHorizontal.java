package finalProject.ui;

import java.awt.geom.Rectangle2D;

public class UICarHorizontal  extends UICarAbstract
{
	private static final long serialVersionUID = -3627980518309553271L;
	
	
	
	public UICarHorizontal(double length, double[] roadSegments, int uiRoadLength)
	{
		super(length, roadSegments, uiRoadLength);
	}
	
	@Override
	protected void setCarBounds() {
		this.setBounds((int)_position, (int)_positionMiddle, (int)_uiLength +1, (int)_width + 1);
	}

	@Override
	protected Rectangle2D drawRectangle() {
		return new Rectangle2D.Double(0, 0, _uiLength, _width);
	}
}
