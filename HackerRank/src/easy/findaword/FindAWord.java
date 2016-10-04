package easy.findaword;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nLines;
		String phrase;

		nLines = Integer.parseInt(in.nextLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder();

		for (int i = 0; i < nLines; i++) {
			phrase = in.nextLine();
			sb.append(phrase);
		}
		
		nLines = Integer.parseInt(in.nextLine());
		for (int i = 0; i < nLines; i++) {
			phrase = in.nextLine();
			word.append(phrase);
			if ( i < nLines-1)
				word.append("|");
		}
		
		String procurar = word.toString();
		Pattern p = Pattern.compile("^("+procurar+")$");
		String[] splited = sb.toString().split("\\W");
		
		int count = 0;
		for (String sp : splited) {
			String trimmed = sp.trim();
			if ( !trimmed.isEmpty() ) {
				Matcher m = p.matcher(sp);
				if ( m.matches() )
					count++;
			}
			
		}
		
		System.out.println(count);
		
		in.close();
	}
}
