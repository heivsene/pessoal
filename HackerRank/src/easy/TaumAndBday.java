package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/taum-and-bday
 * 
 * @author G0012477
 * Problem: ACM ICPC Team
 * cd C:\workspace\HackerRank\bin\
 * java easy.TaumAndBday < ../resource/TaumAndBday.in
 *
 */
public class TaumAndBday {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T;
        long X, Y, Z, _x, _y;
        
        String line = in.nextLine();
        
        T = Integer.parseInt(line);
        
        for ( int i = 0 ; i < T ; i++ ){
        	line = in.nextLine();
        	String[] splitted = line.split(" ");
        	long B = Long.parseLong(splitted[0]);
        	long W = Long.parseLong(splitted[1]);
        	
        	
        	line = in.nextLine();
        	splitted = line.split(" ");
        	X = Long.parseLong(splitted[0]);
        	Y = Long.parseLong(splitted[1]);
        	Z = Long.parseLong(splitted[2]);
        	
        	// cost of black to white
        	if ( (X+Z) < Y ){
        		_y = (X+Z);
        	} else {
        		_y = Y;
        	}
        	
        	// cost of white to black
        	if ( (Y+Z) < X ){
        		_x = (Y+Z);
        	} else {
        		_x = X;
        	}
        	
        	System.out.println((B*_x+W*_y));
        }
        in.close();
    }

}
