package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxLenSubsequence {

	
	public int solution(int n, int k, int[] arr) {
		/* My Code
		int answer = Integer.MIN_VALUE;
		ArrayList<Integer> zero = new ArrayList<Integer>();
		
		int idx = 0;
		for(int x : arr) {
			if(x == 0) zero.add(idx);
			idx++;
		}
		
		int lt = 0, rt = k;
		int end = 0, start = 0, len = 0;
		answer = zero.get(rt);
		for(lt=1; lt<zero.size(); lt++) {
			start = zero.get(lt-1)+1;
			if(rt < zero.size()-1) {
				end = zero.get(rt+1);
			} else {
				end = n;
			}
			
			len = end - start;
			//System.out.println("end - start : " + end + " - " + start + " = "+ len);
			answer = answer > len ? answer : len;
			
			if(rt < zero.size()-1) rt++;
		}
		*/
		
		int answer = 0, cnt = 0, lt = 0;
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt]==0) cnt++;
			while(cnt > k) {
				if(arr[lt]==0) cnt--;
				lt++;
			}
			answer = Math.max(answer, rt-lt+1);
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		MaxLenSubsequence mls = new MaxLenSubsequence();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(mls.solution(n, k, arr));
	}

}
