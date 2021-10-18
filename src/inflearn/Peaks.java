package inflearn;

import java.util.Scanner;

public class Peaks {

	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, -1, 0, 1};
	
	public int solution(int n, int[][] arr) {
		/* 1. My Code
		n = n + 2;
		int answer = 0;
		for(int i=1; i<n-1; i++) {
			for(int j=1; j<n-1; j++) {
				int x = arr[i][j];
				if(arr[i-1][j] < x && arr[i][j-1] < x && arr[i][j+1] < x && arr[i+1][j] < x) {
					answer++;
				}
			}
		}
		return answer;
		*/
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				boolean flag = true;
				for(int k=0; k<4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if(x < 0 || y < 0 || x >= n || y >= n ) continue;
					if(arr[x][y] > arr[i][j]) {
						flag = false;
						break;
					}
				}
				if(flag) answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Peaks p = new Peaks();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		/* 1. My Code
		int[][] arr = new int[n+2][n+2];
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < n+2; j++) {
				if(i == 0 || j == 0 || i == n+1 || j == n+1) arr[i][j] = 0;
				else arr[i][j] = in.nextInt();
			}
		}
		*/

		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		System.out.print(p.solution(n, arr));
	}

}
