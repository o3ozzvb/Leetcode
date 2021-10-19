package inflearn;

import java.util.Scanner;

public class TemporaryLeader {

	public int solution(int n, int[][] arr) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				for(int k=0; k<5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(max < cnt) {
				max = cnt;
				answer = i+1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		TemporaryLeader p = new TemporaryLeader();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][5];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		System.out.print(p.solution(n, arr));
	}

}
