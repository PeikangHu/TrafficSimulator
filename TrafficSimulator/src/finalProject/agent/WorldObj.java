package finalProject.agent;

public class WorldObj implements World 
{
	private TimeServer _time = new TimeServerLinked();
	private Object[][] _space = new Object[100][100];
	public TimeServer time()  { return _time; }
	public Object[][] space() { return _space; }
}
