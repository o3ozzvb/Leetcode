package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class SumTwoArrays {

	/* My Code 
	public int[] solution(int n, int m, int[] arr1, int[] arr2) {
		int[] answer = new int[n+m];
		int idx = 0;
		int i = 0, j = 0;
		
		while(idx < n+m) {
			
			if(arr1[i] < arr2[j]) {
				answer[idx++] = arr1[i++];
			} else if(arr1[i] > arr2[j]) {
				answer[idx++] = arr2[j++];
			} else {
				answer[idx++] = arr1[i++];
				answer[idx++] = arr2[j++];
			}
			
			if(i >= n && j < m) {
				for(int k = idx; k < n+m; k++) {
					answer[k] = arr2[j++];
				}
				break;
			}
			
			if(j >= m && i < n) {
				for(int k = idx; k < n+m; k++) {
					answer[k] = arr1[i++];
				}
				break;
			}
		}
		
		return answer;
	}
	*/
	
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int p1=0, p2=0;
		
		while(p1<n && p2<m) {
			if(a[p1]<b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}
		while(p1<n) answer.add(a[p1++]);
		while(p2<m) answer.add(b[p2++]);
		
		return answer;
	}
	
	public static void main(String[] args) {
		SumTwoArrays sta = new SumTwoArrays();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr1 = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr1[i] = in.nextInt();
		}
		
		int m = in.nextInt();
		int[] arr2 = new int[m];
		
		for(int i = 0; i < m; i++) {
			arr2[i] = in.nextInt();
		}
		
		for(int x : sta.solution(n, m, arr1, arr2)) {
			System.out.print(x + " ");
		}
	}

}
