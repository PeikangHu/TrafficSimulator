package finalProject.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import finalProject.trafficSimulator.TrafficSimulatorParameters;
import finalProject.trafficSimulator.road.intersection.light.LightColorTurnListener;
import finalProject.trafficSimulator.road.intersection.light.LightColorTurnEventObject;

public class UILight extends JPanel  implements LightColorTurnListener
{
	private static final long serialVersionUID = 8965791498513588406L;
	private Color lightColor = Color.red;
	
	private int diameter = TrafficSimulatorParameters.LIGHT_DIAMETER;
	
	public UILight(int x, int y)
	{
		this.setLayout(null);
		
		this.setBounds(x, y, diameter, diameter);
	}
	
	public  void paintComponent(Graphics g) {  
		super.paintComponent(g); 

		g.setColor(lightColor);
		g.fillOval(0, 0, diameter, diameter); 
	}

	@Override
	public void lightEventExecute(LightColorTurnEventObject event) 
	{
		switch(event.getLightStateEnum())
		{
			case Green: lightColor = Color.green; break;
			case Red:	lightColor = Color.red; break;
			case Yellow:lightColor = Color.yellow; break;
		}

		repaint();
	}
}
