package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/song-of-pi
 * @author G0012477
 * Problem: Song Of Pi
 * cd C:\workspace\HackerRank\bin\
 * java easy.SongOfPi < ../resource/SongOfPi.in
 *
 */
public class SongOfPi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int[] pi = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,3};

		boolean achou = true;
		
		for(int i = 0; i < N; i ++) {
			achou = true;
			
			String linha = in.nextLine();
			String[] splitted = linha.split(" ");
			for ( int j = 0; j < splitted.length ; j++ ){
				int l = splitted[j].length();
				
				if ( pi[j] != l ){
					achou = false;
					break;
				}
			}
			
			if (achou){
				System.out.println("It's a pi song.");
			} else {
				System.out.println("It's not a pi song.");
			}
		}
		
		in.close();
	}
}
