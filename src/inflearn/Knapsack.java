package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    static int n, m;
    static int[] dy;
    
    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        
        for(int i=0; i<n; i++) {
        	for(int j=coin[i]; j<=m; j++) {
        		dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
        	}
        }
        
        return dy[m];
    }

    public static void main(String[] args){
        Knapsack ks = new Knapsack();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int[] coin = new int[n];
        for(int i=0; i<n; i++) {
        	coin[i] = in.nextInt();
        }
        m = in.nextInt();

        dy = new int[m+1];

        System.out.println(ks.solution(coin));
    }
}
