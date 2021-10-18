package inflearn;

import java.util.Scanner;

public class CalculateScore {

	public int solution(int n, int[] score) {
		int answer = 0;
		int plus = 0;
		for(int x : score) {
			if(x == 1) {
				answer += (1 + plus);
				plus++;
			} else {
				plus = 0;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		CalculateScore cs = new CalculateScore();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] score = new int[n];
		for(int i = 0; i < n; i++) {
			score[i] = in.nextInt();
		}
		
		System.out.println(cs.solution(n, score));
	}

}
