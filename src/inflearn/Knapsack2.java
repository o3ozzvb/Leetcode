package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {
    static int n, m;
    static int[] dy;
    
    public static void main(String[] args){
        Knapsack2 ks2 = new Knapsack2();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        
        dy = new int[m+1];
        
        for(int i=0; i<n; i++) {
        	int s = in.nextInt();
        	int t = in.nextInt();
        	
        	for(int j=m; j>=t; j--) {
        		dy[j] = Math.max(dy[j], dy[j-t] + s);
        	}
        }
       
        System.out.println(dy[m]);
    }
}
