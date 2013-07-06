package uni.mars.naasaa.commands;

import uni.mars.naasaa.MarsRover;

/**
 * A concrete command that implements turning right.
 * 
 * @author karanikasg
 *
 */
public class RightCommand implements Command {

	/* (non-Javadoc)
	 * @see uni.mars.naasaa.commands.Command#execute(uni.mars.naasaa.MarsRover)
	 */
	@Override
	public void execute(MarsRover marsRover) {
		marsRover.right();
	}

}
