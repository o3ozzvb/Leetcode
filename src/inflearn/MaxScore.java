package inflearn;

import java.util.Scanner;

public class MaxScore {

	static int n;
	static int m;
	static int[][] arr;
	
	static int answer = Integer.MIN_VALUE;
	
	public static void DFS(int x, int score, int time) {
		if(time > m) return;
		if(x == n) {
			answer = Math.max(score, answer);
		}
		else {
			DFS(x+1, arr[x][0]+score, arr[x][1]+time);
			DFS(x+1, score, time);
		}
		
		return;
	}
	
	public static void main(String[] args) {
		MaxScore ms = new MaxScore();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n][2];
		for(int i=0; i<n; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
	
		ms.DFS(0,0,0);
		
		System.out.println(answer);
	}

}



