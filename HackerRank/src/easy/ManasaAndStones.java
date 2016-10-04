package easy;

import java.util.Scanner;

/**
 * {@link https://www.hackerrank.com/challenges/manasa-and-stones}</br>
 * </br>
 * @author G0012477 </br>
 * @Problem Manasa and Stones </br>
 * @run cd C:\workspace\HackerRank\bin\ </br>
 * java easy.ManasaAndStones < ../resource/ManasaAndStones.in </br>
 * </br>
 * @Explanation
 * The first stone is numbered 0, and from then on, the numbers on the stones have a difference of either a or b.</br>
 * When a equals b, there is only one possible value for the last stone, which is (n-1)×a.</br>
 * When a does not equal b:</br>
 * (Store the bigger number in a and the smaller in b)</br>
 * Now, the second stone can have the values - a or b. The third stone can have values 2a, a+b, or 2b.</br> 
 * The fourth stone can have values 3a, 2a+b, 2b+a, or 3b </br>
 * The fifth stone can have values 4a, 3a+b, 2a+2b, 3b+a, or 4b, and so on.</br> 
 * Now, consider the coefficients of a and b (let us call them c_a,c_b) in all the possible numbers for the ith stone.</br> 
 * As it is clear, they are such that c_a+c_b=i-1 . </br>
 * For example, when i=5, the coefficients of a and b in each of the possibilities are - (0, 4), (1,3),(2,2),(3,1), or (4,0).</br> 
 * Each pair adds up to 4, which is i-1. </br>
 * Thus, to find the possible values on the nth stone, our problem reduces to finding all the values of c_a * a + c_a * b such that c_a+c_b = n-1.</br> 
 * In order to do this, we just have to run a for loop over the range [0,n-1] and add the value i×a+(n-1-i)×b (call this val) to the list of the values. As we can see, the difference is the values of val between two iterations is a-b. Since a>b, we can see that the list of values will always be increasing and distinct. Thus, we can print the value in each iteration as one of the possibilities for the number on the last stone.</br>
 * 
 */
public class ManasaAndStones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, a, b;
		int t;
		t = Integer.parseInt(in.nextLine());

		for (int i = 0; i < t; i++) {

			n = Integer.parseInt(in.nextLine());
			a = Integer.parseInt(in.nextLine());
			b = Integer.parseInt(in.nextLine());

			solve(n, (a > b) ? b : a, (a > b) ? a : b);
		}

		in.close();
	}

	private static void solve(int n, int a, int b) {
		StringBuilder sb = new StringBuilder();

		long value = 0;

		/**
		 * Edge situation when a = b. Then all iterations will be the same.
		 */
		for (int i = (a == b ? (n - 1) : 0); i < n; i++) {
			value = (((n - 1 - i) * a) + (i * b));
			sb.append(value + " ");
		}

		System.out.println(sb.toString().trim());
	}

}
