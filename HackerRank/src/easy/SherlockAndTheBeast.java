package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 * 
 * @author G0012477
 * Problem: Sherlock And The Beast
 * cd C:\workspace\HackerRank\bin\
 * java easy.SherlockAndTheBeast < ../resource/SherlockAndTheBeast.in
 *
 */
public class SherlockAndTheBeast {
	
    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int T, A, div, mod;
        
        String line = in.nextLine();
        T = Integer.parseInt(line);
        
        StringBuilder sb;
        
        for ( int i = 0 ; i < T ; i++ ){
        	sb = new StringBuilder();
        	line = in.nextLine();
            A = Integer.parseInt(line);
            
            int pivot = getPivot(A);
            
            if ( pivot < 0 ){
            	System.out.println("-1");
            } else {
            	int repeat = pivot / 3;
            	while ( repeat-- != 0 ){
            		sb.append("555");
            	}
            	
            	repeat = (A-pivot)/5;
            	while ( repeat-- != 0 ){
            		sb.append("33333");
            	}
            	
            	System.out.println(sb.toString());
            }
            
        }
        
        in.close();
    }

	private static int getPivot(int a) {
		while ( a > 0 ) {
			if ( a % 3 == 0 )
				break;
			
			a -= 5;
		}
		
		return a;
	}

}
