package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer
 * 
 * @author heivs
 *
 */
public class DesignerPDFViewer {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int[] h = new int[26];
		
		for (int h_i = 0; h_i < 26; h_i++) {
			h[h_i] = in.nextInt();
		}
		
		String word = in.next();
		int tallest = -1;
		
		byte[] byteW = word.getBytes();
		
		for (byte b : byteW) {
			if ( h[b-'a']>tallest )
				tallest =  h[b-'a'];
		}
		
		System.out.println(tallest*word.length());
		
		in.close();
	
	}

}
