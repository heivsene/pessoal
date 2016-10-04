package amazon.robot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotNew {

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
	 * Pattern to validate input format. Validate Digits 0-9 Or exactly any of
	 * this Characters
	 */
	Pattern p = Pattern.compile("[0-9NSEWX]");

	public RobotNew() {
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

		try {
			char[] a_Position = position.toCharArray();

			// Validate empty command
			if (position == null || position.isEmpty()) {
				throw new IllegalArgumentException("Invalid Command ["
						+ position + "].");
			}

			// Validate the Arguments to Operate
			for (int i = 0; i < a_Position.length; i++) {
				validateCommandInput(Character.toString(a_Position[i]));
			}

			this.inputCommad = position;
			int moves = 0, pointer = 0, lastGroupPosition = 0;
			boolean finished = false;

			while (!finished) {
				// Validate +Y Position
				if (a_Position[pointer] == 'N') {
					moves += getAmountMovesBeforePosition(a_Position,
							lastGroupPosition, pointer, true);
					
					//If is North so I have to subtract -1;
					while ( a_Position[pointer+1] == 'X' ){
						pointer++;
						moves--;
					}
					
				}
				// Validate -Y Position
				else if (a_Position[pointer] == 'S') {

				}
				// Validate +X Position
				else if (a_Position[pointer] == 'E') {

				}
				// Validate -X Position
				else if (a_Position[pointer] == 'W') {

				}

				pointer++;
			}

		} catch (Exception e) {
			this.x = 999;
			this.y = 999;
		}

		return this.getPoints();

	}

	private int getAmountMovesBeforePosition(char[] a_Position, int lastGroup,
			int i, boolean isSum) {
		int valor = 0;

		if (lastGroup < i) {
			int tBefore = Integer.parseInt(this.inputCommad.substring(
					lastGroup, i));

			if (isSum)
				valor += tBefore;
			else
				valor -= tBefore;

		}

		return valor;
	}

	private String getPoints() {
		return "(" + this.x + "," + this.y + ")";
	}

	private void validateCommandInput(String position) {

		Matcher m = p.matcher(position);

		if (!m.find())
			throw new IllegalArgumentException("Invalid Command [" + position
					+ "].");

	}

	public static void main(String[] args) {
		RobotNew chappie = new RobotNew();

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

	}

}
