package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class SetStall {

	public int count(int[] arr, int distance) {
		 int cnt = 1;
		 int pos = arr[0];
		 for(int i=1; i<arr.length; i++) {
			 if(arr[i] - pos >= distance) {
				 cnt++;
				 pos = arr[i];
			 }
		 }
		 return cnt;
	}
	
	public int solution(int n, int c, int[] arr) {
		int answer =0;
		
		Arrays.sort(arr);
		
		int lt = 1;
		int rt = arr[n-1];
		
		while(lt <= rt) {
			int mid = (lt+rt)/2;
			int cnt = count(arr, mid);
			//System.out.println("mid : " + mid + ", cnt : " + cnt);
			if(cnt >= c) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		return answer; 
	}
	
	public static void main(String[] args) {
		SetStall s = new SetStall();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int c = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=in.nextInt();
		}
		
		System.out.println(s.solution(n, c, arr));
	}

}



