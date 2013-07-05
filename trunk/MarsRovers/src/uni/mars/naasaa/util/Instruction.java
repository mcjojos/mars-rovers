package uni.mars.naasaa.util;

import uni.mars.naasaa.commands.Command;
import uni.mars.naasaa.commands.LeftCommand;
import uni.mars.naasaa.commands.MoveForwardCommand;
import uni.mars.naasaa.commands.RightCommand;

public enum Instruction {
	
	L(new LeftCommand()), 
	R(new RightCommand()), 
	M(new MoveForwardCommand());
	
    private final Command command;
    
    private Instruction(Command command) {
        this.command = command;
    }
    
    public Command getCommand() {
    	return this.command;
    }
    
}
