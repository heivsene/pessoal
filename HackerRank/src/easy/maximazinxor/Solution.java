package easy.maximazinxor;

import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/maximizing-xor
 * @author G0012477
 * Problem: Maximizing XOR
 * cd C:\workspace\HackerRank\bin\
 * java maximazinxor.Solution < ../resource/MaximizingXOR.in
 *
 */
public class Solution {
	
	static int maxXor(int l, int r) {

		return 0;

    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);

	}

}
