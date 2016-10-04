package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/min-max
 * @author G0012477
 * Problem: Min Max
 * cd C:\workspace\HackerRank\bin\
 * java easy.MinMax < ../resource/MinMax.in
 *
 */
public class MinMax {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int K = Integer.parseInt(in.nextLine());
		List<Integer> lista = new ArrayList<Integer>();

		for(int i = 0; i < N; i ++)
			lista.add(Integer.parseInt(in.nextLine()));

		Collections.sort(lista);

		// 2 147 483 647 
		int unfairness = Integer.MAX_VALUE;

		/*
		 * Write your code here, to process numPackets N, numKids K, and the packets of candies
		 * Compute the ideal value for unfairness over here
		 */
		int temp = 0;
		for ( int i = 0 ; i < lista.size() - K ; i++ ) {
			temp = (lista.get(K+i-1)-lista.get(i));
			if ( temp == 0 ){
				unfairness = 0;
				break;
			} else if ( temp < unfairness ) {
				unfairness = temp;
			}
		}

		System.out.println(unfairness);
		in.close();
	}
}
