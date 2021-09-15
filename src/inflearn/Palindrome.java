package inflearn;

import java.util.Scanner;

public class Palindrome {

	public String solution(String str) {
		String answer = "YES";
		
		/* 1. 문자 하나씩 비교 
		str = str.toLowerCase();
		char[] arr = str.toCharArray();
		int lt = 0;
		int rt = str.length()-1;
		
		while(lt < rt) {
			if(arr[lt] == arr[rt]) {
				lt++;
				rt--;
				continue;
			}
			else {
				return "NO";
			}
		}
		*/
		
		/* 2. String Builder Reverse 하여 String 하나로 비교 */
		answer = "NO";
		String tmp = new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(tmp)) {
			answer = "YES";
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		
		Scanner in = new Scanner(System.in);
		String str = in.next();
		 
		System.out.println(p.solution(str));
	}

}
