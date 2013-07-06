package uni.mars.naasaa.commands;

import uni.mars.naasaa.MarsRover;

/**
 * The super class of all Commands. It should encapsulate invocation of an
 * action, adhering to the Command pattern.
 * 
 * @author karanikasg
 * 
 */
public interface Command {

	/**
	 * The method that all subclasses of Command must implement.
	 * 
	 * @param marsRover
	 */
	public void execute(MarsRover marsRover);

}
