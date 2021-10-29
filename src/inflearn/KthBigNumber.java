package inflearn;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class KthBigNumber {

	public int solution(int n, int k, int[] arr) {
		int answer = -1;
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int l=j+1; l<n; l++) {
					set.add(arr[i]+arr[j]+arr[l]);
				}
			}
		}
		int idx = 0;
		for(int x : set) {
			idx++;
			if(idx == k) return x;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthBigNumber kb = new KthBigNumber();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(kb.solution(n, k, arr));
	}

}
