package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
	int income;
	int due;
	
	public Lecture(int income, int due) {
		super();
		this.income = income;
		this.due = due;
	}

	@Override
	public int compareTo(Lecture o) {
		return o.due - this.due;
	}
}

public class MaxIncome {
	static int maxD, n;
	public static int solution(ArrayList<Lecture> list) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int answer = 0;
		Lecture l;
		
		int j = 0;
		for(int i = maxD; i > 0; i--) {
			for( ; j < n; j++) {
				if(list.get(j).due < i) break;
				pq.offer(list.get(j).income); 
			}
			if(!pq.isEmpty()) answer += pq.poll();
		}

		return answer;
	}
	
	public static void main(String[] args) {
		MaxIncome mi = new MaxIncome();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		ArrayList<Lecture> list = new ArrayList<>();
		maxD = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			int m = in.nextInt();
			int d = in.nextInt();
			maxD = Math.max(maxD, d);
			list.add(new Lecture(m, d));
		}
		Collections.sort(list);
		
		System.out.println(mi.solution(list));
	}
}



