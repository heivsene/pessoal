package amazon.interview.histogram;

import java.util.Stack;

public class Histogram {
	
	static Stack<Integer> s_positions = new Stack<Integer>();
	static Stack<Integer> s_heights = new Stack<Integer>();
	
	public static void main(String[] args) {
		
		int histogram[] = {1,3,2,1,2};
		
		int area = 0;
		
		area = findLargestRectangule(histogram);
		
		System.out.println("Area of the largest rectangule is: ["+area+"] u.a.");
		
	}

	private static int findLargestRectangule(int[] histogram) {
		int maxArea = -1; // Doesn't not exists negative area, so anything should be greater than -1.
		int position = 0;
		int localHeight = 0;
		int tempHeight, tempPosition = position, tempArea = -1;
		
		for ( ; position < histogram.length; position++ ){
			//Acquiring local height.
			localHeight = histogram[position];
			
			if ( s_heights.isEmpty() || localHeight > s_heights.get(s_heights.size()-1) ){
				s_heights.push(localHeight);
				s_positions.push(position);
			}

			// If the localHeigh is less than the top element.
			else if (localHeight < s_heights.get(s_heights.size()-1) ) {
				// While this condition is true, then pop the top elemente out of the stack.				
				while ( !s_heights.isEmpty() && localHeight < s_heights.get(s_heights.size()-1) ){
					tempHeight   = s_heights.pop();
					tempPosition = s_positions.pop();
					tempArea = tempHeight * (position - tempPosition);
					maxArea = Math.max(maxArea, tempArea);
				}
				s_heights.push(localHeight);
				s_positions.push(tempPosition);				
			}
		}
		
		// While this condition is true, then pop the top elemente out of the stack.				
		while ( !s_heights.isEmpty() ){
			tempHeight   = s_heights.pop();
			tempPosition = s_positions.pop();
			tempArea = tempHeight * (position - tempPosition);
			maxArea = Math.max(maxArea, tempArea);
		}
		
		return maxArea;
	}

}
