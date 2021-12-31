package inflearn;

import java.util.Scanner;

public class SelectionSort {

	public int[] solution(int n, int[] arr) {
		int tmp = 0;
		for(int i=0; i<n-1; i++) {
			int idx = i;
			for(int j=i+1; j<n; j++) {
				if(arr[idx] > arr[j]) {
					idx = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*선택정렬 : 주어진 리스트 중에 최소값을 찾는다. 그 값을 맨 앞에 위치한 값과 교체한다 */
		SelectionSort ss = new SelectionSort();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int x : ss.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}

}



