package inflearn;

import java.util.Scanner;

public class RemoveDuplicateChar {

	public String solution(String str) {
		String answer = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i))==i) {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		RemoveDuplicateChar rdc = new RemoveDuplicateChar();
		
		Scanner in = new Scanner(System.in);
		String str = in.next();
		 
		System.out.println(rdc.solution(str));
	}
}
