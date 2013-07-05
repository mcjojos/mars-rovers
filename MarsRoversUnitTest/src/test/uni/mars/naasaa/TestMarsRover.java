/**
 * 
 */
package test.uni.mars.naasaa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uni.mars.naasaa.MarsRover;
import uni.mars.naasaa.util.Direction;
import uni.mars.naasaa.util.PlaneTable;

import junit.framework.TestCase;

/**
 * @author gkaranikas
 * 
 */
public class TestMarsRover extends TestCase {

	private PlaneTable planeTable;
	
	private List<MarsRover> initFromFile(String fileName) throws NumberFormatException, IOException {
		
		List<MarsRover> marsRovers = new ArrayList<MarsRover>();
		final BufferedReader in = new BufferedReader(new FileReader(fileName));
		final String tableInput = in.readLine();
		final String[] dimensions = tableInput == null ? new String[] { "0", "0" } : tableInput.split(" ");
		
		planeTable = new PlaneTable(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
		
		String position;
		String instructionsInput;
		
		while ((position = in.readLine()) != null && (instructionsInput = in.readLine()) != null) {
			String[] positionSplitted = position.split(" ");
			
			MarsRover rover = new MarsRover();
			rover.setTable(planeTable);
			rover.positionOnTable(Integer.parseInt(positionSplitted[0]), Integer.parseInt(positionSplitted[1]), positionSplitted[2]);
			rover.setInputCommands(instructionsInput.toCharArray());
			marsRovers.add(rover);
		}
		
		return marsRovers;
		
	}

	/**
	 * Test method for {@link uni.mars.naasaa.MarsRover#execute()}.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@Test
	public void testMarsRoverExecute1() throws NumberFormatException, IOException {
		List<MarsRover> rovers = initFromFile("input1.txt");
		assertEquals(1, rovers.size());
		MarsRover rover = rovers.get(0);
		rover.execute();
		rover.print();
		// result: 1 3 N
		assertEquals(1, rover.getPoint().getX());
        assertEquals(3, rover.getPoint().getY());
        assertEquals(Direction.N, rover.getDirection());
	}

	
	/**
	 * Test method for {@link uni.mars.naasaa.MarsRover#execute()}.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@Test
	public void testMarsRoverExecute2() throws NumberFormatException, IOException {
		List<MarsRover> rovers = initFromFile("input2.txt");
		assertEquals(1, rovers.size());
		MarsRover rover = rovers.get(0);
		rover.execute();
		rover.print();
		// result: 5 1 E
        assertEquals(5, rover.getPoint().getX());
        assertEquals(1, rover.getPoint().getY());
        assertEquals(Direction.E, rover.getDirection());
	}

	/**
//	 * Test method for {@link uni.mars.naasaa.MarsRover#setTable(int, int)}.
//	 */
//	@Test
//	public void testSetTable() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link uni.mars.naasaa.MarsRover#positionOnTable(int, int, java.lang.String)}
//	 * .
//	 */
//	@Test
//	public void testPositionOnTable() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link uni.mars.naasaa.MarsRover#actionLeft()}.
//	 */
//	@Test
//	public void testActionLeft() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link uni.mars.naasaa.MarsRover#actionRight()}.
//	 */
//	@Test
//	public void testActionRight() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link uni.mars.naasaa.MarsRover#actionMoveForward()}.
//	 */
//	@Test
//	public void testActionMoveForward() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link uni.mars.naasaa.MarsRover#main(java.lang.String[])}.
//	 */
//	@Test
//	public void testMain() {
//		fail("Not yet implemented");
//	}

}
