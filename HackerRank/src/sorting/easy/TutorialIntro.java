package sorting.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tutorial-intro </BR>
 * 
 * @author G0012477 </BR>
 * @problem Intro to Tutorial Challenges </BR>
 * cd C:\workspace\HackerRank\bin\ </BR>
 * java sorting.easy.TutorialIntro < ../resource/TutorialIntro.in </BR>
 *
 */
public class TutorialIntro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = Integer.parseInt(in.nextLine());
		int size = Integer.parseInt(in.nextLine());

		List<Integer> arrayList = new ArrayList<Integer>(size);
		
		String linha = in.nextLine();
		String[] splitted = linha.split(" ");

		for (String s : splitted) {
			arrayList.add(Integer.parseInt(s));
		}

		System.out.println(arrayList.indexOf(new Integer(t)));

		in.close();

	}

}
