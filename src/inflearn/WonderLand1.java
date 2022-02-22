package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int cost;
	
	public Edge(int v1, int v2, int cost) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class WonderLand1 {
	static int[] unf;
	static int answer = 0;
	
	public static int Find(int v) {
		if(unf[v] == v) return unf[v];
		else return unf[v] = Find(unf[v]);
	}
	
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	} 
	
	public static void main(String[] args) {
		WonderLand1 w1 = new WonderLand1();
		Scanner in = new Scanner(System.in); 
		
		int v = in.nextInt();
		unf = new int[v+1];
		int e = in.nextInt();
		
		for(int i=1; i<=v; i++) unf[i] = i;
		
		ArrayList<Edge> list = new ArrayList<>();
		for(int i=0; i<e; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			list.add(new Edge(a, b, c));
		}
		Collections.sort(list);
		
		for(Edge ed : list) {
			int fv1 = Find(ed.v1);
			int fv2 = Find(ed.v2);
		
			if(fv1 != fv2) {
				answer += ed.cost;
				Union(ed.v1, ed.v2);
			}
		}

		System.out.println(answer);
	}
}



