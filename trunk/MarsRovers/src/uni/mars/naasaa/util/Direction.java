package uni.mars.naasaa.util;

public enum Direction {
	N(0, 1), E(1, 0), S(0, -1), W(-1, 0);
	
	private final int stepX;
	private final int stepY;
    
    private Direction(int stepX, int stepY) {
        this.stepX = stepX;
        this.stepY = stepY;
    }
    
    public int getStepX() {
    	return this.stepX;
    }
    
    public int getStepY() {
    	return this.stepY;
    }
	
	public Direction rotateLeft() {
		int index = ordinal() - 1; 
		if (index < 0) {
			index = values().length - 1;
		}
		return Direction.values()[index % values().length];
	}
	
	public Direction rotateRight() {
		return Direction.values()[(ordinal() + 1) % values().length];
	}
	
}
