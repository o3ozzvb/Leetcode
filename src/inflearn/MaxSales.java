package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSales {

	public int solution(int n, int k, int[] arr) {
		int max = Integer.MIN_VALUE;
		int tmp = 0;
		
		for(int i=0; i<k; i++) {
			tmp += arr[i];
		}
		max = tmp;
		
		int idx = k;
		while(idx < n) {
			tmp = tmp + arr[idx] - arr[idx-k];
			max = max > tmp ? max : tmp;
			idx++;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MaxSales ms = new MaxSales();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(ms.solution(n, k, arr));
	}

}
