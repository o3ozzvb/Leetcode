package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Patient {
	int idx;
	int priority;
	
	public Patient(int idx, int priority) {
		this.idx = idx;
		this.priority = priority; 
	}
}

public class EmergencyRoom {

	public int solution(int n, int m, int[] arr) {
		int answer = 1;
		Queue<Patient> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			q.offer(new Patient(i, arr[i]));
		}
		
		while(!q.isEmpty()) {
			Patient x = q.poll();
			for(Patient p : q) {
				if(p.priority > x.priority) {
					q.offer(x);
					x = null;
					break;
				}
			}
			if(x != null) {
				if(x.idx == m) {
					return answer;
				}else {
					answer++;
				}
			}
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmergencyRoom er = new EmergencyRoom();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(er.solution(n, m, arr));
	}

}



