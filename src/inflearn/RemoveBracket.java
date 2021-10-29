package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class RemoveBracket {

	public String solution(String s) {
		String answer = "";
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c==')') {
				while(stack.pop()!='(');
			}else {
				stack.push(c);
			}
		}
		
		for(char c : stack) {
			answer += c;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveBracket rb = new RemoveBracket();
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		System.out.println(rb.solution(s));
	}

}
