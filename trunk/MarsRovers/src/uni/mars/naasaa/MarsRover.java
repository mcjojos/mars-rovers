package uni.mars.naasaa;

import java.util.logging.Logger;

import uni.mars.naasaa.commands.CommandController;
import uni.mars.naasaa.util.Direction;
import uni.mars.naasaa.util.Point;
import uni.mars.naasaa.util.PlaneTable;

/**
 * The MarsRover class represents a robotic rover used by NAASAA for a mission
 * on Mars. Before executing the commands transmitted by NAASAA we have to make
 * sure that the plateau is marked and the rover is landed on the plateau.
 * Ideally the commands must have been also already transmitted. If the rover is
 * not yet landed then the default coordinates of Plane.X/2, Plane.Y/2 are used.
 * The recommended sequence of method invocations must adhere to the following
 * commands:
 * MarsRover rover = new MarsRover();
 * rover.setTable(plateau);
 * rover.landOnTable(x, y, direction);
 * rover.receiveCommands(instructions);
 * rover.executeCommands();
 * 
 * In case the direction type is not found the default that is used is N (North).
 * In case an instruction is not matched against the determined ones then it
 * is simply skipped.
 * 
 * @author karanikasg
 * 
 */
public class MarsRover {

	private final static Direction DEFAULT_DIRECTION = Direction.N;

	private PlaneTable planeTable;
	private Point position;
	private Direction direction;
	private CommandController cmdController;

	/**
	 * Initialize the MarsRover.
	 */
	public MarsRover() {
		this.cmdController = new CommandController(this);
	}

	/**
	 * Mark the plateau with a new plane table.
	 * 
	 * @param planeTable
	 */
	public void setTable(PlaneTable planeTable) {
		this.planeTable = planeTable;
	}

	/**
	 * Mark the plateau with x and y coordinates.
	 * 
	 * @param upperRightX
	 * @param upperRightY
	 */
	public void setTable(int upperRightX, int upperRightY) {
		this.planeTable = new PlaneTable(upperRightX, upperRightY);
	}

	/**
	 * Land the rover in Mars. If no plateau is defined mark the default plane
	 * and land it over there. Make sure the final position of the rover is
	 * between the plateau's boundaries.
	 * 
	 * @param x
	 *            the rover's position in the X Axis
	 * @param y
	 *            the rover's position in the Y Axis
	 * @param d
	 *            the cardinal point
	 */
	public void landOnTable(int x, int y, Direction d) {
		landOnTable(x, y, d.toString());
	}

	/**
	 * Land the rover in Mars. If no plateau is defined mark the default plane
	 * and land it over there. Make sure the final position of the rover is
	 * between the plateau's boundaries.
	 * 
	 * @param x
	 *            the rover's position in the X Axis
	 * @param y
	 *            the rover's position in the Y Axis
	 * @param d
	 *            the cardinal point
	 */
	public void landOnTable(int x, int y, String d) {
		if (planeTable == null) {
			planeTable = new PlaneTable();
		}
		x = getBetweenBoundary(x, 0, planeTable.getXAxis());
		y = getBetweenBoundary(y, 0, planeTable.getYAxis());
		this.position = new Point(x, y);
		this.direction = Direction.findDirection(d);
	}

	/**
	 * Receive the commands sent by NAASAA by parsing and storing them
	 * sequentially.
	 * 
	 * @param input
	 */
	public void receiveCommands(char[] input) {
		this.cmdController.parse(input);
	}

	/**
	 * Execute all the commands (if any) sent by NAASAA in the order they were
	 * received. First check if the rover is already landed on Mars between the
	 * boundaries specified by the plateau and if not land it in the middle of
	 * it.
	 */
	public void executeCommands() {
		if (!isLanded()) {
			this.landOnTable(PlaneTable.getDefaultXLanding(planeTable),
					PlaneTable.getDefaultXLanding(planeTable),
					DEFAULT_DIRECTION);
		}
		this.cmdController.executeAll();
	}

	/**
	 * @return the position of the rover.
	 */
	public Point getPosition() {
		return this.position;
	}

	/**
	 * @return the direction of the rover.
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/*******************************************************
	 ******* action methods used by the command pattern ****
	 *******************************************************/
	/**
	 * Make the rover spin 90 degrees left, without moving from its current
	 * position.
	 */
	public void left() {
		this.direction = this.direction.rotateLeft();
	}

	/**
	 * Make the rover spin 90 degrees right, without moving from its current
	 * position.
	 */
	public void right() {
		this.direction = this.direction.rotateRight();
	}

	/**
	 * Move forward one grid point, and maintain the same heading.
	 */
	public void moveForward() {
		position.setX(getBetweenBoundary(getPosition().getX()
				+ getDirection().getStepX(), 0, planeTable.getXAxis()));
		position.setY(getBetweenBoundary(getPosition().getY()
				+ getDirection().getStepY(), 0, planeTable.getYAxis()));
	}

	/**
	 * Log the position and heading of the rover.
	 */
	public void logPosition() {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(
				this.getPosition().getX() + " " + this.getPosition().getY()
						+ " " + this.getDirection());
	}

	/*
	 * Helper private method to ensure the value is between the specified
	 * boundaries.
	 */
	private int getBetweenBoundary(int i, int min, int max) {
		return Math.max(min, Math.min(i, max));
	}

	/*
	 * Helper method to return true if the rover is landed, false otherwise.
	 */
	private boolean isLanded() {
		boolean result = true;
		if (this.getPosition() == null || this.getDirection() == null) {
			result = false;
		}
		return result;
	}

}
