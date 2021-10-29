package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {

	public String solution(String s) {
		String answer = "YES";
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c==')') {
				if(!stack.empty() && stack.peek()=='(') stack.pop();
				else return "NO";
			}
			else {
				stack.push(c);
			}
		}
		
		if(!stack.empty()) return "NO";
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bracket b = new Bracket();
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		System.out.println(b.solution(s));
	}

}
