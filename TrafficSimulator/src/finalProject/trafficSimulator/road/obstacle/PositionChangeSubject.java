package finalProject.trafficSimulator.road.obstacle;


public interface PositionChangeSubject {
	public void addObstacleListener(PositionChangeListener eventListener);
	public void removeObstacleListener(PositionChangeListener eventListener);
	public void notifyObstacleListeners();
}
