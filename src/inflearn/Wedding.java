package inflearn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Friend implements Comparable<Friend> {
	int time;
	char status;
	
	public Friend(int time, char status) {
		super();
		this.time = time;
		this.status = status;
	}

	@Override
	public int compareTo(Friend o) {
		if(this.time == o.time) return this.status - o.status;
		return this.time - o.time;
	}
	
}

public class Wedding {

	public static int solution(List<Friend> list) {
		int answer = Integer.MIN_VALUE;
		int time = list.get(0).time;
		int people = 0;
		
		for(Friend f : list) {
			
			if(f.status == 'e') {
				people--;
			}else if(f.status == 's') {
				people++;
			}
			answer = Math.max(answer, people);
		}

		return answer;
	}
	
	public static void main(String[] args) {
		Wedding w = new Wedding();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		List<Friend> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			int s = in.nextInt();
			list.add(new Friend(s, 's'));
			int e = in.nextInt();
			list.add(new Friend(e, 'e'));
			
		}
		Collections.sort(list);
		
		System.out.println(w.solution(list));
	}
}



