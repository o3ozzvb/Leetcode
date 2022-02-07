package inflearn;

import java.util.Scanner;

public class Island {

	static int n;
	static int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
	static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	static int[][] board, visit;
	
	static int answer = 0;
	
	public static void DFS(int x, int y) {
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			else if(board[nx][ny] == 1 && visit[nx][ny] != 1) {
				visit[nx][ny] = 1;
				DFS(nx, ny);
				//visit[nx][ny] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Island l = new Island();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		board = new int[n][n];
		visit = new int[n][n];
		int x = -1, y = -1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = in.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 1 && visit[i][j] == 0) {
					answer++;
					visit[i][j] = 1;
					//System.out.println("x,y : " + i + "," + j);
					l.DFS(i, j);
					/*
					for(int k=0; k<n; k++) {
						for(int m=0; m<n; m++) {
							System.out.print(visit[k][m] + " ");
						}
						System.out.println();
					}
					*/
				}
			}
		}
		
		
		System.out.println(answer);
	}
}



