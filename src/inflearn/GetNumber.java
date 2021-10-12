package inflearn;

import java.util.Scanner;

public class GetNumber {
	
	public int solution(String str) {
		/* 1. int 형으로 변
		int answer = 0;
		char[] arr = str.toCharArray();

		for(int i = 0; i < str.length(); i++) {
			if(arr[i] >= '0' && arr[i] <= '9') {
				//System.out.println(arr[i]);
				answer = answer * 10 + (arr[i] - '0');
				//System.out.println(answer);
			}
		}
		*/
	
		/* 2. String으로 받은 후 Integer로 Parsing */
		String answer = "";
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				answer += c;
			}
		}
		System.out.println(answer);
		
		return Integer.parseInt(answer);
	}
	
	
	public static void main(String[] args) {
		GetNumber g = new GetNumber();
		
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		 
		System.out.println(g.solution(str));
	}

}
