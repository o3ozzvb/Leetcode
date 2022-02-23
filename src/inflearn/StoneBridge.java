package inflearn;

import java.util.Scanner;

public class StoneBridge {
	static int n;
	
	public int solution(int[] dy) {
		
		dy[1] = 1;
		dy[2] = 2;

		for(int i=3; i<=n+1; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		
		return dy[n+1];
	}
	
	public static void main(String[] args) {
		StoneBridge sb = new StoneBridge();
		Scanner in = new Scanner(System.in); 
		
		n = in.nextInt();
		int[] dy = new int[n+2];
		
		System.out.println(sb.solution(dy));
	}
}



