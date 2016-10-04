package easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 * @author G0012477
 * Problem: Utopian Tree
 * cd C:\workspace\HackerRank\bin\
 * java easy.AngryProfessor < ../resource/AngryProfessor.in
 *
 */
public class AngryProfessor {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t; //Number of Test Cases

        t = Integer.parseInt(in.nextLine());
        
        for ( int i = 0 ; i < t ; i++ ){
        	String next = in.nextLine();
    		String[] next_split = next.split(" ");

    		//Number of students in class
    		int minStudents = Integer.parseInt(next_split[1]);
    		
    		next = in.nextLine();
    		next_split = next.split(" ");
    		
    		for (String token : next_split) {
				int arrival = Integer.parseInt(token);
				
				if ( arrival <= 0 ) {
					minStudents--;
				}
				
				if ( minStudents == 0 )
					break;
			}
    		
    		if ( minStudents > 0 )
    			System.out.println("YES");
    		else
    			System.out.println("NO");
    		
        }
        
        in.close();
	}

}
