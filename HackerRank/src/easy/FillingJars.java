package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/filling-jars
 * @author G0012477
 * Problem: Chocolate Feast
 * cd C:\workspace\HackerRank\bin\
 * java easy.FillingJars < ../resource/FillingJars.in
 *
 */
public class FillingJars {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        
	        String line = in.nextLine();
	        String[] s = line.split(" ");
	        long T = Long.parseLong(s[1]);
	        long P = Long.parseLong(s[0]);
	        long a, b, k;
	        long total = 0;
	        
	        for(long i = 0; i < T; i++){
	        	line = in.nextLine();
		        s = line.split(" ");
		        a = Long.parseLong(s[0]);
		        b = Long.parseLong(s[1]);
		        k = Long.parseLong(s[2]);
		        
		        total += (b-a+1)*k;
	        }
	        
	        System.out.println(total/P);
	        in.close();
	    }
}
