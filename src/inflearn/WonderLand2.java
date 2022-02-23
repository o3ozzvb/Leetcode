package inflearn;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
	int vex;
	int cost;
	
	public Edge2(int vex, int cost) {
		super();
		this.vex = vex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge2 o) {
		return this.cost - o.cost;
	}
}

public class WonderLand2 {
	public static void main(String[] args) {
		WonderLand2 w2 = new WonderLand2();
		Scanner in = new Scanner(System.in); 
		
		int answer = 0;
		
		int v = in.nextInt();
		int e = in.nextInt();
		int[] ch = new int[v+1];
		
		ArrayList<ArrayList<Edge2>> graph = new ArrayList<ArrayList<Edge2>>();
		for(int i=0; i<=v; i++) {
			graph.add(new ArrayList<Edge2>());
		}
		
		for(int i=0; i<e; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			graph.get(a).add(new Edge2(b, c));
			graph.get(b).add(new Edge2(a, c));
		}

		PriorityQueue<Edge2> pq = new PriorityQueue<>();
		pq.offer(new Edge2(1, 0));
		
		while(!pq.isEmpty()) {
			Edge2 tmp = pq.poll();
			int ev = tmp.vex;
			if(ch[ev] == 0) {
				ch[ev] = 1;
				answer += tmp.cost;
				for(Edge2 ed : graph.get(ev)) {
					if(ch[ed.vex]==0) pq.offer(new Edge2(ed.vex, ed.cost));
				}
			}
		}
		System.out.println(answer);
	}
}



