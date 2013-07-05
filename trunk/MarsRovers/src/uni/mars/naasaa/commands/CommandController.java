package uni.mars.naasaa.commands;

import java.util.LinkedList;
import java.util.Queue;

import uni.mars.naasaa.MarsRover;
import uni.mars.naasaa.util.Instruction;

public class CommandController {

	private Queue<Command> commands;
	private MarsRover marsRover;
	
	public CommandController(MarsRover marsRover) {
		this.commands = new LinkedList<Command>();
		this.marsRover = marsRover;
	}
	
	public void parse(char[] instructionsInput) {
		for (char c : instructionsInput) {
			Instruction instr = Instruction.valueOf(String.valueOf(c));
			add(instr.getCommand());
		}
	}
	
	public void add(Command object) {
		this.commands.add(object);
	}

	public Command poll() {
		return this.commands.poll();
	}
	
	public boolean hasCommands() {
		boolean result = false;
		
		if (commands != null && !commands.isEmpty()) {
			result = true;
		}
		
		return result;
	}

	public void executeAll() {
		Command cmd;
		while ((cmd = this.poll()) != null) {
			cmd.execute(marsRover);
		}
	}

}
