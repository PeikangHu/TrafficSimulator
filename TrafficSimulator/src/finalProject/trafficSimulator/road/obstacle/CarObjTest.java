package finalProject.trafficSimulator.road.obstacle;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import finalProject.trafficSimulator.road.intersection.Intersection;
import finalProject.trafficSimulator.road.intersection.IntersectionStaticFactory;

public class CarObjTest {

	@Test
	public void testHashCode() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCarObj() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRun() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddObstacleListener() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveObstacleListener() {
		//fail("Not yet implemented");
	}

	@Test
	public void testNotifyObstacleListeners() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLength() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPosition() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCanStop() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCanBrake() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetDistanceToObstacle() {
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		 TreeSet<Obstacle> _obstacles = new TreeSet<Obstacle>();
		 Intersection intersection1 = IntersectionStaticFactory.newIntersection(10, 10, 10);
		 Intersection intersection2 = IntersectionStaticFactory.newIntersection(30,20,15);
		 
		 intersection1.setPosition(20);
		 intersection2.setPosition(30);
		 
		 _obstacles.add(intersection2);
		 _obstacles.add(intersection1);
		 
		 assertTrue( _obstacles.higher(intersection1).equals(intersection2));
		 assertTrue( _obstacles.lower(intersection2).equals(intersection1));

		 
		 intersection1.setPosition(40);
		 intersection2.setPosition(20);
		 
		 TreeSet<Obstacle> newObstacles = new TreeSet<Obstacle>();
		 for(Obstacle item:_obstacles)
		 {
			 newObstacles.add(item);
		 }
		 
		 assertTrue( newObstacles.higher(intersection1) == null);
		 assertTrue( newObstacles.higher(intersection2).equals(intersection1));
		 
		 assertTrue( newObstacles.lower(intersection1).equals(intersection2));
	}

	@Test
	public void testSetPositionIndex() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPositionIndex() {
		//fail("Not yet implemented");
	}

}
