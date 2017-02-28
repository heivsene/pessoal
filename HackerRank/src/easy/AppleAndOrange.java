package easy;

import java.util.Scanner;

public class AppleAndOrange {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        
        int countApple = 0, countOrange = 0;
        
        for(int apple_i=0; apple_i < m; apple_i++){
            if ( isBetween(s, t, a, in.nextInt()) ){
                countApple++;
            }
        }
        
        for(int orange_i=0; orange_i < n; orange_i++){
            if ( isBetween(s,t,b,in.nextInt()) ){
                countOrange++;
             }
        }
        
        System.out.println(countApple);
        System.out.println(countOrange);
        
        in.close();
    }
    
    public static boolean isBetween(int hs, int ht, int tree, int d){
        return ((hs >= (tree+d)) && (ht <= (tree+d))); 
    }

}
