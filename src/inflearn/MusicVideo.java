package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {

	public int count(int[] arr, int capacity) {
		 int cnt = 1, sum = 0;
		 for(int x : arr) {
			 if(sum + x > capacity) {
				 sum = x;
				 cnt++;
			 }else {
				 sum += x; 
			 }
		 }
		 return cnt;
	}
	
	public int solution(int n, int m, int[] arr) {
		int answer =0;
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt+rt)/2;
			if(count(arr, mid) <= m) {
				answer = mid;
				rt = mid-1;
			}else {
				lt = mid+1;
			}
			
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		MusicVideo mv = new MusicVideo();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=in.nextInt();
		}
		
		System.out.println(mv.solution(n, m, arr));
	}

}



