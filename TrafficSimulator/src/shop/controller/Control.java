package shop.controller;


import finalProject.agent.World;
import finalProject.controller.RoadController;
import finalProject.main.AnimationAgent;
import finalProject.trafficSimulator.TrafficSimulatorParameters;
import shop.ui.UI;
import shop.ui.UIError;


import shop.ui.UIMenu;
import shop.ui.UIMenuAction;
import shop.ui.UIMenuBuilder;

public class Control {
	  private static final int EXITED = 0;
	  private static final int EXIT = 1;
	  private static final int START = 2;
	  private static final int NUMSTATES = 10;
	  private static final int CHANGE = 3;

	  private UIMenu[] _menus;
	  private int _state;

	    

	  private UI _ui;
	  
	  public Control(UI ui) {
	    _ui = ui;

	    _menus = new UIMenu[NUMSTATES];
	    _state = START;
	    addSTART(START);
	    addEXIT(EXIT);
	    addCHANGE(CHANGE);

	  }
	  

	  
	 public void run() {
	    try {
	      while (_state != EXITED) {
	        _ui.processMenu(_menus[_state]);
	      }
	    } catch (UIError e) {
	      _ui.displayError("UI closed");
	    }
	  }
	  
	  private void addCHANGE(int stateNum) 
	  {
		  UIMenuBuilder m = new UIMenuBuilder();
		    m.add("Default",
		  	      new UIMenuAction() {
		  	        public void run() {
		  	          _ui.displayError("doh!");
		  	        }
		  	      });
		    m.add("Show current values",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	showCurrentValue();
			  	          }
			  	      });
		    m.add("Simulation time step",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Simulation run time",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Grid size",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Traffic pattern",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Car entry rate",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Road segment length",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Intersection length",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Car length",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Car maximum velocity",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Car stop distance",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Traffic light green time",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Traffic light yellow time",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    m.add("Reset simulation and return to the main menu",
			  	      new UIMenuAction() {
			  	        public void run() {
			  	        	_ui.displayMessage("Sorry, under construction");
			  	          }
			  	      });
		    _menus[stateNum] = m.toUIMenu("Change Simulation Parameters");
	  }
	 
	  private void addSTART(int stateNum) {
	    UIMenuBuilder m = new UIMenuBuilder();
	    
	    m.add("Default",
	      new UIMenuAction() {
	        public void run() {
	          _ui.displayError("doh!");
	        }
	      });
	    m.add("Run Simulation",
	      new UIMenuAction() {
	        public void run() {
	        	runSimulation();
	          }
	      });
	    
	    m.add("Change Simulation Parameters",
	  	      new UIMenuAction() {
	  	        public void run() {
	  	        	_state = CHANGE;

	  	          }
	  	      });
	          
	    m.add("Exit",
	      new UIMenuAction() {
	        public void run() {
	          _state = EXIT;
	        }
	      });
	    

	    
	    _menus[stateNum] = m.toUIMenu("Traffic Simulation");
	  }
	  private void addEXIT(int stateNum) {
	    UIMenuBuilder m = new UIMenuBuilder();
	    
	    m.add("Default", new UIMenuAction() { public void run() {} });
	    m.add("Yes",
	      new UIMenuAction() {
	        public void run() {
	          _state = EXITED;
	        }
	      });
	    m.add("No",
	      new UIMenuAction() {
	        public void run() {
	          _state = START;
	        }
	      });
	    
	    _menus[stateNum] = m.toUIMenu("Are you sure you want to exit?");
	  }
	  
	  
	  private void runSimulation()
	  {
  		int duration = 	TrafficSimulatorParameters.SIMULATION_RUN_TIME;
  		World w = World.instance;

  		new  RoadController(TrafficSimulatorParameters.ROAD_HORIZONTAL_NUMBER,TrafficSimulatorParameters.ROAD_VERTICAL_NUMBER);
          for(int n = 0; n < duration; n++) 
          {
          	w.time().enqueue(n, new AnimationAgent());
          }

  		w.time().run(duration);
	  }
	  
	  private void showCurrentValue()
	  {
		  String currentValue = "";
		  currentValue += "Simulation time step (seconds)       [" + TrafficSimulatorParameters.SIMULATION_TIME_STEP + "]\n";
		  currentValue += "Simulation run time (seconds)        [" + TrafficSimulatorParameters.SIMULATION_RUN_TIME + "]\n";
		  currentValue += "Grid size (number of roads)          [row=" + TrafficSimulatorParameters.ROAD_HORIZONTAL_NUMBER + ",column=" + TrafficSimulatorParameters.ROAD_VERTICAL_NUMBER+"]\n";
		  currentValue += "Traffic pattern                      [" + TrafficSimulatorParameters.TRAFFIC_PATTERN + "]\n";
		  currentValue += "Car entry rate (seconds/car)         [min=" + TrafficSimulatorParameters.CAR_GENERATION_DELAY_MIN + ",max=" +  TrafficSimulatorParameters.CAR_GENERATION_DELAY_MAX + "]\n";
		  currentValue += "Road segment length (meters)         [min=" + TrafficSimulatorParameters.ROAD_LENGTH_MIN + ",max=" + TrafficSimulatorParameters.ROAD_LENGTH_MAX + "]\n";
		  currentValue += "Intersection length (meters)         [min=" + TrafficSimulatorParameters.INTERSECTION_LENGTH_MIN + ",max=" + TrafficSimulatorParameters.INTERSECTION_LENGTH_MAX + "]\n";
		  currentValue += "Car length (meters)                  [min=" + TrafficSimulatorParameters.CAR_LENGTH_MIN + ",max=" + TrafficSimulatorParameters.CAR_LENGTH_MAX + "]\n";
		  currentValue += "Car maximum velocity (meters/second) [min=" + TrafficSimulatorParameters.CAR_MAX_VELOCITY_MIN + ",max=" + TrafficSimulatorParameters.CAR_MAX_VELOCITY_MAX + "]\n";
		  currentValue += "Car stop distance (meters)           [min=" + TrafficSimulatorParameters.CAR_STOP_DISTANCE_MIN + ",max=" + TrafficSimulatorParameters.CAR_STOP_DISTANCE_MAX + "]\n";
		  currentValue += "Car brake distance (meters)          [min=" + TrafficSimulatorParameters.CAR_BRAKE_DISTANCE_MIN + ",max=" + TrafficSimulatorParameters.CAR_BRAKE_DISTANCE_MAX + "]\n"; 
		  currentValue += "Traffic light green time (seconds)   [min=" + TrafficSimulatorParameters.INTERSECTION_GREEN_DURATION_MIN + ",max=" + TrafficSimulatorParameters.INTERSECTION_GREEN_DURATION_MAX + "]\n";
		  currentValue += "Traffic light yellow time (seconds)  [min=" + TrafficSimulatorParameters.INTERSECTION_YELLOW_DURATION_MIN + ",max=" + TrafficSimulatorParameters.INTERSECTION_YELLOW_DURATION_MAX + "]\n";

		_ui.displayMessage(currentValue);
	  }
}
