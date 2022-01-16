package inflearn;

import java.util.Scanner;

public class SubSet {

	static int n;
	static int[] arr;
	static int[] sum;
	static int tot = 0;
	
	static String answer = "NO";
	static boolean flag = false;
	
	public static void DFS(int x, int tmpSum) {
		if(flag) return;
		if(x == n) {
			if(tot - tmpSum == tmpSum){ 
				answer = "YES";
				flag = true;
			}
		}
		else {
			DFS(x+1, arr[x]+tmpSum);
			DFS(x+1, tmpSum);
		}
		
		return;
	}
	
	public static void main(String[] args) {
		SubSet ss = new SubSet();
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			tot += arr[i];
		}
	
		sum = new int[tot+1];
		
		DFS(0,0);
		
		System.out.println(answer);
	}

}



