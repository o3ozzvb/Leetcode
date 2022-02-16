package inflearn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}
	
}

public class MeetingRoom {

	public static int solution(List<Meeting> list) {
		int answer = 0;
		int endTime = 0;
		
		for(Meeting m : list) {
			if(m.start >= endTime) {
				answer++;
				endTime = m.end;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		MeetingRoom mr = new MeetingRoom();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		List<Meeting> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			list.add(new Meeting(s, e));
		}
		Collections.sort(list);
		
		System.out.println(mr.solution(list));
	}
}



