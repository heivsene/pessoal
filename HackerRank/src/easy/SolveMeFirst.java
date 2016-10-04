package easy;
import java.io.*;
import java.util.*;

/**
 * 
 * @author G0012477
 * cd C:\workspace\HackerRank\bin
 * java easy.SolveMeFirst < ../resource/SolveMeFirst.in
 */
class SolveMeFirst {

    static int solveMeSecond(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        int sum;
        int a,b;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextInt();
            b = in.nextInt();
            sum = solveMeSecond(a, b);
            System.out.println(sum);
        }
    }
}
