package finalProject.agent;

public interface World {
	public static final World instance = new WorldObj();
	public TimeServer time();
	public Object[][] space();

}
