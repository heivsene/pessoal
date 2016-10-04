package easy;

import java.util.Scanner;

import com.sun.corba.se.impl.ior.ByteBuffer;

/**
 * https://www.hackerrank.com/challenges/find-digits
 * @author G0012477
 * Problem: Find Digits
 * cd C:\workspace\HackerRank\bin\
 * java easy.FindDigits < ../resource/FindDigits.in
 *
 */
public class FindDigits {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t; //Number of Test Cases

        t = in.nextInt();
        
        for ( int i = 0 ; i < t ; i++ ){
        	long K = in.nextLong();
        	
        	String S = Long.toString(K);
        	char[] array = S.toCharArray();
        	
        	int cont = 0;
        	for (char c : array) {
        		if ( c != '0' ) {
        			if ( (K % (((int)c)-48)) == 0 )
        					cont++;
        		}
			}
        	
        	System.out.println(cont);
        }
        
        in.close();
	}

}
