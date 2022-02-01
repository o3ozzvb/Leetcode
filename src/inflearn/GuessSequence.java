package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class GuessSequence {

	static int n;
	static int f;
	static int[] ch;
	static int[] answer;
	
	static boolean flag = false;
	
	public static int calc(int[] numbers) {
		int ret = 0;
		int[][] tmp = new int[n][n];
		
		int idx = 0;
		for(int x: numbers) {
			ret += x;
			tmp[0][idx++] = x;
		}
		for(int i=1; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				tmp[i][j] = tmp[i-1][j] + tmp[i-1][j+1];
			}
		}
		return tmp[n-1][0];
	}
	
	public static void DFS(int x, int[] arr) {
		if(flag) return;
		if(x==n) {
			if(calc(arr) == f) {
				answer = Arrays.copyOf(arr, n);
				flag = true;
				return;
			}
		}
		else {
			for(int i=1; i<=n; i++) {
				//System.out.println("ch["+i+"] : "+ ch[i]);
				if(ch[i]==0) {
					ch[i]=1;
					arr[x]=i;
					DFS(x+1, arr);
					ch[i]=0;
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		GuessSequence gs = new GuessSequence();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		f = in.nextInt();
		
		int[] arr = new int[n];
		ch = new int[n+1];
		
		DFS(0, arr);
		for(int x : answer) {
			System.out.print(x + " ");
		}
	}

}



