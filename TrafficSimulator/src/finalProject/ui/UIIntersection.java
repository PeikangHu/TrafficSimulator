package finalProject.ui;

import javax.swing.JPanel;

public class UIIntersection extends JPanel
{
	private static final long serialVersionUID = 1002973910936770390L;
	
	
	public UIIntersection(UILight uiLightTop, UILight uiLightBottom)
	{
		this.setLayout(null);

		this.add(uiLightTop);
		this.add(uiLightBottom);
	}

}
