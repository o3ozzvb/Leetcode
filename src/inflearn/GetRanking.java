package inflearn;

import java.util.Scanner;

public class GetRanking {

	public int[] solution(int n, int[] score) {
		int[] answer = new int[n];
		
		for(int i=0; i<n; i++) {
			int rank = 1;
			for(int j=0; j<n; j++) {
				if(score[i] < score[j]) {
					rank++;
				}
			}
			answer[i] = rank;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		GetRanking gr = new GetRanking();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] score = new int[n];
		for(int i = 0; i < n; i++) {
			score[i] = in.nextInt();
		}
		
		for(int x : gr.solution(n, score)) {
			System.out.print(x + " ");
		}
	}

}
