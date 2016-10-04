package amazon.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotRegex {

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
	Pattern SPLIT_GROUP = Pattern.compile("(\\d*[NSWE]X*)");
	
	Pattern SPLIT_N_DIRECTION = Pattern.compile("(\\d*)N(X*)");
	Pattern SPLIT_S_DIRECTION = Pattern.compile("(\\d*)S(X*)");
	Pattern SPLIT_W_DIRECTION = Pattern.compile("(\\d*)W(X*)");
	Pattern SPLIT_E_DIRECTION = Pattern.compile("(\\d*)E(X*)");
	
	/** 
	 * Coordinates Plan
	 * */
    private class Coordinates {
          public int _x = 0;
          public int _y = 0;
          
          /** 
           * Based in Pattern Command
           * */
          public int undo = 0;
          
          @Override
        public String toString() {
        	return "("+_x+","+_y+") "+ undo;
        }
          
    }

	public RobotRegex() {
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

	
	private void calculateDestination(String position) {
		Matcher m = SPLIT_GROUP.matcher(position);
		
		List<String> commands = new ArrayList<String>();
		while ( m.find() )
			commands.add(m.group());
		
		
		while ( !commands.isEmpty() ){
			String lastCmd = commands.get(commands.size()-1);
			Coordinates c = extractPoint(lastCmd);
//			System.out.println(c);
			
			/**
			 * The command is OK.
			 */
			if ( c.undo == 0 ){
				commands.remove(commands.size()-1);
				this.x += c._x;
				this.y += c._y;
			} else {
				while ( !commands.isEmpty() && c.undo > 0){
					commands.remove(commands.size()-1);
					c.undo--;
				}
			}

		}
		
		
	}

	/**
	 * These method is used to extract the magnitude value and how much undo the algorithms should do.
	 * @param cmd
	 * @return
	 */
	private Coordinates extractPoint(String cmd) {
		Coordinates c = new Coordinates();
		Matcher m;
		if ( cmd.contains("N") ){
			
			m = SPLIT_N_DIRECTION.matcher(cmd);
			if ( m.find() ){
				String yvalue = m.group(1);
				if ( !yvalue.isEmpty() ){
					c._y = Integer.parseInt(yvalue);
				} else {
					c._y = 1;
				}
				
				String undoValue = m.group(2);
				if ( !undoValue.isEmpty() ){
					c.undo = undoValue.length();
				}
			}
			
			
		} else if ( cmd.contains("S") ){
			m = SPLIT_S_DIRECTION.matcher(cmd);
			if ( m.find() ){
				String yvalue = m.group(1);
				if ( !yvalue.isEmpty() ){
					c._y = -Integer.parseInt(yvalue);
				} else {
					c._y = -1;
				}
				
				String undoValue = m.group(2);
				if ( !undoValue.isEmpty() ){
					c.undo = undoValue.length();
				}
			}
			
		} else if ( cmd.contains("E") ){
			
			m = SPLIT_E_DIRECTION.matcher(cmd);
			if ( m.find() ){
				String yvalue = m.group(1);
				if ( !yvalue.isEmpty() ){
					c._x = Integer.parseInt(yvalue);
				} else {
					c._x = 1;
				}
				
				String undoValue = m.group(2);
				if ( !undoValue.isEmpty() ){
					c.undo = undoValue.length();
				}
			}
			
		} else if ( cmd.contains("W") ){
			m = SPLIT_W_DIRECTION.matcher(cmd);
			if ( m.find() ){
				String yvalue = m.group(1);
				if ( !yvalue.isEmpty() ){
					c._x = -Integer.parseInt(yvalue);
				} else {
					c._x = -1;
				}
				
				String undoValue = m.group(2);
				if ( !undoValue.isEmpty() ){
					c.undo = undoValue.length();
				}
			}
		}
		
		return c;
	}

	private String getPoints() {
		return "(" + this.x + "," + this.y + ")";
	}

	private void validateCommandInput(String position) {

		Matcher m = INPUT_VALIDATOR.matcher(position);

		if (!m.find())
			throw new IllegalArgumentException("Invalid Command [" + position
					+ "].");

	}

	public static void main(String[] args) {
		RobotRegex chappie = new RobotRegex();

		/**
		 * Validate Wrong Letter Input Input
		 */
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("A7NS"));
//
//		/**
//		 * Validate null, empty
//		 */
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo(null));
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo(""));
//		
//		
//		
//		/**
//		 * Validate 7NXX
//		 */
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("7NXX"));
//		
		/**
		 * Validate N
		 */
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("N"));
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("N"));
		
		
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("N"));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("S"));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("E"));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("W"));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("NE"));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("SW"));
		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("ESXXN100SXE100W"));
		
		/**
		 * Valid Input
		 */
//		System.out.println(chappie.getCoordinatesToMoveFromOriginTo("EWSN10NX123NX1NS"));
		

	}

}
