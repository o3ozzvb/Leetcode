package inflearn;

import java.util.Scanner;

public class Maze {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] arr = new int[7][7];
	static int[][] visit = new int[7][7];
	
	static int answer = 0;
	
	public static void DFS(int x, int y) {
		if(x == 6 && y == 6) {
			answer++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=7 || ny<0 || ny>=7) continue;
			else if(visit[nx][ny]==0 && arr[nx][ny] == 0) {
				visit[nx][ny] = 1;
				DFS(nx, ny);
				visit[nx][ny] = 0;
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		Maze m = new Maze();
		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		visit[0][0] = 1;
		DFS(0, 0);
		
		System.out.println(answer);
	}

}



