package bitmanipulation.medium;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/and-product
 * 
 * @author G0012477
 *
 */
public class AndProduct {
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

	private static final double LOG10_2 = Math.log(2L);
	
	public static void main(String[] args) {
		
		Set<Long> base2 = new TreeSet<Long>();
		long l = 1;
		long n,m;
		int base_n, base_m;
		
		//Populando base 2
		for ( int i = 0; i < 33 ; i++ ){
			base2.add(new Long(l));
			l = l<<1;
		}

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		
		for( int a = 0; a < t; a++){
			n = in.nextLong();
			m = in.nextLong();
			
			base_n = (int) ( Math.log(n)/LOG10_2 );
			base_m = (int) ( Math.log(m)/LOG10_2 );
			
			if ( base_n == base_m )
				if ( m == n )
					System.out.println(n);
				else {
					
				}
			else {
				System.out.println(0);
			}
		}
		
		in.close();
	}

}

