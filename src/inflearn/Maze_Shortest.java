package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze_Shortest {

	static  int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board = new int[8][8];
	static int[][] arr = new int[8][8];
	
	public static void BFS(int x, int y) {
		Queue<PointXY> q = new LinkedList<>();
		
		board[x][y] = 1;
		q.offer(new PointXY(x, y));
		
		while(!q.isEmpty()) {
			PointXY p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<1 || nx>=8 || ny<1 || ny>=8) continue;
				else if(board[nx][ny] == 0) {
					board[nx][ny] = 1;
 					arr[nx][ny] = arr[p.x][p.y]+1;
					q.offer(new PointXY(nx, ny));
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		Maze_Shortest ms = new Maze_Shortest();
		Scanner in = new Scanner(System.in);
		
		for(int i=1; i<=7; i++) {
			for(int j=1; j<=7; j++) {
				board[i][j] = in.nextInt();
			}
		}
	
		ms.BFS(1,1);
		if(arr[7][7]==0) System.out.println("-1");
		else System.out.println(arr[7][7]);
	}

}



