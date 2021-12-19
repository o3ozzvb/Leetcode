package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {

	public int solution(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n ; i++) {
			q.offer(i);
		}
		while(q.size()>1) {
			for(int i=1; i<k ; i++) {
				q.offer(q.poll());
			}
			q.poll();
		}
		return q.poll();
	}
	
	public static void main(String[] args) {
		SavePrincess sp = new SavePrincess();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		System.out.println(sp.solution(n, k));

	}

}
