package uni.mars.naasaa.util;

/**
 * Represent a point in the two dimensional Euclidean space, having x, y as
 * Cartesian coordinates.
 * 
 * @author karanikasg
 * 
 */
public class Point {

	private int x;
	private int y;
	
	/**
	 * Initialize the Cartesian coordinates x, y to default values 0, 0.
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Initialize the Cartesian coordinates x, y.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x < 0 ? 0 : x;
		this.y = y < 0 ? 0 : y;
	}

	/**
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x coordinate to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y coordinate to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
