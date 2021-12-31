package inflearn;

import java.util.Scanner;

public class BubbleSort {

	public int[] solution(int n, int[] arr) {
		int tmp = 0;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 버블정렬 : 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘 */
		BubbleSort bs = new BubbleSort();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int x : bs.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}

}



