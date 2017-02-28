package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/mini-max-sum
 * 
 * @author heivs
 *
 */
public class MiniMaxSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<Long> nums = new ArrayList<Long>();
				
		nums.add(in.nextLong());
		nums.add(in.nextLong());
		nums.add(in.nextLong());
		nums.add(in.nextLong());
		nums.add(in.nextLong());
		
		Collections.sort(nums);
		
		long min=0,max=0;
		
		for ( int i = 0; i < 5 ; i++ ){
			if ( i < 4 ) {
				min += nums.get(i);
			}
			
			if ( i > 0 ) {
				max += nums.get(i);
			}
		}

		System.out.println(min + " " + max);
		
		in.close();

	}

}
