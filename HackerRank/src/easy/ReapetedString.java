package easy;

import java.util.Scanner;

public class ReapetedString {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        long n = in.nextLong();
	        
	        long qtdeRemainder = 0, qtdeTotal = 0, sizeWord = 0, posRemainder = 0;
	        
	        sizeWord = s.length();
	        posRemainder = n%sizeWord;
	        
	        byte[] b = s.getBytes();
	        
	        for ( long i = 0; i < posRemainder ; i++ ){
	            if ( b[(int) i] == 'a' )
	                qtdeRemainder++;
	        }
	        
	        qtdeTotal += qtdeRemainder;
	        
	        for ( long i = posRemainder; i < sizeWord ; i++ ){
	            if ( b[(int) i] == 'a' )
	                qtdeTotal++;
	        }
	        
	        System.out.println((n/sizeWord)*qtdeTotal+qtdeRemainder);
	        
	        in.close();
	        
	    }

}
