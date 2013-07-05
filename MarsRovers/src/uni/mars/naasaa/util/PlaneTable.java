package uni.mars.naasaa.util;

public class PlaneTable {
	
	private int xAxis;
	private int yAxis;
	
	public PlaneTable() {
		this.xAxis = 0;
		this.yAxis = 0;
	}
	
	public PlaneTable(int xAxis, int yAxis) {
		this.xAxis = xAxis < 0 ? 0 : xAxis;
		this.yAxis = yAxis < 0 ? 0 : yAxis;
	}
	
	public int getXAxis() {
		return xAxis;
	}
	
	public int getYAxis() {
		return yAxis;
	}
	
}
