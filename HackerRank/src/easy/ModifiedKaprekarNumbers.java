package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers
 * @author G0012477
 * Problem: Modified Kaprekar Numbers
 * cd C:\workspace\HackerRank\bin\
 * java easy.ModifiedKaprekarNumbers < ../resource/ModifiedKaprekarNumbers.in
 *
 */
public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int q = in.nextInt();
		int sumSqrt;
		long sqrt = 0;
		StringBuilder sb = new StringBuilder();
		String number;
		
//		if ( p == 1) {
//			sb.append("1 ");
//			p = 2;
//		}
		
		for ( int i = p ; i <= q ; i++ ){
			sqrt = (long)i*(long)i;
			
			number = Long.toString(sqrt);
			
			sumSqrt = findSumHalf(number);
			
			if ( i == sumSqrt ){
				sb.append(i+" ");
			}
			
		}
		
		if ( sb.length() > 0 ){
			System.out.println(sb.toString().trim());
		} else { 
			System.out.println("INVALID RANGE");
		}
		
		in.close();
	}

	private static int findSumHalf(String number) {
		System.out.println(number);
		int tamanho = number.length();
		if ( tamanho%2 != 0 ){
			tamanho++;
			number = "0"+number;
		}
		
		int l_half = (tamanho>>1); 
		int r_half = (tamanho-l_half);
		
		r_half = Integer.parseInt(number.substring(r_half));
		l_half = Integer.parseInt(number.substring(0, l_half));
		
		return r_half+l_half;
	}
	
}
