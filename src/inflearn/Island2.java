package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Island2 {

	static int n;
	static int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
	static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	static int[][] board, visit;
	
	static int answer = 0;
	
	public static void BFS(int x, int y) {
		Queue<PointXY> q = new LinkedList<>();
		
		q.offer(new PointXY(x, y));
		
		while(!q.isEmpty()) {
			PointXY p = q.poll();
			for(int i=0; i<8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				else if(board[nx][ny] == 1 && visit[nx][ny] != 1) {
					visit[nx][ny] = 1;
					BFS(nx, ny);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Island2 l = new Island2();
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
					l.BFS(i, j);
				}
			}
		}
		
		
		System.out.println(answer);
	}
}



