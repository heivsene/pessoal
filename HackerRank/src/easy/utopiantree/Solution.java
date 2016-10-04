package easy.utopiantree;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/utopian-tree
 * @author G0012477
 * Problem: Utopian Tree
 * cd C:\workspace\HackerRank\bin\
 * java utopiantree.Solution < ../resource/UtopianTree.in
 *
 */
public class Solution {

	static int solveSizeOfTree(int n) {
        
		//Solução do Fórum
		//return (~(~1<<(n>>1)) << n%2);
		
		return (int) (((int)Math.pow(2, (int)(n/2)+1)-1)*((int)Math.pow(2, (int)n%2)));
    }

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int t;
        int size;
        int a;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextInt();
            size = solveSizeOfTree(a);
            System.out.println(size);
        }
    }
	
}