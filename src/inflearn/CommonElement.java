package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElement {

	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		Arrays.sort(a);
		Arrays.sort(b);

		int p1 = 0, p2 = 0;
		
		while(p1<n && p2<m) {
			if(a[p1] < b[p2]) {
				p1++;
			} else if(a[p1] > b[p2]) {
				p2++;
			} else {
				answer.add(a[p1]);
				p1++;
				p2++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		CommonElement ce = new CommonElement();
		
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
		
		for(int x : ce.solution(n, m, arr1, arr2)) {
			System.out.print(x + " ");
		}
	}

}
