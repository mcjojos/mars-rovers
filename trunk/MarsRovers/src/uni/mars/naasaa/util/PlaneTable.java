package uni.mars.naasaa.util;

/**
 * Represents the rectangular table of the plateau. The lower-left coordinates
 * are assumed to be at 0,0.
 * 
 * @author karanikasg
 * 
 */
public class PlaneTable {

	private int xAxis;
	private int yAxis;

	private final static int DEFAULT_PLANE_X_AXIS = 0;
	private final static int DEFAULT_PLANE_Y_AXIS = 0;

	/**
	 * Initialize the X and Y axis of the plateau to default values 0,0.
	 */
	public PlaneTable() {
		this.xAxis = DEFAULT_PLANE_X_AXIS;
		this.yAxis = DEFAULT_PLANE_Y_AXIS;
	}

	/**
	 * Construct the plateau to the desired X and Y axis. A sanity check for
	 * negative values is applied, in which case the value of 0 is applied.
	 * 
	 * @param xAxis
	 * @param yAxis
	 */
	public PlaneTable(int xAxis, int yAxis) {
		this.xAxis = xAxis < 0 ? 0 : xAxis;
		this.yAxis = yAxis < 0 ? 0 : yAxis;
	}

	/**
	 * @return the X axis
	 */
	public int getXAxis() {
		return xAxis;
	}

	/**
	 * @return the Y axis
	 */
	public int getYAxis() {
		return yAxis;
	}

	/**
	 * Static method to get the default X coordinate for landing, which in this
	 * case is half way the whole distance.
	 * 
	 * @param planeTable
	 * @return
	 */
	public static int getDefaultXLanding(PlaneTable planeTable) {
		if (planeTable != null) {
			return planeTable.getXAxis() / 2;
		}
		return DEFAULT_PLANE_X_AXIS / 2;
	}

	/**
	 * Static method to get the default Y coordinate for landing, which in this
	 * case is half way the whole distance.
	 * 
	 * @param planeTable
	 * @return
	 */
	public static int getDefaultYLanding(PlaneTable planeTable) {
		if (planeTable != null) {
			return planeTable.getYAxis() / 2;
		}
		return DEFAULT_PLANE_Y_AXIS / 2;
	}

}
