package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class SteelStick {

	public int solution(String s) {
		int answer = 0;
		Stack<Character> st = new Stack<>();
		int idx = 0;
		
		for(char c : s.toCharArray()) {
			if(c == '(') {
				st.push(c);
			}
			else if(c == ')') {
				//laser
				if(s.charAt(idx-1) == '(') {
					st.pop();
					answer += st.size();
				}
				else { 
					answer += 1;
					st.pop();
				}
			}
			idx++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		SteelStick s = new SteelStick();
		
		Scanner in = new Scanner(System.in);
		
		String st = in.nextLine();
		
		System.out.println(s.solution(st));

	}

}
