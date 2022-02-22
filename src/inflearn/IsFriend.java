package inflearn;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IsFriend {
	static int[] unf;
	
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
		IsFriend f = new IsFriend();
		Scanner in = new Scanner(System.in); 
		
		int n = in.nextInt();
		unf = new int[n+1];
		int m = in.nextInt();
		
		for(int i=0; i<n; i++) unf[i] = i;
		for(int i=0; i<m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			Union(x, y);
		}
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		int fa = Find(a);
		int fb = Find(b);
		
		String answer;
		if(fa == fb) answer = "YES";
		else answer = "NO";
		
		System.out.println(answer);
	}
}



