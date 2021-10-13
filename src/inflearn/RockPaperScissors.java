package inflearn;

import java.util.Scanner;

public class RockPaperScissors {

	public char[] solution(int n, int[] arrA, int[] arrB) {
		// 1:가위, 2:바위, 3:보
		char[] answer = new char[n];
		for(int i = 0; i < n; i++) {
			int a = arrA[i];
			int b = arrB[i];
			//비겼을 때 
			if(a == b) answer[i] = 'D';
			//A가 이길 경우 (가위 - 보, 주먹 - 가위, 보 - 주먹)
			else if((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
				answer[i] = 'A';
			}else {
				answer[i] = 'B';
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arrA = new int[n];
		int[] arrB = new int[n];

		for (int i = 0; i < n; i++) {
			arrA[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arrB[i] = in.nextInt();
		}
		RockPaperScissors rps = new RockPaperScissors();
		for(char x : rps.solution(n, arrA, arrB)) {
			System.out.println(x);
		}
	}

}
