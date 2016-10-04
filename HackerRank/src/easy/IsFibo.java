package easy;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/is-fibo
 * @author G0012477
 * Problem: Identify Smith Numbers
 * cd C:\workspace\HackerRank\bin\
 * java easy.IdentifySmithNumbers < ../resource/IdentifySmithNumbers.in
 *
 */
public class IsFibo {

	private static SortedSet<Long> fibonacci = new TreeSet<Long>();
	
	public static void main(String[] args) {
		
		Long[] array = {0L,1L,2L,3L,5L,8L,13L,21L,34L,55L,89L,144L,233L,377L,610L,
				987L,1597L,2584L,4181L,6765L,10946L,17711L,28657L,46368L,75025L,
				121393L,196418L,317811L,514229L,832040L,1346269L,2178309L,3524578L,
				5702887L,9227465L,14930352L,24157817L,39088169L,63245986L,102334155L,
				165580141L,267914296L,433494437L,701408733L,1134903170L,1836311903L,
				2971215073L,4807526976L,7778742049L,12586269025L,20365011074L,32951280099L,
				53316291173L,86267571272L,139583862445L,225851433717L,365435296162L,
				591286729879L,956722026041L,1548008755920L};
		
		for (Long l : array) {
			fibonacci.add(l);
		}
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long num;
		
		for ( int i = 0; i < N; i++ ){
			num = in.nextLong();
			
			if ( fibonacci.contains(new Long(num))){
				System.out.println("IsFibo");
			} else {
				System.out.println("IsNotFibo");
			}
		}
		
		in.close();
	}
	
}
