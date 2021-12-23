package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {

	public String solution(String required, String curriculum) {
		String answer = "NO";
		Queue<Character> q1 = new LinkedList<Character>();
		Queue<Character> q2= new LinkedList<Character>();

		for(char x : required.toCharArray()) {
			q1.offer(x);
		}
		for(char x : curriculum.toCharArray()) {
			q2.offer(x);
		}
		
		while(!q2.isEmpty()) {
			char first = q2.peek();
			if(!q1.contains(first)) {
				q2.poll();
			} else if(first == q1.peek()) {
				q1.poll();
				q2.poll();
				if(q1.isEmpty()) {
					return "YES";
				}
			} else {
				return "NO";
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Curriculum c = new Curriculum();
		
		Scanner in = new Scanner(System.in);
		
		String required = in.nextLine();
		String curriculum = in.nextLine();
		
		System.out.println(c.solution(required, curriculum));

	}

}
