package regex.tweetshackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		int qtde = Integer.parseInt(line);
		Pattern p = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL );
//		Pattern p = Pattern.compile("(hackerrank");

		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < qtde ; i++ ){
			sb.append(in.nextLine());
			sb.append(System.lineSeparator());
		}
		
		Matcher m = p.matcher(sb.toString());
		
		int total = 0;
		
		while ( m.find() ){
			total++;
		}
		
		System.out.println(total);
		
		in.close();
	}
}