package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public int solution(String s) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c == '+' || c == '-' || c == '*' || c == '/') {
				
				int b = st.pop();
				int a = st.pop();
				
				if(c == '+') {
					answer = a + b;
				}else if(c== '-') {
					answer = a - b;
				}else if(c== '*') {
					answer = a * b;
				}else {
					answer = a / b;
				}
				st.push(answer);
			}
			else {
				st.push(c - '0');
			}
		}
		
		answer = st.pop();
		
		return answer;
	}
	
	public static void main(String[] args) {
		Postfix p = new Postfix();
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		System.out.println(p.solution(s));

	}

}
