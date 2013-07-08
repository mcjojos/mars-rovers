In order to run the JUnit test from the command line make sure that the two projects MarsRovers amd MarsRoversUnitTest exist under the same directory
and JRE 7 is installed (for Windows OS):

java -cp .;../MarsRovers/bin;bin;junit.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore test.uni.mars.naasaa.TestMarsRover