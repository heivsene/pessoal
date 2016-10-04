package bitmanipulation.easy;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		
		String nrc = "0CDE00001";
		
		System.out.println("valor 1 = " +Long.toString(Long.valueOf("0CDE00001",16).longValue(), 16).toUpperCase());
		
		
		if (true)
			System.exit(0);
		
		Scanner in = new Scanner(System.in);
		
		long number;
		long bitmask = 0;
		
		for ( int i = 0 ; i < 31 ; i++){
			bitmask++;
			bitmask = (bitmask<<1);
		}
		bitmask++;
		
		int T = in.nextInt();
		
		for ( int i = 0 ; i < T ; i++ ){
			number = in.nextLong();	
			System.out.println((number^bitmask));
		}
		
		in.close();
	}

}

