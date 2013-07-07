/**
 * 
 */
package test.uni.mars.naasaa;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import uni.mars.naasaa.MarsRover;
import uni.mars.naasaa.util.Direction;

import junit.framework.TestCase;

/**
 * @author gkaranikas
 * 
 */
public class TestMarsRover extends TestCase {

	private final static String TURN_LEFT = "L";
	private final static String TURN_RIGHT = "R";
	private final static String MOVE_FORWARD = "M";
	private final static String NORTH = "N";
	// private final static String EAST = "E";
	// private final static String SOUTH = "S";
	private final static String WEST = "W";

	private final static boolean IS_LOGGABLE = true;

	/**
	 * Test parsing from file input1.txt
	 */
	@Test
	public void testLoadFromFile1() {
		try {
			MarsRover[] rovers;
			rovers = MarsRover.loadFromFile(new File("input1.txt"), true,
					IS_LOGGABLE);
			assertEquals(1, rovers.length);
			// result: 1 3 N
			assertEquals(1, rovers[0].getPosition().getX());
			assertEquals(3, rovers[0].getPosition().getY());
			assertEquals(Direction.N, rovers[0].getDirection());
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test parsing from file input2.txt
	 */
	@Test
	public void testLoadFromFile2() {
		try {
			MarsRover[] rovers;
			rovers = MarsRover.loadFromFile(new File("input2.txt"), true,
					IS_LOGGABLE);
			assertEquals(1, rovers.length);
			// result: 5 1 E
			assertEquals(5, rovers[0].getPosition().getX());
			assertEquals(1, rovers[0].getPosition().getY());
			assertEquals(Direction.E, rovers[0].getDirection());
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test parsing the commands for two rovers with bigger instruction inputs
	 * 
	 */
	@Test
	public void testLoadMultipleRoversFromFile3() {
		try {
			MarsRover[] rovers;
			rovers = MarsRover.loadFromFile(new File("input3.txt"), true,
					IS_LOGGABLE);
			assertEquals(2, rovers.length);
			// result: 4 5 S
			assertEquals(4, rovers[0].getPosition().getX());
			assertEquals(5, rovers[0].getPosition().getY());
			assertEquals(Direction.S, rovers[0].getDirection());
			// result: 1 4 E
			assertEquals(1, rovers[1].getPosition().getX());
			assertEquals(4, rovers[1].getPosition().getY());
			assertEquals(Direction.E, rovers[1].getDirection());
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test if the default position of the rover is in the middle of the plateau
	 * heading North.
	 */
	@Test
	public void testDefaultPosition() {
		MarsRover rover = new MarsRover();
		rover.setTable(6, 6);
		rover.receiveCommands("LLL");
		rover.executeCommands();
		log(rover);
		assertEquals(3, rover.getPosition().getX());
		assertEquals(3, rover.getPosition().getY());
		assertEquals(Direction.E, rover.getDirection());
	}

	/**
	 * Test turning from all possible directions.
	 */
	@Test
	public void testTurning() {
		MarsRover rover = new MarsRover();
		rover.setDirection(NORTH);
		rover.receiveAndExecuteCommands(TURN_LEFT);
		assertEquals(Direction.W, rover.getDirection());
		rover.receiveAndExecuteCommands(TURN_LEFT);
		assertEquals(Direction.S, rover.getDirection());
		rover.receiveAndExecuteCommands(TURN_LEFT);
		assertEquals(Direction.E, rover.getDirection());
		rover.receiveAndExecuteCommands(TURN_LEFT);
		assertEquals(Direction.N, rover.getDirection());

		rover.receiveAndExecuteCommands(TURN_RIGHT);
		assertEquals(Direction.E, rover.getDirection());
		rover.receiveAndExecuteCommands(TURN_RIGHT);
		assertEquals(Direction.S, rover.getDirection());
		rover.receiveAndExecuteCommands(TURN_RIGHT);
		assertEquals(Direction.W, rover.getDirection());
		rover.receiveAndExecuteCommands(TURN_RIGHT);
		assertEquals(Direction.N, rover.getDirection());
	}

	/**
	 * Land the rover outside the plane. Then direct it to the boundaries of the
	 * plane
	 */
	@Test
	public void testPlateauBoundaries() {
		MarsRover rover = new MarsRover();
		rover.setTable(5, 5);
		rover.landOnTable(15, 15, WEST);
		assertEquals(5, rover.getPosition().getX());
		assertEquals(5, rover.getPosition().getY());
		for (int i = 0; i < 100; i++) {
			rover.receiveCommands(MOVE_FORWARD);
		}
		rover.receiveAndExecuteCommands(TURN_LEFT);
		assertEquals(0, rover.getPosition().getX());

		for (int i = 0; i < 100; i++) {
			rover.receiveCommands(MOVE_FORWARD);
		}
		rover.receiveAndExecuteCommands(TURN_LEFT);
		assertEquals(0, rover.getPosition().getY());

		for (int i = 0; i < 5; i++) {
			rover.receiveCommands(MOVE_FORWARD);
		}
		rover.receiveCommands(TURN_LEFT);
		for (int i = 0; i < 5; i++) {
			rover.receiveCommands(MOVE_FORWARD);
		}
		rover.executeCommands();
		assertEquals(5, rover.getPosition().getX());
		assertEquals(5, rover.getPosition().getY());
		assertEquals(Direction.N, rover.getDirection());

		log(rover);
	}

	private void log(MarsRover rover) {
		if (IS_LOGGABLE) {
			rover.logPosition();
		}
	}

}
