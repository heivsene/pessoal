package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/halloween-party
 * @author G0012477
 * Problem: Halloween Party
 * cd C:\workspace\HackerRank\bin\
 * java easy.HalloweenParty < ../resource/HalloweenParty.in
 *
 */
public class HalloweenParty {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t; //Number of Test Cases

        t = in.nextInt();
        
        for ( int i = 0 ; i < t ; i++ ){
        	int K = in.nextInt();
        	System.out.println(K);
        	System.out.println(K>>1);
        	
        	System.out.println((K>>1)+(K%2));

   			System.out.println((long)((long)(K>>1))*(long)((K>>1)+(K%2)));
        }

        System.out.println(Integer.MAX_VALUE);
        
        in.close();
	}

}
