package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-gcd
 * 
 * @author G0012477
 * Problem: Sherlock And GDC
 * cd C:\workspace\HackerRank\bin\
 * java easy.SherlockAndGDC < ../resource/SherlockAndGDC.in
 * 
 * GDC(a,b,c,d) = GDC(GDC(GDC(a,b),c),d);
 *
 */
public class SherlockAndGDC {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T, size;
        
        String line = in.nextLine();
        
        T = Integer.parseInt(line);
        
        Set<Integer> a_num = new HashSet<Integer>();
        
        for ( int i = 0 ; i < T ; i++ ){
        	a_num.clear();
        	line = in.nextLine();
        	size = Integer.parseInt(line);
        	
        	line = in.nextLine();
        	
        	if ( size < 2 ) {
        		System.out.println("NO");
        		continue;
        	}
        	
        	String[] splitted = line.split(" ");        	
        	for ( int j = 0; j < size; j++){
        		a_num.add(Integer.parseInt(splitted[j]));
        	}
        	
        	if ( a_num.size() < 2 ) {
        		System.out.println("NO");
        		continue;
        	}
        	
        	List<Integer> a_set = new ArrayList<Integer>(a_num);
        	int v_b = a_set.remove(1);
        	int v_a = a_set.remove(0);
			
			if ( recursiveGDC(a_set, v_a , v_b) == 1 ){
        		System.out.println("YES");
        	} else {
        		System.out.println("NO");
        	}
        	
        }
        
        in.close();
    }
    
    
    private static int recursiveGDC(List<Integer> a_set, int num1, int num2) {
    	if ( a_set.size() < 1 ) {
    		return findGCD(num1, num2);
    	} else {
        	int v_a = a_set.remove(0);
    		return recursiveGDC(a_set, findGCD(num1, num2), v_a);
    	}
	}


	/*
     * Java method to find GCD of two number using Euclid's method
     * @return GDC of two numbers in Java
     */
    private static int findGCD(int number1, int number2) {
//    	System.out.println("findGDC( " + number1 + " , " + number2 + " )");
        //base case
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }

}
