package bitmanipulation.medium;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sansa-and-xor
 * 
 * @author G0012477
 *
 */
public class SansaAndXor {
	static final void calcularXor(int[] a){
		if ( a.length % 2 == 0 ){
			System.out.println("0");
		} else {
			int temp = 0;
			for ( int i = 0 ; i < a.length ; i += 2){
				temp = temp ^ a[i];
			}
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
//		calcularXor(new int[]{1,2,3});
//		calcularXor(new int[]{1});
		
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());

		String linha;
		String[] distances;
		int[] d;
		
		for( int a = 0; a < t; a++){
			linha = in.nextLine(); // Ignora size
			linha = in.nextLine();
			distances = linha.split(" ");
			d = new int[distances.length];
			
			for ( int b = 0 ; b < distances.length; b++ ){
				d[b] = Integer.parseInt(distances[b]);
			}
			calcularXor(d);
		}
		
		in.close();
	}

}

