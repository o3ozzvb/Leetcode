package inflearn;

import java.util.Scanner;

public class SumOfNumber {

	public int solution(int n) {
		int answer = 0;
		int sum = 0, lt = 1, rt = 1;

		// 2로 나눈 몫 + 1 까지만 확인하면 됨. 
		while (rt <= n/2 + 1) {
			sum += rt++;
			
			if (sum == n) {
				answer++;
			}
			while(sum >= n) {
				sum -= lt;
				lt++;
				if(sum == n) answer++;
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		SumOfNumber s = new SumOfNumber();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		System.out.println(s.solution(n));
	}

}
