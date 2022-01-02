package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicationCheck {

	public String solution(int n, int[] arr) {
		Arrays.sort(arr);
		for(int i=0; i<n-1; i++) {
			if(arr[i]==arr[i+1]) {
				return "D";
			}
		}
		return "U";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicationCheck dc = new DuplicationCheck();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(dc.solution(n, arr));
	}

}



