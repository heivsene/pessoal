package easy.cutthesticks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks
 * 
 * @author G0012477 
 * Problem: Cut the sticks
 * cd C:\workspace\HackerRank\bin\
 * java cutthesticks.CutTheSticks < ../resource/CutTheSticks.in
 */
public class CutTheSticks {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);

		int n = Integer.parseInt(in.nextLine());

		String next = in.nextLine();
		String[] next_split = next.split(" ");
		List<Integer> lista = new ArrayList<Integer>();
		Set<Integer> keys = new HashSet<Integer>();

		for (int _a_i = 0; _a_i < n; _a_i++) {
			int t = Integer.parseInt(next_split[_a_i]);
			lista.add(t);
			keys.add(t);
		}


		solve(lista, keys );
		
	}

	private static void adicionarInteiro(int valor) {
				
	}

	private static void solve(List<Integer> lista, Set<Integer> keys) {
		List<Integer> unique = new ArrayList<Integer>();
		unique.addAll(keys);
		Collections.sort(unique);
		
		
		System.out.println( lista.size() );
		
		for (Integer pos : unique) {
			while ( lista.remove( pos ) );
			
			if ( lista.size() == 0)
				break;
			System.out.println( lista.size() );
		}
		
	}

}



