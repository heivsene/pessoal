package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-time-in-words
 * @author G0012477
 * Problem: The Time In Words
 * cd C:\workspace\HackerRank\bin\
 * java easy.TheTimeInWords < ../resource/TheTimeInWords.in
 *
 */
public class TheTimeInWords {

	private static Map<Integer,String> hour;
	private static Map<Integer,String> minute;

	public static String calculateHour(int h, int m){
		
		if ( m == 0 ){
			return hour.get(h) + " o' clock";
		}
		
		if ( m == 30 ){
			return "half past "+hour.get(h);
		}
		
		if ( m == 15 ){
			return "quarter past "+hour.get(h);
		}
		
		if ( m == 45 ){
			return "quarter to "+hour.get(h+1);
		}
		
		if ( m < 30 )
			return minute.get(m) + hour.get(h);
		
		return minute.get(m) + hour.get(h+1);
		
	}
	
	public static void main(String[] args) {
		hour = new HashMap<Integer,String>();
		minute = new HashMap<Integer,String>();
		hour.put(1,"one");
		hour.put(2,"two");
		hour.put(3,"three");
		hour.put(4,"four");
		hour.put(5,"five");
		hour.put(6,"six");
		hour.put(7,"seven");
		hour.put(8,"eight");
		hour.put(9,"nine");
		hour.put(10,"ten");
		hour.put(11,"eleven");
		hour.put(12,"twelve");
		hour.put(13,"one");
		
		minute.put(1,"one minute past ");
		minute.put(2,"two minutes past ");
		minute.put(3,"three minutes past ");
		minute.put(4,"four minutes past ");
		minute.put(5,"five minutes past ");
		minute.put(6,"six minutes past ");
		minute.put(7,"seven minutes past ");
		minute.put(8,"eight minutes past ");
		minute.put(9,"nine minutes past ");
		minute.put(10,"ten minutes past ");
		minute.put(11,"eleven minutes past ");
		minute.put(12,"twelve minutes past ");
		minute.put(13,"thirteen minutes past ");
		minute.put(14,"fourteen minutes past ");
		minute.put(16,"sixteen minutes past ");
		minute.put(17,"seventeen minutes past ");
		minute.put(18,"eighteen minutes past ");
		minute.put(19,"nineteen minutes past ");
		minute.put(20,"twenty minutes past ");
		minute.put(21,"twenty one minutes past ");
		minute.put(22,"twenty two minutes past ");
		minute.put(23,"twenty three minutes past ");
		minute.put(24,"twenty four minutes past ");
		minute.put(25,"twenty five minutes past ");
		minute.put(26,"twenty six minutes past ");
		minute.put(27,"twenty seven minutes past ");
		minute.put(28,"twenty eigth minutes past ");
		minute.put(29,"twenty nine minutes past ");
		
		minute.put(59,"one minute to ");
		minute.put(58,"two minutes to ");
		minute.put(57,"three minutes to ");
		minute.put(56,"four minutes to ");
		minute.put(55,"five minutes to ");
		minute.put(54,"six minutes to ");
		minute.put(53,"seven minutes to ");
		minute.put(52,"eight minutes to ");
		minute.put(51,"nine minutes to ");
		minute.put(50,"ten minutes to ");
		minute.put(49,"eleven minute to ");
		minute.put(48,"twelve minutes to ");
		minute.put(47,"thirteen minutes to ");
		minute.put(46,"fourteen minutes to ");
		minute.put(44,"sixteen minutes to ");
		minute.put(43,"seventeen minutes to ");
		minute.put(42,"eighteen minutes to ");
		minute.put(41,"nineteen minutes to ");
		minute.put(40,"twenty minutes to ");
		minute.put(39,"twenty one minute to ");
		minute.put(38,"twenty two minutes to ");
		minute.put(37,"twenty three minutes to ");
		minute.put(36,"twenty four minutes to ");
		minute.put(35,"twenty five minutes to ");
		minute.put(34,"twenty six minutes to ");
		minute.put(33,"twenty seven minutes to ");
		minute.put(32,"twenty eight minutes to ");
		minute.put(31,"twenty nine minutes to ");
		
//		testCases();
		
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		
		System.out.println(calculateHour(h, m));
		
		in.close();
	}

	private static void testCases() {
		System.out.println(calculateHour(0, 0));
		System.out.println(calculateHour(1, 0));
		System.out.println(calculateHour(2, 0));
		System.out.println(calculateHour(3, 0));
		System.out.println(calculateHour(4, 0));
		System.out.println(calculateHour(5, 0));
		System.out.println(calculateHour(6, 0));
		System.out.println(calculateHour(7, 0));
		System.out.println(calculateHour(8, 0));
		System.out.println(calculateHour(9, 45));
		System.out.println(calculateHour(12, 40));
	}

}
