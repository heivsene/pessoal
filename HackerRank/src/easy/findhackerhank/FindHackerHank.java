package easy.findhackerhank;

import java.util.Scanner;

public class FindHackerHank {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nLines;
		String phrase;

		nLines = Integer.parseInt(in.nextLine());
		

		for (int i = 0; i < nLines; i++) {
			phrase = in.nextLine();
			boolean comeca = phrase.startsWith("hackerrank");
			boolean termina = phrase.endsWith("hackerrank");

			if (comeca && termina)
				System.out.println("0");
			else if (comeca)
				System.out.println("1");
			else if (termina)
				System.out.println("2");
			else
				System.out.println("-1");
		}
		
		in.close();
	}
}
