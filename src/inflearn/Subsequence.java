package inflearn;

import java.util.Scanner;

public class Subsequence {

	
	public int solution(int n, int m, int[] arr) {
		/* My Code
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			int p = i;
			while(p < n && sum < m) {
				sum += arr[p++];
			}
			if(sum == m) {
				answer++;
			}
		}
		*/
		
		int answer = 0, sum = 0, lt = 0;
		for(int rt=0; rt<n; rt++) {
			sum += arr[rt];
			if(sum==m) answer++;
			while(sum>=m) {
				sum -= arr[lt++];
				if(sum==m) answer++;
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Subsequence s = new Subsequence();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(s.solution(n, m, arr));
	}

}
