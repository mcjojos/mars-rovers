package uni.mars.naasaa.commands;

import uni.mars.naasaa.MarsRover;

public class RightCommand implements Command {

	public RightCommand() { }
	
	@Override
	public void execute(MarsRover marsRover) {
		marsRover.right();
	}

}
