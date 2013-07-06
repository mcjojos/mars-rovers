package uni.mars.naasaa.util;

import uni.mars.naasaa.commands.Command;
import uni.mars.naasaa.commands.LeftCommand;
import uni.mars.naasaa.commands.MoveForwardCommand;
import uni.mars.naasaa.commands.RightCommand;

/**
 * Enumeration defining the three possible instructions - Left, Right and
 * MoveForward It also maps each one of them in the analogous Commands.
 * 
 * @author karanikasg
 * 
 */
public enum Instruction {

	/**
	 * Left instruction.
	 */
	L(new LeftCommand()),
	/**
	 * Right instruction.
	 */
	R(new RightCommand()),
	/**
	 * Move forward instruction.
	 */
	M(new MoveForwardCommand());

	private final Command command;

	private Instruction(Command command) {
		this.command = command;
	}

	/**
	 * Get the command that is mapped to this instruction.
	 * 
	 * @return
	 */
	public Command getCommand() {
		return this.command;
	}

}
