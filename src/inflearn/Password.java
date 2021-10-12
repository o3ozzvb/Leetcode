package inflearn;

import java.util.Scanner;

public class Password {

	public String solution(int len, String pw) {
		String answer = "";
		/* 1.My Code
		for(int i = 0; i < len; i++) {
			answer += decToBinary(pw.substring(i*7, i*7+7));
		}
		*/
		for(int i = 0; i < len; i++) {
			String tmp = pw.substring(0, 7).replace('#','1').replace('*','0');
			int num = Integer.parseInt(tmp, 2);
			answer += (char)num;
			pw = pw.substring(7);
		}
		
		return answer;
	}
	
	/* 1. My Code
	public char decToBinary(String pw) {
		int[] binary = {64, 32, 16, 8, 4, 2, 1};
		int tot = 0;
		int i = 0;
		for(char c : pw.toCharArray()) {
			if(c == '#') {
				tot += binary[i];
			}
			i++;
		}
		return (char)tot;
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String len = in.nextLine();
		String input = in.nextLine();
		
		Password pw = new Password();
		System.out.println(pw.solution(Integer.parseInt(len), input));
	}

}
