package inflearn;

import java.util.Scanner;

public class Palindrome2 {

	public String solution(String str) {
		String answer = "NO";
		
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		//System.out.println(str);
		String tmp = new StringBuilder(str).reverse().toString();
		if(tmp.equals(str)) {
			answer = "YES";
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Palindrome2 p = new Palindrome2();
		
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		 
		System.out.println(p.solution(str));
	}

}
