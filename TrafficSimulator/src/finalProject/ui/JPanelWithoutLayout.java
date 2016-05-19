package finalProject.ui;

import javax.swing.JPanel;

abstract class JPanelWithoutLayout extends JPanel
{
	private static final long serialVersionUID = -3443820980038272638L;

	JPanelWithoutLayout(int x, int y, int width, int height)
	{
		this.setLayout(null);
		setOpaque(false);
		this.setBounds(x, y, width, height);
	}
}
