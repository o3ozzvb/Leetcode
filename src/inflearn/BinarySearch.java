package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public int solution(int n, int m, int[] arr) {
		int answer =0;
		int lt = 0, rt = n-1;
		Arrays.sort(arr);
		
		while(lt <= rt) {
			int idx = (lt+rt)/2;
			if(arr[idx] > m) rt = idx - 1;
			else if(arr[idx] < m) lt = idx + 1;
			else {
				answer = idx+1;
				break;
			}
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=in.nextInt();
		}
		
		System.out.println(bs.solution(n, m, arr));
	}

}



