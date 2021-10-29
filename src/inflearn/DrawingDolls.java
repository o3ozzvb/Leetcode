package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class DrawingDolls {

	public int solution(int n, int m, int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		int tmp = 0;
		for(int x : moves) {
			for(int i=1; i<=n; i++) {
				if(board[i][x]!=0) {
					tmp = board[i][x];
					if(!stack.empty() && stack.peek()==tmp) {
						stack.pop();
						answer+=2;
					}else {
						stack.push(tmp);
					}
					board[i][x]=0;
					break;
				}
				
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawingDolls dd = new DrawingDolls();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[][] board = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				board[i][j]=in.nextInt();
			}
		}
		int m = in.nextInt();
		int[] moves = new int[m];
		for(int i=0; i<m; i++) {
			moves[i] = in.nextInt();
		}
		
		System.out.println(dd.solution(n, m, board, moves));
	}

}
