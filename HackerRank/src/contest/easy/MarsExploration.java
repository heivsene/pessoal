package contest.easy;

import java.util.Scanner;

public class MarsExploration {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String S = in.next();
	        
	        int tamanho = S.length();
	        char[] array = S.toCharArray();
	        int mod = 0;
	        
	        if ( tamanho == 1 ){
	        	if ( array[0] == 'S' ) 
	        		System.out.println(2);
	        	else
	        		System.out.println(3);
	        	
	        	in.close();
	        	System.exit(0);
	        }
	        
	        mod=3;
	        if ( tamanho == 2 ){
	        	if ( array[0] == 'S' ){ 
	        		mod--;
	        	}
	        	if ( array[1] == 'O' ){ 
	        		mod--;
	        	}
	        	
	        	System.out.println(mod);
	        	in.close();
	        	System.exit(0);
	        }
	        
	        
	        mod = tamanho%3;
	        
	        for ( int i = 0; i < tamanho ; i=i+3){
	        	if ( array[i] != 'S' ){ 
	        		mod++;
	        	}
	        	if ( array[i+1] != 'O' ){ 
	        		mod++;
	        	}
	        	if ( array[i+2] != 'S' ){ 
	        		mod++;
	        	}
	        }
	        
	        System.out.println(mod);
	        in.close();
	        
	    }

}
