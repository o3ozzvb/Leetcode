package inflearn;

import java.util.Scanner;

public class Baduk {

	static int c;
	static int n;
	static int[] arr;
	
	static int answer = Integer.MIN_VALUE;
	static boolean flag = false;
	
	public static void DFS(int x, int w) {
		if(w > c) return;
		if(x == n) {
			if(answer < w) {
				answer = w;
			}
		}
		else {
			DFS(x+1, arr[x]+w);
			DFS(x+1, w);
		}
		
		return;
	}
	
	public static void main(String[] args) {
		Baduk b = new Baduk();
		Scanner in = new Scanner(System.in);
		
		c = in.nextInt();
		n = in.nextInt();
		arr = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
	
		if(sum < c) {
			answer = sum;
		}else {
			b.DFS(0,0);
		}
		
		System.out.println(answer);
	}

}



