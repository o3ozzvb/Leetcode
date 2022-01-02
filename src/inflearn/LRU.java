package inflearn;

import java.util.Scanner;

public class LRU {

	public int[] solution(int s, int n, int[] arr) {
		int[] cache = new int[s];
		
		for(int x : arr) {
			int idx = -1;
			for(int i=0; i<s; i++) {
				if(cache[i] == x) {
					idx = i;
					break;
				}
			}
			if(idx < 0) {
				for(int j=s-1; j>0; j--) {
					cache[j] = cache[j-1];
				}
			} else {
				for(int j=idx; j>0; j--) {
					cache[j] = cache[j-1];
				}
			}
			cache[0] = x;
		}
		
		return cache;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU lru = new LRU();
		Scanner in = new Scanner(System.in);
		
		int s = in.nextInt();
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int x : lru.solution(s, n, arr)) {
			System.out.print(x + " ");
		}
	}

}



