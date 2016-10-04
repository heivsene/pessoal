package amazon.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Robot {

	/**
	 * x position to the robot move. East = +1 West = -1
	 */
	private int x = 0;

	/**
	 * x position to the robot move. North = +1 South = -1
	 */
	private int y = 0;

	/**
	 * Position to calculate.
	 */
	private String inputCommad;

	/**
	 * Pattern to validate input format.
	 * Must be a Valid Sequence.
	 * Before a N,S,W or E could have a digit.
	 * After N,S,W or E could have 0 to n 'X' character
	 * this Characters
	 */
	Pattern INPUT_VALIDATOR = Pattern.compile("^(\\d*[NSEW]X*)*$");
	
	public Robot() {
		super();
		this.toOrigin();
	}

	/**
	 * Move the Robot to Origin (0,0)
	 */
	private void toOrigin() {
		this.x = 0;
		this.y = 0;
	}
	
	private String getPoints() {
		return "(" + this.x + "," + this.y + ")";
	}


	/**
	 * All comands are suposed to be calculated from Origin (0,0). All valids
	 * commands must follow these rules. Contain only these letters NSEWX
	 * uppercase Contain any number and after a number MUST be any of these
	 * letters above, and never end with a NUMBER.
	 * 
	 * @param position
	 * @return destination in format (x,y);
	 */
	public String getCoordinatesToMoveFromOriginTo(String position) {
		this.toOrigin();
		try {
			// Validate empty command
			if (position == null || position.isEmpty()) {
				throw new IllegalArgumentException("Invalid Command ["
						+ position + "].");
			}

			// Validate the Arguments to Operate
			validateCommandInput(position);
			
			calculateDestination(position);
			

		} catch (Exception e) {
			this.x = 999;
			this.y = 999;
		}

		return this.getPoints();

	}

	
	/**
	 * Calculates the destination position.
	 * 
	 * @param position
	 */
	private void calculateDestination(String position) {
		char[] cmd = position.toCharArray();
		
		//Readin in reverse order
		int excludeCmds = 0;
		int magnitude = 1;
		boolean was_N, was_S, was_E, was_W;
		String digits = "";
		for ( int i = cmd.length-1 ; i >= 0 ; i-- ){
			System.out.println(cmd[i]);
			
			if ( cmd[i] == 'X' ) {
				excludeCmds++;
			} else if ( Character.isDigit(cmd[i]) ){
				digits = "";
				while ( i >= 0 && Character.isDigit(cmd[i]) ){
					digits = cmd[i] + digits;
					i--;
				}
				magnitude = Integer.parseInt(digits);
			} else {
				was_N = cmd[i] == 'N';
				was_S = cmd[i] == 'S';
				was_E = cmd[i] == 'E';
				was_W = cmd[i] == 'W';
				
				if ( i > 0 && Character.isDigit(cmd[i-1]) ){
					continue;
				}
			}
			
			
		}
		
	}

	private void validateCommandInput(String position) {

		Matcher m = INPUT_VALIDATOR.matcher(position);

		if (!m.find())
			throw new IllegalArgumentException("Invalid Command [" + position
					+ "].");

	}

	public static void main(String[] args) {
		Robot chappie = new Robot();

		/**
		 * Validate Wrong Letter Input Input
		 */
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("A7NS"));

		/**
		 * Validate null, empty
		 */
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo(null));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo(""));
		
		
		
		/**
		 * Validate 7NXX
		 */
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("7NXX"));
		
		/**
		 * Validate N
		 */
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("N"));
		
		/**
		 * Valid Input
		 */
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("EWSN10NX123NX1NS"));
		

	}

}
