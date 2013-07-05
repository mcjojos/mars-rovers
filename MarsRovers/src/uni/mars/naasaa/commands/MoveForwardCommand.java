package uni.mars.naasaa.commands;

import uni.mars.naasaa.MarsRover;

public class MoveForwardCommand implements Command {
	
	public MoveForwardCommand() { }

	@Override
	public void execute(MarsRover marsRover) {
		marsRover.moveForward();
	}

}
