package uni.mars.naasaa.util;

import java.util.logging.Logger;

/**
 * Enum that represents the four cardinal compass points. For each instance
 * field representing a point the forward steps in the X and Y dimensions are
 * modeled with the two first constructor arguments, the third one representing
 * the index of each cardinal compass point, thus avoiding using the ordinal()
 * method as recommended. findDirection(java.lang.String) is intended to be used
 * an an alternative to Direction.valueOf(java.lang.String) as a more flexible
 * alternative that defaults to 'N' in case the specified enum type has no
 * constant with the specified name instead of throwing {@link IllegalArgumentException}.
 * 
 * @author karanikasg
 * 
 */
public enum Direction {
	/**
	 * The North cardinal direction indexed at position 0. If the subject is
	 * facing North then moving one step forward means incrementing Y coordinate
	 * by 1.
	 */
	N(0, 1, 0),
	/**
	 * The East cardinal direction indexed at position 1. If the subject is
	 * facing East then moving one step forward means incrementing X coordinate
	 * by 1.
	 */
	E(1, 0, 1),
	/**
	 * The South cardinal direction indexed at position 2. If the subject is
	 * facing South then moving one step forward means decrementing Y coordinate
	 * by 1.
	 */
	S(0, -1, 2),
	/**
	 * The West cardinal direction indexed at position 3. If the subject is
	 * facing West then moving one step forward means decrementing X coordinate
	 * by 1.
	 */
	W(-1, 0, 3);

	private final int stepX;
	private final int stepY;
	private final int index;

	private Direction(int stepX, int stepY, int index) {
		this.stepX = stepX;
		this.stepY = stepY;
		this.index = index;
	}

	/**
	 * @return the step in the X axis
	 */
	public int getStepX() {
		return this.stepX;
	}

	/**
	 * @return the step in the Y axis
	 */
	public int getStepY() {
		return this.stepY;
	}

	/**
	 * Get the next counter-clockwise cardinal direction.
	 * 
	 * @return the left cardinal direction of the current.
	 */
	public Direction rotateLeft() {
		int i = this.index - 1;
		if (i < 0) {
			i = values().length - 1;
		}
		return Direction.values()[i % values().length];
	}

	/**
	 * Get the next clockwise cardinal direction.
	 * 
	 * @return the right cardinal direction of the current.
	 */
	public Direction rotateRight() {
		return Direction.values()[(index + 1) % values().length];
	}

	/**
	 * This method is intended to be used an an alternative to
	 * Direction.valueOf(java.lang.String). In case the specified enum type has no
	 * constant with the specified name the default type for North is returned
	 * instead of throwing {@link IllegalArgumentException}.
	 * 
	 * @param direction
	 * @return
	 */
	public static Direction findDirection(String type) {
		for (Direction d : Direction.values()) {
			if (d.name().equals(type)) {
				return d;
			}
		}
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(
				"Direction \"" + type + "\" not found. Default to \"" + N
						+ "\"");
		// this line works if nothing is found.
		return N;
	}

}
