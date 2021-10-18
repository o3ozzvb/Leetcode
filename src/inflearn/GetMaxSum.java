package inflearn;

import java.util.Scanner;

public class GetMaxSum {

	public int solution(int n, int[][] arr) {
		int answer = 0;
		int diagSum1 = 0;
		int diagSum2 = 0;
		for(int i=0; i<n; i++) {
			int rowSum = 0;
			int colSum = 0;
			diagSum1 += arr[i][i];
			diagSum2 += arr[n-i-1][i];
			for(int j=0; j<n; j++) {
				rowSum += arr[j][i];
				colSum += arr[i][j];
			}
			if(answer < rowSum) answer = rowSum;
			if(answer < colSum) answer = colSum;
		}
		
		if(answer < diagSum1) answer = diagSum1;
		if(answer < diagSum1) answer = diagSum1;
		
		return answer;
	}
	
	public static void main(String[] args) {
		GetMaxSum gms = new GetMaxSum();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		System.out.print(gms.solution(n, arr));
	}

}
