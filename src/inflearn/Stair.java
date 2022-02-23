package inflearn;

import java.util.Scanner;

public class Stair {
	public static void main(String[] args) {
		Stair s = new Stair();
		Scanner in = new Scanner(System.in); 
		
		int n = in.nextInt();
		int[] dy = new int[n+1];
		
		dy[1] = 1;
		dy[2] = 2;

		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		
		System.out.println(dy[n]);
	}
}



