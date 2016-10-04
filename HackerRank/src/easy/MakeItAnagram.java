package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class MakeItAnagram {
	
	static final List<Character> alphabet = new ArrayList<Character>();
	
	static {
		for (char c : "abcdefghijklmnopqrstuvxyzw".toCharArray()) {
			alphabet.add(Character.valueOf(c));
		}
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

		List<Character> listaUm = new ArrayList<Character>();
		List<Character> listaDois = new ArrayList<Character>();
		
		for (char c : a.toCharArray()) {
			listaUm.add(Character.valueOf(c));
		}
		
		for (char c : b.toCharArray()) {
			listaDois.add(Character.valueOf(c));
		}
		
		long soma = 0;
		
		for (Character c : alphabet) {
			soma += Math.abs(Collections.frequency(listaUm, c) - Collections.frequency(listaDois, c));
		}
		
		System.out.println(soma);
		
		in.close();
	}
}
