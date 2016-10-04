package easy.thelovelettermystery;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 * @author G0012477
 * Problem: The Love-Letter Mystery
 * cd C:\workspace\HackerRank\bin\
 * java thelovelettermystery.Solution < ../resource/TheLoveLetterMystery.in
 *
 */
public class Solution {
	
	private static final int calculateMinOperation(String in){
		int max, min, operation = 0 ;
		char[] word = in.toCharArray();
		
		max = word.length-1;
		min = 0;
		
		while ( max > min ){
			operation += Math.abs((word[max]-word[min]));
			max--;
			min++;
		}
		
		
		return operation;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		
		t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			System.out.println(calculateMinOperation(in.next()));
		}
		
		in.close();
	}

}
