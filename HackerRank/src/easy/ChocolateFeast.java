package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-digits
 * @author G0012477
 * Problem: Chocolate Feast
 * cd C:\workspace\HackerRank\bin\
 * java easy.ChocolateFeast < ../resource/ChocolateFeast.in
 *
 */
public class ChocolateFeast {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int i = 0; i < t; i++){
	            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
	        }
	        in.close();
	    }
	    
	    private static long Solve(int N, int C, int M){
	        int comprar = (N/C);
	        int plus = 0;
	        int troca = 0;
	        int resto = 0;
	        
	        do {
	        	troca = comprar / M;
	        	resto = comprar % M;
	        	plus += troca;
	        	
	        	if ( (troca+resto) < M ) {
	        		break;
	        	}
	        	
	        	comprar = troca+resto;
	        } while (true);
	        
	         return (N/C)+plus;
	    }
	    
}
