package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWord {

	/*
	 *	설명

		N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
		
		
		입력
		첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
		
		두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
		
		
		출력
 		N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
	 */
	
	public ArrayList<String> solution(int n, String[] arr) {
		ArrayList<String> answer = new ArrayList<>();
		
		/* 1. StringBuilder 사용하기 
		for(String s : arr) {
			String tmp = new StringBuilder(s).reverse().toString();
			answer.add(tmp);
		}
		*/
		
		/* 2. 직접 reverse 구현 */
		for(String s : arr) {
			char[] c = s.toCharArray();
			int left = 0;
			int right = c.length - 1;
			
			while(left<right) {
				char tmp = c[left];
				c[left] = c[right];
				c[right] = tmp;
				left++;
				right--;
			}
			String stmp = String.valueOf(c);
			answer.add(stmp);
			
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		ReverseWord rw = new ReverseWord();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.next();
		}
		
		for(String x: rw.solution(n, arr)) {
			System.out.println(x);
		}
		
	}

}
