package regex.htmlattributes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		int qtde = Integer.parseInt(line);
		Pattern p = Pattern.compile("(\\d{1,3})[ -](\\d{1,3})[ -](\\d{4,10})");

		for ( int i = 0 ; i < qtde ; i++ ){
			line = in.nextLine();
			Matcher m = p.matcher(line);
			if ( m.matches() )
				System.out.println(String.format("CountryCode=%s,LocalAreaCode=%s,Number=%s", m.group(1), m.group(2), m.group(3)));
		}
		
		in.close();
	}
}