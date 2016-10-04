package easy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/manasa-and-stones
 * 
 * @author G0012477
 * Problem: ACM ICPC Team
 * cd C:\workspace\HackerRank\bin\
 * java easy.ACMICPCTeam < ../resource/ACMICPCTeam.in
 *
 */
public class ACMICPCTeam {
	
	public static BitSet createBitset(final String input){
	    final int length = input.length();
	    final BitSet bitSet = new BitSet(length);
	    for(int i = length - 1; i >= 0; i--){
	        // anything that's not a 1 is a zero, per convention
	        bitSet.set(i, input.charAt(i) == '1');
	    }
	    return bitSet;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int t;
        
        String line = in.nextLine();
        String[] splited = line.split(" ");
        
        t = Integer.parseInt(splited[0]);
        n = Integer.parseInt(splited[1]);
        
        List<BitSet> bitsets = new ArrayList<BitSet>();
        
        for ( int i = 0 ; i < t ; i++ ){
        	String input = in.nextLine();
        	BitSet b = createBitset(input);
        	bitsets.add(b);
        	
        }
        
        BitSet a,b;
        int actual, previous, sum;
        int count, know;
        int or;
        
        actual = 0;
        previous = 0;
        sum = 0;
        
        for ( int i = 0 ; i < bitsets.size()-1 ; i++ ){
        	a = bitsets.get(i);
        	for ( int j = i+1 ; j < bitsets.size() ; j++ ){
        		know = 0;
            	b = bitsets.get(j);
//            	System.out.println("["+i+" , "+j+"]"+"( "+a+" , "+b+" )");
            	BitSet c = (BitSet)a.clone();
            	c.or(b);
            	
            	know = c.cardinality();
            	if ( know > actual ){
            		actual = know;
            		sum = 1;
            	} else if ( know == actual ){
            		sum++;
            	}
            }
        }
        
        System.out.println(actual);
        System.out.println(sum);
        
        in.close();
    }

}
