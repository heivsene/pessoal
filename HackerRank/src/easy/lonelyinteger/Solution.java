package easy.lonelyinteger;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lonely-integer
 * 
 * @author G0012477 
 * Problem: Lonely Integer 
 * cd C:\workspace\HackerRank\bin\
 * java lonelyinteger.Solution < ../resource/LonelyInteger.in
 */
public class Solution {

	static int lonelyinteger(int[] v, int size) {
		
		int resposta = 0;
		
		// A XOR A = 0
		// A XOR 0 = A
		// A XOR 4 XOR A = 4;
		
		for (int i = 0; i < size; i++) {
			resposta = v[i];
		}
		
		
//		int resposta = v[0];
//		int j = 1;
//		boolean achou = false;
//		
//		for (int i = 0; i < size; ) {
//			if ( v[i] != -1){
//				for ( ; j < size; j++) {
//					if ( v[i] == v[j] ) {
//						v[i] = v[j] = -1;
//						achou = true;
//						break;
//					} 
//				}
//
//				if ( achou ) {
//					achou = false;
//				} else {
//					return v[i];
//				}
//			} 
//			
//			j = (++i)+1;
//		}
		
		return resposta;
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(in.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = in.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyinteger(_a, _a_size);
		System.out.println(res);

	}

}
