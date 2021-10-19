package inflearn;

import java.util.Scanner;

public class Mentoring {

	public int solution(int n, int test, int[][] arr) {
		int answer = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				boolean isPair = true;
				for(int k=0; k<test; k++) {
					int pi = 0; 
					int pj = 0;
					for(int l=0; l<n; l++) {
						if(arr[k][l] == i) {
							pi = l;
						}
						if(arr[k][l] == j) {
							pj = l;
						}
					}
					if(pi > pj) {
						isPair = false;
					}
				}
				if(isPair) {
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Mentoring p = new Mentoring();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int test = in.nextInt();
		int[][] arr = new int[test][n];
		for(int i = 0; i < test; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		System.out.print(p.solution(n, test, arr));
	}

}
