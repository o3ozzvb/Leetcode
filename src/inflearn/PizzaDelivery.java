package inflearn;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PizzaDelivery {

	static int n, m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board;
	
	static List<PointXY> house = new LinkedList<>();
	static List<PointXY> pizza = new LinkedList<>();
	static int[] combi;
	
	static int answer = Integer.MAX_VALUE;
	
	public static int calculate(int[] selected) {
		int distance = 0;
		int tmp;
		/*
		for(int i=0; i<pizza.size(); i++) {
			if(selected[i] == 1) {
				PointXY p = pizza.get(i);
				System.out.println(p.x + ", " + p.y);
			}
		}
		*/
		for(int i=0; i<house.size(); i++) {
			tmp = Integer.MAX_VALUE;
			PointXY h = house.get(i);
			for(int j=0; j<m; j++) {
				PointXY p = pizza.get(combi[j]);
				tmp = Math.min(tmp, (Math.abs(h.x - p.x) + Math.abs(h.y - p.y)));
			}
			distance += tmp;
		}
		
		return distance;
	}
	
	public static void DFS(int idx, int cnt) {
		if(cnt == m) {
			//최소거리 계산 
			answer = Math.min(answer, calculate(combi));
			return;
		}
		if(idx >= pizza.size()-1) return;
		
		for(int i=0; i<pizza.size(); i++) {
			combi[idx] = i;
			DFS(idx+1, cnt+1);
		}
		
	}
	
	public static void main(String[] args) {
		PizzaDelivery pd = new PizzaDelivery();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();

		board = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int x = in.nextInt();
				if(x == 1) {
					house.add(new PointXY(i, j));
				}else if(x == 2) {
					pizza.add(new PointXY(i, j));
				}
				board[i][j] = x;
			}
		}
		
		combi = new int[m];
		pd.DFS(0, 0);
		
		System.out.println(answer);
	}
}



