package uni.mars.naasaa;

import uni.mars.naasaa.commands.CommandController;
import uni.mars.naasaa.util.Direction;
import uni.mars.naasaa.util.Point;
import uni.mars.naasaa.util.PlaneTable;

public class MarsRover {
	
	PlaneTable planeTable;
	Point point;
	Direction direction;
	CommandController cmdController;
	
	private boolean printable = false;
	
	public MarsRover() {
		this.cmdController = new CommandController(this);
	}
	
	public void setInputCommands(char[] input) {
		cmdController.parse(input);
	}
 	
	public void execute() {
		cmdController.executeAll();
	}
	
	public void setTable(PlaneTable planeTable) {
		this.planeTable = planeTable;
	}
	
	public void setTable(int upperRightX, int upperRightY) {
		this.planeTable = new PlaneTable(upperRightX, upperRightY);
	}
	
	
	public void positionOnTable(int x, int y, String d) {
		if (planeTable == null) {
			planeTable = new PlaneTable();
		}
		x = getBetweenBoundary(x, 0, planeTable.getXAxis());
		y = getBetweenBoundary(y, 0, planeTable.getYAxis());
		this.point = new Point(x, y);
		this.direction = Direction.valueOf(d);
	}
	
	public Point getPoint() {
		return this.point;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	/*
	 * Helper private method to ensure the value is between the specified boundaries
	 */
	private int getBetweenBoundary(int i, int min, int max) {
		return Math.max(min, Math.min(i, max));
	}
	
	/*******************************************************
	 ******* action methods used by the command patter ****
	 *******************************************************/
	public void left() {
		this.direction = this.direction.rotateLeft();
	}
	
	public void right() {
		this.direction = this.direction.rotateRight();
	}
	
	public void moveForward() {
		point.setX(getBetweenBoundary(point.getX() + direction.getStepX(), 0, planeTable.getXAxis()));
		point.setY(getBetweenBoundary(point.getY() + direction.getStepY(), 0, planeTable.getYAxis()));
	}
	
	
	public void print() {
		System.out.print(this.getPoint().getX() + " ");
		System.out.print(this.getPoint().getY() + " ");
		System.out.println(this.getDirection());
	}
	
}
