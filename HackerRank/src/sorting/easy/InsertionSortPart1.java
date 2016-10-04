package sorting.easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1 </BR>
 * 
 * @author G0012477 </BR>
 * @problem Insertion Sort - Part 1 </BR>
 * cd C:\workspace\HackerRank\bin\ </BR>
 * java sorting.easy.InsertionSortPart1 < ../resource/TutorialIntro.in </BR>
 *
 */
public class InsertionSortPart1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = Integer.parseInt(in.nextLine());

		int[] ar = new int[t];
		
		String linha = in.nextLine();
		String[] splitted = linha.split(" ");

		int i = 0;
		for (String s : splitted) {
			ar[i] = Integer.parseInt(s);
			i++;
		}

		
		int last = ar[t-1];
		StringBuilder sb;
		
		for ( i = t-2 ; i >= 0 ; i-- ){
			
			int temp = ar[i];
			
			if ( temp <= last ){
				ar[i+1] = last;
				break;
			}
			
			ar[i+1] = temp;
			
			sb = new StringBuilder();
			for ( int a = 0 ; a < t ; a++ ){
				sb.append(ar[a]+" ");
			}
			System.out.println(sb.toString().trim());
			
		}
		
		sb = new StringBuilder();
		for ( int a = 0 ; a < t ; a++ ){
			sb.append(ar[a]+" ");
		}
		System.out.println(sb.toString().trim());
		

		in.close();
	}

}
