package inflearn;

import java.util.Scanner;

public class Combination {

	static int[][] combi;
	
	static int answer = Integer.MAX_VALUE;
	
	public static int DFS(int n, int r) {
		/*
		System.out.println("combi");
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=r; j++) {
				System.out.print(combi[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		if(r==0 || n==r) {
			return 1;
		}
		else {
			//out.println("n :" + n + ", r : " + r);
			if(combi[n-1][r-1] == 0) { 
				combi[n-1][r-1] = DFS(n-1, r-1);
			}
			if(combi[n-1][r] == 0) {
				combi[n-1][r] = DFS(n-1,r);
			}
			return combi[n-1][r-1] + combi[n-1][r];
		}
	}
	
	public static void main(String[] args) {
		Combination c = new Combination();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int r = in.nextInt();
		
		combi = new int[n+1][r+1];
		
		System.out.println(c.DFS(n,r));
		
	}

}



