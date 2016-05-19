package finalProject.main;

import shop.controller.Control;
import shop.ui.UI;



public class Main
{

	public static void main(String[] args) 
	{
		UI ui = new shop.ui.TextUI();
		Control control = new Control(ui);
	    control.run();
	}
	

}

