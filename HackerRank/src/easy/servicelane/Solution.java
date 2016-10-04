package easy.servicelane;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/service-lane
 * @author G0012477
 * Problem: Service Lane
 * cd C:\workspace\HackerRank\bin\
 * java servicelane.Solution < ../resource/ServiceLane.in
 *
 */
public class Solution {
	
	private static List<Integer> width;

	static int findCalvinVehiclesAllowed(int l, int u) {
		List<Integer> sublist = width.subList(l, u+1);
		
		if ( sublist.contains(new Integer(1)) )
			return 1;
		else if ( sublist.contains(new Integer(2)) )
			return 2;
		else 
			return 3;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length;
		int testCases;
		int lower, upper;
		
		length = in.nextInt();
		testCases = in.nextInt();
		
		width = new ArrayList<Integer>(length);
		
		for (int i = 0; i < length; i++) {
			width.add(new Integer(in.nextInt()));
		}
		
		for ( int i = 0; i < testCases ; i++){
			lower = in.nextInt();
			upper = in.nextInt();
			System.out.println(findCalvinVehiclesAllowed(lower, upper));
		}
	}
}
