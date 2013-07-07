package uni.mars.naasaa.commands;

import java.util.LinkedList;
import java.util.Queue;

import uni.mars.naasaa.MarsRover;
import uni.mars.naasaa.util.Instruction;
import uni.mars.naasaa.util.LookUpEnum;

/**
 * A controller that is responsible for parsing an array of instructions and
 * storing the corresponding commands to an internal FIFO structure. The parser
 * was chosen to be flexible in the sense that if an instruction cannot be
 * matched against a known instruction then it is simply skipped. It provides a
 * method to execute all of the commands in the order they were received.
 * 
 * The Queue itself does not impose any insertion restrictions, thus the parsing
 * can fail to insert an element only by throwing an exception.
 * 
 * @author karanikasg
 * 
 */
public class CommandController {

	private Queue<Command> commands;
	private MarsRover marsRover;

	/**
	 * Initialize the FIFO queue used for storing commands prior to processing
	 * and the marsRover to be used.
	 * 
	 * @param marsRover
	 *            the {@link MarsRover} object that should be used by each
	 *            command.
	 */
	public CommandController(MarsRover marsRover) {
		this.commands = new LinkedList<Command>();
		this.marsRover = marsRover;
	}

	/**
	 * Parse the input and store it in the internal FIFO queue. If an
	 * instruction cannot be recognized just skip it.
	 * 
	 * @param instructionsInput
	 *            an array of characters corresponding to the instructions given
	 *            for a specific MarsRover.
	 */
	public void parse(char[] instructionsInput) {
		for (char c : instructionsInput) {
			Instruction instr = LookUpEnum.lookup(Instruction.class,
					String.valueOf(c));
			if (instr != null) {
				this.add(instr.getCommand());
			}
		}
	}

	/**
	 * Execute all of the commands sequentially in the order they were parsed.
	 */
	public void executeAll() {
		Command cmd;
		while ((cmd = this.poll()) != null) {
			cmd.execute(marsRover);
		}
	}

	private void add(Command object) {
		this.commands.add(object);
	}

	private Command poll() {
		return this.commands.poll();
	}

}
