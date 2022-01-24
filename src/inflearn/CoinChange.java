package inflearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinChange {

	static int n;
	static int m;
	static Integer[] arr;
	
	static int answer = Integer.MAX_VALUE;
	
	public static void DFS(int coin, int sum) {
		if(coin > answer) return;
		if(sum > m) return;
		if(sum == m) {
			answer = Math.min(coin, answer);
		}
		else {
			for(int i=0; i<n; i++) {
				DFS(coin+1, sum+arr[i]);
			}
		}
		
		return;
	}
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		arr = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		m = in.nextInt();
		
		Arrays.sort(arr, Collections.reverseOrder());
		cc.DFS(0,0);
		
		System.out.println(answer);
	}

}



