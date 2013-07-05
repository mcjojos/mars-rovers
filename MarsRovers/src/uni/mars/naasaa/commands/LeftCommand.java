package uni.mars.naasaa.commands;

import uni.mars.naasaa.MarsRover;

public class LeftCommand implements Command {

	public LeftCommand() { }
	
	@Override
	public void execute(MarsRover marsRover) {
		marsRover.left();
	}

}
