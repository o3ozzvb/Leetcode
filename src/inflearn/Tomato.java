package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PointXY {
	int x;
	int y;

	public PointXY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Tomato {

	static int m, n;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board;
	static int cnt = 0;
	
	static Queue<PointXY> q = new LinkedList<>();
	
	public static int BFS() {
		
		int level = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i< qSize; i++) {
				PointXY p = q.poll();
				
				for(int j=0; j<4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					
					if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
					else if(board[nx][ny] == 0) {
						//System.out.println("nx, ny : " + nx + ", " + ny + " board[x][y] :" + board[nx][ny]);
						board[nx][ny] = 1;
						q.offer(new PointXY(nx, ny));
						cnt--;
					}
				}
			}
			
			if(cnt <= 0) return level;
			else level++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Tomato t = new Tomato();
		Scanner in = new Scanner(System.in);
		
		m = in.nextInt();
		n = in.nextInt();
		
		board = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int x = in.nextInt();
				if(x == 0) {
					cnt++;
				}else if(x == 1){
					//System.out.println("i,j : " + i + ", " + j);
					q.offer(new PointXY(i,j));
				}
				board[i][j] = x;
				//System.out.print(x + " ");
			}
			//System.out.println();
		}
		
		System.out.println(t.BFS());
	}
}



