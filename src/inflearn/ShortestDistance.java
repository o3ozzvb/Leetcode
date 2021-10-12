package inflearn;

import java.util.Scanner;

public class ShortestDistance {
	
	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		/* 1. indexOf 사용 
		for(int i = 0; i < s.length(); i++) {
			int min = 200;
			int start = 0;
			while(s.indexOf(t, start) != -1) {
				int distance = Math.abs(i - s.indexOf(t, start));
				if(distance < min) {
					min = distance;
				}
				start = s.indexOf(c, start) + 1;
			}
			answer[i] = min;
		}
		*/
		/* 2.앞에서, 뒤에서 for문 사용 */
		int p = 1000;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == t) {
				p = 0;
			}else {
				p += 1;
			}
			answer[i] = p;
		}
		
		p = 1000;
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) == t) {
				p = 0;
			}else {
				p += 1;
			}
			if(answer[i] > p) {
				answer[i] = p;
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		ShortestDistance sd = new ShortestDistance();
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		char t = in.next().charAt(0);
		 
		for(int i : sd.solution(s, t)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
