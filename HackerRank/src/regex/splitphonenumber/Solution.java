package regex.splitphonenumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	private static final String INVALID = "INVALID";
	private static final String VALID = "VALID";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		Pattern p = Pattern.compile("[a-z]{0,3}[0-9]{2,8}[A-Z]{3}[A-Z]*");

		while (in.hasNext()) {
			line = in.nextLine();
			Matcher m = p.matcher(line);

			if (m.matches()) {
				System.out.println(VALID);
			} else {
				System.out.println(INVALID);
			}
		}

		in.close();
	}
}