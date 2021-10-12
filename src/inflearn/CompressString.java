package inflearn;

import java.util.Scanner;

public class CompressString {

	public String solution(String s) {
		String answer = "";
		/* 1. My Code
		int cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			cnt = 0;
			answer += c;
			while(i < s.length() && s.charAt(i) == c) {
				cnt++;
				i++;
			}
			i--;
			if(cnt > 1) {
				answer += cnt;
			}
		}
		*/
		s = s + " ";
		int cnt = 1;
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				cnt++;
			} else {
				answer += Character.toString(s.charAt(i)) + (cnt > 1 ? cnt : "");
				cnt = 1;
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		CompressString cs = new CompressString();
		
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(cs.solution(s));
	}

}
