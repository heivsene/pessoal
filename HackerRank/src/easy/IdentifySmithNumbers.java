package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/identify-smith-numbers
 * @author G0012477
 * Problem: Identify Smith Numbers
 * cd C:\workspace\HackerRank\bin\
 * java easy.IdentifySmithNumbers < ../resource/IdentifySmithNumbers.in
 *
 */
public class IdentifySmithNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int n = N;
		int sumDigitos = 0;
		int sumFactors = 0;
		
		calculatePrimeNumbers(N);
		
		if (true)
			System.exit(0);
		
		sumDigitos = sumDigits(n);
		
		for (int i = 2; i <= N / i; i++) {
			while (N % i == 0) {
				sumFactors += sumDigits(i);
				N /= i;
			}
		}
		if (N > 1) {
			sumFactors += sumDigits(N);
		}
		
		System.out.println((sumDigitos == sumFactors)?1:0);

		
		in.close();
	}
	
	private static void calculatePrimeNumbers(int num){
		int i=2;
		while(num>1)
		{
			System.out.println("Teste i = "+i);
			if(num%i==0)
			{
				System.out.println("termo = "+i); //Here 'i' is the prime factor of 'n' and we are finding its sum
				num=num/i;
			}
			else
				i++;
		}
	}
	
	private static int sumDigits(int numero){
		int temp = 0;
		while ( numero/10 > 0 ){
			temp += numero%10;
			numero = numero/10;
		}
		temp += numero;
		
		return temp;
	}
}
