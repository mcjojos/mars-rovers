MarsRovers has a PlaneTable where it is positioned, a position (x, y) and a direction (North, East,
South, West). It provides a method to receive commands and to execute them. Receipt and execution 
of commands can be also done in one step, invoking one method. A command controller is responsible
to parse the commands, store them in a FIFO queue and execute them.
The command design pattern is used to implement the three possible commands, thus making it easily
extentable with other commands. The three possible instructions are modelled in an Enum, providing
for each one the proper command implementation during construction time. This way only three
instance commands are created and reused for any number of input commands.
The four cardinal compass points are represented by the Direction enum initializing each direction
with the steps in the X-Axis and Y-Axis to be added in the x, y coordinates when a step is
performed in that direction.
Several sanity checks are provided:
	- If the Plateau is not initialized, it is initialized to 0, 0.
	- If the direction or the position is not set before the execution of commands, set the default
	direction to North and the default position to be the middle of the plateau.
	- The rover is never allowed to exit the boundaries of the plateau, ignoring the commands if
	they are instructing it to move outside its boundaries.
	- Any instructions that are not recognized are also skipped.
	
It is assumed that no collision can occur between two rovers and that two rovers can be positioned 
in the same point.