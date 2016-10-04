package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/taum-and-bday
 * 
 * @author G0012477
 * Problem: Sherlock And Squares
 * cd C:\workspace\HackerRank\bin\
 * java easy.SherlockAndSquares < ../resource/SherlockAndSquares.in
 *
 */
public class SherlockAndSquares {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T;
        long A, B, _x, _y;
        
        String line = in.nextLine();
        
        T = Integer.parseInt(line);
        
        for ( int i = 0 ; i < T ; i++ ){
        	line = in.nextLine();
        	String[] splitted = line.split(" ");
        	A = Long.parseLong(splitted[0]);
        	B = Long.parseLong(splitted[1]);
        	
        	_x = (int) Math.ceil(Math.sqrt(A));
        	_y = (int) Math.floor(Math.sqrt(B));
        	
        	/**
        	System.out.println(_x);
        	System.out.println(_y);
        	System.out.println(_y-_x);
        	*/
        	
        	if ( (_y-_x) == 0 ){
        		
        		if ( (long)(_x*_x) <= B ) {
        			System.out.println("1");
        		} else {
        			System.out.println("0");
        		}
        		
        	} else {
        		System.out.println(_y-_x+1);	
        	}
        	
        	
        }
        in.close();
    }

}
