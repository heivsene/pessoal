package datastructures.hard;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/direct-connections
 * @author G0012477
 *
 */
public class DirectConnections {
	private static final int MODULOS = 1000000007;
	
	public static void main(String[] args) {
		
		if (true ){
			int a = 0;
			a = 10;
			a += 5;
			a += 12;
			a += 13;
			System.out.println(a%7);
			a = 10%7;
			a += 5%7;
			a += 12%7;
			a += 13%7;
			System.out.println(a%7);
			System.exit(0);
		}
		
		//executeTestsCases();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] skyscrappers = new int[t];

		String linha;
		String[] distances;
		String[] citiePop;
		int[] d;
		int[] p;
		
		for( int a = 0; a < t; a++){
			linha = in.nextLine(); // Ignora size
			linha = in.nextLine();
			distances = linha.split(" ");
			linha = in.nextLine();
			citiePop = linha.split(" ");
			
			d = new int[citiePop.length];
			p = new int[citiePop.length];
			for ( int b = 0 ; b < citiePop.length; b++ ){
				d[b] = Integer.parseInt(distances[b]);
				p[b] = Integer.parseInt(citiePop[b]);
			}
			
			System.out.println(calculateAmountOfCables(d, p));
			
		}
		
		in.close();

	}

	private static void executeTestsCases() {
		System.out.println(calculateAmountOfCables(new int[]{1,3,6}, new int[]{10,20,30}));
		System.out.println(calculateAmountOfCables(new int[]{5,55,555,55555,555555}, new int[]{3333,333,333,33,35}));
		
	}

	private static long calculateAmountOfCables(int[] distance, int[] population) {
		long response = 0;
		
		for ( int i = 0 ; i < distance.length ; i++ ){
			for ( int j = i+1 ; j < distance.length ; j++ ) {
				long km = Math.abs(distance[i]-distance[j]);
				long pop = 0;
				if ( population[i]>=population[j] ){
					pop = population[i];
				} else {
					pop = population[j];
				}
				response += km*pop;
				response = response%MODULOS;
			}
		}
		
		return response%MODULOS;
	}

}
