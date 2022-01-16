package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	int pos;
	int level;
	
	public Location(int pos, int level) {
		super();
		this.pos = pos;
		this.level = level;
	}
}

public class FindCalf {

	public int solution(int s, int e) {
		int answer =0;
		int[] visited = new int[100001];
		int[] dist = {1, -1, 5};
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(s, 0));
		visited[s] = 1;
		
		while(!q.isEmpty()) {
			Location x = q.poll();
			for (int i = 0; i < 3; i++) {
				int nx = x.pos + dist[i];
				if (visited[nx] != 1 && nx >= 1 && nx <= 10000) {
					if (nx == e) {
						return x.level + 1;
					}
					visited[nx] = 1;
					q.offer(new Location(nx, x.level + 1));
					q.offer(new Location(nx, x.level + 1));
					q.offer(new Location(nx, x.level + 1));
				}
			}
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		FindCalf fc = new FindCalf();
		Scanner in = new Scanner(System.in);
		
		int s = in.nextInt();
		int e = in.nextInt();
		
		System.out.println(fc.solution(s, e));
	}

}



