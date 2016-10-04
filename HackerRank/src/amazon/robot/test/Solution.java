package amazon.robot.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	
	  /**
		 * x position to the robot move. East = +1 West = -1
		 */
		static private int x = 0;

		/**
		 * x position to the robot move. North = +1 South = -1
		 */
		static private int y = 0;

	/**
		 * Pattern to validate input format.
		 * Must be a Valid Sequence.
		 * Before a N,S,W or E could have a digit.
		 * After N,S,W or E could have 0 to n 'X' character
		 * this Characters
		 */
		static Pattern INPUT_VALIDATOR = Pattern.compile("^(\\d*[NSEW]X*)*$");
		static Pattern SPLIT_GROUP = Pattern.compile("(\\d*[NSWE]X*)");

	    /**
	    * Pattern to split magnitude and undo.
	    */
		static Pattern SPLIT_N_DIRECTION = Pattern.compile("(\\d*)N(X*)");
		static Pattern SPLIT_S_DIRECTION = Pattern.compile("(\\d*)S(X*)");
		static Pattern SPLIT_W_DIRECTION = Pattern.compile("(\\d*)W(X*)");
		static Pattern SPLIT_E_DIRECTION = Pattern.compile("(\\d*)E(X*)");

	    /** 
		 * Inner Class Coordinates Plan, using the concept of Command Pattern
		 * */
	    private static class CoordinatesRobot {
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

	    /**
		 * Move the Robot to Origin (0,0)
		 */
		private static void toOrigin() {
			x = 0;
			y = 0;
		}

	    /**
		 * All comands are suposed to be calculated from Origin (0,0). All valids
		 * commands must follow these rules. Contain only these letters NSEWX
		 * uppercase Contain any number and after a number MUST be any of these
		 * letters above, and never end with a NUMBER.
		 * 
		 * 
		 * Space Complexity = O(n) , because of Array in method calculateDestination
		 * 
		 * Runtime Complexity = 2.n + c in method calculateDestination
		 * Runtime Complexity = O(n), we don't have an while inside an while, if we did then O(n^2)
		 * Runtime Complexity = because of that the answer is O(n).
		 * 
		 * @param position
		 * @return destination in format (x, y);
		 */
	    /*
	    * Complete the function below.
	    */
	    static String moveRobot(String s) {
	        toOrigin();
			
			try {
				// Validate empty command
				if (s == null || s.isEmpty()) {
					throw new IllegalArgumentException("Invalid Command ["
							+ s + "].");
				}

				// Validate the Arguments to Operate
				validateCommandInput(s);
				
				calculateDestination(s);
				

			} catch (Exception e) {
				x = 999;
				y = 999;
			}

			return getPoints();
	    }

	    private static void calculateDestination(String position) {
			Matcher m = SPLIT_GROUP.matcher(position);
			
			List<String> commands = new ArrayList<String>();
			while ( m.find() )
				commands.add(m.group());
			
			
			while ( !commands.isEmpty() ){
				String lastCmd = commands.get(commands.size()-1);
				CoordinatesRobot c = extractPoint(lastCmd);
//				System.out.println(c);
				
				/**
				 * The command is OK.
				 */
				if ( c.undo == 0 ){
					commands.remove(commands.size()-1);
					x += c._x;
					y += c._y;
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
		private static CoordinatesRobot extractPoint(String cmd) {
			CoordinatesRobot c = new CoordinatesRobot();
			Matcher m;
			if ( cmd.contains("N") ){
				
				m = SPLIT_N_DIRECTION.matcher(cmd);
				if ( m.find() ){
					String yvalue = m.group(1);
					if ( !yvalue.isEmpty() ){
						c._y = Integer.parseInt(yvalue);
						
						if ( c._y == 0 )
							throw new IllegalArgumentException("Magnitude can't be 0");
						
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
						
						if ( c._y == 0 )
							throw new IllegalArgumentException("Magnitude can't be 0");
						
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
						
						if ( c._x == 0 )
							throw new IllegalArgumentException("Magnitude can't be 0");
						
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
						if ( c._x == 0 )
							throw new IllegalArgumentException("Magnitude can't be 0");
						
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

		private static String getPoints() {
			return "(" + x + ", " + y + ")";
		}

		private static void validateCommandInput(String position) {

			Matcher m = INPUT_VALIDATOR.matcher(position);

			if (!m.find())
				throw new IllegalArgumentException("Invalid Command [" + position
						+ "].");

		}


		public static final void runTests(){
			/**
			 * Illegal
			 */
//			System.out.println(moveRobot(null));
//			System.out.println(moveRobot(""));
//			System.out.println(moveRobot("A7NS"));
			
			//MAYBE
//			System.out.println(moveRobot("7NX"));
//			System.out.println(moveRobot("7NXX"));
//			System.out.println(moveRobot("7NXXX"));
			System.out.println(moveRobot("N0W"));
			
			/**
			 * Legal
			 */
//			System.out.println(moveRobot("N"));
//			System.out.println(moveRobot("S"));
//			System.out.println(moveRobot("E"));
//			System.out.println(moveRobot("W"));
//			System.out.println(moveRobot("7NXXX"));
		}
		
		 public static void main(String[] args) throws IOException{
			 runTests();
//		        Scanner in = new Scanner(System.in);
//		        final String fileName = System.getenv("OUTPUT_PATH");
//		        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//		        String res;
//		        String _s;
//		        try {
//		            _s = in.nextLine();
//		        } catch (Exception e) {
//		            _s = null;
//		        }
//		        
//		        res = moveRobot(_s);
//		        bw.write(res);
//		        bw.newLine();
//		        
//		        bw.close();
		    }
	
}
